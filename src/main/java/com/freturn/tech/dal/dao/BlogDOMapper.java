package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.BlogDO;
import com.freturn.tech.dal.query.BlogQuery;

import java.util.List;

public interface BlogDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogDO blogDO);

    BlogDO selectByPrimaryKey(String id);

    int updateByPrimaryKey(BlogDO blogDO);

    List<BlogDO> query(BlogQuery query);

    int count(BlogQuery query);
}