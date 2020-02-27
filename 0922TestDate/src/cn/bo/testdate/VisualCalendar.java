package cn.bo.testdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ���ӻ���������
 * @author 33136
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("����������(���ո�ʽ��2030-3-10)��");
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
			System.out.println("��\tһ\t��\t��\t��\t��\t��");
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
