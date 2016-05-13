package com.freturn.tech.controller;

import com.freturn.tech.biz.manager.UserManager;
import com.freturn.tech.support.constant.PathConstant;
import com.google.common.collect.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;

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

    @RequestMapping(value = "/qrtest")
    public void getQr(HttpServletResponse response) throws WriterException, IOException {
        String text = "http://www.baidu.com";
        int width = 100;
        int height = 100;
        String format = "png";
        HashMap hints= Maps.newHashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

        response.setContentType("image/png");

        OutputStream os = response.getOutputStream();  //创建输出流

        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
        MatrixToImageWriter.writeToStream(bitMatrix, format, os);

        os.flush();
        os.close();

    }


    /**
     * 全站搜索
     *
     */
    @RequestMapping(value = "/webSiteQuery", method = RequestMethod.POST)
    public String webSiteQuery(@RequestParam String keyword){

        return PathConstant.QUERY_RESULT;

    }


}
