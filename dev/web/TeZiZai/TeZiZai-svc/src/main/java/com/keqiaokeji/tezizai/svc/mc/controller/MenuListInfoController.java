package com.keqiaokeji.tezizai.svc.mc.controller;

import com.keqiaokeji.tezizai.common.app.JsonResultContants;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.svc.mc.service.MenuInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 公司管理
 */
@Controller
public class MenuListInfoController {

    @Autowired
    MenuInfoService menuInfoService;


    Logger logger = Logger.getLogger(MenuListInfoController.class.getName());




    @ResponseBody
    @RequestMapping(value = "/user/mc/addMenuListInfo", method = RequestMethod.POST)
    public JsonResult addMenuListInfo() {
        JsonResult result;
        String menuListId = StringUtils.getUUID();


        result = new JsonResult(JsonResultContants.SUCCESS, "新增成功！");
        return result;
    }



}
