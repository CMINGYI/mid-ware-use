package com.chengming.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: yichengming
 * @Date: 2021/09/26/21:29
 * @Description:
 */
public class DateUtil {
    /**
     * 时间格式常量
     */
    public static final String COMMON_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String COMMON_PATTERN_TYPE2 = "yyyy/MM/dd HH:mm:ss";
    public static final String SHORT_PATTERN = "yyyy-MM-dd";
    public static final String SHORT_PATTERN_TYPE2 = "yyyy/MM/dd";
    public static final String LONG_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String SUP_SHORT_PATTERN = "yyyyMMdd";
    public static final String SUP_LONG_PATTERN = "yyyyMMddHHmmss";
    public static final String YEAR_MONTH = "yyyyMM";
    public static final String CN_SHORT_PATTERN = "yyyy年MM月dd日";
    public static final String DDMM_PATTERN = "ddMM";

    /**
     * 1、将 String 解析为 date
     *
     * @param dateString 待解析的日期字符串
     * @param pattern    日期字符串的时间格式
     * @return
     */
    public static Date trans2Date(String dateString, String pattern) {
        String fRTN = StringUtils.isNotBlank(pattern) ? pattern : COMMON_PATTERN;
        DateTimeFormatter format = DateTimeFormat.forPattern(fRTN);
        DateTime dt = DateTime.parse(dateString, format);
        return dt.toDate();
    }

    /**
     * 2、日期字符串格式化输出
     * * @param dateString  待格式化的日期字符串
     *
     * @param fromPattern 待格式化日期字符串的格式
     * @param toPattern   格式化后的日期格式
     * @return
     */
    public static String formatDate2String(String dateString, String fromPattern, String toPattern) {
        String tRTN = StringUtils.isNotBlank(toPattern) ? toPattern : COMMON_PATTERN;
        DateTimeFormatter format = DateTimeFormat.forPattern(fromPattern);
        DateTime dt = DateTime.parse(dateString, format);
        return dt.toString(tRTN);
    }

    /**
     * 3、Date类型日期转字符串格式化输出
     *
     * @param date    待格式化的日期
     * @param pattern 格式化后的格式
     * @return
     */
    public static String formatDate2String(Date date, String pattern) {
        String fRTN = StringUtils.isNotBlank(pattern) ? pattern : COMMON_PATTERN;
        DateTimeFormatter format = DateTimeFormat.forPattern(fRTN);
        return new DateTime(date).toString(format);
    }

    /**
     * 4、增加天数后的Date日期
     *
     * @param date      起点日期（date/string）
     * @param daysCount 增加天数
     * @return
     */
    public static <T> Date add(T date, int daysCount) {
        DateTime dt = new DateTime(date);
        return dt.plusDays(daysCount).toDate();
    }
    /**
     * 5、计算日期{@link Date}增加某天数后的Date类型日期
     *
     * @param d           Date
     * @param amountToAdd 天数增加值
     * @return Date
     */
    /**
     * 6、减少天数后的日期
     *
     * @param date      起点日期（date/string）
     * @param daysCount 减少的天数
     * @return
     */
    public static <T> Date sub(T date, int daysCount) {
        DateTime dt = new DateTime(date);
        return dt.minusDays(daysCount).toDate();
    }

    /**
     * 7、增加月数后的日期
     *
     * @param date   起点日期（date/string）
     * @param months 增加月数
     * @return
     */
    public static <T> Date addMonths(T date, int months) {
        DateTime dt = new DateTime(date);
        return dt.plusMonths(months).toDate();
    }

    /**
     * 8、减少月数后的日期
     *
     * @param date   起点日期（date/string）
     * @param months 减少的月数
     * @return
     */
    public static <T> Date subMonths(T date, int months) {
        DateTime dt = new DateTime(date);
        return dt.minusMonths(months).toDate();
    }

    /**
     * 9、减少年数后的日期
     *
     * @param date  起点日期（date/string）
     * @param years 减少的年数
     * @return
     */
    public static <T> Date subYears(T date, int years) {
        DateTime dt = new DateTime(date);
        return dt.minusYears(years).toDate();
    }

    /**
     * 10、计算月份差
     *
     * @param lastRepaymentDate
     * @param fundLoanDate
     * @return
     */
    public static int getMonthParse(String lastRepaymentDate, String fundLoanDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(sdf.parse(fundLoanDate));
        aft.setTime(sdf.parse(lastRepaymentDate));
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        return month + result;
    }

    /**
     * 11、计算两个日期的间隔天数
     * 目前不对两个日期比较大小，如放错顺序，则结果为负数的天数
     *
     * @param dateMin 起点日期（date/string）
     * @param dateMax 结束日期（date/string）
     * @return
     */
    public static <T> int betweenDays(T dateMin, T dateMax) {
        LocalDate start = new LocalDate(dateMin);
        LocalDate end = new LocalDate(dateMax);
        return Days.daysBetween(start, end).getDays();
    }

