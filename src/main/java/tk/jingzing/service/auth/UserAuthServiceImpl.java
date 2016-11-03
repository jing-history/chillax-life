package tk.jingzing.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jingzing.mapper.UserAuthMapper;
import tk.jingzing.model.User;

/**
 * Created by wangyunjing on 2016/11/2.
 */
@Service
public class UserAuthServiceImpl implements UserAuthService{

    @Autowired
    private UserAuthMapper mapper;
    @Override
    public User findByUsername(String username) {
        return mapper.findByUsername(username);
    }

    @Override
    public User findOne(Long currentUserId) {
        return mapper.findOne(currentUserId);
    }
}
