package com.freturn.tech.biz.domain;

import com.freturn.tech.dal.dataobject.UserExtInfoDO;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao.lyt
 * @version $Id: User, v 0.1 2016-05-05 09:38 yangtao.lyt Exp $
 */
public class User {

    private String id;

    private Date gmtCreate;

    private Date gmtModified;

    private String email;

    private String passWord;

    private Integer type;

    private String nickName;

    private String iconUrl;

    private String selfIntroduction;

    /** 扩展信息 */
    private List<UserExtInfoDO> extInfoDOList;

    private Map<String, Integer> categoryMap;

    private Map<String, String> linkProMap;

    private Map<String, String> contactMap;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
        this.nickName = nickName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public List<UserExtInfoDO> getExtInfoDOList() {
        return extInfoDOList;
    }

    public void setExtInfoDOList(List<UserExtInfoDO> extInfoDOList) {
        this.extInfoDOList = extInfoDOList;
    }

    public Map<String, Integer> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<String, Integer> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public Map<String, String> getLinkProMap() {
        return linkProMap;
    }

    public void setLinkProMap(Map<String, String> linkProMap) {
        this.linkProMap = linkProMap;
    }

    public Map<String, String> getContactMap() {
        return contactMap;
    }

    public void setContactMap(Map<String, String> contactMap) {
        this.contactMap = contactMap;
    }
}
