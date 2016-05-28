package com.freturn.tech.biz.domain;

/**
 * @author yangtao.lyt
 * @version $Id: PageNavigable, v 0.1 2016-05-28 18:38 yangtao.lyt Exp $
 */
public interface PageNavigable {


    /**
     * 是否有上一页
     * @return
     */
    public boolean hasPrePage();

    /**
     * 是否有下一页
     * @return
     */
    public boolean hasNextPage();

    /**
     * 获取上一页页号
     * @return
     */
    public int getPrePageNo();

    /**
     * 获取下一页页号
     * @return
     */
    public int getNextPageNo();

    /**
     * 总页数
     * @return
     */
    public int getTotalPage();


}
