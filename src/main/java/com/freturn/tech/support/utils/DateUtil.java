package com.freturn.tech.support.utils;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: DateUtil, v 0.1 2016-01-26 19:15 yangtao.lyt Exp $
 */

@Component
public class DateUtil {

    private static final String SHORT_DATE = "yyyy-MM-dd";

    private static final String LONG_DATE = "yyyy-MM-dd HH:mm:ss";

    private static final String MIDDLE_DATE = "yyyy-MM-dd HH:mm:ss";

    public static Date parseStr(String dateStr, String format){

        Preconditions.checkArgument(!StringUtils.isEmpty(dateStr), "dateStr不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(format), "format不能为空");

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("解析时间错误", e);
        }
    }

    public static String format(Date date, String format){

        Preconditions.checkArgument(!StringUtils.isEmpty(date), "date不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(format), "format不能为空");

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return sdf.format(date);

    }

    public static String shortFormat(Date date){

        if(date == null){
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE);

        return sdf.format(date);

    }

    public static String longFormat(Date date){

        if(date == null){
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE);

        return sdf.format(date);

    }

    public static String middleFormat(Date date){

        if(date == null){
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(MIDDLE_DATE);

        return sdf.format(date);

    }




}
