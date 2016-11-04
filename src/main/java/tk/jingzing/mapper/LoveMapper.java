package tk.jingzing.mapper;

import tk.jingzing.model.Love;
import tk.jingzing.model.User;
import tk.jingzing.util.MyMapper;

/**
 * Created by wangyunjing on 2016/11/2.
 */
public interface LoveMapper extends MyMapper<User> {

    Love getMyLove();
}
