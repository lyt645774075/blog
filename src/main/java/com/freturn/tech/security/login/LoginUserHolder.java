package com.freturn.tech.security.login;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author yangtao.lyt
 * @version $Id: LoginUserHolder, v 0.1 2016-01-27 23:38 yangtao.lyt Exp $
 */
@Component
public class LoginUserHolder {

    /**
     * 获取登陆用户的昵称
     * @return
     */
    public String getNickName() {

        UserAuthDetail userAuthDetail = getLoginUser();

        return userAuthDetail == null ? null : userAuthDetail.getNickName();

    }

    /**
     * 获取登陆用户的id
     * @return
     */
    public String getId() {

        UserAuthDetail userAuthDetail = getLoginUser();

        return userAuthDetail == null ? null : userAuthDetail.getId();
    }

    /**
     * 获取登陆用户的email(用户名)
     * @return
     */
    public String getEmail() {
        UserAuthDetail userAuthDetail = getLoginUser();

        return userAuthDetail == null ? null : userAuthDetail.getEmail();
    }

    /**
     * 用户是否登陆
     * @return
     */
    public boolean isLogin() {
        return getLoginUser() == null ? false : true;
    }

    /**
     * 用户信息
     * @return
     */
    public UserAuthDetail getLoginUser(){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof UserDetails) {
            return (UserAuthDetail) obj;
        } else {
            return null;
        }
    }

    public boolean isNotLogin(){
        return !isLogin();
    }





}
