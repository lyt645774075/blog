package com.freturn.tech.security.login;/*
* Alipay.com Inc.
* Copyright (c) 2004-2016 All Rights Reserved
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.freturn.tech.dal.dao.UserBaseInfoDOMapper;
import com.freturn.tech.dal.dataobject.UserBaseInfoDO;

/**
 * @author yangtao.lyt
 * @version $Id: security.UserAuthenticationService, v 0.1 2016-01-16 23:04 yangtao.lyt Exp $
 */

@Service
public class UserAuthenticationService implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(UserAuthenticationService.class);

    @Autowired
    private UserBaseInfoDOMapper UserBaseInfoDOMapper;

    @Override
    public UserAuthDetail loadUserByUsername(String userName) {

        UserBaseInfoDO userBaseInfo = UserBaseInfoDOMapper.queryByEmail(userName);

        UserAuthDetail userAuthDetail = new UserAuthDetail();
        userAuthDetail.setId(userBaseInfo.getId());
        userAuthDetail.setEmail(userBaseInfo.getEmail());
        userAuthDetail.setPassword(userBaseInfo.getPassWord());
        userAuthDetail.setNickName(userBaseInfo.getNickName());
        userAuthDetail.setIconUrl(userBaseInfo.getIconUrl());

        return userAuthDetail;

    }
}
