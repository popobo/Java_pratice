package cn.bo.testdate;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 测试日期类
 * @author 33136
 *
 */
public class TestCalendar {
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(2001, Calendar.FEBRUARY, 10, 12, 23, 34);
			
		Date date = calendar.getTime();
		System.out.println(date);
		System.out.println(calendar.get(Calendar.YEAR));
		
		calendar.set(Calendar.YEAR, 2030);
		calendar.set(Calendar.MONTH, 10);
		calendar.set(Calendar.DATE, 10);
		calendar.setTime(new Date());
		
		// 测试日期计算
		calendar.add(Calendar.MONTH, 30);
		System.out.println(calendar.getTime());
	}
}
