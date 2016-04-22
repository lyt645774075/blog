package com.freturn.tech.controller;

import com.freturn.tech.support.constant.PathConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangtao.lyt
 * @version $Id: BlogController, v 0.1 2016-04-20 20:49 yangtao.lyt Exp $
 */
@Controller
public class BlogController {

    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);


    @RequestMapping("/blog/{blogId}")
    public String getUserHome(@PathVariable String blogId, ModelMap modelMap){

        modelMap.addAttribute("blogId", blogId);

        return PathConstant.BLOG_HOME;

    }



}
