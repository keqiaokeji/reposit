package com.keqiaokeji.tezizai.common.utils;

import java.util.Date;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM4:58
 */
public class JsonResult {

    private String statusCode;

    private String statusMsg;

    private String content;

    private String token;

    private long timestamp = new Date().getTime();

    public JsonResult() {
    }

    public JsonResult(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public JsonResult(String statusCode, String statusMsg, String content) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.content = content;
    }

    public void setContentToJsonString(Object object) {
        this.content = JsonUtils.toJSONString(object);
    }

    public <T> T getContentObject(Class<T> clazz){
          return JsonUtils.parseObject(this.content, clazz);
    }





    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
