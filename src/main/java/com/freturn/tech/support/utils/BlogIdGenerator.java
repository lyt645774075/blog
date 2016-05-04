package com.freturn.tech.support.utils;

import java.util.UUID;

/**
 *
 * 博客id生成器
 *
 * @author yangtao.lyt
 * @version $Id: BlogIdGenerator, v 0.1 2016-05-04 19:37 yangtao.lyt Exp $
 */
public class BlogIdGenerator {

    public static String getBlogId(){

        return UUID.randomUUID().toString().replaceAll("-", "").substring(0,20);

    }

    public static void main(String[] args) {
        String ttt = BlogIdGenerator.getBlogId();
        System.out.println(ttt + "\t" + ttt.length());
    }

}
