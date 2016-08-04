package tk.jingzing.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import tk.jingzing.mybatis.model.City2;

import java.util.List;

/**
 * @Description:mybatis3.3.1版本新增功能测试
 * Created by Louis Wang on 2016/8/4.
 */

public interface MyBatis331Mapper {

    /**
     * 批量插入
     *
     * @param cities
     * @return
     */
    @Insert("<script>" +
            "insert into city (id, name, state) values " +
            "<foreach collection=\"list\" item=\"city\" separator=\",\" >" +
            "(#{city.id}, #{city.cityName}, #{city.cityState})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertCities(List<City2> cities);

    /**
     * 根据主键查询一个
     *
     * @param id
     * @return
     */
    @Results(id = "cityResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "cityName", column = "name", id = true),
            @Result(property = "cityState", column = "state", id = true)
    })
    @Select("select id, name, state from city where id = #{id}")
    City2 selectByCityId(Integer id);

    /**
     * 查询全部，引用上面的Results
     *
     * @return
     */
    @ResultMap("cityResult")
    @Select("select id, name, state from city")
    List<City2> selectAll();
}
