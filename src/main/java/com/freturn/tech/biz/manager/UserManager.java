package com.freturn.tech.biz.manager;

import com.freturn.tech.biz.domain.Comment;
import com.freturn.tech.biz.domain.User;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: UserManager, v 0.1 2016-05-05 09:37 yangtao.lyt Exp $
 */
public interface UserManager {



    public String register(String email, String passWord, String nickName);

    public boolean isUserExist(String email);

    public User getUserById(String id);

    public List<Comment> queryCommentByUserId(String userId);


}
