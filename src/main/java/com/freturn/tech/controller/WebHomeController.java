package com.freturn.tech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: demo, v 0.1 2016-04-12 01:21 yangtao.lyt Exp $
 */
@Controller
public class WebHomeController {

    private static final Logger logger = LoggerFactory.getLogger(WebHomeController.class);

    @RequestMapping("/")
    public String testDemoPage(ModelMap modelMap){

        logger.error("test error");
        logger.warn("test warn");


        modelMap.addAttribute("date", new Date());

        return "screen/demo";

    }




}
