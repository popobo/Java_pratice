package cn.bo.testexception;

import javax.print.attribute.standard.Copies;
import java.io.File;
import java.io.FileNotFoundException;

public class TestException {
	public static void main(String[] args) {
//		int i = 1/0;
//		Computer computer = null;
//		if (computer != null) {
//			computer.start();
//		}
		
//		String string = "1234abcf";
//		Integer integer = new Integer(string);
		
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			System.out.println("aaaa");
//		}
		
		File f = new File("C:/Users/33136/Desktop/test.txt");
		if (!f.exists()) {
			try {
				throw new FileNotFoundException("File can not be found!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
