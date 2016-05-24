package com.freturn.tech.dal.dataobject;

import java.util.Date;

/**
 * 用户扩展信息
 */
public class UserExtInfoDO {
    /**
     * 主键id
     */
    private Long   id;

    /**
     * gmtCreate
     */
    private Date   gmtCreate;

    /**
     * gmtModified
     */
    private Date   gmtModified;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 类型
     */
    private String type;

    /**
     * 扩展属性key
     */
    private String extName;

    /**
     * 扩展属性value
     */
    private String extValue;

    /**
     * 介绍
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName == null ? null : userNickName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName == null ? null : extName.trim();
    }

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue == null ? null : extValue.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUserId() {
        return userId;
    }
}