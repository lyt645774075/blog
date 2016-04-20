package com.freturn.tech.support;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author yangtao.lyt
 * @version $Id: AopSupport, v 0.1 2016-04-17 15:25 yangtao.lyt Exp $
 */
public class AopSupport {

    /**
     * 打印[被外部调用服务]时的参数信息
     *
     * @param joinPoint
     */
    public void logServiceParams(JoinPoint joinPoint) {

        //获取logger
        Object clazz = joinPoint.getTarget();
        Logger logger = LoggerFactory.getLogger(clazz.getClass());

        logger.warn("aop log params:"
                + JSONObject.toJSONString(joinPoint.getArgs(),
                SerializerFeature.WriteMapNullValue));

    }
}