    /**
     * 12、计算两个时间的毫秒间隔
     * 目前不对两个时间参数比较大小，如放错顺序，则结果为负数的毫秒间隔
     *
     * @param dateMin 起点日期（date/string）
     * @param dateMax 结束日期（date/string）
     * @return
     */
    public static <T> long betweenMs(T dateMin, T dateMax) {
        DateTime start = new DateTime(dateMin);
        DateTime end = new DateTime(dateMax);
        return end.getMillis() - start.getMillis();
    }

    /**
     * 13、判断是否为交易日/工作日
     *
     * @param date 待判断日期（date/string）
     * @return
     */
    public static <T> boolean isTradeDay(T date) {
        if (null == date){
            return false;
        }
        boolean isTD = false;
        DateTime dt = new DateTime(date);
        if (isSpWorkDay(dt) || (!isHoliday(dt) && !isWeekEnd(dt))) {
            isTD = true;
        }
        return isTD;
    }

    //14、判断是否是周末*/
    private static boolean isWeekEnd(DateTime dt) {
        boolean isWE = false;
        int wd = dt.dayOfWeek().get();
        switch (wd) {
            case 6:
            case 7:
                isWE = true;
                break;
            default:
                break;
        }
        return isWE;
    }

    //15、判断是否为国家法定节假日*/
    private static boolean isHoliday(DateTime dt) {
        boolean isHD = false;
        //TODO：get days from redis

        List<String> holidayList = new ArrayList<String>();
        holidayList.add("2021-09-20");
        holidayList.add("2022-01-15");
        holidayList.add("2022-01-16");
        if (holidayList != null) {
            for (String holiday : holidayList) {
                if (dt.isEqual(new DateTime(holiday))) {
                    isHD = true;
                    break;
                }
            }
        }
        return isHD;
    }

    //16、判断是否为国家调整后的工作日*/
    private static boolean isSpWorkDay(DateTime dt) {
        boolean isSpWD = false;
        //TODO：get days from redis
        List<String> spWorkDayList = new ArrayList<String>();
        spWorkDayList.add("2021-09-18");
//        spWorkDayList.add("2022-01-15");
//        spWorkDayList.add("2022-01-16");
        if (spWorkDayList != null) {
            for (String spWorkDay : spWorkDayList) {
                if (dt.isEqual(new DateTime(spWorkDay))) {
                    isSpWD = true;
                    break;
                }
            }
        }
        return isSpWD;
    }

    /**
     * 17、获得时间指定时间差值 日期
     *
     * @param: aDate
     * @param: field 查看  Calendar.MINUTE  、SECOND
     * @param: diff 时间差
     * @return:
     */
    public static final Date diffDate(Date aDate, int field, int diff) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(aDate);
        cal.add(field, diff);
        return cal.getTime();
    }

    /**
     * 18、判断目标时间是否在区间内
     *
     * @param sDate 开始时间date/string
     * @param eDate 结束时间date/string
     * @param cDate 目标时间date/string
     * @param <T>
     * @return
     */
    public static <T> boolean isInRange(T sDate, T eDate, T cDate) {
        DateTime dtLow = new DateTime(sDate);
        DateTime dtHigh = new DateTime(eDate);
        DateTime dt = new DateTime(cDate);
        if (dt.getMillis() >= dtLow.getMillis() && dt.getMillis() <= dtHigh.getMillis()) {
            return true;
        }
        return false;
    }

    public static <T> boolean isInRange() {
        DateTime now = DateTime.now();
        return isInRange(now, now, now);
    }

    public static <T> boolean isInRange(T sDate, T eDate) {
        DateTime now = DateTime.now();
        return isInRange(sDate, eDate, now);
    }
    /**
     * 19、获取当前8位系统日期
     *
     * @return yyyyMMdd
     */

    /**
     *20、获取当前6位系统时间
     *
     * @return HHmmss
     */

    /**
     *21、获取当前14位系统日期时间
     *
     * @return yyyyMMddHHmmss
     */
    /**
     *22、按指定格式获取当前系统日期时间
     *
     * @param pattern pattern
     * @return 格式化的当前系统日期时间
     */

    /**
     *23、获取字符串start到end天数间隔
     *
     * @param start 开始日期，YYYYMMDD
     * @param end   结束日期，YYYYMMDD
     * @return 天数间隔
     */

    /**
     * 24、获取Date日期类型start到end天数间隔
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 天数间隔
     */
    public static void main(String[] args) {
        DateTime dt = new DateTime(DateTimeUtil.parseDate("2021-09-20", DateTimeUtil.DATE_FORMAT));

        System.out.println(dt);
        System.out.println(isTradeDay(DateTimeUtil.parseDate("2022-01-15", DateTimeUtil.DATE_FORMAT)));

        System.out.println(isHoliday(dt));

        System.out.println(isSpWorkDay(dt));

    }
}
