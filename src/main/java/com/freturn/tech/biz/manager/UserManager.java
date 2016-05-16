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

    /**
     * 查询用户最近的k个评论
     * @param userId
     * @return
     */
    List<Comment> queryKLatestComment(String userId, Integer k);


    /**
     * 添加文章分类
     * @param userId
     * @param cateName
     */
    void addCategory(String userId, String cateName);


    /**
     * 删除文章分类
     * @param userId
     * @param cateName
     */
    void deleteCategory(String userId, String cateName);


    /**
     * 添加个人作品
     * @param userId
     * @param cateName
     */
    void addWork(String userId, String cateName);


    /**
     * 删除个人作品
     * @param userId
     * @param cateName
     */
    void deleteWork(String userId, String cateName);


}
