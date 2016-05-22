package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.UserExtInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserExtInfoDOMapper {
    /**
     * 删除指定主键的扩展信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 删除指定用户id的所有扩展信息
     * @param userId
     * @return
     */
    int deleteByUserId(String userId);

    /**
     * 根据用户id和扩展属性名称,删除指定的扩展信息
     * @param userId
     * @param extName
     * @return
     */
    int deleteByUserIdAndExtName(@Param("userId") String userId, @Param("extName") String extName);

    /**
     * 插入一条新的扩展信息
     * @param userExtInfoDO
     * @return
     */
    int insert(UserExtInfoDO userExtInfoDO);

    /**
     * 查询指定主键的用户扩展信息
     * @param id
     * @return
     */
    UserExtInfoDO selectByPrimaryKey(String id);

    /**
     * 查询指定主键的用户扩展信息
     * @param userExtInfoDO
     * @return
     */
    int updateByPrimaryKey(UserExtInfoDO userExtInfoDO);

    /**
     * 查询指定用户id的所有扩展信息
     * @param userId
     * @return
     */
    List<UserExtInfoDO> queryByUserId(String userId);

    /**
     * 查询指定用户id和扩展属性名称的扩展信息
     * @param userId
     * @param extName
     * @return
     */
    UserExtInfoDO queryByUserIdAndExtName(@Param("userId") String userId,
                                          @Param("extName") String extName);
}