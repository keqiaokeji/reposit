package com.keqiaokeji.tezizai.web.uc.controller;

import com.keqiaokeji.tezizai.common.cache.verifycode.AccreditCodeCache;
import com.keqiaokeji.tezizai.common.cache.verifycode.VerifyCodeCache;
import com.keqiaokeji.tezizai.common.utils.JQGridContants;
import com.keqiaokeji.tezizai.common.utils.JQGridPage;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.web.uc.domain.UserInfo;
import com.keqiaokeji.tezizai.web.uc.service.UserService;
import com.keqiaokeji.tezizai.web.utils.JsonResultContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 用户管理
 */
@Controller//声明为控制器（使用Controller将该类标记为spring mvc解析的类，类似Struts中的Action）
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    VerifyCodeCache verifyCodeCache;

    @Autowired
    AccreditCodeCache accreditCodeCache;


    @ResponseBody
    @RequestMapping(value = "/anonymous/uc/loginUserWithVerifyCode")
    public JsonResult loginUserWithVerifyCode(String username, String password, String codeKey, String codeContent) {
        JsonResult result = null;
        if (verifyCodeCache.checkVerifyCode(codeKey, codeContent)) {//验证码正确
            result = userService.loginUser(username, password);
        } else {
            result = new JsonResult(JsonResultContants.VERIFY_CODE_FAIL, JsonResultContants.VERIFY_CODE_FAIL_MSG);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/anonymous/uc/loginUserWithAccreditCode")
    public JsonResult loginUserWithAccreditCode(String username, String password, String accreditCode) {
        JsonResult result = null;
        if (accreditCodeCache.checkAccreditCode(accreditCode)) {
            result = userService.loginUser(username, password);
        } else {
            result = new JsonResult(JsonResultContants.ACCREDIt_CODE_FAIL, JsonResultContants.ACCREDIt_CODE_FAIL_MSG);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/anonymous/uc/regUser")
    public JsonResult regUser(UserInfo userInfo, String codeKey, String codeContent) {
        JsonResult result = null;
        if (verifyCodeCache.checkVerifyCode(codeKey, codeContent)) {//验证码正确
            result = userService.regUser(userInfo);
        } else {
            result = new JsonResult(JsonResultContants.VERIFY_CODE_FAIL, JsonResultContants.VERIFY_CODE_FAIL_MSG);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/anonymous/uc/findPasswordUser")
    public JsonResult findPasswordUser(String email, String codeKey, String codeContent) {
        JsonResult result = null;
        if (verifyCodeCache.checkVerifyCode(codeKey, codeContent)) {//验证码正确
            result = userService.findPasswordUser(email);
        } else {
            result = new JsonResult(JsonResultContants.VERIFY_CODE_FAIL, JsonResultContants.VERIFY_CODE_FAIL_MSG);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/admin/uc/getUserList")
    public JQGridPage getUserList(JQGridPage pageJQGrid) {
        return userService.getUserInfoList(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/admin/uc/editUserInfo")
    public void editUserInfo(UserInfo userInfo) {
        if (userInfo.getOper().equals(JQGridContants.EDIT_OPER_ADD)) {
            userService.add(userInfo);
        } else if (userInfo.getOper().equals(JQGridContants.EDIT_OPER_UPDATE)) {
            userInfo.setUserId(userInfo.getId());
            userService.update(userInfo);
        } else if (userInfo.getOper().equals(JQGridContants.EDIT_OPER_DEL)) {
            String[] ids = userInfo.getId().split(",");
            for (String id : ids) {
                userService.delete(id);
            }
        }
    }


}
