package com.keqiaokeji.tezizai.common.cache.token;

import com.keqiaokeji.tezizai.common.character.StringUtils;
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
@Service("tokenCache")
public class TokenCache {

    private Hashtable<String, TokenInfo> tokens = new Hashtable<String, TokenInfo>();

    /**
     * 新增用户Token(用户登录成功之后添加)
     *
     * @param userId 用户ID
     * @return 返回Token值
     */
    public String addToken(String userId) {
        String tokenContent = StringUtils.getUUID();
        TokenInfo token = new TokenInfo();
        token.setUserId(userId);
        token.setToken(tokenContent);
        token.setLastUseTime(new Date().getTime());
        tokens.put(tokenContent, token);
        return tokenContent;
    }


    /**
     * 验证Token是否过期
     * 如果为过期则继续使用并修改最后使用时间为当前时间
     * 如果过去则移除该Token值
     * @param token Token字符串
     * @return true：未过期，false：过期
     */
    public boolean checkTokenTimeOut(String token) {
        boolean result = false;
        TokenInfo tokenInfo = tokens.get(token);
        if (tokenInfo != null) {
            long currentTime = new Date().getTime();
            long timeSpace = currentTime - tokenInfo.getLastUseTime();
            if (timeSpace < 1000 * 60 * 60) {//如果距离最后一次使用时间不超过一小时则可继续使用
                tokenInfo.setLastUseTime(currentTime);
                result = true;
            } else {//如果已经过时则移除该用户
                tokens.remove(token);
            }
        }
        return result;
    }

    public TokenInfo getTokenInfo(String token){
        return tokens.get(token);
    }


}
