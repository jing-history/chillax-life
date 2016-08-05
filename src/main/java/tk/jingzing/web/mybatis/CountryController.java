package tk.jingzing.web.mybatis;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tk.jingzing.model.Country;
import tk.jingzing.service.mybatis.CountryService;

import java.util.List;

/**
 * @Description:获取国家信息
 * Created by Louis Wang on 2016/8/4.
 */
@Controller
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping
    public ModelAndView getAll(Country country){
        ModelAndView result = new ModelAndView("mybatis/index");
        List<Country> countryList = countryService.getAll(country);
        result.addObject("pageInfo", new PageInfo<Country>(countryList));
        result.addObject("queryParam", country);
        result.addObject("page", country.getPage());
        result.addObject("rows", country.getRows());
        return result;
    }
}
