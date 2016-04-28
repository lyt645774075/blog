package com.freturn.tech.controller;

import com.freturn.tech.support.constant.PathConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 *
 * 站点controller
 *
 * @author yangtao.lyt
 * @version $Id: demo, v 0.1 2016-04-12 01:21 yangtao.lyt Exp $
 */
@Controller
public class WebController {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/")
    public String getWebHome(ModelMap modelMap){

        modelMap.addAttribute("date", new Date());

        return PathConstant.WEB_HOME;
    }


    @RequestMapping("/login")
    public String getLogin(ModelMap modelMap){

        modelMap.addAttribute("date", new Date());

        return PathConstant.USER_LOGIN;
    }






}
