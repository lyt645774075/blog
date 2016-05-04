package com.freturn.tech.dal.query;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: LabelQuery, v 0.1 2016-05-04 13:11 yangtao.lyt Exp $
 */
public class LabelQuery {


    private String scope;

    private String name;

    private Integer count;

    private List<String> creatorIdList;


    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getCreatorIdList() {
        return creatorIdList;
    }

    public void setCreatorIdList(List<String> creatorIdList) {
        this.creatorIdList = creatorIdList;
    }
}
