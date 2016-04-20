package com.freturn.tech.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 这只是一种组装aop能力的方式
 *
 *
 * @author yangtao.lyt
 * @version $Id: ExceptionAop, v 0.1 2016-04-12 01:34 yangtao.lyt Exp $
 */
@Aspect
public class ExceptionAop {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAop.class);

    @AfterThrowing(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)", throwing = "ex")
    public void logException(Exception ex){
        logger.error("拦截到异常:", ex);
    }


}
