package com.freturn.tech.biz.manager.impl;

import com.freturn.tech.biz.domain.Comment;
import com.freturn.tech.biz.domain.User;
import com.freturn.tech.biz.manager.UserManager;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: UserManagerImpl, v 0.1 2016-05-05 09:39 yangtao.lyt Exp $
 */
@Component
public class UserManagerImpl implements UserManager{
    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public List<Comment> queryCommentByUserId(String userId) {
        return null;
    }


}
