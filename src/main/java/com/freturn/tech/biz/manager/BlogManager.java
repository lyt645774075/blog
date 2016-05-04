package com.freturn.tech.biz.manager;

import com.freturn.tech.biz.domain.Blog;

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


}
