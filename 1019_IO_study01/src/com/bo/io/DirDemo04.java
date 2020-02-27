package com.bo.io;

import java.io.File;

/**
 * 统计文件夹大小
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
		//获取大小
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
