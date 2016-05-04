package com.freturn.tech.security.login;/*
* Alipay.com Inc.
* Copyright (c) 2004-2016 All Rights Reserved
*/

import com.freturn.tech.dal.dao.UserBaseInfoDOMapper;
import com.freturn.tech.dal.dataobject.UserBaseInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yangtao.lyt
 * @version $Id: security.UserAuthenticationService, v 0.1 2016-01-16 23:04 yangtao.lyt Exp $
 */

@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private UserBaseInfoDOMapper UserBaseInfoDOMapper;

    @Override
    public UserAuthDetail loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserBaseInfoDO UserBaseInfo = UserBaseInfoDOMapper.queryByEmail(userName);

        UserAuthDetail userAuthDetail = new UserAuthDetail();
        userAuthDetail.setId(UserBaseInfo.getId());
        userAuthDetail.setEmail(UserBaseInfo.getEmail());
        userAuthDetail.setPassword(UserBaseInfo.getPassWord());
        userAuthDetail.setNickName(UserBaseInfo.getNickName());

        return userAuthDetail;
    }
}
