package com.freturn.tech.dal.dataobject;

import java.util.Date;

/**
 * 用户基本信息
 */
public class UserBaseInfoDO {

    /**
     * 主键id
     */
    private String  id;

    /**
     * gmtCreate
     */
    private Date    gmtCreate;

    /**
     * gmtModified
     */
    private Date    gmtModified;

    /**
     * 邮箱(账号)
     */
    private String  email;

    /**
     * 密码
     */
    private String  passWord;

    /**
     * 用户类型:个人/团体
     */
    private Integer type;

    /**
     * 用户昵称
     */
    private String  nickName;

    /**
     * 头像地址
     */
    private String  iconUrl;

    /**
     * 自我介绍
     */
    private String  selfIntroduction;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction == null ? null : selfIntroduction.trim();
    }
}