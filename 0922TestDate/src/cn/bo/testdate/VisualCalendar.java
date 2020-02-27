package cn.bo.testdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历程序
 * @author 33136
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("请输入日期(按照格式：2030-3-10)：");
		Scanner scanner = new Scanner(System.in);
		String tempString = scanner.nextLine();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(tempString);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int day = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, 1);
			
			int maxDate = calendar.getActualMaximum(Calendar.DATE);
			System.out.println("日\t一\t二\t三\t四\t五\t六");
			for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
				System.out.print("\t");
			}
			
			for (int i = 0; i < maxDate; i++) {
				if (i == day) {
					System.out.print("*");
				}
				System.out.print(i + "\t");
				int w = calendar.get(Calendar.DAY_OF_WEEK);
				if (w == Calendar.SATURDAY) {
					System.out.print('\n');
				}
				calendar.add(Calendar.DATE, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
