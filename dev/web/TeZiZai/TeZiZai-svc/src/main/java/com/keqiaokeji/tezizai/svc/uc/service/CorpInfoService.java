package com.keqiaokeji.tezizai.svc.uc.service;

import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcCorpInfo;
import com.keqiaokeji.tezizai.common.dbmapper.uc.mapper.UcCorpInfoMapper;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.uc.domain.CorpInfo;
import com.keqiaokeji.tezizai.svc.uc.mapper.CorpInfoMapper;
import com.keqiaokeji.tezizai.svc.utils.AppContents;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户操作实现类
 */
@Service("corpInfoService")
public class CorpInfoService {

    @Autowired
    private UcCorpInfoMapper ucCorpInfoMapper;

    @Autowired
    private CorpInfoMapper corpInfoMapper;


    Logger logger = Logger.getLogger(CorpInfoService.class.getName());




    public JQGridPage getListByJQgrid(JQGridPage pageJQGrid) {
        pageJQGrid.initJqGrid();
        List<CorpInfo> corpInfoList = corpInfoMapper.getListByJQgrid(pageJQGrid);
        pageJQGrid.setDataRows(corpInfoList);
        Integer count = corpInfoMapper.getListCountByJQgrid(pageJQGrid);
        if (count != null) {
            pageJQGrid.setRecords(count);
        }
        return pageJQGrid;
    }


    public void update(UcCorpInfo corpInfo) {
        corpInfo.setLastModifyTime(new Date().getTime());
        corpInfo.setRecordStatus(AppContents.RECORD_STATUS_UPDATE);
        ucCorpInfoMapper.updateByPrimaryKeySelective(corpInfo);
    }


    public void delete(String corpId) {
        ucCorpInfoMapper.deleteByPrimaryKey(corpId);
    }


    public void add(UcCorpInfo corpInfo) {
        corpInfo.setRecordStatus(AppContents.RECORD_STATUS_INSERT);
        corpInfo.setCorpId(StringUtils.getUUID());
        corpInfo.setCreateTime(new Date().getTime());
        corpInfo.setLastModifyTime(new Date().getTime());
        ucCorpInfoMapper.insert(corpInfo);
    }
}
