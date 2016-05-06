package com.freturn.tech.support.domainObj.transfer;

import com.alibaba.fastjson.JSONObject;
import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.dal.dataobject.BlogDO;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author yangtao.lyt
 * @version $Id: BlogTransfer, v 0.1 2016-05-02 13:23 yangtao.lyt Exp $
 */
public class BlogTransfer {

    public static BlogDO toDO(Blog blog){

        BlogDO blogDO = new BlogDO();
        blogDO.setCreatorId(blog.getCreatorId());
        blogDO.setCreatorNickName(blog.getCreatorNickName());
        blogDO.setTitle(blog.getTitle());
        blogDO.setCategory("默认");
        blogDO.setType(blog.getType().getCode());

        Map<String,Object> contentMap = Maps.newHashMap();
        contentMap.put("content", blog.getContent());

        blogDO.setContentMap(JSONObject.toJSONString(contentMap));

        return blogDO;
    }






}
