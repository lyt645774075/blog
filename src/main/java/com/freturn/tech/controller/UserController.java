package com.freturn.tech.controller;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.biz.domain.Comment;
import com.freturn.tech.biz.domain.User;
import com.freturn.tech.biz.manager.BlogManager;
import com.freturn.tech.biz.manager.UserManager;
import com.freturn.tech.support.constant.PathConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 用户controller
 *
 * @author yangtao.lyt
 * @version $Id: BlogController, v 0.1 2016-04-20 20:49 yangtao.lyt Exp $
 */
@Controller
public class UserController {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserManager userManager;

    @Resource
    private BlogManager blogManager;


    @RequestMapping("/user/{userId}")
    public String getUserHome(@PathVariable String userId, ModelMap modelMap) {

        User user = userManager.getUserById(userId);

        modelMap.addAttribute("user", user);


        /*UserDO userDO = userDOMapper.queryOneById(userId);

        List<MetadataDO> metadataDOList = metadataDOMapper.queryListByIdList(Splitter.on(",")
                .splitToList(userDO.getCategoryIdList()));

        List<UserExtDO> userExtDOList = userExtDOMapper.queryListByUserId(userId);

        modelMap.addAttribute("user", userDO);
        modelMap.addAttribute("metadataList", metadataDOList);
        modelMap.addAttribute("userExtList", userExtDOList);

        return PathConstant.USER_HOME;*/

        return PathConstant.USER_HOME;

    }

    @RequestMapping("/blog/{blogId}")
    public String getBlogHome(@PathVariable String blogId,  ModelMap modelMap) {


        Blog blog = blogManager.getBlogById(blogId);
        User user = userManager.getUserById(blog.getCreatorId());
        List<Comment> commentList = blogManager.queryCommonCommentByBlogId(blogId);

        List<Blog> kLatestBlog = blogManager.queryKLatestBlog(blog.getCreatorId(), 5);

        List<Comment> kLatestComment = userManager.queryKLatestComment(blog.getCreatorId(), 5);


        modelMap.addAttribute("user", user);
        modelMap.addAttribute("blog", blog);
        modelMap.addAttribute("commentList", commentList);
        modelMap.addAttribute("kLatestBlog", kLatestBlog);
        modelMap.addAttribute("kLatestComment", kLatestComment);

        return PathConstant.BLOG_HOME;

    }

    @RequestMapping("/user/{userId}/aboutme")
    public String getAboutMe(@PathVariable String userId, ModelMap modelMap) {

        modelMap.addAttribute("userId", userId);

        return PathConstant.USER_ABOUTME;

    }

    @RequestMapping("/user/{userId}/contact")
    public String getContact(@PathVariable String userId, ModelMap modelMap) {

        modelMap.addAttribute("userId", userId);

        return PathConstant.USER_CONTACT;

    }

}
