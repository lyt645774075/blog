package com.freturn.tech.dal.dataobject;

import java.util.Date;

/**
 * 评论对象
 */
public class CommentDO {
    /**
     * 数据库id
     */
    private Long    id;

    /**
     * gmtCreate
     */
    private Date    gmtCreate;

    /**
     * gmtModified
     */
    private Date    gmtModified;

    /**
     * 领域对象id
     */
    private String  domainId;

    /**
     * 领域对象类型:博客,用户
     */
    private Integer domainType;

    /**
     * 领域对象名称:博客标题,用户昵称
     */
    private String  domainName;

    /**
     * 被评论人id
     */
    private String  userId;

    /**
     * 被评论人昵称
     */
    private String  userNickName;

    /**
     * 评论类型:专家评审意见/普通评论
     */
    private Integer type;

    /**
     * 评论内容
     */
    private String  content;

    /**
     * 父评论id
     */
    private Long    parentId;

    /**
     * 评论人id
     */
    private String  creatorId;

    /**
     * 评论人昵称
     */
    private String  creatorNickName;

    /**
     * 评论人头像url
     */
    private String  creatorIconUrl;

    /**
     * 设备
     */
    private Integer device;

    /**
     * 地理位置 
     */
    private String  location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public Integer getDomainType() {
        return domainType;
    }

    public void setDomainType(Integer domainType) {
        this.domainType = domainType;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
        this.creatorNickName = creatorNickName == null ? null : creatorNickName.trim();
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getCreatorIconUrl() {
        return creatorIconUrl;
    }

    public void setCreatorIconUrl(String creatorIconUrl) {
        this.creatorIconUrl = creatorIconUrl;
    }
}