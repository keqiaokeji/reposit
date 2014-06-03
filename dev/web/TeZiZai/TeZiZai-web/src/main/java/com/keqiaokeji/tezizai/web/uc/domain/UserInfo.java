package com.keqiaokeji.tezizai.web.uc.domain;

import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;
import com.keqiaokeji.tezizai.common.utils.DateUtil;

import java.util.Date;

/**
 * @author: Ivan Vigoss
 * Date: 14-2-20
 * Time: AM11:11
 */
public class UserInfo extends UcUserInfo {

    private String Id;

    private String oper;

    private String birthdayContent;


    public void initUserInfo() {
        this.birthdayContent = DateUtil.formatDate(this.getBirthday(), DateUtil.YYYY_MM_DD);

    }

    public void setBirthdayContent(String birthdayContent) {
        this.birthdayContent = birthdayContent;
        Date date = DateUtil.formatDate(this.birthdayContent, DateUtil.YYYY_MM_DD);
        if (date != null) {
            this.setBirthday(date.getTime());
        }


    }


    public String getBirthdayContent() {
        return birthdayContent;
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
