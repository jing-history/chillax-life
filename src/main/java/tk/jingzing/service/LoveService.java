package tk.jingzing.service;

import tk.jingzing.model.Love;

/**
 * Created by wangyunjing on 16/6/9.
 */
public interface LoveService {

    public Love getMyLove();

    void asyncStatus(String status);
}
