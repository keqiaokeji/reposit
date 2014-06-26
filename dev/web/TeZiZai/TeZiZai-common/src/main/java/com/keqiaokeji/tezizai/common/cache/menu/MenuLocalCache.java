package com.keqiaokeji.tezizai.common.cache.menu;

import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuListInfo;
import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-14
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
@Service("menuLocalCache")
public class MenuLocalCache {

    private final long TIMEOUT = 1000 * 60 * 60 * 24 * 7;//超时时间为7天
    private final String TOKEN_PREFIX = "token_";

    @Autowired
    CacheCtrl cacheCtrl;

    private Hashtable<String, MenuCacheInfo> menuListCache = new Hashtable<String, MenuCacheInfo>();


    /**
     * 新增餐桌
     *
     * @return 餐桌对应的菜单ID
     */
    public String addMenuTable() {
        String menuTableId = StringUtils.getUUID();
        MenuCacheInfo menuCacheInfo = new MenuCacheInfo();
        menuCacheInfo.setUcUserInfo(cacheCtrl.getCurrentUcUserInfo());
        menuListCache.put(menuTableId, menuCacheInfo);
        return menuTableId;
    }

    /**
     * 点餐
     *
     * @param menuTableId    所属菜单ID
     * @param mcMenuListInfo 菜单信息
     * @return 已点菜单列表
     */
    public List<McMenuListInfo> addMenuListInfo(String menuTableId, McMenuListInfo mcMenuListInfo) {
        List<McMenuListInfo> menuLists = null;
        if (StringUtils.isNotEmpty(menuTableId)) {
            MenuCacheInfo menuCacheInfo = menuListCache.get(menuTableId);
            if (menuCacheInfo != null) {
                menuLists = menuCacheInfo.getMcMenuListInfos();
                boolean isExisit = false;
                for (McMenuListInfo menuList : menuLists) {
                    if (menuList.getMenuId().equals(mcMenuListInfo.getMenuId()) && menuList.getStatus().equalsIgnoreCase(MenuConstants.MENU_LIST_STATUS_UNCONFIRM)) {//如果已经存在,且未下单则数量加1即可
                        int num = menuList.getMenuNum() == null ? 0 : menuList.getMenuNum();
                        menuList.setMenuNum(num + 1);
                        isExisit = true;
                        break;
                    }
                }
                if (!isExisit) { //如果不存在则需要添加进去
                    mcMenuListInfo.setMenuNum(1);
                    mcMenuListInfo.setStatus(MenuConstants.MENU_LIST_STATUS_UNCONFIRM);
                    menuLists.add(mcMenuListInfo);
                }

            }
        }
        return menuLists;
    }

    public List<McMenuListInfo> getMenuListInfos(String menuTableId) {
        MenuCacheInfo menuCacheInfo = menuListCache.get(menuTableId);
        if (menuCacheInfo != null) {
            return menuCacheInfo.getMcMenuListInfos();
        }
        return null;
    }

    public UcUserInfo getUcUserInfo(String menuTableId) {
        MenuCacheInfo menuCacheInfo = menuListCache.get(menuTableId);
        if (menuCacheInfo != null) {
            return menuCacheInfo.getUcUserInfo();
        }
        return null;
    }

    public MenuCacheInfo getMenuCacheInfo(String menuTableId) {
        return menuListCache.get(menuTableId);
    }
}
