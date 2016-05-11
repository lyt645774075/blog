package com.freturn.tech.biz.manager.impl;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.biz.domain.Comment;
import com.freturn.tech.biz.manager.BlogManager;
import com.freturn.tech.dal.dao.BlogDOMapper;
import com.freturn.tech.dal.dao.CommentDOMapper;
import com.freturn.tech.dal.dataobject.BlogDO;
import com.freturn.tech.dal.dataobject.CommentDO;
import com.freturn.tech.dal.query.BlogQuery;
import com.freturn.tech.dal.query.CommentQuery;
import com.freturn.tech.security.login.LoginUserHolder;
import com.freturn.tech.support.constant.CommentType;
import com.freturn.tech.support.constant.Device;
import com.freturn.tech.support.constant.DomainType;
import com.freturn.tech.support.domainObj.transfer.BlogTransfer;
import com.freturn.tech.support.domainObj.transfer.CommentTransfer;
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

        Preconditions.checkNotNull(blog);

        blogDOMapper.insert(BlogTransfer.toDO(blog));

        return blog.getId();
    }

    @Override
    public Blog getBlogById(String blogId) {

        Preconditions.checkNotNull(blogId);

        BlogDO blogDO = blogDOMapper.selectByPrimaryKey(blogId);

        return BlogTransfer.toBO(blogDO);
    }

    @Override
    public List<Blog> queryBlogByUserId(String userId) {
        return null;
    }

    @Override
    public List<Comment> queryCommonCommentByBlogId(String blogId) {

        Preconditions.checkNotNull(blogId);

        CommentQuery query = new CommentQuery();
        query.setDomainId(blogId);
        query.setDomainType(DomainType.BLOG.getCode());
        query.setType(CommentType.COMMON.getCode());

        List<CommentDO> commentDOList = commentDOMapper.query(query);

        return CommentTransfer.toBOList(commentDOList);
    }

    @Override
    public List<Blog> queryRelatedBlogListByBlogId(String blogId) {
        return null;
    }

    @Override
    public void addComment(String blogId, String blogTitle, String content, Long parentId) {

        Blog blog = getBlogById(blogId);
        if(blog == null){
            return ;
        }

        CommentDO commentDO = new CommentDO();
        commentDO.setDomainId(blogId);
        commentDO.setDomainName(blogTitle);
        commentDO.setDomainType(DomainType.BLOG.getCode());
        commentDO.setUserId(blog.getCreatorId());
        commentDO.setUserNickName(blog.getCreatorNickName());
        commentDO.setType(CommentType.COMMON.getCode());
        commentDO.setContent(content);
        commentDO.setParentId(parentId);
        commentDO.setCreatorId(loginUserHolder.getId());
        commentDO.setCreatorNickName(loginUserHolder.getNickName());
        commentDO.setCreatorIconUrl(loginUserHolder.getIconUrl());
        commentDO.setDevice(Device.PC.getCode());
        commentDO.setLocation("中国");

        commentDOMapper.insert(commentDO);

    }


    @Override
    public List<Blog> queryKLatestBlog(String userId, Integer k) {
        Preconditions.checkNotNull(userId);

        BlogQuery query = new BlogQuery();
        query.setCreatorId(userId);
        query.setOrderByFieldName("gmt_create");
        query.setLimitCount(k);

        List<BlogDO> blogDOList = blogDOMapper.query(query);

        return BlogTransfer.toBOList(blogDOList);
    }



}
