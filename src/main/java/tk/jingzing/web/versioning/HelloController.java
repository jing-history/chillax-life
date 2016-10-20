package tk.jingzing.web.versioning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.jingzing.model.Hello;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * How to implement the different approaches at REST API versioning with Spring MVC
 * 参考地址 git restapi-versioning-spring
 * Created by wangyunjing on 2016/10/17.
 */
@Controller
public class HelloController {

    private enum ValidVersion {
        v1,
        v2
    }

    //表示将功能处理方法将生产json格式的数据，此时根据请求头中的Accept进行匹配，如请求头“Accept:application/json”时即可匹配;
    @ResponseBody
    @RequestMapping(value = "/apiurl/{version}/hello", method = GET, produces = APPLICATION_JSON_VALUE)
    public Hello sayHelloWorldUrl(@PathVariable final ValidVersion version){
        return new Hello();
    }

    @ResponseBody
    @RequestMapping(value = "/apiheader/hello", method = GET, produces = APPLICATION_JSON_VALUE)
    public Hello sayHelloWorldHeader(@RequestHeader("X-API-Version") final ValidVersion version){
        return new Hello();
    }

    @ResponseBody
    @RequestMapping( value = "/apiaccept/hello", method = GET,
                    produces = {"application/vnd.company.app-v1+json","application/vnd.company.app-v2+json\""})
    public Hello sayHelloWorldAccept(){
        return new Hello();
    }
}
