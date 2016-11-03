package tk.jingzing.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * SwaggerConfig
 * http://localhost:8080/swagger-ui.html
 * @Configuration注解，让Spring来加载该类配置
 * @EnableSwagger2注解来启用Swagger2
 * Created by wangyunjing on 16/10/14.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${server.servlet-path}")
    private String pathMapping;

    //apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
    private ApiInfo initApiInfo(){
        ApiInfo apiInfo = new ApiInfo("Jing项目 Platform API",//大标题
                initContextInfo(),//简单的描述
                "1.0.0",//版本
                "服务条款",
                "后台开发团队",//作者
                "The Apache License, Version 2.0",//链接显示文字
                "http://www.baidu.com"//网站链接
        );
        return apiInfo;
    }

    private String initContextInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("REST API 设计在细节上有很多自己独特的需要注意的技巧，并且对开发人员在构架设计能力上比传统 API 有着更高的要求。")
                .append("<br/>")
                .append("本文通过翔实的叙述和一系列的范例，从整体结构，到局部细节，分析和解读了为了提高易用性和高效性，REST API 设计应该注意哪些问题以及如何解决这些问题。");

        return sb.toString();
    }

    /**
     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
     * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，
     * 并产生文档内容（除了被@ApiIgnore指定的请求）。
     * @return
     */
    public Docket restfulApi(){
        System.out.println("http://localhost:8080" + pathMapping + "/swagger-ui.html");

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("RestfulApi")
        //        .genericModelSubstitutes(DeferredResult.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .pathMapping(pathMapping) // base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(doFilteringRules())
                .build()
                .apiInfo(initApiInfo());
    }

    /**
     * 设置过滤规则
     * 这里的过滤规则支持正则匹配
     * @return
     */
    private Predicate<String> doFilteringRules() {
        return or(
          //      regex("/hello.*"),
          //      regex("/vehicles.*")
                regex("/countries.*")
        );
    }
}
