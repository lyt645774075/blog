package com.freturn.tech.biz.manager.impl;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.biz.domain.Comment;
import com.freturn.tech.biz.manager.BlogManager;
import com.freturn.tech.dal.dao.BlogDOMapper;
import com.freturn.tech.dal.dao.CommentDOMapper;
import com.freturn.tech.dal.dataobject.BlogDO;
import com.freturn.tech.security.login.LoginUserHolder;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: BlogManagerImpl, v 0.1 2016-05-02 13:16 yangtao.lyt Exp $
 */
@Component
public class BlogManagerImpl implements BlogManager {

    private static final Logger logger = LoggerFactory.getLogger(BlogManagerImpl.class);

    @Resource
    private BlogDOMapper blogDOMapper;

    @Resource
    private CommentDOMapper commentDOMapper;

    @Autowired
    private LoginUserHolder loginUserHolder;

    @Override
    public String createBlog(Blog blog) {



        return null;
    }

    @Override
    public Blog getBlogById(String blogId) {

       return  null;

    }

    @Override
    public List<Blog> queryBlogByUserId(String userId) {
        return null;
    }

    @Override
    public List<Comment> queryCommentByBlogId(String blogId) {
        return null;
    }


}
