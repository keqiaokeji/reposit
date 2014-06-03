package com.keqiaokeji.tezizai.web.uc.mapper;

import com.keqiaokeji.tezizai.common.utils.JQGridPage;
import com.keqiaokeji.tezizai.web.uc.domain.UserInfo;

import java.util.List;

/**
 * @author: Ivan Vigoss
 * Date: 14-2-20
 * Time: AM11:11
 */


public interface UserInfoMapper {


    List<UserInfo> getUserListJQgrid(JQGridPage jqGridPage);

    Integer getUserListCountJQgrid(JQGridPage jqGridPage);







}
