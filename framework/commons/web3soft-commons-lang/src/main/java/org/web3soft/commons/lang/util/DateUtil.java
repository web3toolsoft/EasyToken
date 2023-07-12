package org.web3soft.commons.lang.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @author web3soft-team
 **/
public class DateUtil {
    public final static long SECOND = 1000L;
    public final static long MINUTE = 60 * SECOND;
    public final static long HOUR = 60 * MINUTE;
    public final static long DAY = 24 * HOUR;
    public final static long THREE_MINUTE = 3 * MINUTE;
    public final static long FIVE_MINUTE = 5 * MINUTE;
    public final static int WEEK_DAY_NUM = 7;
    public final static int HOUR_16_PM = 16;
    public final static int MINTUES_10 = 10;
    public final static String YYYYMMDD = "yyyyMMdd";
    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public final static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String HH_MM_SS = "HH:mm:ss";

    /***
     * 毫秒数据格式化时间
     * @param date 时间毫秒
     * @return 格式为(HH mm ss)的时间字符串
     */
    public static String formatTime(final long date) {
        return formatTime(new Date(date));
    }

    /**
     * 格式化为时间(HH:mm:ss)
     *
     * @param date 日期类型
     * @return 格式为(HH mm ss)的时间字符串
     */
    public static String formatTime(final Date date) {
        return formatDate(date, HH_MM_SS);
    }

    /**
     * 格式化为日期(yyyy-MM-dd HH:mm)
     *
     * @param date
     * @return yyyy-MM-dd HH:mm
     */
    public static String getFormatDateTimeMinute(final Date date) {
        return formatDate(date, YYYY_MM_DD_HH_MM);
    }

