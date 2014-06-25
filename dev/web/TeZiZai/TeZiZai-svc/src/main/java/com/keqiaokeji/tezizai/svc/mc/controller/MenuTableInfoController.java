package com.keqiaokeji.tezizai.svc.mc.controller;

import com.keqiaokeji.tezizai.common.app.JsonResultContants;
import com.keqiaokeji.tezizai.common.cache.menu.MenuLocalCache;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuTableInfo;
import com.keqiaokeji.tezizai.svc.mc.service.MenuTableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 公司管理
 */
@Controller
public class MenuTableInfoController {

    @Autowired
    MenuTableInfoService menuTableInfoService;

    @Autowired
    MenuLocalCache menuLocalCache;

    @ResponseBody
    @RequestMapping(value = "/user/mc/getMenuTableInfoList")
    public JQGridPage getMenuTableInfoList(JQGridPage pageJQGrid) {
        return menuTableInfoService.getListByJQgrid(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/user/mc/editMenuTableInfo")
    public JsonResult editMenuTableInfo(MenuTableInfo menuTableInfo) {
        JsonResult jsonResult = null;
        if (menuTableInfo.getOper().equals(JQGridContants.EDIT_OPER_ADD)) {
            menuTableInfo.setMenuTableId(menuLocalCache.addMenuTable());
            menuTableInfoService.add(menuTableInfo);
            jsonResult = new JsonResult(JsonResultContants.SUCCESS, "新增成功", menuTableInfo.getMenuTableId());
        } else if (menuTableInfo.getOper().equals(JQGridContants.EDIT_OPER_UPDATE)) {
            menuTableInfo.setMenuTableId(menuTableInfo.getId());
            menuTableInfoService.update(menuTableInfo);
            jsonResult = new JsonResult(JsonResultContants.SUCCESS, "修改成功");
        } else if (menuTableInfo.getOper().equals(JQGridContants.EDIT_OPER_DEL)) {
            String[] ids = menuTableInfo.getId().split(",");
            for (String id : ids) {
                menuTableInfoService.delete(id);
            }
            jsonResult = new JsonResult(JsonResultContants.SUCCESS, "删除成功");
        }
        return jsonResult;
    }


}
