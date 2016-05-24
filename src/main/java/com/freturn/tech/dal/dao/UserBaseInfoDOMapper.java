package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.UserBaseInfoDO;

public interface UserBaseInfoDOMapper {

    /**
     * 删除指定主键的用户信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入一条新的用户信息
     * @param userBaseInfoDO
     * @return
     */
    int insert(UserBaseInfoDO userBaseInfoDO);

    /**
     * 查询指定主键的用户信息
     * @param id
     * @return
     */
    UserBaseInfoDO selectByPrimaryKey(String id);

    /**
     * 更新指定主键的用户信息
     * @param userBaseInfoDO
     * @return
     */
    int updateByPrimaryKey(UserBaseInfoDO userBaseInfoDO);

    /**
     * 查询指定email的用户信息
     * @param email
     * @return
     */
    UserBaseInfoDO queryByEmail(String email);

}