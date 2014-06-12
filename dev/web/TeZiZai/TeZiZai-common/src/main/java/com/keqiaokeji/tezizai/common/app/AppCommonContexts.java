package com.keqiaokeji.tezizai.common.app;

import com.keqiaokeji.tezizai.common.utils.CommonContants;
import com.keqiaokeji.tezizai.common.utils.CommonContexts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-10
 * Time: 下午2:56
 * To change this template use File | Settings | File Templates.
 */
public class AppCommonContexts extends CommonContexts{

    /**
     * 该变量存在于当前线程中（每次请求服务器时创建一个线程，该变量创建，请求结束之后线程回收，该变量也被回收）
     */
    transient static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<Map<String, String>>();



    /**
     * 获得当前登录用户Token值
     *
     * @return token值
     */
    public static String getToken() {
        return getThreadLocalMapValue(com.keqiaokeji.tezizai.common.utils.CommonContants.TOKEN_KEY);
    }

    /**
     * 获得当前用户所属公司的ID
     *
     * @return 公司ID
     */
    public static String getCorpId() {
        return getThreadLocalMapValue(com.keqiaokeji.tezizai.common.utils.CommonContants.CORP_ID_KEY);
    }

    /**
     * 获得当前用户的用户ID
     *
     * @return 用户ID
     */
    public static String getUserId() {
        return getThreadLocalMapValue(com.keqiaokeji.tezizai.common.utils.CommonContants.USER_ID_KEY);
    }

    /**
     * 获得当前用户的角色
     *
     * @return 角色值
     */
    public static String getRoles() {
        return getThreadLocalMapValue(CommonContants.ROLES_KEY);
    }


    /**
     * 获得直接下属的角色名
     *
     * @return 角色名
     */
    public static String getSubordinateRoles() {
        String result = AppCommonContants.ROLES_USER;
        String rolesCurrent = getRoles();
        if (AppCommonContants.ROLES_ROOT.equals(rolesCurrent)) {
            result = AppCommonContants.ROLES_ADMIN;
        } else if (AppCommonContants.ROLES_ADMIN.equals(rolesCurrent)) {
            result = AppCommonContants.ROLES_ADMIN;
        }
        return result;
    }

    /**
     * 向当前进程中设置信息
     *
     * @param key   信息的键
     * @param value 信息的值
     */
    public static void setThreadLocalMap(String key, String value) {
        Map<String, String> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, String>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    /**
     * 根据键从当前线程的缓存中取值
     *
     * @param key 键
     * @return 取出的值
     */
    public static String getThreadLocalMapValue(String key) {
        return threadLocal.get().get(key);
    }


}


