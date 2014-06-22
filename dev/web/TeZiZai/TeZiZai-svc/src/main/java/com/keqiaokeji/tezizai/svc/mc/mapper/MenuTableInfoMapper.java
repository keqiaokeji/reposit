package com.keqiaokeji.tezizai.svc.mc.mapper;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuTableInfo;

import java.util.List;


public interface MenuTableInfoMapper {


    List<MenuTableInfo> getListByJQgrid(JQGridPage jqGridPage);

    Integer getListCountByJQgrid(JQGridPage jqGridPage);







}
