package com.keqiaokeji.tezizai.svc.mc.service;

import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuInfo;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuListInfo;
import com.keqiaokeji.tezizai.common.dbmapper.mc.mapper.McMenuListInfoMapper;
import com.keqiaokeji.tezizai.svc.mc.mapper.MenuListInfoMapper;
import com.keqiaokeji.tezizai.svc.utils.AppContants;
import com.keqiaokeji.tezizai.svc.utils.AppContexts;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户操作实现类
 */
@Service("menuListInfoService")
public class MenuListInfoService {

    @Autowired
    private McMenuListInfoMapper mcMenuListInfoMapper;

    @Autowired
    private MenuListInfoMapper menuListInfoMapper;

    @Autowired
    CacheCtrl cacheCtrl;


    Logger logger = Logger.getLogger(MenuListInfoService.class.getName());


    public void add(McMenuListInfo mcMenuListInfo) {
        if (mcMenuListInfo.getPriceFavorable() == null) {
            mcMenuListInfo.setPriceFavorable(mcMenuListInfo.getPriceReal());
        }
        mcMenuListInfo.setMenuListInfoId(StringUtils.getUUID());
        mcMenuListInfo.setCreateTime(new Date().getTime());
        mcMenuListInfo.setLastModifyTime(new Date().getTime());
        mcMenuListInfo.setCorpId(AppContexts.getCorpId());
        mcMenuListInfo.setCreateUserId(AppContexts.getUserId());
        mcMenuListInfoMapper.insertSelective(mcMenuListInfo);
    }



}
