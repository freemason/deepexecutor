package org.freemason.deepexecutor.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期时间工具类
 */
public class DateTimeUtils {
    private DateTimeUtils(){}

    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /**
     * @param dataTimeStr   时间字符串
     * @param pattern       时间日期格式 ex: yyyy-MM-dd HH:mm:ss
     * @return
     * @throws ParseException   日期格式不匹配
     */
    public static long getTimeStamp(String dataTimeStr, String pattern) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dataTimeStr).getTime();
    }

    /**
     * 获取指定时间时间戳
     * @param dataTimeStr   时间字符串
     * @return              时间戳
     * @throws ParseException 日期格式不匹配
     */
    public static long getTimeStamp(String dataTimeStr) throws ParseException{
        return  getTimeStamp(dataTimeStr, DEFAULT_DATE_TIME_FORMAT);
    }

}
