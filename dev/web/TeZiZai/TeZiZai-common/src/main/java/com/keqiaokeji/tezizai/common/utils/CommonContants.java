package com.keqiaokeji.tezizai.common.utils;

/**
 * Created by keqiaokeji on 14-5-23.
 */
public class CommonContants {

    public static final String RECORD_STATUS_INSERT = "INSERT";//新增记录
    public static final String RECORD_STATUS_UPDATE = "UPDATE";//修改记录
    public static final String RECORD_STATUS_DELETE = "DELETE";//删除记录

    public static final String TOKEN_KEY = "TOKEN";//Token的键
    public static final String CORP_ID_KEY = "CORP_ID";//公司ID的键
    public static final String USER_ID_KEY = "USER_ID";//用户ID的键
    public static final String ROLES_KEY = "ROLES";//用户角色

    public static final String ROLES_ROOT = "ROOT";//超级管理员（系统总管理员，有添加公司的权限）
    public static final String ROLES_ADMIN = "ADMIN";//管理员（客户管理员，有新增员工的权限）
    public static final String ROLES_USER = "USER";//普通用户（如员工）


}
