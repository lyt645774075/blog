package com.freturn.tech.biz.manager;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.biz.domain.Comment;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: BlogManagerImpl, v 0.1 2016-05-02 13:12 yangtao.lyt Exp $
 */
public interface BlogManager {

    /**
     * 创建博客文章
     * @param blog
     * @return
     */
    public String createBlog(Blog blog);


    public Blog getBlogById(String blogId);


    public List<Blog> queryBlogByUserId(String userId);


    public List<Comment> queryCommentByBlogId(String blogId);


}
