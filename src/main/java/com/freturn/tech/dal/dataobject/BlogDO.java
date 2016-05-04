package com.freturn.tech.dal.dataobject;

import java.util.Date;

public class BlogDO {
    private String id;

    private Date gmtCreate;

    private Date gmtModified;

    private String title;

    private String creatorId;

    private String creatorNickName;

    private String type;

    private String category;

    private Integer seeScope;

    private String status;

    private Integer device;

    private String location;

    private String contentMap;

    private String labelIdList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        this.title = title == null ? null : title.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public String getCreatorNickName() {
        return creatorNickName;
    }

    public void setCreatorNickName(String creatorNickName) {
        this.creatorNickName = creatorNickName == null ? null : creatorNickName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getSeeScope() {
        return seeScope;
    }

    public void setSeeScope(Integer seeScope) {
        this.seeScope = seeScope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getContentMap() {
        return contentMap;
    }

    public void setContentMap(String contentMap) {
        this.contentMap = contentMap == null ? null : contentMap.trim();
    }

    public String getLabelIdList() {
        return labelIdList;
    }

    public void setLabelIdList(String labelIdList) {
        this.labelIdList = labelIdList == null ? null : labelIdList.trim();
    }
}