package tk.jingzing.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import tk.jingzing.model.Love;
import tk.jingzing.service.LoveService;

import java.time.LocalDateTime;

/**
 * Created by wangyunjing on 16/6/9.
 */
@Controller
@ApiIgnore
public class LoveController {

    // 在Java类中创建 logger 实例
    private static final Logger logger = LoggerFactory.getLogger(LoveController.class);
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

    @RequestMapping(value = "/async", method = RequestMethod.POST)
    @ResponseBody
    public String asyncStatus(@RequestParam(required = false, defaultValue = "1") String status){
        logger.info("change status: " + status);
        loveService.asyncStatus(status);
        return "fragments/user :: info-success";
    }
}
