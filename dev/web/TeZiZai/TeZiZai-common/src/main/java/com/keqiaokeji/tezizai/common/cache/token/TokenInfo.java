package com.keqiaokeji.tezizai.common.cache.token;

/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-14
 * Time: 下午10:16
 * To change this template use File | Settings | File Templates.
 */
public class TokenInfo {

    private String userId;

    private String token;

    private Long lastUseTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime(Long lastUseTime) {
        this.lastUseTime = lastUseTime;
    }
}
