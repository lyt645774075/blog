package com.freturn.tech.support.domainObj.builder;

import com.freturn.tech.biz.domain.User;
import com.freturn.tech.dal.dataobject.UserBaseInfoDO;
import com.freturn.tech.dal.dataobject.UserExtInfoDO;
import com.freturn.tech.support.constant.UserExtInfoType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author yangtao.lyt
 * @version $Id: UserBuilder, v 0.1 2016-05-05 19:26 yangtao.lyt Exp $
 */
public class UserBuilder {


    private UserBaseInfoDO userBaseInfoDO;

    private List<UserExtInfoDO> userExtInfoDOList;

    private UserBuilder(){

    }

    public static UserBuilder getInstance(){
        return new UserBuilder();
    }

    public UserBuilder fromBaseInfo(UserBaseInfoDO userBaseInfoDO){
        Preconditions.checkNotNull(userBaseInfoDO);

        this.userBaseInfoDO = userBaseInfoDO;

        return this;
    }

    public UserBuilder fromExtInfo(List<UserExtInfoDO> userExtInfoDOList){
        Preconditions.checkNotNull(userExtInfoDOList);
        this.userExtInfoDOList = userExtInfoDOList;
        return this;
    }


    public User build(){
        Preconditions.checkNotNull(userBaseInfoDO);

        User user = new User();
        user.setId(userBaseInfoDO.getId());
        user.setGmtCreate(userBaseInfoDO.getGmtCreate());
        user.setGmtModified(userBaseInfoDO.getGmtModified());
        user.setEmail(userBaseInfoDO.getEmail());
        user.setPassWord(userBaseInfoDO.getPassWord());
        user.setType(userBaseInfoDO.getType());
        user.setNickName(userBaseInfoDO.getNickName());
        user.setIconUrl(userBaseInfoDO.getIconUrl());
        user.setSelfIntroduction(userBaseInfoDO.getSelfIntroduction());

        user.setExtInfoDOList(userExtInfoDOList);

        Map<String, Integer> categoryMap = Maps.newHashMap();
        Map<String, String> linkProMap = Maps.newHashMap();
        Map<String, String> contactMap = Maps.newHashMap();

        for(UserExtInfoDO extInfo : userExtInfoDOList){
            if(extInfo.getType().equals(UserExtInfoType.CATEGORY.getCode())){
                categoryMap.put(extInfo.getExtName(), Integer.valueOf(extInfo.getExtValue()));
            }

            if(extInfo.getType().equals(UserExtInfoType.LINK.getCode())){
                linkProMap.put(extInfo.getExtName(), extInfo.getExtValue());
            }

            if(extInfo.getType().equals(UserExtInfoType.CONTACT.getCode())){
                contactMap.put(extInfo.getExtName(), extInfo.getExtValue());
            }
        }

        user.setCategoryMap(categoryMap);
        user.setLinkProMap(linkProMap);
        user.setContactMap(contactMap);

        return user;
    }


}
