package tk.jingzing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jingzing.dao.LoveDao;
import tk.jingzing.entity.Love;
import tk.jingzing.service.LoveService;

/**
 * Created by wangyunjing on 16/6/9.
 */
@Service
public class LoveServiceImpl implements LoveService{

    @Autowired
    private LoveDao loveDao;

    @Override
    public Love getMyLove() {
        return loveDao.getMyLove();
    }
}