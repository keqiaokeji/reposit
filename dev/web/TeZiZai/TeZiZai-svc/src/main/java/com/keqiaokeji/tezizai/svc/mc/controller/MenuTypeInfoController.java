package com.keqiaokeji.tezizai.svc.mc.controller;

import com.keqiaokeji.tezizai.common.app.JsonResultContants;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuTypeInfo;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuTypeInfo;
import com.keqiaokeji.tezizai.svc.mc.service.MenuTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 公司管理
 */
@Controller
public class MenuTypeInfoController {

    @Autowired
    MenuTypeInfoService menuTypeInfoService;

    @ResponseBody
    @RequestMapping(value = "/user/mc/getMenuTypeInfoList")
    public JQGridPage getMenuTypeInfoList(JQGridPage pageJQGrid) {
        return menuTypeInfoService.getListByJQgrid(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/user/mc/getMenuTypeList")
    public JsonResult getMenuType() {
        List<McMenuTypeInfo> list = menuTypeInfoService.getMenuTypeInfo();
        JsonResult result = new JsonResult(JsonResultContants.SUCCESS, "菜单类型获取成功", list);
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/customer/mc/getMenuTypeList")
    public JsonResult getMenuTypeListCustomer() {
        List<McMenuTypeInfo> list = menuTypeInfoService.getMenuTypeInfo();
        JsonResult result = new JsonResult(JsonResultContants.SUCCESS, "菜单类型获取成功", list);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/user/mc/editMenuTypeInfo")
    public void editMenuTypeInfo(MenuTypeInfo menuTypeInfo) {
        if (menuTypeInfo.getOper().equals(JQGridContants.EDIT_OPER_ADD)) {
            menuTypeInfoService.add(menuTypeInfo);
        } else if (menuTypeInfo.getOper().equals(JQGridContants.EDIT_OPER_UPDATE)) {
            menuTypeInfo.setMenuTypeId(menuTypeInfo.getId());
            menuTypeInfoService.update(menuTypeInfo);
        } else if (menuTypeInfo.getOper().equals(JQGridContants.EDIT_OPER_DEL)) {
            String[] ids = menuTypeInfo.getId().split(",");
            for (String id : ids) {
                menuTypeInfoService.delete(id);
            }
        }
    }


}
