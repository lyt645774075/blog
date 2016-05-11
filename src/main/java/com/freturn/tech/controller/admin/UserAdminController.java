package com.freturn.tech.controller.admin;

import com.freturn.tech.support.constant.PathConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * 用户信息管理后台
 *
 * @author yangtao.lyt
 * @version $Id: UserAdminController, v 0.1 2016-05-07 16:06 yangtao.lyt Exp $
 */
@Controller
public class UserAdminController {


    @RequestMapping(value = "/admin/useradmin", method = RequestMethod.GET)
    public String getUserAdmin(){
        return PathConstant.USER_ADMIN;
    }




}
