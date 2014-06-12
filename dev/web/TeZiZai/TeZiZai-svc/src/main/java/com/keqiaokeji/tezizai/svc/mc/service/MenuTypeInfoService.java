package com.keqiaokeji.tezizai.svc.mc.service;

import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuTypeInfo;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuTypeInfoExample;
import com.keqiaokeji.tezizai.common.dbmapper.mc.mapper.McMenuTypeInfoMapper;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuTypeInfo;
import com.keqiaokeji.tezizai.svc.mc.mapper.MenuTypeInfoMapper;
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
@Service("menuTypeInfoService")
public class MenuTypeInfoService {

    @Autowired
    private McMenuTypeInfoMapper mcMenuTypeInfoMapper;

    @Autowired
    private MenuTypeInfoMapper menuTypeInfoMapper;

    @Autowired
    CacheCtrl cacheCtrl;


    Logger logger = Logger.getLogger(MenuTypeInfoService.class.getName());


    public List<McMenuTypeInfo> getMenuTypeInfo() {
        McMenuTypeInfoExample example = new McMenuTypeInfoExample();
        example.createCriteria().andCorpIdEqualTo(AppContexts.getCorpId());
        example.setOrderByClause("menu_type_order ASC");
        return mcMenuTypeInfoMapper.selectByExample(example);
    }

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
        menuTypeInfo.setRecordStatus(AppContants.RECORD_STATUS_UPDATE);
        menuTypeInfo.setLastModifyUserId(AppContexts.getUserId());
        mcMenuTypeInfoMapper.updateByPrimaryKeySelective(menuTypeInfo);
    }


    public void delete(String menuTypeId) {
        mcMenuTypeInfoMapper.deleteByPrimaryKey(menuTypeId);
    }


    public void add(McMenuTypeInfo menuTypeInfo) {
        menuTypeInfo.setRecordStatus(AppContants.RECORD_STATUS_INSERT);
        menuTypeInfo.setMenuTypeId(StringUtils.getUUID());
        menuTypeInfo.setCreateTime(new Date().getTime());
        menuTypeInfo.setLastModifyTime(new Date().getTime());
        menuTypeInfo.setCorpId(AppContexts.getCorpId());
        menuTypeInfo.setCreateUserId(AppContexts.getUserId());
        mcMenuTypeInfoMapper.insert(menuTypeInfo);
    }
}
