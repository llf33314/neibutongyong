package com.gt.inside.api.util;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期操作工具类
 * 
 */
public class DateTimeKit {

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws Exception
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate,Date bdate) throws Exception
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			smdate=sdf.parse(sdf.format(smdate));
			bdate=sdf.parse(sdf.format(bdate));
		} catch (ParseException e) {
			throw new Exception("计算两个日期之间相差的天数  ");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 格式化时间
	 * @param formatString 时间格式 例：（yyyy-MM-dd HH:mm:ss）
	 * @param date
	 * @return
	 */
	public static String formatTime(String formatString, Date date){
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		return format.format(date);
	}

	/**
	 * 格式化时间，到月（yyyy-MM）
	 * @param date
	 * @return
	 */
	public static String formatTimeUntilMonth(Date date){
		return formatTime("yyyy-MM", date);
	}

	/**
	 * 格式化时间，到日（yyyy-MM-dd）
	 * @param date
	 * @return
	 */
	public static String formatTimeUntilDay(Date date){
		return formatTime("yyyy-MM-dd", date);
	}

	/**
	 * 格式化时间，到小时（yyyy-MM-dd HH）
	 * @param date
	 * @return
	 */
	public static String formatTimeUntilHour(Date date){
		return formatTime("yyyy-MM-dd HH", date);
	}

	/**
	 * 格式化时间，到分钟（yyyy-MM-dd HH:mm）
	 * @param date
	 * @return
	 */
	public static String formatTimeUntilMinute(Date date){
		return formatTime("yyyy-MM-dd HH:mm", date);
	}

	/**
	 * 格式化时间，到秒（yyyy-MM-dd HH:mm:ss）
	 * @param date
	 * @return
	 */
	public static String formatTimeUntilSecond(Date date){
		return formatTime("yyyy-MM-dd HH:mm:ss", date);
	}

	/**
	 * 获取本月第一天
	 * @return
	 */
	public static Date getThisMonthFirstDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 获取本月第一天
	 * @return
	 */
	public static Date getThisMonthLastDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		return calendar.getTime();
	}

}
