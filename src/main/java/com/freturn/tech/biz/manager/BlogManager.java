package com.freturn.tech.biz.manager;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.biz.domain.Comment;
import com.freturn.tech.biz.domain.PagedResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: BlogManagerImpl, v 0.1 2016-05-02 13:12 yangtao.lyt Exp $
 */
public interface BlogManager {



    public String createStandardBlog(String title, String content, String category);

    public String createGalleryBlog(MultipartFile[] images, String desc, String category);

    public String createLinkBlog(String title, String url, String category);

    public String createQuoteBlog(String cite, String content, String category);






    public Blog getBlogById(String blogId);


    public List<Blog> queryBlogByUserId(String userId);


    public List<Comment> queryCommonCommentByBlogId(String blogId);

    /**
     * 获取相关博客
     * @param blogId
     * @return
     */
    public List<Blog> queryRelatedBlogListByBlogId(String blogId);


    public void addComment(String blogId, String blogTitle, String content, Long parentId);


    /**
     * 查询用户最近的k篇blog
     * @param userId
     * @return
     */
    List<Blog> queryKLatestBlog(String userId, Integer k);


    List<Blog> queryByUserIdAndCategory(String userId, String category);

    PagedResult<Blog> pageQuery(String userId, Integer pageNo);

}
