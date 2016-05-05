package com.freturn.tech.dal;

import com.freturn.tech.dal.dao.UserBaseInfoDOMapper;
import com.freturn.tech.dal.dataobject.UserBaseInfoDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author yangtao.lyt
 * @version $Id: UserDOMapperTest, v 0.1 2016-05-05 16:06 yangtao.lyt Exp $
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/persistence.xml"})
public class UserDOMapperTest {

    @Resource
    private UserBaseInfoDOMapper userBaseInfoDOMapper;


    @Test
    public void testQuery(){
        UserBaseInfoDO userBaseInfoDO = userBaseInfoDOMapper.selectByPrimaryKey("11");

        Assert.isTrue(true);

    }


}
