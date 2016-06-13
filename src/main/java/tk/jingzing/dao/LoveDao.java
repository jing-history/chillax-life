package tk.jingzing.dao;

import tk.jingzing.entity.Love;

/**
 * Created by wangyunjing on 16/6/9.
 */
public interface LoveDao {

    public Love getMyLove();

    void asyncStatus(String status);
}
