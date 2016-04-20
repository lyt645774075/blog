package com.freturn.tech.dal.dataobject;

import java.util.Date;

public class ActivityDO {
    private Long id;

    private String name;

    private Byte enable;

    private Date begintime;

    private Date endtime;

    private Long creatorid;

    private String creatorname;

    private String taglist;

    private Long entryfee;

    private Long totalexpenditure;

    private Long totalincome;

    private Date gmtcreate;

    private Date gmtmodified;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Long getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Long creatorid) {
        this.creatorid = creatorid;
    }

    public String getCreatorname() {
        return creatorname;
    }

    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname == null ? null : creatorname.trim();
    }

    public String getTaglist() {
        return taglist;
    }

    public void setTaglist(String taglist) {
        this.taglist = taglist == null ? null : taglist.trim();
    }

    public Long getEntryfee() {
        return entryfee;
    }

    public void setEntryfee(Long entryfee) {
        this.entryfee = entryfee;
    }

    public Long getTotalexpenditure() {
        return totalexpenditure;
    }

    public void setTotalexpenditure(Long totalexpenditure) {
        this.totalexpenditure = totalexpenditure;
    }

    public Long getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(Long totalincome) {
        this.totalincome = totalincome;
    }

    public Date getGmtcreate() {
        return gmtcreate;
    }

    public void setGmtcreate(Date gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    public Date getGmtmodified() {
        return gmtmodified;
    }

    public void setGmtmodified(Date gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}