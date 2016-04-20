package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.CommentDO;
import java.util.List;

public interface CommentDOMapper {
    int insert(CommentDO record);

    List<CommentDO> selectAll();
}