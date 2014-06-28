package com.keqiaokeji.tezizai.svc.mc.service;

import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.character.DbSqlUtils;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuInfo;
import com.keqiaokeji.tezizai.common.dbmapper.mc.mapper.McMenuInfoMapper;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.common.utils.Page;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuInfo;
import com.keqiaokeji.tezizai.svc.mc.mapper.MenuInfoMapper;
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
@Service("menuInfoService")
public class MenuInfoService {

    @Autowired
    private McMenuInfoMapper mcMenuInfoMapper;

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    @Autowired
    CacheCtrl cacheCtrl;


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

    public Page<List<McMenuInfo>> getMenuInfoListForCustomer(Page page, String corpId, String menuTypeId, String order) {
        if (page == null) {
            page = new Page();
        }

        String sqlWhere = " where corp_id = '" + corpId + "' ";
        if (StringUtils.isNotEmpty(menuTypeId)) {
            sqlWhere += " and menu_type_id ='" + menuTypeId + "' ";
        }

        String sqlOption = "";
        if (StringUtils.isNotBlank(order)) {
            sqlOption += " order by " + order;
        }
        sqlOption += " limit " + page.getRows() + " offset " + page.getPageFirst();
        DbSqlUtils sqlUtils = new DbSqlUtils();
        sqlUtils.setSqlData("select * from mc_menu_info ");
        sqlUtils.setSqlCount("select count(*) from mc_menu_info ");
        sqlUtils.setSqlWhere(sqlWhere);
        sqlUtils.setSqlOption(sqlOption);
        List<MenuInfo> menuInfoList = menuInfoMapper.getListBySql(sqlUtils);
        page.setDataRows(menuInfoList);
        Integer count = menuInfoMapper.getListCountBySql(sqlUtils);
        if (count != null) {
            page.setRecordsCount(count);
        }
        return page;
    }


    public void update(McMenuInfo menuInfo) {
        menuInfo.setLastModifyTime(new Date().getTime());
        menuInfo.setRecordStatus(AppContants.RECORD_STATUS_UPDATE);
        menuInfo.setLastModifyUserId(AppContexts.getUserId());
        mcMenuInfoMapper.updateByPrimaryKeySelective(menuInfo);
    }


    public void delete(String menuId) {
        mcMenuInfoMapper.deleteByPrimaryKey(menuId);
    }


    public void add(McMenuInfo menuInfo) {
        if (menuInfo.getPriceFavorable() == null) {
            menuInfo.setPriceFavorable(menuInfo.getPriceReal());
        }
        menuInfo.setMenuId(StringUtils.getUUID());
        menuInfo.setCreateTime(new Date().getTime());
        menuInfo.setLastModifyTime(new Date().getTime());
        menuInfo.setCorpId(AppContexts.getCorpId());
        menuInfo.setCreateUserId(AppContexts.getUserId());
        mcMenuInfoMapper.insertSelective(menuInfo);
    }
}
