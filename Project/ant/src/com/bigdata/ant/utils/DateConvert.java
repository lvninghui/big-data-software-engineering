/**
 * @Title:DateConvert.java
 * @Package:com.bigdata.ant.utils
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月20日
 */
package com.bigdata.ant.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @ClassName:DateConvert
 * @Description:TODO（String转Date）
 * @Author 成琼
 * @Date:2018年12月20日
 *
 *
 */
public class DateConvert implements Converter<String, Date> {

	   @Override
	   public Date convert(String stringDate) {
	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	           try {
				return simpleDateFormat.parse(stringDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	       return null;
	   }
	}