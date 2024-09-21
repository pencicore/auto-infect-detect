package com.infect.result;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页查询结果
 */
public class PageResult<T> implements Serializable {

    private long total; //总记录数

    private List<T> records; //当前页数据集合

    public PageResult() {
    }

    public PageResult(long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    /**
     * 获取
     * @return total
     */
    public long getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 获取
     * @return records
     */
    public List<T> getRecords() {
        return records;
    }

    /**
     * 设置
     * @param records
     */
    public void setRecords(List<T> records) {
        this.records = records;
    }

    public String toString() {
        return "PageResult{total = " + total + ", records = " + records + "}";
    }
}
