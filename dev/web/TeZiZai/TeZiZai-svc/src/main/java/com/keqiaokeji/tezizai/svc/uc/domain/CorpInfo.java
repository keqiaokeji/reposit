package com.keqiaokeji.tezizai.svc.uc.domain;

import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcCorpInfo;
import com.keqiaokeji.tezizai.svc.utils.CommonDomain;

/**
 * @author: Ivan Vigoss
 * Date: 14-2-20
 * Time: AM11:11
 */
public class CorpInfo extends UcCorpInfo implements CommonDomain{

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
