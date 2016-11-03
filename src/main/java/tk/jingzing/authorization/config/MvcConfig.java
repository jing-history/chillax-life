package tk.jingzing.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.jingzing.authorization.interceptor.AuthorizationInterceptor;
import tk.jingzing.authorization.resolvers.CurrentUserMethodArgumentResolver;

import java.util.List;

/**
 * 配置类，增加自定义拦截器和解析器
 * Created by wangyunjing on 2016/11/3.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Autowired
    private CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver);
    }
}
