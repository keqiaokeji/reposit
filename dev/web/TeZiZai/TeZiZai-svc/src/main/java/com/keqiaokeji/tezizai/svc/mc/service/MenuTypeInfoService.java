package com.keqiaokeji.tezizai.svc.mc.service;

import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuTypeInfo;
import com.keqiaokeji.tezizai.common.dbmapper.mc.mapper.McMenuTypeInfoMapper;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuTypeInfo;
import com.keqiaokeji.tezizai.svc.mc.mapper.MenuTypeInfoMapper;
import com.keqiaokeji.tezizai.svc.utils.AppContents;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户操作实现类
 */
@Service("menuTypeInfoService")
public class MenuTypeInfoService {

    @Autowired
    private McMenuTypeInfoMapper mcMenuTypeInfoMapper;

    @Autowired
    private MenuTypeInfoMapper menuTypeInfoMapper;

    @Autowired
    CacheCtrl cacheCtrl;


    Logger logger = Logger.getLogger(MenuTypeInfoService.class.getName());




    public JQGridPage getListByJQgrid(JQGridPage pageJQGrid) {
        pageJQGrid.initJqGrid();
        List<MenuTypeInfo> menuTypeInfoList = menuTypeInfoMapper.getListByJQgrid(pageJQGrid);
        pageJQGrid.setDataRows(menuTypeInfoList);
        Integer count = menuTypeInfoMapper.getListCountByJQgrid(pageJQGrid);
        if (count != null) {
            pageJQGrid.setRecords(count);
        }
        return pageJQGrid;
    }


    public void update(McMenuTypeInfo menuTypeInfo) {
        menuTypeInfo.setLastModifyTime(new Date().getTime());
        menuTypeInfo.setRecordStatus(AppContents.RECORD_STATUS_UPDATE);
        mcMenuTypeInfoMapper.updateByPrimaryKeySelective(menuTypeInfo);
    }


    public void delete(String menuTypeId) {
        mcMenuTypeInfoMapper.deleteByPrimaryKey(menuTypeId);
    }


    public void add(McMenuTypeInfo menuTypeInfo) {
        menuTypeInfo.setRecordStatus(AppContents.RECORD_STATUS_INSERT);
        menuTypeInfo.setMenuTypeId(StringUtils.getUUID());
        menuTypeInfo.setCreateTime(new Date().getTime());
        menuTypeInfo.setLastModifyTime(new Date().getTime());
//        menuTypeInfo.setCorpId(cacheCtrl.getTokenCtrl().getUcUserInfo("").getCorpId());
        menuTypeInfo.setCorpId("keqiaokeji");
        mcMenuTypeInfoMapper.insert(menuTypeInfo);
    }
}
