package com.chengming.utils;


import com.chengming.entity.CountingData;
import com.chengming.enums.ClockInTypeEnum;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public final class DateTimeUtil {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMATS = "yyyy-MM-dd HH-mm-ss";
    public static final String DATE_MIT_TIME_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_NUMBER_FORMAT = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_FOREIGN = "dd/MM/yyyy";
    public static final String DATE_FORMAT_YMD = "yyyy/MM/dd";
    public static final String DATE_FORMAT_YM = "yyyy/MM";
    public static final String DATE_NUMBER_FORMAT = "yyyyMMdd";
    public static final String DATE_NUMBER_YEARS_FORMAT = "yyyyMM";
    public static final String TIME_FORMAT = "yyyy-MM-dd 12:00:00";
    public static final long DAY_SECONDS = 24L * 60 * 60;
    public static final long DAY_MILLISECONDS = 24L * 60 * 60 * 1000;
    public static final String DAY_STRING_FORMAT = "yyyy年MM月dd日";
    public static final String DAY_DIAN_FORMAT = "yyyy.MM.dd";
    public static final String TIME_FORMAT_HMS = "HH-mm-ss";

    private DateTimeUtil() {
    }

    public static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String formatDate(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    public static String formatDate(Date date) {
        return formatDate(date, DATE_FORMAT);
    }

    public static String formatMonth(Date date) {
        return formatDate(date, DATE_FORMAT_YM);
    }

    public static String formatDatetime(Date date) {
        return formatDate(date, DATE_TIME_FORMAT);
    }

    public static String formatDatetime() {
        return formatDate(DATE_TIME_FORMAT);
    }

    public static Date formatTime(Date date) {
        String formatDate = formatDate(date, TIME_FORMAT);
        return parseDate(formatDate, DATE_TIME_FORMAT);
    }

    @SneakyThrows
    public static Date formatDateString(String dateString) {
        return new SimpleDateFormat(DATE_TIME_FORMAT).parse(dateString);
    }

    public static Date formatTime(Date date, String pattern) {
        String formatDate = formatDate(date, pattern);
        return parseDate(formatDate, pattern);
    }

    /**
     * 解析日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date parseDate(String date, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            log.error("解析日期错误：" + e.getMessage());
            return null;
        }
    }

    /**
     * 解析日期时间
     *
     * @param date
     * @return
     */
    public static Date parseDatetime(String date) {
        return parseDate(date, DATE_TIME_FORMAT);
    }

    /**
     * 解析年月日期时间
     *
     * @param date
     * @return
     */
    public static Date parseDateDay(String date) {
        return parseDate(date, DATE_FORMAT);
    }

    /**
     * 解析年月日期时间
     *
     * @param date
     * @return
     */
    public static Date numberDateDay(String date) {
        return parseDate(date, DATE_NUMBER_FORMAT);
    }


    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int dayDiff(Date date1, Date date2) {
        Long days = (date1.getTime() - date2.getTime()) / DAY_MILLISECONDS;
        return days.intValue();
    }

    /**
     * 获取一个日期与当前时间相差的天数
     *
     * @param date
     * @return
     */
    public static int dayDiff(Date date) {
        Calendar calendar = Calendar.getInstance();
        setTime2Start(calendar);
        return dayDiff(date, calendar.getTime());
    }

    /**
     * 设置时间部分到开始时刻
     *
     * @param calendar
     * @return
     */
    public static void setTime2Start(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    /**
     * 设置时间部分到结束时刻
     *
     * @param calendar
     * @return
     */
    public static void setTime2End(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }

    /**
     * 当前年的开始时间
     *
     * @return
     */
    public static Date getFirstDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
        setTime2Start(calendar);
        return calendar.getTime();
    }

    /**
     * 当前年的结束时间
     *
     * @return
     */
    public static Date getLastDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        setTime2End(calendar);
        return calendar.getTime();
    }

    /**
     * 当前月的开始时间
     *
     * @return
     */
    public static Date getFirstDayOfMonth() {
        return getFirstDayOfMonth(new Date());
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        setTime2Start(calendar);
        return calendar.getTime();
    }

    /***
     * 当前月的结束时间
     * @return
     */
    public static Date getLastDayOfMonth() {
        return getLastDayOfMonth(new Date());
    }

    /**
     * Description : 获得一个日期所在月最后一天
     *
     * @param date 日期
     * @return java.util.Date
     * @date 2021/7/21 15:17
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setTime2End(calendar);
        return calendar.getTime();
    }

    /**
     * 获取某个日期所在月的天数
     *
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * 两个时间相差的月份
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int monthDiff(Date date1, Date date2) {
        Long month = (date1.getTime() - date2.getTime()) / (DAY_MILLISECONDS * 365 / 12);
        return month.intValue();
    }

    /**
     * 获取某个日期的天数
     *
     * @param date
     * @return
     */
    public static int getDayOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取某个日期的月份
     *
     * @param date
     * @return
     */
    public static int getMonthOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    /**
     * 获取某个日期的月份，补充到两位
     *
     * @param date
     * @return
     */
    public static String getMonthOfDateToString(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String Month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        return Month.length() > 1 ? Month : BigDecimal.ZERO.toString().concat(Month);
    }

    /**
     * 获取某个日期的年份
     *
     * @param date
     * @return
     */
    public static int getYearOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 日期加减
     *
     * @param date
     * @param field
     * @param amount
     * @return
     */
    public static Date add(Date date, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }


    /**
     * 获取某个日期当天的开始时间(00:00:00)
     *
     * @param date
     * @return
     */
    public static Date getStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        setTime2Start(calendar);
        return calendar.getTime();
    }

    /**
     * 获取某个日期当天的结束时间(23:59:59)
     *
     * @param date
     * @return
     */
    public static Date getEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        setTime2End(calendar);
        return calendar.getTime();
    }

    /**
     * 日期分钟加减
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * 日期天数加减
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 日期月份加减
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * 加减小时
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }


    /**
     * 获取昨天开始时间
     *
     * @return
     */
    public static Date yesterdayStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        setTime2Start(calendar);
        return calendar.getTime();
    }

    /**
     * Description : 获得昨天是几号
     *
     * @return int 几号
     * @author Gen
     * @date 2021/4/6 16:55
     */
    public static int yesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Description : 获得今天是几号
     *
     * @return int 几号
     * @author Gen
     * @date 2021/4/6 17:08
     */
    public static int today() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Description : 获取一个日期是第几号
     *
     * @param date 日期
     * @return int 几号
     * @author Gen
     * @date 2021/4/12 20:18
     */
    public static int getDays(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 获取昨天结束时间
     *
     * @return
     */
    public static Date yesterdayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        setTime2End(calendar);
        return calendar.getTime();
    }

    /**
     * 获取今天开始时间
     *
     * @return
     */
    public static Date todayStart() {
        Calendar calendar = Calendar.getInstance();
        setTime2Start(calendar);
        return calendar.getTime();
    }

    /**
     * 获取今天结束时间
     *
     * @return
     */
    public static Date todayEnd() {
        Calendar calendar = Calendar.getInstance();
        setTime2End(calendar);
        return calendar.getTime();
    }

    /**
     * 时间戳转换为date类型
     *
     * @param timestamp
     * @return
     */
    public static Date getTimeOfDate(Long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.getTime();
    }

    /**
     * 获取某个日期当天的开始时间(00:00:00)
     *
     * @param timestamp
     * @return
     */
    public static Date getStartTimeOfDate(Long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        setTime2Start(calendar);
        return calendar.getTime();
    }

    /**
     * 获取某个日期当天的结束时间(23:59:59)
     *
     * @param timestamp
     * @return
     */
    public static Date getEndTimeOfDate(Long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        setTime2End(calendar);
        return calendar.getTime();
    }

    /**
     * 获取某个日期当天的开始时间(00:00:00)
     *
     * @param startDate
     * @return
     */
    public static Date getStartTimeOfDate(String startDate) {
        Date date = parseDate(startDate, DATE_FORMAT);
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        setTime2Start(calendar);
        return calendar.getTime();
    }

    /**
     * 获取某个日期当天的结束时间(23:59:59)
     *
     * @param endDate
     * @return
     */
    public static Date getEndTimeOfDate(String endDate) {
        Date date = parseDate(endDate, DATE_FORMAT);
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        setTime2End(calendar);
        return calendar.getTime();
    }

    /**
     * 获取某个日期的本周的开始时间
     *
     * @param date 某个日期
     * @return 开始时间
     */
    private static Date getBeginDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        if (null != date) {
            cal.setTime(date);
        }
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getStartTimeOfDate(cal.getTime().getTime());
    }

    /**
     * 获取某个日期的本周的结束时间
     *
     * @param date 某个日期
     * @return 结束时间
     */
    private static Date getEndDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek(date));
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return getEndTimeOfDate(cal.getTime().getTime());
    }

    /**
     * 获取某个日期的本月的开始时间
     *
     * @param date 某个日期
     * @return 开始时间
     */
    private static Date getBeginDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getYearOfDate(date), getMonthOfDate(date), 1);
        return getStartTimeOfDate(calendar.getTime().getTime());
    }

    /**
     * 获取某个日期的本月的结束时间
     *
     * @param date 某个日期
     * @return 结束时间
     */
    public static Date getEndDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getYearOfDate(date), getMonthOfDate(date), 1);
        int day = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(getYearOfDate(date), getMonthOfDate(date), day);
        return getEndTimeOfDate(calendar.getTime().getTime());
    }

    /**
     * 获取某个日期的本年的开始时间
     *
     * @param date 某个日期
     * @return 开始时间
     */
    private static Date getBeginDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getYearOfDate(date));
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);
        return getStartTimeOfDate(cal.getTime().getTime());
    }

    /**
     * 获取某个日期的本年的结束时间
     *
     * @param date 某个日期
     * @return 结束时间
     */
    private static Date getEndDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getYearOfDate(date));
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return getEndTimeOfDate(cal.getTime().getTime());
    }

    /**
     * 时间Date类型转Long时间戳
     *
     * @param date
     * @return
     */
    public static Long dateToStamp(Date date) {
        long time = 0L;
        try {
            String sDate = formatDatetime(date);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
            Date parse = simpleDateFormat.parse(sDate);
            time = parse.getTime();
        } catch (Exception e) {
            log.error("时间Date转时间戳错误：" + e.getMessage());
        }
        return time;
    }

    /**
     * 秒级时间戳转Date
     *
     * @param stamp
     * @param pattern
     * @return
     */
    public static String stampToDate(Long stamp, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date(stamp));
    }

    /**
     * 获取年份加减时间
     *
     * @param years
     * @return
     */
    public static Date getYearAdd(Integer years) {
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);//当前时间减去一年，即一年前的时间
        return calendar.getTime();//获取一年前的时间，或者一个月前的时间
    }


    /**
     * 判断某个时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param dateTime  比较时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date dateTime, Date startTime, Date endTime) {
        if (dateTime.getTime() == startTime.getTime()
                || dateTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(dateTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description : 判断两个日期是否在一个时间范围内，只要有一个在范围内，则返回true
     *
     * @param shop           停机时间
     * @param start          开机时间
     * @param startTimeStamp 开始时间戳
     * @param endTimeStamp   结束时间戳
     * @return boolean
     * @author Gen
     * @date 2021/1/21 13:40
     */
    public static boolean isEffectiveDate(Date shop, Date start, Long startTimeStamp, Long endTimeStamp) {

        Date startTime = getTimeOfDate(startTimeStamp);
        Date endTime = getTimeOfDate(endTimeStamp);

        return isEffectiveDate(shop, startTime, endTime) || isEffectiveDate(start, startTime, endTime);
    }

    /**
     * Description : 获得两个日期的区间
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return java.lang.String
     * @author Gen
     * @date 2021/3/5 15:06
     */
    public static String getSection(Date startDate, Date endDate) {
        return formatDate(startDate) + " - " + formatDate(endDate);
    }

    /**
     * Description : 按照格式算周期
     *
     * @param startDate 开始
     * @param endDate   结束
     * @param format    格式
     * @return java.lang.String
     * @author Gen
     * @date 2021/8/13 14:49
     */
    public static String getSection(Date startDate, Date endDate, String format) {
        return formatDate(startDate, format) + " - " + formatDate(endDate, format);
    }

    /**
     * 判断两个日期是否连续
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static boolean ifContinuous(Date dateStart, Date dateEnd) {
        int interval = (int) ((dateEnd.getTime() - dateStart.getTime()) / 1000 / 60 / 60 / 24);
        if (interval == 1 || interval == 0) {
            return true;
        }
        return false;
    }

    /**
     * Description : 判断一个时间是否为今天
     *
     * @param date 时间
     * @return java.lang.Boolean true：今天，false ： 不是今天
     * @author Gen
     * @date 2021/4/6 19:44
     */
    public static Boolean isToday(Date date) {
        return dayDiff(date) == 0;
    }

    /**
     * Description : 判断今天开始时间  >= 开始时间（当前月天数 + 最早进场日期）
     *
     * @param date 时间
     * @return java.lang.Boolean true：大于等于，false ：小于
     * @author Gen
     * @date 2021/4/6 19:48
     */
    public static Boolean isMoreThanMonth(Date date) {
        // 最早进场日期 + 1个月
        Date entryMonthStartDate = DateTimeUtil.getStartDate(DateTimeUtil.addMonths(date, 1));

        return DateTimeUtil.todayStart().after(entryMonthStartDate) || DateTimeUtil.todayStart().equals(entryMonthStartDate);
    }

    /**
     * Description : 获得当前月的天数
     *
     * @return int 天数
     * @author Gen
     * @date 2021/4/12 19:29
     */
    public static int getDayOfMonth() {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        return aCalendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * Description : 获得指定月份的天数，例：上个月天数传 -1
     *
     * @param num 与本月相差的月数
     * @return int 天数
     * @author Gen
     * @date 2021/7/21 10:06
     */
    public static int getDayOfMonth(int num) {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.add(Calendar.MONTH, num);
        return aCalendar.getActualMaximum(Calendar.DATE);
    }


    /**
     * Description : 判断两个日期是否为同一天
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return java.lang.Boolean true : 同一天， false : 不是同一天
     * @author Gen
     * @date 2021/4/7 13:53
     */
    public static Boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        return dayDiff(date1, date2) == 0;
    }

    /**
     * Description : 判断一个时间是否为月底
     *
     * @param date 日期
     * @return java.lang.Boolean true : 月底，false : 不是月底
     * @author Gen
     * @date 2021/4/8 14:31
     */
    public static Boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        return calendar.get(Calendar.DAY_OF_MONTH) == 1;
    }

    /**
     * 校验日期格式是否为yyyy-MM-dd
     *
     * @param timeStr
     * @return
     */
    public static boolean valiDateFormat(String timeStr) {
        String format = "((19|20)[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(timeStr);
        if (matcher.matches()) {
            pattern = Pattern.compile("(\\d{4})-(\\d+)-(\\d+).*");
            matcher = pattern.matcher(timeStr);
            if (matcher.matches()) {
                int y = Integer.parseInt(matcher.group(1));
                int m = Integer.parseInt(matcher.group(2));
                int d = Integer.parseInt(matcher.group(3));
                if (d > 28) {
                    Calendar c = Calendar.getInstance();
                    c.set(y, m - 1, 1);
                    int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return (lastDay >= d);
                }
            }
            return true;
        }
        return false;
    }

    public static Date getCurrentDate2() {
        Calendar calendar = new GregorianCalendar();
        Date time = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(time);
        try {
            return format.parse(s);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 时间转换
     *
     * @param date 日期
     * @return
     */
    public static String getDayStringFomat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DAY_STRING_FORMAT);
        return formatter.format(date);
    }

    /**
     * 获取时间的 12点
     */
    public static Date getTwelve(Date date) {
        return formatDateString(formatDate(date, DateTimeUtil.DATE_FORMAT) + " 12:00:00");
    }

    public static String formatDateMintTime(Date date) {
        return formatDate(date, DATE_MIT_TIME_FORMAT);
    }

    /**
     * 判断12点前
     *
     * @param date 判断日期
     * @return true：12：01 前，false：等于 12：01 或者 12：01 后
     */
    public static Boolean judgeDate(Date date) {
        String formatDate = formatDate(date, TIME_FORMAT);
        Date resultDate = addMinutes(parseDate(formatDate, DATE_TIME_FORMAT), 1);
        return date.before(resultDate);
    }

    /**
     * 获取格林尼治时间
     *
     * @return
     */
    public static Date getGMTDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 0, 01);
        return cal.getTime();
    }

    public static Date getRoundOffSecond(Date date) {
        if (null == date) {
            return null;
        }
        long time = date.getTime() + 500;
        return formatTime(new Date(time), DATE_TIME_FORMAT);
    }

    public static String getNowTime() {
        return formatDate(new Date(), TIME_FORMAT_HMS);
    }


    public static Date getDefaultDate() {
        return parseDate(formatDate(parseDate(formatDate(new Date(), DATE_FORMAT) + " " + "18:30:00", DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT);
    }

    public static Date formatCountHourTime(String dateStr, String type) {
        if (StringUtils.isNotBlank(dateStr)) {
            StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(dateStr.split(":")).forEach(str -> {
                if (str.length() < 2) {
                    str = "0" + str;
                }
                stringBuilder.append(str).append(":").substring(stringBuilder.lastIndexOf(":"));
            });
            dateStr = stringBuilder.toString();
            //时间不为空时设置下午时间
            boolean b = dateStr.compareTo("00:00:00") >= 0 && dateStr.compareTo("06:00:00") <= 0;
            if (ClockInTypeEnum.AFTERNOON.getType().equals(type)) {
                if (b) {
                    return parseDate(formatDate(parseDate(formatDate(addDays(new Date(), 1), DATE_FORMAT) + " " + dateStr, DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT);
                }
                if (dateStr.compareTo("18:00:00") < 0) {
                    return parseDate(formatDate(parseDate(formatDate(new Date(), DATE_FORMAT) + " " + "18:30:00", DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT);
                } else {
                    return parseDate(formatDate(parseDate(formatDate(new Date(), DATE_FORMAT) + " " + dateStr, DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT);
                }
            } else {

                //时间不为空时 设置上午时间
                if (b) {
                    return parseDate(formatDate(parseDate(formatDate(new Date(), DATE_FORMAT) + " " + "09:00:00", DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT);
                }
                if (ClockInTypeEnum.MORNING.getType().equals(type) && dateStr.compareTo("10:00:00") >= 0) {
                    return parseDate(formatDate(parseDate(formatDate(new Date(), DATE_FORMAT) + " " + "09:00:00", DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT);
                }
                return parseDate(formatDate(parseDate(formatDate(new Date(), DATE_FORMAT) + " " + dateStr, DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT);
            }


        } else {
            //时间为空时设置上午时间
            if (ClockInTypeEnum.MORNING.getType().equals(type)) {
                return parseDate(formatDate(parseDate(formatDate(new Date(), DATE_FORMAT) + " " + "09:00:00", DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT);
            } else {
                //设置下午时间
                return parseDate(formatDate(parseDate(formatDate(new Date(), DATE_FORMAT) + " " + "18:30:00", DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT), DateTimeUtil.DATE_TIME_FORMAT);
            }
        }

    }

    public static CountingData getDifferFromTo(Date begin, Date end) {
        CountingData countingData = new CountingData();
        long milliseconds = end.getTime() - begin.getTime();
        StringBuilder workTime = new StringBuilder();
        StringBuilder extraTime = new StringBuilder();
        long mss = milliseconds / 1000;
        long days = mss / (60 * 60 * 24);
        long hours = (mss % (60 * 60 * 24)) / (60 * 60);
        long minutes = (mss % (60 * 60)) / 60;
        long seconds = mss % 60;
        DecimalFormat format = new DecimalFormat("00");
        if (days > 0) {
            hours = days * 24 + hours;
        }
        if (hours > 0) {
            workTime.append(format.format(hours)).append(":").append(format.format(minutes)).append(":").append(format.format(seconds));
            extraTime.append(format.format(hours - 9)).append(":").append(format.format(minutes)).append(":").append(format.format(seconds));
            if (minutes >= 30) {
                extraTime.append(format.format(hours - 9)).append(":").append(format.format(minutes - 30)).append(":").append(format.format(seconds));
            } else {
                extraTime.append(format.format(hours - 10)).append(":").append(format.format(minutes + 30)).append(":").append(format.format(seconds));
            }

        } else {
            workTime.append("00:").append(format.format(minutes)).append(":").append(format.format(seconds));
        }
        if (extraTime.toString().compareTo("00:00:00") <= 0) {
            extraTime = new StringBuilder().append("00:00:00");
        }
        countingData.setWorkingTime(workTime.toString());
        countingData.setExtraTime(extraTime.toString());
        return countingData;
    }

}
