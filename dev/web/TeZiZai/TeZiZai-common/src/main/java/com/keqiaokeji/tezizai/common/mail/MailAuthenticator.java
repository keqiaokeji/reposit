package com.keqiaokeji.tezizai.common.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-15
 * Time: 下午11:00
 * To change this template use File | Settings | File Templates.
 */

public class MailAuthenticator extends Authenticator {
    private String username;
    private String password;

    /**
     * 验证信息
     * @param username
     * @param password
     */
    public MailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.username, this.password);
    }
}

