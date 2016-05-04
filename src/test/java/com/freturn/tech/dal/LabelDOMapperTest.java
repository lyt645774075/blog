package com.freturn.tech.dal;

import java.util.List;

import javax.annotation.Resource;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.freturn.tech.dal.dao.LabelDOMapper;
import com.freturn.tech.dal.dataobject.LabelDO;
import com.freturn.tech.dal.query.LabelQuery;

/**
 * @author yangtao.lyt
 * @version $Id: LabelDOMapperTest, v 0.1 2016-05-04 13:20 yangtao.lyt Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/persistence.xml"})
public class LabelDOMapperTest {

    @Resource
    private LabelDOMapper labelDOMapper;

    @Test
    public void testInsert(){

        LabelDO labelDO = new LabelDO();
        labelDO.setScope("blog");
        labelDO.setCreatorId("11");
        labelDO.setCreatorNickName("liyangtao");
        labelDO.setDescription("description");
        labelDO.setName("JAVA核心技术");

        Integer id = labelDOMapper.insert(labelDO);

        System.out.println(id);

    }


    @Test
    public void testQuery(){


        LabelDO labelDO = labelDOMapper.selectByPrimaryKey(9L);
        Assert.isTrue(labelDO.getId() == 9L);

        LabelQuery query = new LabelQuery();
        query.setCreatorIdList(Lists.newArrayList("10"));

        List<LabelDO> labelDOList = labelDOMapper.query(query);

        Assert.isTrue(labelDOList.size() == 2);

    }

    @Test
    public void testUpdate(){

        LabelDO labelDO = labelDOMapper.selectByPrimaryKey(10L);
        labelDO.setCreatorNickName("李洋涛");

        int i = labelDOMapper.updateByPrimaryKey(labelDO);

        Assert.isTrue(true);
    }


}
