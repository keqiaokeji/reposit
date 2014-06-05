package com.keqiaokeji.tezizai.common.app;

/**
 * Created by keqiaokeji on 14-5-19.
 */
public class JsonResultContants {


    public final static String SUCCESS = "SUCCESS";//操作成功
    public final static String FAIL = "FAIL";//操作失败

    public final static String TOKEN_TIME_OUT = "TOKEN_TIME_OUT";
    public final static String TOKEN_TIME_OUT_MSG = "登录信息已经过期，请重新登录！";

    public final static String VERIFY_CODE_SUCESS = "VERIFY_CODE_SUCESS";
    public final static String VERIFY_CODE_SUCESS_MSG = "验证码正确！";
    public final static String VERIFY_CODE_FAIL = "VERIFY_CODE_FAIL";
    public final static String VERIFY_CODE_FAIL_MSG = "验证码不正确！";


    public final static String ACCREDIt_CODE_SUCESS = "ACCREDIt_CODE_SUCESS";
    public final static String ACCREDIt_CODE_SUCESS_MSG = "授权码正确！";
    public final static String ACCREDIt_CODE_FAIL = "ACCREDIt_CODE_FAIL";
    public final static String ACCREDIt_CODE_FAIL_MSG = "授权码不正确！";


    public final static String LOGIN_USERNAME_PASSWORD_ERROR = "LOGIN_USERNAME_PASSWORD_ERROR";
    public final static String LOGIN_USERNAME_PASSWORD_ERROR_MSG = "用户名或密码错误！";
    public final static String LOGIN_SUCCESS = "LOGIN_SUCCESS";
    public final static String LOGIN_SUCCESS_MSG = "登录成功！";

    public final static String USER_STATE_NORMAL = "USER_STATE_NORMAL";//正常状态
    public final static String USER_STATE_FORBIDDEN = "USER_STATE_FORBIDDEN";
    public final static String USER_STATE_FORBIDDEN_MSG = "用户被禁用！";
    public final static String USER_STATE_FREEZE = "USER_STATE_FREEZE";
    public final static String USER_STATE_FREEZE_MSG = "用户被冻结！";

    public final static String REG_USERNAME_EXSIT = "REG_USERNAME_EXSIT";
    public final static String REG_USERNAME_EXSIT_MSG = "用户名已经存在！";
    public final static String REG_EMAIL_EXSIT = "REG_EMAIL_EXSIT";
    public final static String REG_EMAIL_EXSIT_MSG = "邮箱已经存在！";
    public final static String REG_SUCCESS = "REG_SUCCESS";
    public final static String REG_SUCCESS_MSG = "注册成功！";

    public final static String FIND_PASSWORD_EMAIL_NOT_EXSIT = "FIND_PASSWORD_EMAIL_NOT_EXSIT";
    public final static String FIND_PASSWORD_EMAIL_NOT_EXSIT_MSG = "邮箱不存在！";
    public final static String FIND_PASSWORD_SUCCESS = "FIND_PASSWORD_SUCCESS";
    public final static String FIND_PASSWORD_SUCCESS_MSG = "找回密码成功！邮件已经发送到你填写的邮箱，请查收邮件！";
    public final static String FIND_PASSWORD_FAIL = "FIND_PASSWORD_FAIL";
    public final static String FIND_PASSWORD_FAIL_MSG = "找回密码失败！邮件发送失败，请检查邮箱填写是否正确！";

}
