package com.freturn.tech.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangtao.lyt
 * @version $Id: BlogController, v 0.1 2016-04-27 19:51 yangtao.lyt Exp $
 */
@Controller
public class BlogController {

    @RequestMapping("/blog/edit")
    public String getUserHome(ModelMap modelMap){

        return "screen/admin/blogedit";

    }



}
