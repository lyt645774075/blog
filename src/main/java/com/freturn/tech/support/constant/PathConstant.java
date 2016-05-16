package com.freturn.tech.support.constant;

/**
 * @author yangtao.lyt
 * @version $Id: PathConstant, v 0.1 2016-04-20 14:03 yangtao.lyt Exp $
 */
public interface PathConstant {


    /**=========== 全站通用页面路径 ============ **/

    String WEB_HOME = "screen/webhome";

    String USER_LOGIN = "screen/login";

    String USER_REGISTER = "screen/register";

    String QUERY_RESULT = "screen/queryResult";


    /**=========== 用户相关[前台]页面路径 ============ **/

    String USER_HOME = "screen/user/userhome";

    String USER_ABOUTME = "screen/user/aboutme";

    String USER_CONTACT = "screen/user/contact";

    String BLOG_HOME = "screen/user/blog";


    /**=========== 用户相关[管理后台]页面路径 ========== **/

    String BLOG_EDIT = "screen/admin/blogedit";

    String USER_ADMIN = "screen/admin/useradmin";

    String USER_ADMIN_CATE = "screen/admin/category";

    String USER_ADMIN_PROD = "screen/admin/works";

    String USER_ADMIN_ICON = "screen/admin/iconedit";

    String USER_ADMIN_EXPERIENCE = "screen/admin/experience";

    String USER_ADMIN_BASEINFO = "screen/admin/baseinfo";



    /**========== 重定向页面 ================= **/

    String R = "redirect:";

    String R_ADMIN_USER_CATE = R + "/admin/user/category";

    String R_ADMIN_USER_WORKS = R + "/admin/user/works";



}
