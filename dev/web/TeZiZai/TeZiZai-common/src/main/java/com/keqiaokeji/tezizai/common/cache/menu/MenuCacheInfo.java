package com.keqiaokeji.tezizai.common.cache.menu;

import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuListInfo;
import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shk on 14-6-22.
 */
public class MenuCacheInfo {

    private String menuListId;

    private UcUserInfo ucUserInfo;

    private List<McMenuListInfo> mcMenuListInfos = new ArrayList<McMenuListInfo>();


    public String getMenuListId() {
        return menuListId;
    }

    public void setMenuListId(String menuListId) {
        this.menuListId = menuListId;
    }

    public UcUserInfo getUcUserInfo() {
        return ucUserInfo;
    }

    public void setUcUserInfo(UcUserInfo ucUserInfo) {
        this.ucUserInfo = ucUserInfo;
    }

    public List<McMenuListInfo> getMcMenuListInfos() {
        return mcMenuListInfos;
    }

    public void setMcMenuListInfos(List<McMenuListInfo> mcMenuListInfos) {
        this.mcMenuListInfos = mcMenuListInfos;
    }
}
