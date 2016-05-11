package com.freturn.tech.biz.domain;

import com.freturn.tech.support.constant.CommentType;
import com.freturn.tech.support.constant.Device;
import com.freturn.tech.support.constant.DomainType;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: Comment, v 0.1 2016-05-05 09:47 yangtao.lyt Exp $
 */
public class Comment {

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String domainId;

    private DomainType domainType;

    private String domainName;

    private String userId;

    private String userNickName;

    private CommentType type;

    private String content;

    private Long parentId;

    private String creatorId;

    private String creatorNickName;

    private String creatorIconUrl;

    private Device device;

    private String location;


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

    public DomainType getDomainType() {
        return domainType;
    }

    public void setDomainType(DomainType domainType) {
        this.domainType = domainType;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        this.creatorNickName = creatorNickName;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
