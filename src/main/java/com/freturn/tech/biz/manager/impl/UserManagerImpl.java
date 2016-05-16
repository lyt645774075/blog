package com.freturn.tech.biz.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.dal.dao.CommentDOMapper;
import com.freturn.tech.dal.dataobject.CommentDO;
import com.freturn.tech.dal.query.AdvancedQuery;
import com.freturn.tech.dal.query.CommentQuery;
import com.freturn.tech.support.constant.UserExtInfoType;
import com.freturn.tech.support.constant.UserType;
import com.freturn.tech.support.domainObj.transfer.CommentTransfer;
import com.freturn.tech.support.domainObj.transfer.UserTransfer;
import com.freturn.tech.support.utils.UserIdGenerator;
import com.freturn.tech.support.utils.UserUtil;
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
        userBaseInfoDO.setIconUrl(UserUtil.getRandomIconUrl());

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


    @Override
    public void addCategory(String userId, String cateName) {

        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(cateName);

        UserBaseInfoDO userBaseInfoDO = userBaseInfoDOMapper.selectByPrimaryKey(userId);
        if(userBaseInfoDO == null){
            return;
        }

        UserExtInfoDO extInfoDO = new UserExtInfoDO();
        extInfoDO.setType(UserExtInfoType.CATEGORY.getCode());
        extInfoDO.setUserId(userBaseInfoDO.getId());
        extInfoDO.setUserNickName(userBaseInfoDO.getNickName());
        extInfoDO.setExtName(cateName);
        extInfoDO.setExtValue("0");

        userExtInfoDOMapper.insert(extInfoDO);

    }

    @Override
    public void deleteCategory(String userId, String cateName) {

        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(cateName);

        userExtInfoDOMapper.deleteByUserIdAndExtName(userId, cateName);

    }

    @Override
    public void addWork(String userId, String workName, String workLink) {

        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(workName);
        Preconditions.checkNotNull(workLink);


        UserBaseInfoDO userBaseInfoDO = userBaseInfoDOMapper.selectByPrimaryKey(userId);
        if(userBaseInfoDO == null){
            return;
        }

        UserExtInfoDO extInfoDO = new UserExtInfoDO();
        extInfoDO.setType(UserExtInfoType.LINK.getCode());
        extInfoDO.setUserId(userBaseInfoDO.getId());
        extInfoDO.setUserNickName(userBaseInfoDO.getNickName());
        extInfoDO.setExtName(workName);
        extInfoDO.setExtValue(workLink);

        userExtInfoDOMapper.insert(extInfoDO);
    }

    @Override
    public void deleteWork(String userId, String workName) {
        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(workName);

        userExtInfoDOMapper.deleteByUserIdAndExtName(userId, workName);

    }
}
