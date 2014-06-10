package com.keqiaokeji.tezizai.svc.uc.mapper;

import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.svc.uc.domain.UserInfo;

import java.util.List;

/**
 * @author: Ivan Vigoss
 * Date: 14-2-20
 * Time: AM11:11
 */


public interface UserInfoMapper {


    List<UserInfo> getListByJQgrid(JQGridPage jqGridPage);

    Integer getListCountByJQgrid(JQGridPage jqGridPage);







}