    /**
     * 格式化为日期(yyyy-MM-dd HH:mm:00) 获取分钟数
     *
     * @param date
     * @return yyyy-MM-dd HH:mm:00
     */
    public static Date getZeroSecondOf(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 格式化为日期(yyyy-MM-dd HH:00:00) 获取分钟数
     *
     * @param date
     * @return yyyy-MM-dd HH:00:00
     */
    public static Date getZeroMinuteOf(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 就获取今天0点时间
     *
     * @return 今天0点0分0秒
     */
    public static Date getZeroHourOfToday() {
        return getZeroHourOf(new Date());
    }

    /**
     * 格式化为日期(yyyy-MM-dd 00:00:00) 获取分钟数
     *
     * @param date
     * @return yyyy-MM-dd 00:00:00
     */
    public static Date getZeroHourOf(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取时间A与B之间的分钟差
     *
     * @param dateA
     * @param dateB
     * @return 相差分钟数
     */
    public static long getIntervalMinutes(final Date dateA, final Date dateB) {
        final long between = dateB.getTime() - dateA.getTime();
        return between / (60 * 1000);
    }

    /**
     * 格式化当前日期为：yyyyMMdd
     *
     * @return yyyyMMdd格式的时间字符串
     */
    public static String formatCurrentDate() {
        return formatDate(new Date());
    }

    /**
     * 格式化日期为 yyyyMMdd
     *
     * @param date 日期类型
     * @return 格式为(yyyyMMdd)的日期字符串
     */
    public static String formatDate(final Date date) {
        return formatDate(date, YYYYMMDD);
    }

    /**
     * 格式化日期为yyyy-MM-dd HH:mm:ss
     *
     * @param date 整型日期
     * @return 格式为(yyyy - MM - dd HH : mm : ss)的日期字符串
     */
    public static String formatDate(final long date) {
        final Date d = new Date(date);
        return formatDate(d, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 格式化日期(yyyyMMddHHmmss)
     *
     * @param date 日期类型
     * @return 格式为(pattern)的日期字符串
     */
    public static String formatDateTime(final Date date) {
        return formatDate(date, YYYYMMDDHHMMSS);
    }

    /**
     * 格式化日期(yyyyMMddHHmms)
     * 允许10s误差
     *
     * @param date 日期类型
     * @return 格式为(pattern)的日期字符串
     */
    public static String formatDateTimeDiff10Second(final Date date) {
        final String s = formatDate(date, YYYYMMDDHHMMSS);
        return StringUtils.substring(s, 0, s.length() - 1) + "0";
    }

    /**
     * 格式化日期
     *
     * @param date    日期类型
     * @param pattern 日期时间模式
     * @return 格式为(pattern)的日期字符串
     */
    public static String formatDate(final Date date, final String pattern) {
        final SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static int getWeekOfDate(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w <= 0) {
            w = WEEK_DAY_NUM;
        }
        return w;
    }

    public static long getTodayForHour(final int hour) {
        final Calendar beginningOfDayCalendar = Calendar.getInstance();
        beginningOfDayCalendar.set(Calendar.HOUR_OF_DAY, hour);
        beginningOfDayCalendar.set(Calendar.MINUTE, 0);
        beginningOfDayCalendar.set(Calendar.SECOND, 0);
        beginningOfDayCalendar.set(Calendar.MILLISECOND, 0);
        final long beginningOfDayInMillis = beginningOfDayCalendar.getTimeInMillis();
        final Date beginningOfDayDate = new Date(beginningOfDayInMillis);
        return beginningOfDayDate.getTime();
    }

    public static Date getFriday() {
        final Calendar calendar = Calendar.getInstance();
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.FRIDAY:
                final int hour = calendar.get(Calendar.HOUR_OF_DAY);
                final int min = calendar.get(Calendar.MINUTE);
                if (hour > HOUR_16_PM || (hour == HOUR_16_PM && min >= MINTUES_10)) {
                    calendar.add(Calendar.DAY_OF_WEEK, 7);
                }
                break;
            case Calendar.SATURDAY:
                calendar.add(Calendar.DAY_OF_WEEK, WEEK_DAY_NUM);
                break;
            default:
                break;
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        return calendar.getTime();
    }

    public static Date addDays(final Date date, final int days) {
        final Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date subDays(final Date date, final int days) {
        final Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.DATE, 0 - days);
        return cal.getTime();
    }

    public static Date subHours(final Date date, final int hours) {
        final Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.HOUR_OF_DAY, 0 - hours);
        return cal.getTime();
    }

    public static Date addHours(final Date date, final int hours) {
        final Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return cal.getTime();
    }

    public static String getSeasonFriday() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, getSeason(calendar.getTime()) + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.add(Calendar.DAY_OF_MONTH, Calendar.FRIDAY - calendar.get(Calendar.DAY_OF_WEEK));
        return formatDate(calendar.getTime());
    }

    /**
     * 获取当前月所属的季度
     * <p>
     * 1 第一季度
     * 2 第二季度
     * 3 第三季度
     * 4 第四季度
     *
     * @param date
     * @return 1|2|3|4
     */
    public static int getSeason(final Date date) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        final int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                return Calendar.MARCH;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                return Calendar.JUNE;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                return Calendar.SEPTEMBER;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                return Calendar.DECEMBER;
            default:
                return Calendar.MARCH;
        }
    }

    /**
     * @param date 必须为yyyy-MM-dd HH:mm:ss格式
     * @return 日期时间逝去的毫秒数
     */
    public static Long getTimeMillis(final String date) {
        final SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            final Date dateTime = format.parse(date);
            return dateTime.getTime();
        } catch (final ParseException e) {
            return null;
        }
    }

    /**
     * @param date
     * @param pattern pattern
     * @return date
     */
    public static Date getDateTime(final String date, final String pattern) {
        final SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date);
        } catch (final ParseException e) {
            return new Date();
        }
    }

    /**
     * 获取iso格式的日期字符串
     *
     * @param date
     * @return 2011-12-03T10:15:30Z
     */
    public static String getIsoFormatDate(final Date date) {
        final DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_INSTANT;
        return isoLocalDateTime.format(date.toInstant());
    }

    /**
     * 获取iso格式的日期字符串
     *
     * @param date TimeMillis 日期时间逝去的毫秒数
     * @return 2011-12-03T10:15:30Z
     */
    public static String getIsoFormatDate(final long date) {
        return getIsoFormatDate(new Date(date));
    }

    public static Long getTimeMillisOfIsoDate(final String isoDate) {
        return getDateOfIsoDate(isoDate).getTime();
    }

    public static Date getDateOfIsoDate(final String isoDate) {
        final DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_INSTANT;
        final TemporalAccessor accessor = timeFormatter.parse(isoDate);
        return Date.from(Instant.from(accessor));
    }

    public static Date getDateTimeDiff10Second(final Date date) {
        final String s = DateUtil.formatDateTime(date);
        final String seconds = StringUtils.substring(s, -2, -1) + "0";
        final String formatDate = StringUtils.substring(s, 0, s.length() - 2) + seconds;
        return getDateTime(formatDate, YYYYMMDDHHMMSS);
    }
}
