package com.example.a18751.my_calculator.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @version: 1.8.0_74-b02
 * @program: My_Calculator
 * @Package: com.example.a18751.my_calculator.util
 * @className: DateUtil
 * @description: 时间工具类
 * @author: Ashmam
 * @create: 2020-02-05 15:51
 **/
public final class DateUtil {

    /**
     * 日期工具
     */
    private final static String A = "yyyy-MM-dd";//日期格式
    private final static String B = "yyyy-MM-dd HH:mm:ss";//日期格式
    private final static String C = "yyyy/MM/dd HH:mm:ss";//日期格式
    private final static String exp = "((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(10|12|0?[13578])([-\\/\\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$))";

    /**
     * 时间类型转字符串 固定返回 日期为 yyyy-MM-dd
     *
     * @param date
     * @return String
     */
    public static String getDateToString(Date date) throws Exception {
        String s;
        SimpleDateFormat sft = new SimpleDateFormat(A);//格式时间对象
        s = sft.format(date);
        return s;
    }

    /**
     * 时间类型转字符串 不固定日期格式
     *
     * @param date
     * @param format
     * @return String
     */
    public static String getDteToString(Date date, String format) throws Exception {
        String s;
        SimpleDateFormat sft = new SimpleDateFormat(format);//格式时间对象
        s = sft.format(date);
        return s;
    }

    /**
     * 字符串时间转时间类型 固定日期格式 yyyy-MM-dd
     *
     * @param text 字符串时间
     * @return Date
     * @throws Date
     */
    public static Date getStringToDate(String text) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(A);//格式时间对象
        Date date = sdf.parse(text);
        return date;
    }

    /**
     * 字符串时间转时间类型 不固定时间格式
     *
     * @param text   时间字符串
     * @param format 日期格式
     * @return Date
     * @throws
     */
    public static Date gettringToDate(String text, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);//格式时间对象
        Date date = sdf.parse(text);
        return date;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param a 第一个日期时间
     * @param b 第二个日期时间
     * @return long
     * @throws Date
     */
    public static long getDaysBetweenTwoDates(Date a, Date b) throws Exception {
        //判断这两个时间的大小
        if (a.equals(b)) return 0;
        if (!a.before(b)) {//保证返回的值为正数
            Date temp;
            temp = a;
            a = b;
            b = temp;
        }
        Calendar c = Calendar.getInstance();//获取calendar对像
        c.setTime(a);//设置时间 date  转 calendar 类型
        long t1 = c.getTimeInMillis();//获取时间戳
        c.setTime(b);
        long t2 = c.getTimeInMillis();
        //计算天数
        long days = (t2 - t1) / (24 * 60 * 60 * 1000);
        return days;
    }

    /**
     * 计算当前时间多少天以后的日期
     *
     * @param currentDate 当前时间
     * @param distance    距离多少天
     * @return Date
     */
    public static Date getNextDasByNumber(Date currentDate, int distance) throws Exception {
        Calendar calendar = Calendar.getInstance();//获取日历对象
        calendar.setTime(currentDate);//设置当前时间 date  转 calendar 类型
        calendar.add(Calendar.DATE, distance);//计算离当前时间以后的日期
        Date date = calendar.getTime();//calendar 转 date  类型
        return date;
    }

    /**
     * 判断是否是日期格式
     *
     * @param date 字符串
     * @return boolean
     */
    public static boolean isDate(String date) {
        // 创建 Pattern 对象 java正则表达式对象
        Pattern r = Pattern.compile(exp);
        boolean flag = r.matcher(date).matches();//判断它格式是否正确
        return flag;
    }
}
