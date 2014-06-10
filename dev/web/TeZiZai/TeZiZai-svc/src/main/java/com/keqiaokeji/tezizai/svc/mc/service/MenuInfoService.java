package com.keqiaokeji.tezizai.svc.mc.service;

import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuInfo;
import com.keqiaokeji.tezizai.common.dbmapper.mc.mapper.McMenuInfoMapper;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuInfo;
import com.keqiaokeji.tezizai.svc.mc.mapper.MenuInfoMapper;
import com.keqiaokeji.tezizai.svc.utils.AppContents;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户操作实现类
 */
@Service("menuInfoService")
public class MenuInfoService {

    @Autowired
    private McMenuInfoMapper mcMenuInfoMapper;

    @Autowired
    private MenuInfoMapper menuInfoMapper;


    Logger logger = Logger.getLogger(MenuInfoService.class.getName());




    public JQGridPage getListByJQgrid(JQGridPage pageJQGrid) {
        pageJQGrid.initJqGrid();
        List<MenuInfo> menuInfoList = menuInfoMapper.getListByJQgrid(pageJQGrid);
        pageJQGrid.setDataRows(menuInfoList);
        Integer count = menuInfoMapper.getListCountByJQgrid(pageJQGrid);
        if (count != null) {
            pageJQGrid.setRecords(count);
        }
        return pageJQGrid;
    }


    public void update(McMenuInfo menuInfo) {
        menuInfo.setLastModifyTime(new Date().getTime());
        menuInfo.setRecordStatus(AppContents.RECORD_STATUS_UPDATE);
        mcMenuInfoMapper.updateByPrimaryKeySelective(menuInfo);
    }


    public void delete(String menuId) {
        mcMenuInfoMapper.deleteByPrimaryKey(menuId);
    }


    public void add(McMenuInfo menuInfo) {
        menuInfo.setRecordStatus(AppContents.RECORD_STATUS_INSERT);
        menuInfo.setMenuId(StringUtils.getUUID());
        menuInfo.setCreateTime(new Date().getTime());
        menuInfo.setLastModifyTime(new Date().getTime());
        menuInfo.setCorpId("keqiaokeji");
        mcMenuInfoMapper.insert(menuInfo);
    }
}
