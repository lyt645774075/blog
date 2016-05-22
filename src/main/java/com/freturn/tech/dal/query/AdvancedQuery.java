package com.freturn.tech.dal.query;

/**
 * @author yangtao.lyt
 * @version $Id: AdvancedQuery, v 0.1 2016-05-03 20:36 yangtao.lyt Exp $
 */
public abstract class AdvancedQuery {
    /**
     * 常量定义
     */
    public static int ASC            = 1;
    public static int DESC           = 2;
    public static int EnableDistinct = 1;

    /**
     * 排序的字段名
     */
    private String    orderByFieldName;
    /**
     * 排序时，是升序还是降序  - 使用上述常量
     */
    private Integer   descOrAsc      = DESC;
    /**
     * 当前需要查询的页数  -  分页查询
     * 第一页的页号 为 1
     * 该字段不为null的时候，表名启用分页查询
     */
    private Integer   pageNo;
    /**
     * 单页返回记录上限数    -  分页查询
     */
    private Integer   pageSize       = 20;
    /**
     * 限制返回记录上限数
     * 该值不为null的时候启用，并使用该值作为参数
     */
    private Integer   limitCount;
    /**
     * 返回的字段名  可以配合distinct使用
     * 用于查询满足查询条件，只需返回某一单个字段的场景
     */
    private String    returnDbFieldName;
    /**
     * 是否启用distinct的功能
     * 如果是查询某字段时启用，则去重返回字段
     * 如果是计数某字段时启用，则计数时去掉重复的值
     */
    private Integer   distinct;
    /**
     * 计数时的字段   可以配合distinct使用
     */
    private String    countFieldName;

    public String getOrderByFieldName() {
        return orderByFieldName;
    }

    public void setOrderByFieldName(String orderByFieldName) {
        this.orderByFieldName = orderByFieldName;
    }

    public Integer getDescOrAsc() {
        return descOrAsc;
    }

    public void setDescOrAsc(Integer descOrAsc) {
        this.descOrAsc = descOrAsc;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
    }

    public String getReturnDbFieldName() {
        return returnDbFieldName;
    }

    public void setReturnDbFieldName(String returnDbFieldName) {
        this.returnDbFieldName = returnDbFieldName;
    }

    public Integer getOffset() {
        return (pageNo - 1) * pageSize;
    }

    public Integer getStartRow() {
        return (pageNo - 1) * pageSize;
    }

    public Integer getDistinct() {
        return distinct;
    }

    public void setDistinct(Integer distinct) {
        this.distinct = distinct;
    }

    public void setCountFieldName(String countFieldName) {
        this.countFieldName = countFieldName;
    }

    public String getCountFieldName() {
        return countFieldName;
    }

}
