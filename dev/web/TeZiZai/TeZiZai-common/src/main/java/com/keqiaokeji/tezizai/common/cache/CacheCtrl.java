package com.keqiaokeji.tezizai.common.cache;

import com.keqiaokeji.tezizai.common.cache.token.TokenCtrl;
import com.keqiaokeji.tezizai.common.cache.verifycode.AccreditCodeCache;
import com.keqiaokeji.tezizai.common.cache.verifycode.VerifyCodeCache;
import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shk on 14-6-5.
 */
@Service("cacheCtrl")
public class CacheCtrl {


    @Resource(name = "tokenLocalCache")
    private TokenCtrl tokenCtrl;

    @Autowired
    private VerifyCodeCache verifyCodeCache;


    @Autowired
    AccreditCodeCache accreditCodeCache;


    public TokenCtrl getTokenCtrl() {
        return tokenCtrl;
    }

    public void setTokenCtrl(TokenCtrl tokenCtrl) {
        this.tokenCtrl = tokenCtrl;
    }

    public VerifyCodeCache getVerifyCodeCache() {
        return verifyCodeCache;
    }

    public void setVerifyCodeCache(VerifyCodeCache verifyCodeCache) {
        this.verifyCodeCache = verifyCodeCache;
    }

    public AccreditCodeCache getAccreditCodeCache() {
        return accreditCodeCache;
    }

    public void setAccreditCodeCache(AccreditCodeCache accreditCodeCache) {
        this.accreditCodeCache = accreditCodeCache;
    }

    /**
     * 获得当前用户的用户信息
     *
     * @return 当前用户的用户信息
     */
    public UcUserInfo getCurrentUcUserInfo() {
        return tokenCtrl.getCurrentUcUserInfo();
    }

}
