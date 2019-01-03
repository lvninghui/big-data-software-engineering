package com.bigdata.ant.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName:IncreaseTimeUtil
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月13日
 *
 */
public class IncreaseTimeUtil {
	/**
	 * 
	 * @Title: addDateMinut
	 * @Description: TODO(这里用一句话描述这个方法的作用) 给要求的时间加几个小时
	 * @param:@param date
	 * @param:@param hour
	 * @param:@return (参数)
	 * @return:String(返回类型)
	 *
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addDateMinut(Date date, int hour) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hour);// 24小时制
		date = cal.getTime();
		return date;
	}

	/**
	 * 
	 * @Title: addDateYear
	 * @Description: TODO(这里用一句话描述这个方法的作用) 为了显示可选的年级，判断当前年份（得到当前年份及前四年的）
	 * @param:@param n
	 * @param:@return (参数)
	 * @return:List<String>(返回类型)
	 *
	 * @param n
	 * @return
	 */
	public static List<String> addDateYear(int n) {// 显示当前年份增加
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		List<String> list = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int month = cal.get(Calendar.MONTH) + 1;
		if (month >= 9) {// 如果当年月份超过九月，就存当前年、及前4年
			list.add(sdf.format(cal.getTime()));// 存当前年
		}
		for (int i = 0; i < n; i++) {
			cal.add(Calendar.YEAR, -1); // 年份减1
			String str = sdf.format(cal.getTime());
			list.add(str);
		}
		return list;
	}
}
