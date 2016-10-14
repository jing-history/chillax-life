package tk.jingzing.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

/**
 * 个人首页
 * Created by wangyunjing on 16/6/5.
 */
@Controller

public class IndexController {

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView result = new ModelAndView("jing/index");
        result.addObject("name","Jing");
        result.addObject("now", LocalDateTime.now());
        return result;
    }
}
