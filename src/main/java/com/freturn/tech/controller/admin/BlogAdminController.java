package com.freturn.tech.controller.admin;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.biz.manager.BlogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author yangtao.lyt
 * @version $Id: BlogController, v 0.1 2016-04-27 19:51 yangtao.lyt Exp $
 */
@Controller
public class BlogAdminController {

    @Resource
    private BlogManager blogManager;

    @RequestMapping(value = "/blog/edit", method = RequestMethod.GET)
    public String getUserHome(ModelMap modelMap){
        return "screen/admin/blogedit";
    }

    @RequestMapping(value = "/blog/edit" , params = "type=standard", method = RequestMethod.POST)
    public String createStandardBlog(@RequestParam String title, @RequestParam String content){

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);


        return "screen/admin/blogedit";
    }



}
