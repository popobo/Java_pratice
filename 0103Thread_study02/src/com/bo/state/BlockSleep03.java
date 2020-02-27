package com.bo.state;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class BlockSleep03 {
	
	public static void main(String[] args) throws InterruptedException {
//		test();
		//µ¹¼ÆÊ±
		Date endTime = new Date(System.currentTimeMillis() + 1000 * 5);
		long end = endTime.getTime();
		while (true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime = new Date(endTime.getTime() - 1000);
			if (end - 1000 * 5 > endTime.getTime()) {
				break;
			}
		}
	}
	
	public static void test() throws InterruptedException {
		int num = 5;
		while(num > 0) {
			Thread.sleep(1000);
			System.out.println(num);
			num--;
		}
		System.out.println("end");
	}
}