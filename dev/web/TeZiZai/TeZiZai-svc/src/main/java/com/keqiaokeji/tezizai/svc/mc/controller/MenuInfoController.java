package com.keqiaokeji.tezizai.svc.mc.controller;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuInfo;
import com.keqiaokeji.tezizai.svc.mc.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 公司管理
 */
@Controller
public class MenuInfoController {

    @Autowired
    MenuInfoService menuInfoService;

    @ResponseBody
    @RequestMapping(value = "/admin/mc/getMenuInfoList")
    public JQGridPage getMenuInfoList(JQGridPage pageJQGrid) {
        return menuInfoService.getListByJQgrid(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/admin/mc/editMenuInfo")
    public void editMenuInfo(MenuInfo menuInfoInfo) {
        if (menuInfoInfo.getOper().equals(JQGridContants.EDIT_OPER_ADD)) {
            menuInfoService.add(menuInfoInfo);
        } else if (menuInfoInfo.getOper().equals(JQGridContants.EDIT_OPER_UPDATE)) {
            menuInfoInfo.setMenuId(menuInfoInfo.getId());
            menuInfoService.update(menuInfoInfo);
        } else if (menuInfoInfo.getOper().equals(JQGridContants.EDIT_OPER_DEL)) {
            String[] ids = menuInfoInfo.getId().split(",");
            for (String id : ids) {
                menuInfoService.delete(id);
            }
        }
    }


}
