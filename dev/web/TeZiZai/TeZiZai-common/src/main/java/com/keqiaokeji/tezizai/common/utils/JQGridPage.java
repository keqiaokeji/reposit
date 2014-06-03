package com.keqiaokeji.tezizai.common.utils;

import com.keqiaokeji.tezizai.common.character.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用JQGrid分页时用到的对象
 */
public class JQGridPage {


    /**
     * 当前页是第几页
     */
    private int page = 1;

    /**
     * 总页数
     */
    private int total = 0;

    /**
     * 总记录数
     */
    private int records = 0;

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
    private List dataRows = new ArrayList();


    /**
     * 搜索
     */
    private boolean _search;

    /**
     * 时间戳
     */
    private long nd;


    /**
     * 当前排序字段
     */
    private String sidx;

    /**
     * 排序方式：asc或desc
     */
    private String sord;


    private String filters;

    private JQGridFilter jqGridFilter;

    public void setRecords(int records) {
        this.records = records;
        this.total = (records + rows) / rows;
    }

    public void initJqGrid() {
        if (StringUtils.isNotBlank(this.getFilters())) {
            this.jqGridFilter = JsonUtils.parseObject(this.getFilters(), JQGridFilter.class);
        }
        int firstRowIndex = (page - 1) * rows;
        if (firstRowIndex < 0) {
            firstRowIndex = 0;
        }
        this.pageFirst = firstRowIndex;
    }

    public JQGridFilter getJqGridFilter() {
        return jqGridFilter;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecords() {
        return records;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List getDataRows() {
        return dataRows;
    }

    public void setDataRows(List dataRows) {
        this.dataRows = dataRows;
    }

    public boolean is_search() {
        return _search;
    }

    public void set_search(boolean _search) {
        this._search = _search;
    }

    public long getNd() {
        return nd;
    }

    public void setNd(long nd) {
        this.nd = nd;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public int getPageFirst() {
        return pageFirst;
    }

    public void setPageFirst(int pageFirst) {
        this.pageFirst = pageFirst;
    }

    public void setJqGridFilter(JQGridFilter jqGridFilter) {
        this.jqGridFilter = jqGridFilter;
    }
}

