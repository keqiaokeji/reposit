package com.keqiaokeji.tezizai.svc.mc.controller;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuTypeInfo;
import com.keqiaokeji.tezizai.svc.mc.service.MenuTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 公司管理
 */
@Controller
public class MenuTypeInfoController {

    @Autowired
    MenuTypeInfoService menuTypeInfoService;

    @ResponseBody
    @RequestMapping(value = "/root/uc/getMenuTypeInfoList")
    public JQGridPage getMenuTypeInfoList(JQGridPage pageJQGrid) {
        return menuTypeInfoService.getListByJQgrid(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/root/uc/editMenuTypeInfo")
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
