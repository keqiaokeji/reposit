package com.keqiaokeji.tezizai.svc.mc.mapper;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.mc.domain.MenuTypeInfo;

import java.util.List;


public interface MenuTypeInfoMapper {


    List<MenuTypeInfo> getListByJQgrid(JQGridPage jqGridPage);

    Integer getListCountByJQgrid(JQGridPage jqGridPage);







}
