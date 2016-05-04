package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.UserBaseInfoDO;

public interface UserBaseInfoDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserBaseInfoDO userBaseInfoDO);


    UserBaseInfoDO selectByPrimaryKey(String id);

    int updateByPrimaryKey(UserBaseInfoDO userBaseInfoDO);

    UserBaseInfoDO queryByEmail(String email);

}