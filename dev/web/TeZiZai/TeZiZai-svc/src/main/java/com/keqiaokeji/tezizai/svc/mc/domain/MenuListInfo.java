package com.keqiaokeji.tezizai.svc.mc.domain;

import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuListInfo;
import com.keqiaokeji.tezizai.svc.utils.CommonDomain;

public class MenuListInfo extends McMenuListInfo implements CommonDomain {

    private String Id;

    private String oper;



    public void init() {

    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }
}
