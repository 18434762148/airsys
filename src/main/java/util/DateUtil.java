package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 日期处理工具
 * @param dateFormat 格式
 * @param datestr 日期字符串
 * */
public class DateUtil {
	public static Date toDate(String dateFormat,String datestr) {
		SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	//根据某种日期格式把日期转化为字符串
	public static String dateToString(String dateFormat , Date date) {
		return new SimpleDateFormat(dateFormat).format(date);
	}
	public static void main(String[] args) {
		System.out.println(DateUtil.toDate("yyyy-MM-dd", "2019-11-09"));
	}
}
