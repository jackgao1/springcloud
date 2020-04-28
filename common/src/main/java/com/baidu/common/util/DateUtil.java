package com.baidu.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
    //获取当前年份
    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    //获取当前月份
    public static String getMonth() {
        return getTime("yyyyMM").substring(4, 6);
    }

    //获取当前月日
    public static String getMonthDay() {
        return getTime("yyyyMMdd").substring(4, 8);
    }

    //获取当前小时
    public static String getHour() {
        return getTime("HH");
    }

    //根据输入的日期时间格式获取日期时间数值，如果格式为空，默认为yyyyMMdd格式
    public static String getTime(String str) {
        if (!StringUtil.isNullOrEmpty(str)) {
            return new SimpleDateFormat(str).format(new Date());
        } else {
            return new SimpleDateFormat("yyyyMMdd").format(new Date());
        }
    }

    //获取固定时间格式的字符串
    public static String getTimeNum(String format) {
        return getTime(format);
    }
}
