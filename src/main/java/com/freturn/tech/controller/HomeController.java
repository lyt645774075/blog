package com.freturn.tech.controller;

import com.freturn.tech.support.constant.PathConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 *
 * 主页controller
 *
 * @author yangtao.lyt
 * @version $Id: demo, v 0.1 2016-04-12 01:21 yangtao.lyt Exp $
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String testDemoPage(ModelMap modelMap){

        logger.error("test error");
        logger.warn("test warn");


        modelMap.addAttribute("date", new Date());

        return "screen/demo";

    }


    /**
     * 获取个人主页
     * @param userId
     * @param modelMap
     * @return
     */
    @RequestMapping("/{userId}")
    public String getUserHome(@PathVariable String userId, ModelMap modelMap){

        modelMap.addAttribute("userId", userId);

        return PathConstant.USER_HOME;

    }




}
