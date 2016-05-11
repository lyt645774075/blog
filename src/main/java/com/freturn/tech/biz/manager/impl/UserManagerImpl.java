package com.freturn.tech.biz.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.dal.dao.CommentDOMapper;
import com.freturn.tech.dal.dataobject.CommentDO;
import com.freturn.tech.dal.query.AdvancedQuery;
import com.freturn.tech.dal.query.CommentQuery;
import com.freturn.tech.support.constant.UserType;
import com.freturn.tech.support.domainObj.transfer.CommentTransfer;
import com.freturn.tech.support.domainObj.transfer.UserTransfer;
import com.freturn.tech.support.utils.UserIdGenerator;
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
import org.springframework.util.StringUtils;

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

    @Resource
    private CommentDOMapper commentDOMapper;



    @Override
    public String register(String email, String passWord, String nickName) {

        Preconditions.checkArgument(!StringUtils.isEmpty(email));
        Preconditions.checkArgument(!StringUtils.isEmpty(passWord));
        Preconditions.checkArgument(!StringUtils.isEmpty(nickName));

        String userId = UserIdGenerator.getUserId();

        UserBaseInfoDO userBaseInfoDO = new UserBaseInfoDO();
        userBaseInfoDO.setId(userId);
        userBaseInfoDO.setEmail(email);
        userBaseInfoDO.setPassWord(passWord);
        userBaseInfoDO.setNickName(nickName);

        userBaseInfoDO.setType(UserType.PERSON.getCode());

        userBaseInfoDOMapper.insert(userBaseInfoDO);

        return userId;

    }

    @Override
    public boolean isUserExist(String email) {
        return userBaseInfoDOMapper.queryByEmail(email) != null ? true : false;
    }

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


    @Override
    public List<Comment> queryKLatestComment(String userId, Integer k) {

        CommentQuery query = new CommentQuery();
        query.setUserId(userId);

        query.setOrderByFieldName("gmt_create");
        query.setLimitCount(k);

        List<CommentDO> commentDoList = commentDOMapper.query(query);

        return CommentTransfer.toBOList(commentDoList);
    }
}
