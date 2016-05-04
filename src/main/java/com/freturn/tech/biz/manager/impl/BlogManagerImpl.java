package com.freturn.tech.biz.manager.impl;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.biz.manager.BlogManager;
import com.freturn.tech.dal.dao.BlogDOMapper;
import com.freturn.tech.security.login.LoginUserHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author yangtao.lyt
 * @version $Id: BlogManagerImpl, v 0.1 2016-05-02 13:16 yangtao.lyt Exp $
 */
public class BlogManagerImpl implements BlogManager {

    private static final Logger logger = LoggerFactory.getLogger(BlogManagerImpl.class);

    @Resource
    private BlogDOMapper blogDOMapper;

    @Autowired
    private LoginUserHolder loginUserHolder;

    @Override
    public String createBlog(Blog blog) {



        return null;
    }



}
