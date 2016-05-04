package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.CommentDO;
import com.freturn.tech.dal.query.CommentQuery;

import java.util.List;

public interface CommentDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentDO commentDO);

    CommentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKey(CommentDO commentDO);

    List<CommentDO> query(CommentQuery query);
}