package com.freturn.tech.biz.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.freturn.tech.biz.domain.Comment;
import com.freturn.tech.biz.domain.User;
import com.freturn.tech.biz.manager.UserManager;
import com.freturn.tech.dal.dao.UserBaseInfoDOMapper;
import com.freturn.tech.dal.dao.UserExtInfoDOMapper;
import com.freturn.tech.dal.dataobject.UserBaseInfoDO;
import com.freturn.tech.dal.dataobject.UserExtInfoDO;
import com.freturn.tech.support.domainObj.builder.UserBuilder;
import com.google.common.base.Preconditions;

/**
 * @author yangtao.lyt
 * @version $Id: UserManagerImpl, v 0.1 2016-05-05 09:39 yangtao.lyt Exp $
 */
@Component
public class UserManagerImpl implements UserManager{

    @Resource
    private UserBaseInfoDOMapper userBaseInfoDOMapper;

    @Resource
    private UserExtInfoDOMapper userExtInfoDOMapper;


    @Override
    public User getUserById(String id) {

        Preconditions.checkNotNull(id);

        UserBaseInfoDO userBaseInfoDO = userBaseInfoDOMapper.selectByPrimaryKey(id);

        List<UserExtInfoDO> userExtInfoDOList = userExtInfoDOMapper.queryByUserId(id);

        return UserBuilder.getInstance().fromBaseInfo(userBaseInfoDO).fromExtInfo(userExtInfoDOList).build();

    }

    @Override
    public List<Comment> queryCommentByUserId(String userId) {
        return null;
    }


}
