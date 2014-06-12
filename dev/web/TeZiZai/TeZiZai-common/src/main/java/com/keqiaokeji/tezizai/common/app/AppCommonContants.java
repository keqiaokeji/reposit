package com.keqiaokeji.tezizai.common.app;

import com.keqiaokeji.tezizai.common.utils.CommonContants;

/**
 * Created by keqiaokeji on 14-5-23.
 */
public class AppCommonContants extends CommonContants{


    /**
     * 对密码进行DES加密时使用的密钥
     */
    public static final String PASSWORD_DES = "3423fwewefwf";

    public static final String STATUS_NORMOR = "STATUS_NORMOR";
    public static final String STATE_FORBIDDEN = "STATE_FORBIDDEN";
    public static final String STATE_FREEZE = "STATE_FREEZE";



    public static final String TOKEN_KEY = "TOKEN";//Token的键
    public static final String CORP_ID_KEY = "CORP_ID";//公司ID的键
    public static final String USER_ID_KEY = "USER_ID";//用户ID的键
    public static final String ROLES_KEY = "ROLES";//用户角色

    public static final String ROLES_ROOT = "ROOT";//超级管理员（系统总管理员，有添加公司的权限）
    public static final String ROLES_ADMIN = "ADMIN";//管理员（客户管理员，有新增员工的权限）
    public static final String ROLES_USER = "USER";//普通用户（如员工）


}
