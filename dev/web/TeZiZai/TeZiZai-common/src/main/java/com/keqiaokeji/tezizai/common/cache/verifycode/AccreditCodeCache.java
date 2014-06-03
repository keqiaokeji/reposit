package com.keqiaokeji.tezizai.common.cache.verifycode;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by keqiaokeji on 14-5-23.
 */
public class AccreditCodeCache {

    private Map<String, String> accreditCodes = new Hashtable<String, String>();

    /**
     * 检查授权码是否正确
     *
     * @param accreditCode 授权码
     * @return true：正确，false：错误
     */
    public boolean checkAccreditCode(String accreditCode) {
        boolean result = false;
        if (accreditCode != null && accreditCodes.containsKey(accreditCode)) {
            result = true;
        }
        return result;
    }

    public Map<String, String> getAccreditCodes() {
        return accreditCodes;
    }

    public void setAccreditCodes(Map<String, String> accreditCodes) {
        this.accreditCodes = accreditCodes;
    }
}
