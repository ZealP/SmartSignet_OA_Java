package com.smartsignet.smartsignet_oa_library_java.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public class CommonUtil {

    /**
     * 格式化日期字符串 也可以用 ：commons-lang.rar 下的：DateFormatUtils类 更为简单
     *
     * @param date
     * @param pattern
     * @return String
     */
    public static String formatDate(Date date, String pattern) {
        return StringUtils.formatDate(date, pattern);
    }

    /**
     * 解析long型时间数据格式化为yyyy-MM-dd
     *
     * @param time
     * @return
     */
    public static String formatTimeStamp(Long time) {
        if (time != null)
            return formatDate(new Date(time), "yyyyMMddHHmmss");
        return "";
    }
}
