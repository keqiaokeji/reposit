package com.keqiaokeji.tezizai.web.uc.controller;

import com.alibaba.fastjson.JSONObject;
import com.keqiaokeji.tezizai.common.app.JsonResultContants;
import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.common.file.Uploader;
import com.keqiaokeji.tezizai.web.uc.domain.UserInfo;
import com.keqiaokeji.tezizai.web.uc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


/**
 * 用户管理
 */
@Controller//声明为控制器（使用Controller将该类标记为spring mvc解析的类，类似Struts中的Action）
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CacheCtrl cacheCtrl;

    @Autowired
    private Uploader uploader;

    @ResponseBody
    @RequestMapping(value = "/anonymous/uc/loginUserWithVerifyCode")
    public JsonResult loginUserWithVerifyCode(String username, String password, String codeKey, String codeContent) {
        JsonResult result = null;
        if (cacheCtrl.getVerifyCodeCache().checkVerifyCode(codeKey, codeContent)) {//验证码正确
            result = userService.loginUser(username, password);
        } else {
            result = new JsonResult(JsonResultContants.FAIL, JsonResultContants.VERIFY_CODE_FAIL_MSG);
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
            result = new JsonResult(JsonResultContants.FAIL, JsonResultContants.ACCREDIt_CODE_FAIL_MSG);
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
            result = new JsonResult(JsonResultContants.FAIL, JsonResultContants.VERIFY_CODE_FAIL_MSG);
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
            result = new JsonResult(JsonResultContants.FAIL, JsonResultContants.VERIFY_CODE_FAIL_MSG);
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


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/imgupload")
    public String uploadImg(HttpServletRequest request, @RequestParam("imgFile") MultipartFile imgFile) {
        String uploadDir = request.getRealPath("/upload");
        File dirPath = new File(uploadDir);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        String uuid = StringUtils.getUUID();
        String oriName = imgFile.getOriginalFilename();
        //文件名后缀处理---start---
        String _suffix = oriName.substring(oriName.lastIndexOf(".") + 1, oriName.length());
        //---重新处理文件名start---
        String suffix = oriName.substring(oriName.lastIndexOf("."), oriName.length());
        String newFileName = uuid + suffix;
        try {
            imgFile.transferTo(new File(uploadDir + "/" + newFileName));

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //---end---
        JSONObject object = new JSONObject();
        object.put("success", "true");
        object.put("filePath", "http");
        return JSONObject.toJSONString(object);

    }

//    @ResponseBody
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public JsonResult upload(@RequestParam(value = "avatar", required = false) MultipartFile avatar) {
//        JsonResult result = new JsonResult();
//        try {
////            String fileName = avatar.getOriginalFilename();
//            String fileName = "111.jpg";
//            File targetFile = new File(uploader.getSavePath(), fileName);
//            if (!targetFile.exists()) {
//                targetFile.mkdirs();
//            }
//            avatar.transferTo(targetFile);
//        } catch (Exception e) {
//            e.printStackTrace();
////            result.setSuccess(false);
////            result.setMsg(e.getMessage());
//        }
//        return result;
//    }


}
