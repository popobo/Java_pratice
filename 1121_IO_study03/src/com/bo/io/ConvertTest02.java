package com.bo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ת����:InputStreamReader OutputStreamWriter
 * 1�����ַ�������ʽ�����ַ���(���ı���)
 * 2��ָ���ַ���
 * @author 33136
 *
 */

public class ConvertTest02 {
	public static void main(String[] args) {
		try (BufferedReader reader =
				new BufferedReader(
						new InputStreamReader(
								new URL("https://www.baidu.com").openStream(), "UTF-8"));
			BufferedWriter writer = 
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream("baidu.html"), "UTF-8"));) {
			//����(��ȡ)
			String msg;
			while((msg = reader.readLine()) != null) {
				writer.write(msg); //�ַ�����ͳһ���������
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			System.out.println("�����쳣");
		}
//		test1();
	}
	
	public static void test1() {
		// ���������� ���ذٶ���ҳԴ��
		try(InputStream is = new URL("https://www.baidu.com").openStream();){
			int len;
			while((len = is.read()) != -1) {
				System.out.println((char)len);//�ֽ���������������
			}
		}catch (IOException e) {
			System.out.println("�����쳣");
		}
	}
	
	public static void test2() {
		// ���������� ���ذٶ���ҳԴ��
		try(InputStreamReader is = 
				new InputStreamReader(new URL("https://www.baidu.com").openStream(), "UTF-8");){
			int len;
			while((len = is.read()) != -1) {
				System.out.println((char)len);//�ֽ���������������
			}
		}catch (IOException e) {
			System.out.println("�����쳣");
		}
	}
	
}
