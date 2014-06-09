package com.keqiaokeji.tezizai.svc.uc.mapper;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.uc.domain.CorpInfo;

import java.util.List;


public interface CorpInfoMapper {


    List<CorpInfo> getListByJQgrid(JQGridPage jqGridPage);

    Integer getListCountByJQgrid(JQGridPage jqGridPage);







}
