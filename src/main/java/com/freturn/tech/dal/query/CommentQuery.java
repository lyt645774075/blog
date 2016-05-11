package com.freturn.tech.dal.query;

/**
 * @author yangtao.lyt
 * @version $Id: CommentQuery, v 0.1 2016-05-04 19:12 yangtao.lyt Exp $
 */
public class CommentQuery extends AdvancedQuery{

    private String domainId;

    private Integer domainType;

    private Integer type;

    private Long parentId;

    private String creatorId;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}
