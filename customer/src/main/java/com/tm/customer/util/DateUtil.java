package com.tm.customer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 基本时间转换
 * 创建时间：2019/6/11.
 * 作者：tm
 */

public class DateUtil {

    /**
     * 输出当前需要转换的格式的时间
     * 例 输入（"yyyy-MM-dd"）输出（"2019-06-11"）
     * <p>
     * time
     *
     * @return
     */
    public static String getTime(String SimpleDateFormat) {
        java.text.SimpleDateFormat sf = null;
        Date d = new Date(System.currentTimeMillis());
        sf = new SimpleDateFormat(SimpleDateFormat);
        return sf.format(d);

    }

    /**
     * 获取明天的年月日
     *
     * @return
     */
    public static String[] getTomorrowY() {
        long time = System.currentTimeMillis() + 24 * 60 * 60 * 1000L;
        String data = getDateYYYY_MM_dd(time);
        return data.split("-");
    }

    /**
     * 获取今天的年月日
     *
     * @return
     */
    public static String[] getTodayY() {
        long time = System.currentTimeMillis();
        String data = getDateYYYY_MM_dd(time);
        return data.split("-");
    }

    /**
     * 时间戳转换成"yyyyMMdd"
     *
     * @return
     */
    public static String getDateToYYYYMMdd(long time) {
        SimpleDateFormat sf = null;
        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyyMMdd");
        return sf.format(d);
    }

    /**
     * 时间戳转换成"yyyy-MM-dd"
     *
     * @return
     */
    public static String getDateYYYY_MM_dd(long time) {
        SimpleDateFormat sf = null;
        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(d);
    }

    /**
     * 时间戳转换成想要的格式
     *
     * @return
     */
    public static String getDateToString(long time, String SimpleDateFormat) {
        java.text.SimpleDateFormat sf = null;
        if (String.valueOf(time).length() <= 10) {
            time = time * 1000L;
        }
        Date d = new Date(time);
        sf = new SimpleDateFormat(SimpleDateFormat);
        return sf.format(d);
    }

