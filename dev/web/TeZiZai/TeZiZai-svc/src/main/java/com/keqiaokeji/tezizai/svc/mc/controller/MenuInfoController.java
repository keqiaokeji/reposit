package com.keqiaokeji.tezizai.svc.mc.controller;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.common.utils.Uploader;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuInfo;
import com.keqiaokeji.tezizai.svc.mc.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


/**
 * 公司管理
 */
@Controller
public class MenuInfoController {

    @Autowired
    MenuInfoService menuInfoService;

    @Autowired
    private Uploader uploader;

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


    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JsonResult upload(@RequestParam(value = "file", required = false) MultipartFile file) {
        JsonResult result = new JsonResult();
        try {
            String fileName = file.getOriginalFilename();
            File targetFile = new File(uploader.getSavePath(), fileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
//            result.setSuccess(false);
//            result.setMsg(e.getMessage());
        }
        return result;
    }




}
