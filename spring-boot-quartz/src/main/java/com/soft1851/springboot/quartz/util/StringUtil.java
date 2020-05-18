package com.soft1851.springboot.quartz.util;

import java.util.List;

/**
 * @author ke
 * @ClassName StringUtil
 * @Description TOOD
 * @Date 2020/5/19
 * @Version 1.0
 **/
public enum StringUtil {
    ;

    /**
     * 获取List参数值
     * @param list
     * @return
     */
    public static String getListString(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s).append(" ");
        }
        return result.toString();
    }
}
