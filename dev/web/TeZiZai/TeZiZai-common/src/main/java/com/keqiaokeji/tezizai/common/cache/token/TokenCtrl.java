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
     * 验证Token是否过期及初始化当前线程的缓存信息
     * 如果未过期则初始化当前线程的用户信息
     * 如果过期则移除该Token值
     *
     * @param token Token字符串
     * @return true：未过期，false：过期
     */
    public boolean checkTokenTimeOutAndInitThreadLocal(String token);

    /**
     * 根据Token获得用户信息
     *
     * @param token token值
     * @return 用户信息或null
     */
    public UcUserInfo getUcUserInfo(String token);

    /**
     * 取出当前用户的用户信息（通过当前线程中的token获取）
     *
     * @return 用户信息
     */
    public UcUserInfo getCurrentUcUserInfo();

}
