package com.keqiaokeji.tezizai.common.cache.token;

import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-14
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
@Service("tokenLocalCache")
public class TokenLocalCache implements TokenCtrl {

    private final long TIMEOUT = 1000 * 60 * 60;//超时时间为1小时
    private final String TOKEN_PREFIX = "token_";


    private Hashtable<String, TokenInfo> tokens = new Hashtable<String, TokenInfo>();


    public String addToken(UcUserInfo ucUserInfo) {
        String tokenContent = StringUtils.getUUID();
        TokenInfo token = new TokenInfo();
        token.setUcUserInfo(ucUserInfo);
        token.setToken(tokenContent);
        token.setLastUseTime(new Date().getTime());
        tokens.put(tokenContent, token);
        return tokenContent;
    }

    public boolean checkTokenTimeOut(String token) {
        boolean result = false;
        TokenInfo tokenInfo = tokens.get(token);
        if (tokenInfo != null) {
            long currentTime = new Date().getTime();
            long timeSpace = currentTime - tokenInfo.getLastUseTime();
            if (timeSpace < TIMEOUT) {//如果距离最后一次使用时间不超过一小时则可继续使用
                tokenInfo.setLastUseTime(currentTime);
                result = true;
            } else {//如果已经过时则移除该用户
                tokens.remove(token);
            }
        }
        return result;
    }

    public TokenInfo getTokenInfo(String token) {
        return tokens.get(token);
    }


    public UcUserInfo getUcUserInfo(String token) {
        return tokens.get(token).getUcUserInfo();
    }

}
