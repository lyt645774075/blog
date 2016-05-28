package com.freturn.tech.biz.domain;

import com.freturn.tech.support.constant.CommonConstant;
import com.google.common.base.Preconditions;

import java.util.ArrayList;

/**
 *
 * 分页查询结果
 *
 * @author yangtao.lyt
 * @version $Id: PagedResult, v 0.1 2016-05-28 18:25 yangtao.lyt Exp $
 */
public class PagedResult<E> extends ArrayList<E> implements PageNavigable {

    /** 页编号 */
    private Integer pageNo;

    /** 每页记录数
     * @see com.freturn.tech.dal.query.AdvancedQuery
     */
    private Integer pageSize = CommonConstant.DEFAULT_PAGE_SIZE;

    /** 总记录数 */
    private Integer totalCount;

    @Override
    public boolean hasPrePage() {

        if (pageNo <= 1) {
            return false;
        }

        return true;
    }

    @Override
    public boolean hasNextPage() {
        return pageNo < getTotalPage() ? true : false;
    }

    @Override
    public int getPrePageNo() {
        Preconditions.checkArgument(hasPrePage());

        return pageNo - 1;
    }

    @Override
    public int getNextPageNo() {
        Preconditions.checkArgument(hasNextPage());

        return pageNo + 1;
    }

    @Override
    public int getTotalPage() {
        return Double.valueOf(Math.ceil(totalCount.doubleValue() / pageSize)).intValue();
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}
