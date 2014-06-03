package com.keqiaokeji.tezizai.common.cache.verifycode;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 * 验证码操作
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-17
 * Time: 下午3:12
 * To change this template use File | Settings | File Templates.
 */
@Service("verifyCodeCache")
public class VerifyCodeCache {

    private Hashtable<String, VerifyCodeInfo> verifyCodes = new Hashtable<String, VerifyCodeInfo>();


    /**
     * 存储验证码
     *
     * @param codeKey      验证码的键
     * @param codeContents 验证码内容
     * @param imgUrl       验证码图片的URL
     * @return 验证码的键（32位的UUID）
     */
    public String addVerifyCode(String codeKey, List<String> codeContents, String imgUrl) {
        VerifyCodeInfo imgCodeInfo = new VerifyCodeInfo();
        imgCodeInfo.setCodeKey(codeKey);
        imgCodeInfo.setCodeContents(codeContents);
        imgCodeInfo.setImgUrl(imgUrl);
        imgCodeInfo.setCreateTime(new Date().getTime());
        verifyCodes.put(codeKey, imgCodeInfo);
        return codeKey;
    }

    /**
     * 验证验证码是否正确
     *
     * @param codeKey     验证码的键
     * @param codeContent 验证码的内容
     * @return true：验证码码正确，false：验证码错误
     */
    public boolean checkVerifyCode(String codeKey, String codeContent) {
        boolean result = false;
        if (codeKey != null && codeContent != null) {
            VerifyCodeInfo imgCodeInfo = verifyCodes.get(codeKey);
            if (imgCodeInfo != null) {
                String content = "";
                for (String code : imgCodeInfo.getCodeContents()) {
                    content = content + code;
                }

                if (content.equalsIgnoreCase(codeContent)) {
                    verifyCodes.remove(codeKey);
                    result = true;
                }
            }
        }
        return result;
    }

    public VerifyCodeInfo getVerifyCodeInfo(String codeKey) {
        return verifyCodes.get(codeKey);
    }


    public void removeVerifyCode(String codeKey) {
        verifyCodes.remove(codeKey);
    }


    public Hashtable<String, VerifyCodeInfo> getVerifyCodes() {
        return verifyCodes;
    }

    public void setVerifyCodes(Hashtable<String, VerifyCodeInfo> verifyCodes) {
        this.verifyCodes = verifyCodes;
    }
}
