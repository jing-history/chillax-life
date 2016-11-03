package tk.jingzing.model;

/**
 * User类的CRUD操作
 * Created by wangyunjing on 2016/11/2.
 */
public interface UserRepository {

    public User findByUsername(String username);
}
