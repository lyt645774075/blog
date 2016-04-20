package com.freturn.tech.dal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.freturn.tech.dal.dao.ActivityDOMapper;
import com.freturn.tech.dal.dataobject.ActivityDO;

/**
 * @author yangtao.lyt
 * @version $Id: DAOTest, v 0.1 2016-04-14 03:00 yangtao.lyt Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/persistence.xml"})
public class DAOTest {

    private static final Logger logger = LoggerFactory.getLogger(DAOTest.class);

    @Autowired
    private ActivityDOMapper activityDOMapper;

    @Test
    public void testInsert(){


        ActivityDO activityDO = activityDOMapper.selectByPrimaryKey(19L);

        logger.error(ToStringBuilder.reflectionToString(activityDO));

        System.out.println(ToStringBuilder.reflectionToString(activityDO));
    }

}
