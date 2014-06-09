package com.keqiaokeji.tezizai.svc.mc.mapper;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuInfo;

import java.util.List;


public interface MenuInfoMapper {


    List<MenuInfo> getListByJQgrid(JQGridPage jqGridPage);

    Integer getListCountByJQgrid(JQGridPage jqGridPage);







}
