package com.keqiaokeji.tezizai.common.jqgrid;

import java.util.List;

/**
 * 使用JQGrid搜索时的过滤器
 */
public class JQGridFilter {

    /**
     * 方式
     */
    private String groupOp;

    /**
     * 规则集合
     */
    private List<JQGridRules> rules;

    public String getGroupOp() {
        return groupOp;
    }

    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    public List<JQGridRules> getRules() {
        return rules;
    }

    public void setRules(List<JQGridRules> rules) {
        this.rules = rules;
    }
}

