package com.lyl.springintegrationjdbc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日趋工具类
 *
 * @author Administrator
 */
public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);


    public static String formate(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**s
     * 日期转为字符串
     *
     * @param date    日期
     * @param pattern 规则
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "null";
        }
        if (pattern == null || pattern.equals("") || pattern.equals("null")) {
            pattern = "yyyy-MM-dd  HH:mm:ss";
        }
        return new SimpleDateFormat(pattern).format(date);
    }


}
