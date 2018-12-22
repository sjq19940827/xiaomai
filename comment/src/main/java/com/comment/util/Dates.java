package com.comment.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component("dt")
public class Dates {
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 获取当前日期时间
     * @return 当前日期时间
     */
    public static String dates(){
        return df.format(new Date());
    }

    /**
     * 计算时间戳差，精确到分钟
     * @param date1 第一次获取时间
     * @param date2 第二次获取时间
     * @return 分钟差(如果返回结果等于0则代表两次获取时间一致)
     */
    public static int dateMin(String date1, String date2){
        int minutes = 0;
        minutes = (int) repetition(date1,date2)/(1000 * 60);
        return minutes;
    }

    /**
     * 计算时间戳差，精确到小时
     * @param date1 第一次获取时间
     * @param date2 第二次获取时间
     * @return 小时差(如果返回结果等于0则代表两次获取时间一致)
     */
    public static int dateHour(String date1, String date2){
        int hours = 0;
        hours = (int)repetition(date1,date2)/3600/1000;
        return hours;
    }
    /**
     * 计算时间戳差，精确到秒
     * @param date1 第一次获取时间
     * @param date2 第二次获取时间
     * @return 秒差(如果返回结果等于0则代表两次获取时间一致)
     */
    public static double dateSecond(String date1, String date2){
        int second = 0;
        second = (int)repetition(date1,date2)/1000;
        return second;
    }
    /**
     * 冗余提取
     * @param date1 第一次获取时间
     * @param date2 第二次获取时间
     * @return 时间差
     */
    private static long repetition(String date1, String date2){
        long from = 0;
        long to = 0;
        long difference = 0;
        if(date1 != date2) {
            try {
                //gittime精确到毫秒
                from = df.parse(date1).getTime();
                to = df.parse(date2).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            difference = to - from;
        }
        return difference;
    }
}
