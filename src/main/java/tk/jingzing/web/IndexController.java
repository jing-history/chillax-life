package tk.jingzing.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

/**
 * Created by wangyunjing on 16/6/5.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false, defaultValue="Jing") String name, Model model){
        model.addAttribute("name",name);
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }
}
