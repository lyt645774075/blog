package com.freturn.tech.support.utils;

import com.freturn.tech.biz.domain.User;
import com.freturn.tech.biz.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 * 用户加载工具
 *
 * @author yangtao.lyt
 * @version $Id: UserLoader, v 0.1 2016-05-21 10:36 yangtao.lyt Exp $
 */
@Component
public class UserLoader {

    private static final Logger logger = LoggerFactory.getLogger(UserLoader.class);

    @Resource
    private UserManager userManager;

    public User load(String userId){

        try{
            return userManager.getUserById(userId);
        }catch (Exception e){

            logger.error("加载用户信息失败, userId=" + userId, e);

            return null;
        }
    }


}
