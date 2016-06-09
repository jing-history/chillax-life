package tk.jingzing.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/**
 * Created by wangyunjing on 16/6/9.
 */
@Controller
public class LoveController {

    @RequestMapping("/")
    public String love(Model model){
        model.addAttribute("now", LocalDateTime.now());
        return "love";
    }
}
