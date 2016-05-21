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
     * @param workName
     * @param workLink
     */
    void addWork(String userId, String workName, String workLink);


    /**
     * 删除个人作品
     * @param userId
     * @param workName
     */
    void deleteWork(String userId, String workName);


    void updateIcon(String userId, String iconUrl);

    /**
     * 更新联系方式
     * @param userId
     * @param extName
     * @param extValue
     */
    void updateContact(String userId, String extName, String extValue);

    void updatePhone(String userId, String extValue);
    void updateEmail(String userId, String extValue);
    void updateQQ(String userId, String extValue);
    void updateWeiXin(String userId, String extValue);
    void updateLinkedIn(String userId, String extValue);
    void updateGitHub(String userId, String extValue);


}
