package cn.bo.testdate;

import java.util.Date;

/**
 * ����Date����÷�
 * @author 33136
 *
 */

public class TestDate {
	public static void main(String[] args) {
		Date date = new Date();
		long t = System.currentTimeMillis();
		System.out.println(t);
		Date date2 = new Date(1569133263843L);
		
		System.out.println(date2.toGMTString()); // ������ʹ��
		date2.setTime(23246325);
		System.out.println(date2.getTime());
		System.out.println(date.getTime() < date2.getTime());
	}
}
