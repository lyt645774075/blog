package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.CommentDO;
import com.freturn.tech.dal.query.CommentQuery;

import java.util.List;

public interface CommentDOMapper {
    /**
     * 查询指定主键id的评论
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入一条评论
     * @param commentDO
     * @return
     */
    int insert(CommentDO commentDO);

    /**
     * 查询指定主键的评论
     * @param id
     * @return
     */
    CommentDO selectByPrimaryKey(Long id);

    /**
     * 更新指定主键的评论
     * @param commentDO
     * @return
     */
    int updateByPrimaryKey(CommentDO commentDO);

    /**
     * 查询满足条件的评论
     * @param query
     * @return
     */
    List<CommentDO> query(CommentQuery query);
}