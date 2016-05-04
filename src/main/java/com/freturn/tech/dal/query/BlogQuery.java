package com.freturn.tech.dal.query;

/**
 * @author yangtao.lyt
 * @version $Id: BlogQuery, v 0.1 2016-04-20 15:01 yangtao.lyt Exp $
 */
public class BlogQuery extends AdvancedQuery{

    private String title;

    private String creatorId;

    private String type;

    private String category;

    private Integer seeScope;

    private String status;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        this.status = status;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
}
