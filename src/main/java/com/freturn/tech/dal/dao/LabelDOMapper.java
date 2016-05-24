package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.LabelDO;
import com.freturn.tech.dal.query.LabelQuery;

import java.util.List;

public interface LabelDOMapper {

    /**
     * 删除指定主键的标签
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入一条新的标签
     * @param labelDO
     * @return
     */
    int insert(LabelDO labelDO);

    /**
     * 查询指定主键id的标签
     * @param id
     * @return
     */
    LabelDO selectByPrimaryKey(Long id);

    /**
     * 查询满足条件的标签
     * @param labelQuery
     * @return
     */
    List<LabelDO> query(LabelQuery labelQuery);

    /**
     * 更新指定主键的标签
     * @param labelDO
     * @return
     */
    int updateByPrimaryKey(LabelDO labelDO);
}