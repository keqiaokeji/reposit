package com.keqiaokeji.tezizai.common.cache.token;

import com.keqiaokeji.tezizai.common.app.AppCommonContexts;
import com.keqiaokeji.tezizai.common.cache.Jedis.JedisTools;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;
import com.keqiaokeji.tezizai.common.utils.CommonContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-14
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
@Service("tokenRedisCache")
public class TokenRedisCache implements TokenCtrl{

    @Autowired
    JedisTools jedisTools;

    private final long TIMEOUT = 60 * 60;//超时时间为1小时
    private final String TOKEN_PREFIX = "token_";


    public String addToken(UcUserInfo ucUserInfo) {
        String token = StringUtils.getUUID();
        jedisTools.setObject(getJedisToken(token), ucUserInfo, TIMEOUT);
        return token;
    }

    public boolean checkTokenTimeOutAndInitThreadLocal(String token) {
        return jedisTools.exitsAndSetTimeout(getJedisToken(token), TIMEOUT);
    }

    public UcUserInfo getUcUserInfo(String token){
        return jedisTools.getObject(getJedisToken(token), UcUserInfo.class);
    }

    public UcUserInfo getCurrentUcUserInfo(){
        String token = getJedisToken(AppCommonContexts.getThreadLocalMapValue(CommonContants.TOKEN_KEY));
        return getUcUserInfo(token);
    }

    private String getJedisToken(String token) {
        return TOKEN_PREFIX + token;
    }


}
