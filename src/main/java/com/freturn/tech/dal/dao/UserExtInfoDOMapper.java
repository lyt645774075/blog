package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.UserExtInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserExtInfoDOMapper {
    int deleteByPrimaryKey(String id);

    int deleteByUserId(String userId);

    int deleteByUserIdAndExtName(@Param("userId") String userId, @Param("extName") String extName);

    int insert(UserExtInfoDO userExtInfoDO);

    UserExtInfoDO selectByPrimaryKey(String id);

    int updateByPrimaryKey(UserExtInfoDO userExtInfoDO);

    List<UserExtInfoDO> queryByUserId(String userId);

    UserExtInfoDO queryByUserIdAndExtName(@Param("userId") String userId, @Param("extName") String extName);
}