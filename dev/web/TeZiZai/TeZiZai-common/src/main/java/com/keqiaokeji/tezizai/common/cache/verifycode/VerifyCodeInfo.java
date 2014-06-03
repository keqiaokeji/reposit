package com.keqiaokeji.tezizai.common.cache.verifycode;

import java.util.List;

/**
 * 验证码信息对象
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-17
 * Time: 下午3:15
 * To change this template use File | Settings | File Templates.
 */
public class VerifyCodeInfo {

    /**
     * 验证码的键
     */
    private String codeKey;

    /**
     * 验证码的内容
     */
    private List<String> codeContents;

    /**
     * 验证码的路径
     */
    private String imgUrl;

    /**
     * 验证码的生成时间（以便后期将长时间不用的验证码数据清理掉）
     */
    private Long createTime;



    public String getCodeKey() {
        return codeKey;
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    public List<String> getCodeContents() {
        return codeContents;
    }

    public void setCodeContents(List<String> codeContents) {
        this.codeContents = codeContents;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
