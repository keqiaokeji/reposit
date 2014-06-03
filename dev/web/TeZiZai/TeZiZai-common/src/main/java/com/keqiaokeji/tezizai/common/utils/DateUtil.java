package com.keqiaokeji.tezizai.common.utils;

import com.keqiaokeji.tezizai.common.character.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期操作
 *
 * @author HAIKANG SONG
 * @time 2013-4-18上午10:52:52
 */

public class DateUtil {

    /**
     * yyyy-MM-dd
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm(24小时)
     */
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * yyyy-MM-dd hh:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";

    /**
     * MM-dd hh:mm
     */
    public static final String MM_DD_HH_MM = "MM-dd hh:mm";

    /**
     * 获得当前日期，格式yyyy-MM-dd
     *
     * @return
     * @author HAIKANG SONG
     * @time 2013-4-18上午10:53:07
     */
    public static String getCurrentDate() {
        return getCurrentDate(YYYY_MM_DD);
    }

    /**
     * 获得当前时间，格式yyyy-MM-dd hh:mm:ss
     *
     * @return
     * @author HAIKANG SONG
     * @time 2013-4-18上午10:53:07
     */
    public static String getCurrentTime() {
        return getCurrentDate(YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获得当前时间，格式自定义
     *
     * @param format 如：yyyy-MM-dd
     * @return
     * @author HAIKANG SONG
     * @time 2013-4-18上午10:54:52
     */
    public static String getCurrentDate(String format) {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, 0);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(day.getTime());
    }

    /**
     * 获取距当前时间指定间隔的时间
     *
     * @param space  如-1表示昨天，-10表示10天前，1表示明天，5表示5天后
     * @param format 日期格式
     * @return
     */
    public static String getDateSpace(int space, String format) {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, space);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     * 获取距当前时间指定间隔的时间
     *
     * @param space 如-1表示昨天，-10表示10天前，1表示明天，5表示5天后
     * @return
     */
    public static Date getDateSpace(int space) {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, space);
        return day.getTime();
    }

    /**
     * 判断指定时间是否符合指定的时间格式
     *
     * @param date       时间字符串
     * @param dateFormat 时间格式
     * @return
     * @author HAIKANG SONG
     * @time 2013-4-18上午11:26:20
     */
    public static boolean isDateFormat(String date, String dateFormat) {
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            format.setLenient(false);
            try {
                format.format(format.parse(date));
            } catch (ParseException e) {
                return false;
            }
            return true;
        }
        return false;
    }


    public static Date formatDate(String dateContent, String format) {
        Date result = null;
        if (StringUtils.isNotBlank(dateContent) && StringUtils.isNotBlank(format)) {
            DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
            dateFormat.setLenient(false);
            try {
                Date date = dateFormat.parse(dateContent);
                result = new Date(date.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String formatDate(Long date, String format) {
        String result = null;
        if (date != null && StringUtils.isNotBlank(format)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            result = sdf.format(new Date(date));
        }
        return result;
    }

    public static String formatDate(Date date, String format) {
        String result = null;
        if (date != null && StringUtils.isNotBlank(format)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            result = sdf.format(date);
        }
        return result;
    }

    /**
     * 将时间转化成几秒前，几分钟前，几小时前，几天前 ，距离当前时间大于10天的显示为“月日时间”格式
     *
     * @param date
     * @return
     * @author keqiaokeji
     */
    public static String formatDateSpace(Date date) {
        if (date == null) {
            return "未知时间";
        }
        long before = date.getTime();
        long current = System.currentTimeMillis();
        long dur = (current - before) / 1000;
        if (dur <= 0) {
            return "刚刚";
        } else if (dur < 60) {
            return dur + "秒前";
        } else if (dur <= 60 * 60) {
            return dur / 60 + "分钟前";
        } else if (dur <= 3600 * 24) {
            return dur / (60 * 60) + "小时前";
        } else if (dur / (60 * 60 * 24) < 10) {
            return dur / (60 * 60 * 24) + "天前";
        } else {// 大于10天的显示为“月日时间”
            return formatDate(date, YYYY_MM_DD);
        }
    }


}
