package tk.jingzing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.jingzing.entity.Love;
import tk.jingzing.service.LoveService;

import java.time.LocalDateTime;

/**
 * Created by wangyunjing on 16/6/9.
 */
@Controller
public class LoveController {

    @Autowired
    private LoveService loveService;

    @RequestMapping("/")
    public String love(Model model){
        Love love = loveService.getMyLove();
        model.addAttribute("firstTime",love.getFirst_time());
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("status", love.isStatus());
        return "love";
    }
}
