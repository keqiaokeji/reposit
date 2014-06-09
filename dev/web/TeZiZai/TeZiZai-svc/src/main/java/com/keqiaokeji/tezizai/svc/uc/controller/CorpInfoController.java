package com.keqiaokeji.tezizai.svc.uc.controller;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridContants;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.uc.domain.CorpInfo;
import com.keqiaokeji.tezizai.svc.uc.service.CorpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 公司管理
 */
@Controller
public class CorpInfoController {

    @Autowired
    CorpInfoService corpService;

    @ResponseBody
    @RequestMapping(value = "/root/uc/getCorpInfoList")
    public JQGridPage getCorpInfoList(JQGridPage pageJQGrid) {
        return corpService.getListByJQgrid(pageJQGrid);
    }

    @ResponseBody
    @RequestMapping(value = "/root/uc/editCorpInfo")
    public void editCorpInfo(CorpInfo corpInfo) {
        if (corpInfo.getOper().equals(JQGridContants.EDIT_OPER_ADD)) {
            corpService.add(corpInfo);
        } else if (corpInfo.getOper().equals(JQGridContants.EDIT_OPER_UPDATE)) {
            corpInfo.setCorpId(corpInfo.getId());
            corpService.update(corpInfo);
        } else if (corpInfo.getOper().equals(JQGridContants.EDIT_OPER_DEL)) {
            String[] ids = corpInfo.getId().split(",");
            for (String id : ids) {
                corpService.delete(id);
            }
        }
    }


}
