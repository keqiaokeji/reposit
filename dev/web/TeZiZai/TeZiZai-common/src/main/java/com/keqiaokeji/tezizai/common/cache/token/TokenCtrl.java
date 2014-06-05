package com.keqiaokeji.tezizai.common.cache.token;

import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;

/**
 * Created by shk on 14-6-4.
 */
public interface TokenCtrl {


    /**
     * 新增用户Token(用户登录成功之后添加)
     *
     * @param ucUserInfo 用户信息
     * @return 返回Token值
     */
    public String addToken(UcUserInfo ucUserInfo);

    /**
     * 验证Token是否过期
     * 如果为过期则继续使用并修改最后使用时间为当前时间
     * 如果过去则移除该Token值
     *
     * @param token Token字符串
     * @return true：未过期，false：过期
     */
    public boolean checkTokenTimeOut(String token);

    /**
     * 根据Token获得用户信息
     *
     * @param token token值
     * @return 用户信息或null
     */
    public UcUserInfo getUcUserInfo(String token);

}
