package com.keqiaokeji.tezizai.svc.utils;

import com.keqiaokeji.tezizai.common.mail.MailReceiveInfo;
import com.keqiaokeji.tezizai.common.mail.MailSendTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by keqiaokeji on 14-5-23.
 */
@Component//交给spring托管，但是不确定是什么类型的对象
public class MailSendUtils {


    @Autowired
    MailSendTools mailSendTools;

    public void sendFindPasswordMail(String receiveEmailAccount, String password) throws Exception {
        MailReceiveInfo receiveInfo = new MailReceiveInfo();
        receiveInfo.setToEmails(receiveEmailAccount);
        receiveInfo.setContent("你的密码是：" + password);
        receiveInfo.setSubject("找回密码");
        mailSendTools.sendEmail(receiveInfo);
    }


}
