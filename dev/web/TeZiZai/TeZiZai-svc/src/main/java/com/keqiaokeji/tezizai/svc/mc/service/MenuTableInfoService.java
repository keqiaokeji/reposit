package com.keqiaokeji.tezizai.svc.mc.service;

import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuTableInfo;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuTableInfoExample;
import com.keqiaokeji.tezizai.common.dbmapper.mc.mapper.McMenuTableInfoMapper;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuTableInfo;
import com.keqiaokeji.tezizai.svc.mc.mapper.MenuTableInfoMapper;
import com.keqiaokeji.tezizai.svc.utils.AppContants;
import com.keqiaokeji.tezizai.svc.utils.AppContexts;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户操作实现类
 */
@Service("menuTableInfoService")
public class MenuTableInfoService {

    @Autowired
    private McMenuTableInfoMapper mcMenuTableInfoMapper;

    @Autowired
    private MenuTableInfoMapper menuTableInfoMapper;

    @Autowired
    CacheCtrl cacheCtrl;


    Logger logger = Logger.getLogger(MenuTableInfoService.class.getName());


    public JQGridPage getListByJQgrid(JQGridPage pageJQGrid) {
        pageJQGrid.initJqGrid();
        List<MenuTableInfo> menuTableInfoList = menuTableInfoMapper.getListByJQgrid(pageJQGrid);
        pageJQGrid.setDataRows(menuTableInfoList);
        Integer count = menuTableInfoMapper.getListCountByJQgrid(pageJQGrid);
        if (count != null) {
            pageJQGrid.setRecords(count);
        }
        return pageJQGrid;
    }


    public void update(McMenuTableInfo menuTableInfo) {
        menuTableInfo.setLastModifyTime(new Date().getTime());
        menuTableInfo.setRecordStatus(AppContants.RECORD_STATUS_UPDATE);
        menuTableInfo.setLastModifyUserId(AppContexts.getUserId());
        mcMenuTableInfoMapper.updateByPrimaryKeySelective(menuTableInfo);
    }


    public void delete(String menuTableId) {
        mcMenuTableInfoMapper.deleteByPrimaryKey(menuTableId);
    }


    public void add(McMenuTableInfo menuTableInfo) {
        menuTableInfo.setCreateTime(new Date().getTime());
        menuTableInfo.setLastModifyTime(new Date().getTime());
        menuTableInfo.setCorpId(AppContexts.getCorpId());
        menuTableInfo.setCreateUserId(AppContexts.getUserId());
        mcMenuTableInfoMapper.insertSelective(menuTableInfo);
    }
}
