package com.freturn.tech.dal.query;

/**
 * @author yangtao.lyt
 * @version $Id: CommentQuery, v 0.1 2016-05-04 19:12 yangtao.lyt Exp $
 */
public class CommentQuery {

    private Long domainId;

    private Integer domainType;

    private Integer type;

    private Integer parentId;

    private Long creatorId;


    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}
