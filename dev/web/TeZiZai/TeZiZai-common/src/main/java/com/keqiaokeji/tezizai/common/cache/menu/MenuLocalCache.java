package com.keqiaokeji.tezizai.common.cache.menu;

import com.keqiaokeji.tezizai.common.character.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-14
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
@Service("menuLocalCache")
public class MenuLocalCache{

    private final long TIMEOUT = 1000 * 60 * 60 * 24 * 7;//超时时间为7天
    private final String TOKEN_PREFIX = "token_";


    private Hashtable<String, MenuCacheInfo> tokens = new Hashtable<String, MenuCacheInfo>();


    public String addMenuList() {
        String menuListId = StringUtils.getUUID();



        return menuListId;
    }


}
