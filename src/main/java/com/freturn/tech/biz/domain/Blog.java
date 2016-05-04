package com.freturn.tech.biz.domain;

import com.freturn.tech.support.constant.BlogType;
import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: Blog, v 0.1 2016-05-02 12:55 yangtao.lyt Exp $
 */
public class Blog {

    /** 数据库主键 */
    private String id;

    /** 创建时间 */
    private Date gmtCreate;

    /** 修改时间 */
    private Date gmtModified;

    /** 文章标题 */
    private String title;

    /** 创建人id */
    private String creatorId;

    /** 创建人昵称 */
    private String creatorNickName;

    /** 文章类型 */
    private BlogType type = BlogType.STANDARD;

    /** 文章分类 */
    private String category;

    /** 正文内容 */
    private String content;

    /** 文章标签 */
    private List<String> labelList = Lists.newArrayList();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorNickName() {
        return creatorNickName;
    }

    public void setCreatorNickName(String creatorNickName) {
        this.creatorNickName = creatorNickName;
    }

    public BlogType getType() {
        return type;
    }

    public void setType(BlogType type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
    }
}
