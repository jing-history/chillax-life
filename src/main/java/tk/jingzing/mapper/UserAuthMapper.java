package tk.jingzing.mapper;

import tk.jingzing.model.User;
import tk.jingzing.util.MyMapper;

/**
 * Created by wangyunjing on 2016/11/2.
 */
public interface UserAuthMapper extends MyMapper<User> {

    User findByUsername(String username);

    User findOne(Long currentUserId);
}
