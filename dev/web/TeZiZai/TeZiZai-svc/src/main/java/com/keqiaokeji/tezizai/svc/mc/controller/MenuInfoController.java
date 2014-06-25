package com.keqiaokeji.tezizai.svc.mc.controller;

import com.keqiaokeji.tezizai.common.app.JsonResultContants;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.file.FileInfo;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuInfo;
import com.keqiaokeji.tezizai.svc.mc.service.ImageService;
import com.keqiaokeji.tezizai.svc.mc.service.MenuInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * 公司管理
 */
@Controller
public class MenuInfoController {

    @Autowired
    MenuInfoService menuInfoService;

    @Autowired
    private ImageService imageService;

    Logger logger = Logger.getLogger(MenuInfoController.class.getName());

    @ResponseBody
    @RequestMapping(value = "/user/mc/getMenuInfoList")
    public JQGridPage getMenuInfoList(JQGridPage pageJQGrid) {
        return menuInfoService.getListByJQgrid(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/customer/mc/getMenuInfoListByTableId")
    public JQGridPage getMenuInfoListByTableId(JQGridPage pageJQGrid) {
        return menuInfoService.getListByJQgrid(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/user/mc/editMenuInfo")
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
    @RequestMapping(value = "/user/mc/addMenuInfo", method = RequestMethod.POST)
    public JsonResult addMenuInfo(@RequestParam(value = "image", required = false) MultipartFile image, MenuInfo menuInfoInfo) {
        JsonResult result;
        if (image != null) {
            try {
                FileInfo fileInfo = imageService.uploadImage(image);
                menuInfoInfo.setPictureId(fileInfo.getFileId());
            } catch (Exception e) {
                result = new JsonResult(JsonResultContants.FAIL, "文件上传失败！");
                logger.error(e);
            }
        }
        menuInfoService.add(menuInfoInfo);
        result = new JsonResult(JsonResultContants.SUCCESS, "新增成功！");
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/user/mc/updateMenuInfo", method = RequestMethod.POST)
    public JsonResult updateMenuInfo(@RequestParam(value = "image", required = false) MultipartFile image, MenuInfo menuInfoInfo) {
        JsonResult result;
        if (image != null) {
            try {
                String imageId = menuInfoInfo.getPictureId();
                if (StringUtils.isEmpty(imageId)) {
                    imageId = StringUtils.getUUID();
                }
                FileInfo fileInfo = imageService.uploadImage(imageId, image);
                menuInfoInfo.setPictureId(fileInfo.getFileId());
            } catch (Exception e) {
                result = new JsonResult(JsonResultContants.FAIL, "文件上传失败！");
                logger.error(e);
            }
        }
        menuInfoService.add(menuInfoInfo);
        result = new JsonResult(JsonResultContants.SUCCESS, "修改成功！");
        return result;
    }


}
