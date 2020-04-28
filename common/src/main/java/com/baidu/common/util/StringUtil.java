package com.baidu.common.util;
//校验类
public class StringUtil {

    //返回字符串对象是否为空或空字符串 如果为空则返回true
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null || "null".equals(obj)) {
            return true;
        }
        return "".equals(obj);
    }
}
