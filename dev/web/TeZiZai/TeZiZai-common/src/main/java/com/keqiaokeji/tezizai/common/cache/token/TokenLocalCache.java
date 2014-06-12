package com.keqiaokeji.tezizai.common.cache.token;

import com.keqiaokeji.tezizai.common.app.AppCommonContexts;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;
import com.keqiaokeji.tezizai.common.utils.CommonContants;
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

    private final long TIMEOUT = 1000 * 60 * 60 * 24 * 7;//超时时间为7天
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

    public boolean checkTokenTimeOutAndInitThreadLocal(String token) {
        boolean result = false;
        TokenInfo tokenInfo = tokens.get(token);
        if (tokenInfo != null) {
            long timeSpace = new Date().getTime() - tokenInfo.getLastUseTime();
            if (timeSpace < TIMEOUT) {
                initThreadLocal(token, tokenInfo.getUcUserInfo());
                result = true;
            } else {//如果已经过时则移除该用户
                tokens.remove(token);
            }
        }
        return result;
    }

    private void initThreadLocal(String token, UcUserInfo ucUserInfo) {
        AppCommonContexts.setThreadLocalMap(CommonContants.TOKEN_KEY, token);
        AppCommonContexts.setThreadLocalMap(CommonContants.CORP_ID_KEY, ucUserInfo.getCorpId());
        AppCommonContexts.setThreadLocalMap(CommonContants.USER_ID_KEY, ucUserInfo.getUserId());
        AppCommonContexts.setThreadLocalMap(CommonContants.ROLES_KEY, ucUserInfo.getRoles());
    }

    public TokenInfo getTokenInfo(String token) {
        return tokens.get(token);
    }


    public UcUserInfo getUcUserInfo(String token) {
        return tokens.get(token).getUcUserInfo();
    }

    public UcUserInfo getCurrentUcUserInfo() {
        return getUcUserInfo(AppCommonContexts.getThreadLocalMapValue(CommonContants.TOKEN_KEY));
    }

}
