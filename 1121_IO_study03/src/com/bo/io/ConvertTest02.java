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
 * 转换流:InputStreamReader OutputStreamWriter
 * 1、以字符流的形式操作字符流(纯文本的)
 * 2、指定字符集
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
			//操作(读取)
			String msg;
			while((msg = reader.readLine()) != null) {
				writer.write(msg); //字符集不统一会出现乱码
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			System.out.println("操作异常");
		}
//		test1();
	}
	
	public static void test1() {
		// 操作网络流 下载百度网页源码
		try(InputStream is = new URL("https://www.baidu.com").openStream();){
			int len;
			while((len = is.read()) != -1) {
				System.out.println((char)len);//字节数不够出现乱码
			}
		}catch (IOException e) {
			System.out.println("操作异常");
		}
	}
	
	public static void test2() {
		// 操作网络流 下载百度网页源码
		try(InputStreamReader is = 
				new InputStreamReader(new URL("https://www.baidu.com").openStream(), "UTF-8");){
			int len;
			while((len = is.read()) != -1) {
				System.out.println((char)len);//字节数不够出现乱码
			}
		}catch (IOException e) {
			System.out.println("操作异常");
		}
	}
	
}
