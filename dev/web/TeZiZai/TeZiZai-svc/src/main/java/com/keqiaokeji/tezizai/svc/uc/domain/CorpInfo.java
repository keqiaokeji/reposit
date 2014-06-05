package com.keqiaokeji.tezizai.svc.uc.domain;

import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcCorpInfo;

/**
 * @author: Ivan Vigoss
 * Date: 14-2-20
 * Time: AM11:11
 */
public class CorpInfo extends UcCorpInfo {

    private String Id;

    private String oper;



    public void initCorpInfo() {

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
