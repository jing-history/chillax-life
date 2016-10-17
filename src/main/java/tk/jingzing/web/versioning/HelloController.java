package tk.jingzing.web.versioning;

import org.springframework.stereotype.Controller;

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
}
