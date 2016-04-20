package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.UserDO;
import java.util.List;

public interface UserDOMapper {
    int insert(UserDO record);

    List<UserDO> selectAll();
}