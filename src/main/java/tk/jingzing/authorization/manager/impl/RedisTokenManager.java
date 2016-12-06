package tk.jingzing.authorization.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.jingzing.authorization.config.Constants;
import tk.jingzing.authorization.manager.TokenManager;
import tk.jingzing.authorization.model.TokenModel;
import tk.jingzing.cache.RedisCache;

import java.util.UUID;

/**
 * 通过Redis存储和验证token的实现类
 * Created by wangyunjing on 2016/11/3.
 */
@Component
public class RedisTokenManager implements TokenManager{
    @Autowired
    private RedisCache cache;


    private final static String CACHE_KEY=RedisCache.CAHCENAME+"|userToken|";

    @Override
    public TokenModel createToken(long userId) {
        String cache_key = CACHE_KEY + userId;
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId,token);
        //存储到redis并设置过期时间
        cache.putCacheWithExpireTime(cache_key,token,Constants.TOKEN_EXPIRES_HOUR * 3600);
    //    redis.boundValueOps(userId).set(token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if(model == null){
            return false;
        }
        String cache_key = CACHE_KEY + model.getUserId();
     //   String token = redis.boundValueOps(model.getUserId()).get();
        String token = cache.getCache(cache_key,String.class);
        if(token == null || !token.equals(model.getToken())){
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
    //    redis.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR,TimeUnit.HOURS);
        cache.setExpireTime(cache_key);
        return true;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("-");
        if(param.length != 2){
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new TokenModel(userId,token);
    }

    @Override
    public void deleteToken(long userId) {
        cache.deleteCache(CACHE_KEY + userId);
    }
}
