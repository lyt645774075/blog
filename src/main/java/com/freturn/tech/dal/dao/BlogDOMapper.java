package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.BlogDO;
import com.freturn.tech.dal.query.BlogQueryObj;

import java.util.List;

public interface BlogDOMapper {
    int insert(BlogDO record);

    List<BlogDO> selectAll();


    List<BlogDO> query(BlogQueryObj queryObj);
}