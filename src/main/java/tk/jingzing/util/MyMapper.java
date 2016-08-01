package tk.jingzing.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description:继承自己的MyMapper
 * Created by Louis Wang on 2016/8/1.
 */

public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
