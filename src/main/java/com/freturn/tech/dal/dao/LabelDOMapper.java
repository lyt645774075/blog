package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.LabelDO;
import com.freturn.tech.dal.query.LabelQuery;

import java.util.List;

public interface LabelDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LabelDO labelDO);

    LabelDO selectByPrimaryKey(Long id);

    List<LabelDO> query(LabelQuery labelQuery);

    int updateByPrimaryKey(LabelDO labelDO);
}