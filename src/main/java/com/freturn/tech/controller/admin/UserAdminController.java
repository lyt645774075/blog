package com.freturn.tech.controller.admin;

import com.freturn.tech.biz.domain.User;
import com.freturn.tech.biz.manager.UserManager;
import com.freturn.tech.security.login.LoginUserHolder;
import com.freturn.tech.support.constant.PathConstant;
import com.freturn.tech.support.helper.ImageUploadHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 *
 * 用户信息管理后台
 *
 * @author yangtao.lyt
 * @version $Id: UserAdminController, v 0.1 2016-05-07 16:06 yangtao.lyt Exp $
 */
@Controller
@RequestMapping("/admin/user")
public class UserAdminController {

    private static final Logger logger = LoggerFactory.getLogger(UserAdminController.class);

    @Resource
    private UserManager userManager;

    @Resource
    private LoginUserHolder loginUserHolder;

    @Resource
    private ImageUploadHelper imageUploadHelper;


    @RequestMapping(method = RequestMethod.GET)
    public String getUserAdmin(){
        return PathConstant.USER_ADMIN;
    }


    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getUserCategory(ModelMap modelMap){

        User loginUser = userManager.getUserById(loginUserHolder.getId());

        modelMap.addAttribute("user", loginUser);

        return PathConstant.USER_ADMIN_CATE;
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String addUserCategory(@RequestParam String cateName){

        userManager.addCategory(loginUserHolder.getId(), cateName);

        return PathConstant.R_ADMIN_USER_CATE;
    }

    @RequestMapping(value = "/category/delete", method = RequestMethod.POST)
    public String delUserCategory(@RequestParam String cateName){

        userManager.deleteCategory(loginUserHolder.getId(), cateName);

        return PathConstant.R_ADMIN_USER_CATE;
    }


    @RequestMapping(value = "/works", method = RequestMethod.GET)
    public String getUserWork(ModelMap modelMap){

        User loginUser = userManager.getUserById(loginUserHolder.getId());

        modelMap.addAttribute("user", loginUser);

        return PathConstant.USER_ADMIN_WORK;
    }

    @RequestMapping(value = "/works/add", method = RequestMethod.POST)
    public String addUserWork(@RequestParam String workName, @RequestParam String link){

        userManager.addWork(loginUserHolder.getId(), workName, link);

        return PathConstant.R_ADMIN_USER_WORKS;
    }

    @RequestMapping(value = "/works/delete", method = RequestMethod.POST)
    public String delUserWork(@RequestParam String workName){

        userManager.deleteWork(loginUserHolder.getId(), workName);

        return PathConstant.R_ADMIN_USER_WORKS;
    }


    @RequestMapping(value = "/iconedit", method = RequestMethod.GET)
    public String getUserIconEdit(){
        return PathConstant.USER_ADMIN_ICON;
    }

    @RequestMapping(value = "/iconedit/update", method = RequestMethod.POST)
    public String postUserIconEdit(@RequestParam MultipartFile icon){

        try {
            String url = imageUploadHelper.doUpload(icon);

            userManager.updateIcon(loginUserHolder.getId(), url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PathConstant.R_ADMIN_USER_ICON;
    }


    @RequestMapping(value = "/experience", method = RequestMethod.GET)
    public String getUserExperience(){
        return PathConstant.USER_ADMIN_EXPERIENCE;
    }

    @RequestMapping(value = "/baseinfo", method = RequestMethod.GET)
    public String getUserBaseInfo(){
        return PathConstant.USER_ADMIN_BASEINFO;
    }





}
