package com.keqiaokeji.tezizai.common.cache.token;

import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;

/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-14
 * Time: 下午10:16
 * To change this template use File | Settings | File Templates.
 */
public class TokenInfo {

    private UcUserInfo ucUserInfo;

    private String token;

    private Long lastUseTime;

    public UcUserInfo getUcUserInfo() {
        return ucUserInfo;
    }

    public void setUcUserInfo(UcUserInfo ucUserInfo) {
        this.ucUserInfo = ucUserInfo;
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
