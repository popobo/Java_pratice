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
 * �ĸ����� �ַ�������
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * @author 33136
 *
 */
public class BufferedTest03 {
	public static void main(String[] args) {
		//1��create source
		File src = new File("abc.txt");
		//2��choose stream �˴�������BufferedReader reader������Reader reader
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(src));
			// 3��operate(segmented read)
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
