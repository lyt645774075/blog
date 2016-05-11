package com.freturn.tech.support.domainObj.transfer;

import com.alibaba.fastjson.JSONObject;
import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.dal.dataobject.BlogDO;
import com.freturn.tech.support.constant.BlogStatus;
import com.freturn.tech.support.constant.BlogType;
import com.freturn.tech.support.constant.Device;
import com.freturn.tech.support.constant.SeeScope;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author yangtao.lyt
 * @version $Id: BlogTransfer, v 0.1 2016-05-02 13:23 yangtao.lyt Exp $
 */
public class BlogTransfer {

    public static BlogDO toDO(Blog blog){

        Preconditions.checkNotNull(blog);

        BlogDO blogDO = new BlogDO();


        blogDO.setId(blog.getId());
        blogDO.setTitle(blog.getTitle());
        blogDO.setCreatorId(blog.getCreatorId());
        blogDO.setCreatorNickName(blog.getCreatorNickName());
        blogDO.setType(blog.getType().getCode());
        blogDO.setCategory(blog.getCategory());
        blogDO.setSeeScope(blog.getSeeScope().getCode());
        blogDO.setStatus(blog.getStatus().getCode());
        blogDO.setDevice(blog.getDevice().getCode());
        blogDO.setLocation(blog.getLocation());

        blogDO.setContentMap(JSONObject.toJSONString(blog.getContentMap()));

        blogDO.setLabelIdList(Joiner.on(",").join(blog.getLabelList()));


        return blogDO;
    }


    public static Blog toBO(BlogDO blogDO){

        Preconditions.checkNotNull(blogDO);

        Blog blog = new Blog();

        blog.setId(blogDO.getId());
        blog.setGmtCreate(blogDO.getGmtCreate());
        blog.setGmtModified(blogDO.getGmtModified());
        blog.setTitle(blogDO.getTitle());
        blog.setCreatorId(blogDO.getCreatorId());
        blog.setCreatorNickName(blogDO.getCreatorNickName());
        blog.setType(BlogType.getTypeByCode(blogDO.getType()));
        blog.setCategory(blogDO.getCategory());
        blog.setSeeScope(SeeScope.getEnumByCode(blogDO.getSeeScope()));
        blog.setStatus(BlogStatus.getStatusByCode(blogDO.getStatus()));
        blog.setDevice(Device.getTypeByCode(blogDO.getDevice()));
        blog.setLocation(blogDO.getLocation());

        blog.setContentMap((Map<String, String>) JSONObject.parse(blogDO.getContentMap()));

        blog.setLabelList(Splitter.on(",").splitToList(blogDO.getLabelIdList()));

        return blog;

    }


    public static List<Blog> toBOList(List<BlogDO> blogDOList){
        if(CollectionUtils.isEmpty(blogDOList)){
            return Lists.newArrayList();
        }

        List<Blog> result = Lists.newArrayList();
        for(BlogDO blogDO : blogDOList){
            result.add(toBO(blogDO));
        }

        return result;
    }



}
