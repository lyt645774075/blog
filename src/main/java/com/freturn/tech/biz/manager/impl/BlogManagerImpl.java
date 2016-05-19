package com.freturn.tech.biz.manager.impl;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.biz.domain.Comment;
import com.freturn.tech.biz.manager.BlogManager;
import com.freturn.tech.dal.dao.BlogDOMapper;
import com.freturn.tech.dal.dao.CommentDOMapper;
import com.freturn.tech.dal.dao.UserExtInfoDOMapper;
import com.freturn.tech.dal.dataobject.BlogDO;
import com.freturn.tech.dal.dataobject.CommentDO;
import com.freturn.tech.dal.dataobject.UserBaseInfoDO;
import com.freturn.tech.dal.dataobject.UserExtInfoDO;
import com.freturn.tech.dal.query.BlogQuery;
import com.freturn.tech.dal.query.CommentQuery;
import com.freturn.tech.security.login.LoginUserHolder;
import com.freturn.tech.support.constant.BlogStatus;
import com.freturn.tech.support.constant.BlogType;
import com.freturn.tech.support.constant.CommentType;
import com.freturn.tech.support.constant.CommonConstant;
import com.freturn.tech.support.constant.Device;
import com.freturn.tech.support.constant.DomainType;
import com.freturn.tech.support.constant.SeeScope;
import com.freturn.tech.support.constant.UserExtInfoType;
import com.freturn.tech.support.domainObj.transfer.BlogTransfer;
import com.freturn.tech.support.domainObj.transfer.CommentTransfer;
import com.freturn.tech.support.helper.ImageUploadHelper;
import com.freturn.tech.support.utils.BlogIdGenerator;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @Resource
    private UserExtInfoDOMapper userExtInfoDOMapper;

    @Autowired
    private LoginUserHolder loginUserHolder;

    @Autowired
    private ImageUploadHelper imageUploadHelper;


    @Override
    public String createStandardBlog(String title, String content, String category) {
        Preconditions.checkNotNull(title);
        Preconditions.checkNotNull(content);

        Blog blog = new Blog();

        blog.setType(BlogType.STANDARD);
        blog.setTitle(title);
        blog.setCategory(category);

        Map<String, Object> contentMap = Maps.newHashMap();
        contentMap.put("title", title);
        contentMap.put("content", content);
        blog.setContentMap(contentMap);

        return this.createBlog(blog);
    }

    @Override
    public String createGalleryBlog(MultipartFile[] images, String desc, String category) {
        Preconditions.checkNotNull(images);
        Preconditions.checkNotNull(desc);

        Blog blog = new Blog();

        blog.setType(BlogType.GALLERY);
        blog.setTitle("图集分享");
        blog.setCategory(category);

        List<String> urlList = Lists.newArrayList();
        for(MultipartFile image : images){
            try {
                String url = imageUploadHelper.doUpload(image);
                urlList.add(url);
            } catch (IOException e) {
                logger.error("图片上传失败", e);
            }
        }

        Map<String, Object> contentMap = Maps.newHashMap();
        contentMap.put("imageUrlList", urlList);
        contentMap.put("desc", desc);
        blog.setContentMap(contentMap);

        return this.createBlog(blog);
    }

    @Override
    public String createLinkBlog(String title, String url, String category) {

        Preconditions.checkNotNull(title);
        Preconditions.checkNotNull(url);

        Blog blog = new Blog();

        blog.setType(BlogType.LINK);
        blog.setTitle(title);
        blog.setCategory(category);

        Map<String, Object> contentMap = Maps.newHashMap();
        contentMap.put("title", title);
        contentMap.put("url", url);
        blog.setContentMap(contentMap);

        return this.createBlog(blog);

    }

    @Override
    public String createQuoteBlog(String cite, String content, String category) {
        Preconditions.checkNotNull(cite);
        Preconditions.checkNotNull(content);

        Blog blog = new Blog();

        blog.setType(BlogType.QUOTE);
        blog.setTitle("生活感悟");
        blog.setCategory(category);

        Map<String, Object> contentMap = Maps.newHashMap();
        contentMap.put("cite", cite);
        contentMap.put("content", content);
        blog.setContentMap(contentMap);

        return this.createBlog(blog);
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
        commentDO.setLocation(CommonConstant.DEFAULT_LOCATION);

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




    private String createBlog(Blog blog) {
        Preconditions.checkNotNull(blog);

        String blogId = BlogIdGenerator.getBlogId();
        blog.setId(blogId);
        blog.setCreatorId(loginUserHolder.getId());
        blog.setCreatorNickName(loginUserHolder.getNickName());

        if(StringUtils.isEmpty(blog.getCategory())){
            blog.setCategory(CommonConstant.DEFAULT_CATEGORY);
        }

        blog.setSeeScope(SeeScope.PRIVATE);
        blog.setStatus(BlogStatus.FINISH);
        blog.setDevice(Device.PC);
        blog.setLocation(CommonConstant.DEFAULT_LOCATION);

        //新增文章
        blogDOMapper.insert(BlogTransfer.toDO(blog));

        //更新分类计数
        UserExtInfoDO extInfoDO = userExtInfoDOMapper.queryByUserIdAndExtName(loginUserHolder.getId(), blog.getCategory());

        if(extInfoDO != null){
            //查一次用户在该分类下的所有文章总数,更新计数,保证每次写文章可以纠错计数一次
            BlogQuery query = new BlogQuery();
            query.setCreatorId(loginUserHolder.getId());
            query.setCategory(blog.getCategory());

            extInfoDO.setExtValue(String.valueOf(blogDOMapper.count(query)));
            userExtInfoDOMapper.updateByPrimaryKey(extInfoDO);
        }

        //如果是"默认分类"不存在..创建一个
        if(extInfoDO == null && blog.getCategory().equals(CommonConstant.DEFAULT_CATEGORY)){
            extInfoDO = new UserExtInfoDO();
            extInfoDO.setType(UserExtInfoType.CATEGORY.getCode());
            extInfoDO.setUserId(loginUserHolder.getId());
            extInfoDO.setUserNickName(loginUserHolder.getNickName());
            extInfoDO.setDescription(CommonConstant.DEFAULT_CATEGORY);
            extInfoDO.setExtName(CommonConstant.DEFAULT_CATEGORY);
            extInfoDO.setExtValue("1");

            userExtInfoDOMapper.insert(extInfoDO);
        }

        return blog.getId();
    }



}
