package com.freturn.tech.support.utils;

import java.util.Date;

/**
 *
 * 生成20位内的用户id
 *
 * @author yangtao.lyt
 * @version $Id: UserIdGenerator, v 0.1 2016-05-04 19:31 yangtao.lyt Exp $
 */
public class UserIdGenerator {


    public static String getUserId(){

        return String.valueOf(new Date().getTime());

    }



}
