package tk.jingzing.service.mybatis;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jingzing.mapper.CountryMapper;
import tk.jingzing.model.Country;

import java.util.List;

/**
 * @Description:what to do
 * Created by Louis Wang on 2016/8/4.
 */
@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;

    public List<Country> getAll(Country country){
        if (country.getPage() != null && country.getRows() != null) {
            PageHelper.startPage(country.getPage(), country.getRows(),"id");
        }
        return countryMapper.selectAll();
    }

    public Country getById(Integer id) {
        return countryMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        countryMapper.deleteByPrimaryKey(id);
    }

    public void save(Country country) {
        if (country.getId() != null) {
            countryMapper.updateByPrimaryKey(country);
        } else {
            countryMapper.insert(country);
        }
    }

    public Country getMySql(Integer id) {
        return countryMapper.getMySql(id);
    }
}
