package com.keqiaokeji.tezizai.svc.uc.mapper;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.uc.domain.CorpInfo;

import java.util.List;

/**
 * @author: Ivan Vigoss
 * Date: 14-2-20
 * Time: AM11:11
 */


public interface CorpInfoMapper {


    List<CorpInfo> getCorpListJQgrid(JQGridPage jqGridPage);

    Integer getCorpListCountJQgrid(JQGridPage jqGridPage);







}
