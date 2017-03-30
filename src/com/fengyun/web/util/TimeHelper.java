package com.fengyun.web.util;

import java.util.Calendar;
import java.util.Date;

import mmo.common.utils.DateStringUtils;

/**
 * 副本时间段计算帮助类
 */
public class TimeHelper {
	/**
	 * 将时间段字符串解析成TimeSegment对象
	 * 
	 * @param times
	 *            时间段字符串
	 * @return TimeSegment对象
	 */

	/**
	 * 计算时间差，以秒为单位
	 * 
	 * @param loginTime
	 * @return
	 */
	public static long caculateTime(Date time) {
		return (System.currentTimeMillis() - time.getTime()) / 1000;
	}

	/**
	 * 是否同一天
	 * 
	 * @param dateA
	 * @param dateB
	 * @return
	 */
	public static boolean isSameDay(Date dateA, Date dateB) {
		Calendar calDateA = Calendar.getInstance();
		calDateA.setTime(dateA);

		Calendar calDateB = Calendar.getInstance();
		calDateB.setTime(dateB);

		return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
				&& calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
				&& calDateA.get(Calendar.DAY_OF_MONTH) == calDateB
						.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 是否同一周
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeek(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		// subYear==0,说明是同一年
		if (subYear == 0) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		// 例子:cal1是"2005-1-1"，cal2是"2004-12-25"
		// java对"2004-12-25"处理成第52周
		// "2004-12-26"它处理成了第1周，和"2005-1-1"相同了
		// 大家可以查一下自己的日历
		// 处理的比较好
		// 说明:java的一月用"0"标识，那么12月用"11"
		else if (subYear == 1 && cal2.get(Calendar.MONTH) == 11) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		// 例子:cal1是"2004-12-31"，cal2是"2005-1-1"
		else if (subYear == -1 && cal1.get(Calendar.MONTH) == 11) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;

		}
		return false;
	}

	public static void main(String[] args){
		Date data1 = DateStringUtils.parse("2015-04-28 16:12:01");
		Date data2 = DateStringUtils.parse("2015-04-30 16:22:24");
		System.out.println(subDate(data1,data2));
	}
	
	/**
	 * 使用结束日期减去开始日期,得到相差的天数
	 * 
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int subDate(Date date1, Date date2) {
		if(date1 == null || date2 == null)
			return 0;
		Date starttime = DateStringUtils.parse(DateStringUtils.format(date1));
		Date endtime = DateStringUtils.parse(DateStringUtils.format(date2));
		
		starttime.setHours(0);
		starttime.setMinutes(0);
		starttime.setSeconds(0);
		endtime.setHours(0);
		endtime.setMinutes(0);
		endtime.setSeconds(0);
		if (starttime == null || endtime == null) {
			return 0;
		}
		long temp = endtime.getTime() - starttime.getTime();
		if (temp > 0) {
			return (int) (temp / (24 * 60 * 60 * 1000));
		}
		return 0;
	}
}
