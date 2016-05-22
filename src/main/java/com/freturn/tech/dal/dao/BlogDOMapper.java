package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.BlogDO;
import com.freturn.tech.dal.query.BlogQuery;

import java.util.List;

/**
 * 文章数据访问接口
 */
public interface BlogDOMapper {

    /**
     * 删除指定主键id的文章
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入新的文章
     * @param blogDO
     * @return
     */
    int insert(BlogDO blogDO);

    /**
     * 查询指定主键id的文章
     * @param id
     * @return
     */
    BlogDO selectByPrimaryKey(String id);

    /**
     * 更新指定主键的文章
     * @param blogDO
     * @return
     */
    int updateByPrimaryKey(BlogDO blogDO);

    /**
     * 查询指定条件的文章列表
     * @param query
     * @return
     */
    List<BlogDO> query(BlogQuery query);

    /**
     * 统计满足条件的文章数目
     * @param query
     * @return
     */
    int count(BlogQuery query);
}