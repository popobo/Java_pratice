package cn.bo.testdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm, 属于本月的第W周");
		Date date = new Date(123465841123L);
		String string = dateFormat.format(date);
		System.out.println(string);
		System.out.println("############");
		String string2 = "1997-3-23";
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date2 = dateFormat2.parse(string2);
			System.out.println(date2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
