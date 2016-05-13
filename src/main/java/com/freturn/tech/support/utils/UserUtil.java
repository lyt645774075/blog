package com.freturn.tech.support.utils;

/**
 * @author yangtao.lyt
 * @version $Id: UserUtil, v 0.1 2016-05-13 17:36 yangtao.lyt Exp $
 */
public class UserUtil {

    private static final String ICON_URL_PREFIX = "/img/user/";

    private static final String ICON_URL_SUFFIX = ".jpg";


    /**
     * 获取一个随机的用户头像地址
     * @return
     */
    public static String getRandomIconUrl(){
        return ICON_URL_PREFIX + getRandomNum(0, 10) + ICON_URL_SUFFIX;
    }


    /**
     * 获取[start,end)内的随机整数
     * @param start
     * @param end
     * @return
     */
    private static long getRandomNum(long start, long end){

        double random = Math.floor(Math.random() * (end - start) + start);

        return Double.valueOf(random).longValue();

    }



}
