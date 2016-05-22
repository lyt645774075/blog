package com.freturn.tech.dal.dataobject;

import java.util.Date;

/**
 * 标签对象
 */
public class LabelDO {
    /**
     * 主键id
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
     * 使用范围
     */
    private String  scope;

    /**
     * 标签名称
     */
    private String  name;

    /**
     * 使用次数
     */
    private Integer count;

    /**
     * 创建人id
     */
    private String  creatorId;

    /**
     * 创建人昵称
     */
    private String  creatorNickName;

    /**
     * 标签描述
     */
    private String  description;

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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}