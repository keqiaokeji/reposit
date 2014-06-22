package com.keqiaokeji.tezizai.svc.mc.controller;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
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

    @ResponseBody
    @RequestMapping(value = "/user/mc/getMenuTableInfoList")
    public JQGridPage getMenuTableInfoList(JQGridPage pageJQGrid) {
        return menuTableInfoService.getListByJQgrid(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/user/mc/editMenuTableInfo")
    public void editMenuTableInfo(MenuTableInfo menuTableInfo) {
        if (menuTableInfo.getOper().equals(JQGridContants.EDIT_OPER_ADD)) {
            menuTableInfoService.add(menuTableInfo);
        } else if (menuTableInfo.getOper().equals(JQGridContants.EDIT_OPER_UPDATE)) {
            menuTableInfo.setMenuTableId(menuTableInfo.getId());
            menuTableInfoService.update(menuTableInfo);
        } else if (menuTableInfo.getOper().equals(JQGridContants.EDIT_OPER_DEL)) {
            String[] ids = menuTableInfo.getId().split(",");
            for (String id : ids) {
                menuTableInfoService.delete(id);
            }
        }
    }


}