    /**
     * 将字符串转为时间戳
     * 输入格式  yyyy年MM月dd日
     *
     * @return
     */
    public static long getStringToDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date();
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 将字符串转为时间戳
     * 输入格式和时间自定义
     *
     * @return
     */
    public static long getStringToDate(String time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 判断是否是闰年
     */
    public static boolean isLeapYear(int str) {
        return (str % 4 == 0 && str % 100 != 0) || str % 400 == 0;
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param year  当前年
     * @param month 当前月
     * @return
     */
    public static int DayNum(int year, int month) {
        int dayNum = 31;
        if (isLeapYear(year)) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                dayNum = 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                dayNum = 30;
            } else {
                dayNum = 29;
            }

        } else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                dayNum = 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                dayNum = 30;
            } else {
                dayNum = 28;
            }
        }
        return dayNum;
    }

    /**
     * 根据当前日期获得是星期几
     * 输入格式  yyyy-MM-dd
     *
     * @return
     */
    public static int getWeekNum(String time) {
        int Week = 0;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(time));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            Week = 6;
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            Week = 0;
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            Week = 1;
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            Week = 2;
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            Week = 3;
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            Week = 4;
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            Week = 5;
        }
        return Week;
    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */

    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 根据当前日期获得是星期几
     *
     * @return
     */
    public static String getWeek(String time) {
        String Week = "";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(time));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            Week += "日";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            Week += "一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            Week += "二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            Week += "三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            Week += "四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            Week += "五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            Week += "六";
        }
        return Week;
    }

    /**
     * 根据当前日期获得是星期几
     *
     * @return
     */
    public static int getNextWeek(int week) {
        int Week = Calendar.SUNDAY;
        switch (week) {
            case Calendar.SUNDAY:
                Week = Calendar.MONDAY;
                break;
            case Calendar.MONDAY:
                Week = Calendar.TUESDAY;
                break;
            case Calendar.TUESDAY:
                Week = Calendar.WEDNESDAY;
                break;
            case Calendar.WEDNESDAY:
                Week = Calendar.THURSDAY;
                break;
            case Calendar.THURSDAY:
                Week = Calendar.FRIDAY;
                break;
            case Calendar.FRIDAY:
                Week = Calendar.SATURDAY;
                break;
            case Calendar.SATURDAY:
                Week = Calendar.SUNDAY;
                break;
        }
        return Week;
    }

    /**
     * 根据当前日期获得是星期几
     *
     * @return
     */
    public static int getNextDay(int week) {
        int Week = Calendar.SUNDAY;
        switch (week) {
            case Calendar.SUNDAY:
                Week = Calendar.MONDAY;
                break;
            case Calendar.MONDAY:
                Week = Calendar.TUESDAY;
                break;
            case Calendar.TUESDAY:
                Week = Calendar.WEDNESDAY;
                break;
            case Calendar.WEDNESDAY:
                Week = Calendar.THURSDAY;
                break;
            case Calendar.THURSDAY:
                Week = Calendar.FRIDAY;
                break;
            case Calendar.FRIDAY:
                Week = Calendar.SATURDAY;
                break;
            case Calendar.SATURDAY:
                Week = Calendar.SUNDAY;
                break;
        }
        return Week;
    }

    /**
     * 秒转换成分
     *
     * @return
     */
    public static String minute(int second) {
        String time = "00:00";
        time = (second / 60 < 10 ? "0" + String.valueOf(second / 60) : String.valueOf(second / 60))
                + ":" +
                (second % 60 < 10 ? "0" + String.valueOf(second % 60) : String.valueOf(second % 60));
        return time;
    }

    /**
     * 根据日历获取天
     *
     * @return
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 返回日期的月份，1-12,即yyyy-MM-dd中的MM
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回日期的年,即yyyy-MM-dd中的yyyy
     *
     * @param date Date
     * @return int
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回日期的天
     *
     * @param year month
     * @return
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    /**
     * 日期间隔整月数
     *
     * @param start
     * @param end
     * @return
     */
    public static int calDiffMonth(Date start, Date end) {
        int result = 0;
        try {
//            SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
//            Date start = sfd.parse(startDate);
//            Date end = sfd.parse(endDate);
            int startYear = getYear(start);
            int startMonth = getMonth(start);
            int startDay = getDay(start);
            int endYear = getYear(end);
            int endMonth = getMonth(end);
            int endDay = getDay(end);
            if (startDay > endDay) { //1月17  大于 2月28
                if (endDay == getDaysOfMonth(getYear(new Date()), 2)) {   //也满足一月
                    result = (endYear - startYear) * 12 + endMonth - startMonth;
                } else {
                    result = (endYear - startYear) * 12 + endMonth - startMonth - 1;
                }
            } else {
                result = (endYear - startYear) * 12 + endMonth - startMonth;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取两个日期之间的间隔天数
     *
     * @return
     */
    public static int getGapCount(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * 获取今天的日期
     *
     * @return yyyy-MM-dd
     */
    public static String getTodayDate() {
        return getDateToString(System.currentTimeMillis(), "yyyy-MM-dd");
    }

    /**
     * 获取昨天的日期
     *
     * @return yyyy-MM-dd
     */
    public static String getYesterdayDate() {
        return getDateToString(System.currentTimeMillis() - 24 * 60 * 60 * 1000L, "yyyy-MM-dd");
    }

    /**
     * 获取前天的日期
     *
     * @return yyyy-MM-dd
     */
    public static String getYesterdayBeforeDate() {
        return getDateToString(System.currentTimeMillis() - 24 * 60 * 60 * 1000L * 2, "yyyy-MM-dd");
    }

    /**
     * 获取明天的日期
     *
     * @return yyyy-MM-dd
     */
    public static int getTodayAfter() {
        return (int) (System.currentTimeMillis() + 24 * 60 * 60 * 1000L);
    }

    /**
     * 获取当前时间戳 s
     *
     * @return
     */
    public static int getNow() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 获取当前时间的时间戳
     *
     * @return 当前时间的时间戳（四舍五入精确到秒）
     */
    public static int getNowTimestamp() {
        return (int) (System.currentTimeMillis() / 1000.0 + 0.5);
    }

}
