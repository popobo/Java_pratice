package com.bo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 四个步骤 字符输入流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author 33136
 *
 */
public class BufferedTest03 {
	public static void main(String[] args) {
		//1、create source
		File src = new File("abc.txt");
		//2、choose stream 此处必须用BufferedReader reader而不是Reader reader
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(src));
			// 3、operate(segmented read)
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != reader)
				{
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
