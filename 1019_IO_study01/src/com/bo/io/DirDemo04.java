package com.bo.io;

import java.io.File;

/**
 * ͳ���ļ��д�С
 * @author 33136
 *
 */
public class DirDemo04 {
	public static void main(String[] args) {
		File src = new File("D:\\Code\\Java\\1019_IO_study01");
		count(src);
		System.out.println(len);
	}
	private static long len = 0;
	public static void count(File src) {
		//��ȡ��С
		if(null != src && src.exists()) {
			if (src.isFile()) {
				len += src.length();
			}else {
				for(File s:src.listFiles()) {
					count(s);
				}
			}
		}
	}
	
}
