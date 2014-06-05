package com.keqiaokeji.tezizai.common.jqgrid;

/**
 * 排序规则
 */
public class JQGridRules {

    /**
     * 属性
     */
    private String field;

    /**
     * 条件
     */
    private String op;

    /**
     * 值
     */
    private String data;



    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

