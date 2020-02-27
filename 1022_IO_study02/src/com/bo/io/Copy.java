package com.bo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

/**
 * 拷贝
 * @author 33136
 *
 */
public class Copy {
	public static void main(String[] args) {
		Copy.copy("dest.txt", "abc.txt");
	}
	
	public static void copy(String srcPath, String destPath) {
		//1、创建源
		File src = new File(srcPath);//源头
		File dest = new File(destPath);//目的地
		//2、选择流
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			//3、操作(分段读取)
			byte[] flush = new byte[1024 * 1]; //缓冲容器
			int len = -1;//接收长度
			while((len = is.read(flush)) != -1) {
				//字节数组->字符串(解码)
				os.write(flush, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//分别关闭，先打开的后关闭
			
			try {
				if (null != os) {
					os.close();
				}
			} catch (IOException e) { 
				e.printStackTrace();
			}
			
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
