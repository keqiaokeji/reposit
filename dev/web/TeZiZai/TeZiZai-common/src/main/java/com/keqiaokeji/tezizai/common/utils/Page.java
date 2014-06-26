package com.keqiaokeji.tezizai.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用JQGrid分页时用到的对象
 */
public class Page<T> {


    /**
     * 当前页是第几页
     */
    private int pageNo = 1;

    /**
     * 总页数
     */
    private int totalPage = 0;

    /**
     * 总记录数
     */
    private int recordsCount = 0;

    /**
     * 每页显示的条数
     */
    private int rows = 10;

    /**
     * 分页起始记录位置
     */
    private int pageFirst;


    /**
     * 记录集
     */
    private List<T> dataRows = new ArrayList<T>();

    /**
     * 自动分页
     */
    private boolean autoPage;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageFirst = pageNo * rows;
        this.pageNo = pageNo;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRecordsCount() {
        return recordsCount;
    }

    public void setRecordsCount(int recordsCount) {
        if (recordsCount > 0) {
            totalPage = recordsCount / rows + 1;
        }
        this.recordsCount = recordsCount;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPageFirst() {
        return pageFirst;
    }

    public void setPageFirst(int pageFirst) {
        this.pageFirst = pageFirst;
    }

    public List<T> getDataRows() {
        return dataRows;
    }

    public void setDataRows(List<T> dataRows) {
        this.dataRows = dataRows;
    }

    public boolean isAutoPage() {
        return autoPage;
    }

    public void setAutoPage(boolean autoPage) {
        this.autoPage = autoPage;
    }
}

