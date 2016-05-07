package com.freturn.tech.controller;

import com.freturn.tech.biz.manager.UserManager;
import com.freturn.tech.support.constant.PathConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
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

    @Resource
    private UserManager userManager;

    @RequestMapping("/")
    public String getWebHome(ModelMap modelMap){

        modelMap.addAttribute("date", new Date());

        return PathConstant.WEB_HOME;
    }


    @RequestMapping("/login")
    public String getLogin(){

        return PathConstant.USER_LOGIN;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(){
        return PathConstant.USER_REGISTER;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(@RequestParam String email, @RequestParam String passWord, @RequestParam String nickName, ModelMap modelMap){

        //先检查是否已经存在该用户
        if(userManager.isUserExist(email)){
            modelMap.addAttribute("msg", "该邮箱地址已被注册...");
            return PathConstant.USER_REGISTER;
        }

        //注册到数据库
        userManager.register(email, passWord, nickName);

        //跳转到登陆页
        modelMap.addAttribute("username", email);
        modelMap.addAttribute("password", passWord);
        //设置自动登陆标志
        modelMap.addAttribute("autoLogin", "true");

        return PathConstant.USER_LOGIN;
    }


}
