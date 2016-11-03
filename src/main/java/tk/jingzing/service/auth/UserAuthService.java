package tk.jingzing.service.auth;

import tk.jingzing.model.User;

/**
 * Created by wangyunjing on 2016/11/2.
 */
public interface UserAuthService {

    public User findByUsername(String username);

    User findOne(Long currentUserId);
}
