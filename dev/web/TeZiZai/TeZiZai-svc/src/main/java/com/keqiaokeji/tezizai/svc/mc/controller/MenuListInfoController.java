package com.keqiaokeji.tezizai.svc.mc.controller;

import com.keqiaokeji.tezizai.common.app.JsonResultContants;
import com.keqiaokeji.tezizai.common.cache.menu.MenuConstants;
import com.keqiaokeji.tezizai.common.cache.menu.MenuLocalCache;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuListInfo;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.svc.mc.service.MenuListInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 公司管理
 */
@Controller
public class MenuListInfoController {

    @Autowired
    MenuListInfoService menuListInfoService;

    @Autowired
    MenuLocalCache menuLocalCache;


    Logger logger = Logger.getLogger(MenuListInfoController.class.getName());


    @ResponseBody
    @RequestMapping(value = "/customer/mc/addMenuListInfo", method = RequestMethod.POST)
    public JsonResult addMenuListInfo(String menuTableId, McMenuListInfo mcMenuListInfo) {
        JsonResult<List<McMenuListInfo>> result = null;
        List<McMenuListInfo> menuLists = menuLocalCache.addMenuListInfo(menuTableId, mcMenuListInfo);
        result = new JsonResult<List<McMenuListInfo>>(JsonResultContants.SUCCESS, "新增成功！", menuLists);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/customer/mc/getMenuListInfos", method = RequestMethod.POST)
    public JsonResult<List<McMenuListInfo>> getMenuListInfos(String menuTableId) {
        List<McMenuListInfo> menuLists = menuLocalCache.getMenuListInfos(menuTableId);
        return new JsonResult<List<McMenuListInfo>>(JsonResultContants.SUCCESS, "获取菜单信息成功！", menuLists);
    }

    @ResponseBody
    @RequestMapping(value = "/customer/mc/orderMenuListInfos", method = RequestMethod.POST)
    public JsonResult<List<McMenuListInfo>> orderMenuListInfos(String menuTableId) {
        List<McMenuListInfo> menuLists = menuLocalCache.getMenuListInfos(menuTableId);
        for (McMenuListInfo menuListInfo:menuLists){
            if(menuListInfo.getStatus().equalsIgnoreCase(MenuConstants.MENU_LIST_STATUS_UNCONFIRM)){
                menuListInfo.setStatus(MenuConstants.MENU_LIST_STATUS_CONFIRM);
                menuListInfoService.add(menuListInfo);
            }
        }
        return new JsonResult<List<McMenuListInfo>>(JsonResultContants.SUCCESS, "获取菜单信息成功！", menuLists);
    }



}
