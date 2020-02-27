package com.bo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 第一个IO程序 标准
 * 理解操作步骤
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author 33136
 *
 */
public class IOtest02 {
	public static void main(String[] args) {
		//1、创建源
		File src = new File("abc.txt");
		//2、选择流
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			//3、操作(读取)
			int temp;
			while((temp = is.read()) != -1) {
				System.out.println((char)temp);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != is)
				{
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
