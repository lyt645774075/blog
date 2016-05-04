package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.UserExtInfoDO;

import java.util.List;

public interface UserExtInfoDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserExtInfoDO userExtInfoDO);

    UserExtInfoDO selectByPrimaryKey(String id);

    int updateByPrimaryKey(UserExtInfoDO userExtInfoDO);

    List<UserExtInfoDO> queryByUserId(String userId);
}