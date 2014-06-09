package com.keqiaokeji.tezizai.svc.uc.controller;

import com.keqiaokeji.tezizai.common.app.JsonResultContants;
import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.svc.uc.domain.UserInfo;
import com.keqiaokeji.tezizai.svc.uc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * 用户管理
 */
@Controller//声明为控制器（使用Controller将该类标记为spring mvc解析的类，类似Struts中的Action）
public class UserInfoController {

    @Autowired
    UserInfoService userService;

    @Autowired
    CacheCtrl cacheCtrl;


    @ResponseBody
    @RequestMapping(value = "/anonymous/uc/loginUserWithVerifyCode")
    public JsonResult loginUserWithVerifyCode(String username, String password, String codeKey, String codeContent) {
        JsonResult result = null;
        if (cacheCtrl.getVerifyCodeCache().checkVerifyCode(codeKey, codeContent)) {//验证码正确
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
        if (cacheCtrl.getAccreditCodeCache().checkAccreditCode(accreditCode)) {
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
        if (cacheCtrl.getVerifyCodeCache().checkVerifyCode(codeKey, codeContent)) {//验证码正确
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
        if (cacheCtrl.getVerifyCodeCache().checkVerifyCode(codeKey, codeContent)) {//验证码正确
            result = userService.findPasswordUser(email);
        } else {
            result = new JsonResult(JsonResultContants.VERIFY_CODE_FAIL, JsonResultContants.VERIFY_CODE_FAIL_MSG);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/admin/uc/getUserInfoList")
    public JQGridPage getUserInfoList(JQGridPage pageJQGrid) {
        return userService.getListByJQgrid(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/admin/uc/editUserInfo")
    public void editUserInfo(UserInfo userInfo, HttpServletResponse response) {
        String result = null;
        if (userInfo.getOper().equals(JQGridContants.EDIT_OPER_ADD)) {
            userService.add(userInfo);
        } else if (userInfo.getOper().equals(JQGridContants.EDIT_OPER_UPDATE)) {
            userInfo.setUserId(userInfo.getId());
            userService.update(userInfo);
            result = "用户名已经存在！";
        } else if (userInfo.getOper().equals(JQGridContants.EDIT_OPER_DEL)) {
            String[] ids = userInfo.getId().split(",");
            for (String id : ids) {
                userService.delete(id);
            }
        }
        if (result != null) {
            response.setContentType("text/json; charset=UTF-8");
            try {
                PrintWriter out = response.getWriter();
                out.print(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
