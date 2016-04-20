package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.ActivityDO;
import java.util.List;

public interface ActivityDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ActivityDO record);

    ActivityDO selectByPrimaryKey(Long id);

    List<ActivityDO> selectAll();

    int updateByPrimaryKey(ActivityDO record);
}