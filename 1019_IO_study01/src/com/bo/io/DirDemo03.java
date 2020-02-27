package com.bo.io;

import java.io.File;

/**
 * 递归:方法自己调用自己
 * 递归出口:
 * 递归提: 
 * 打印子孙级目录和文件
 * @author 33136
 *
 */
public class DirDemo03 {
	public static void main(String[] args) {
		File src = new File("./");
		printFile(src, 0);
	}
	public static void printFile(File src, int deep) {
		for (int i = 0; i < deep; i++) {
			System.out.print("-");
		}
		System.out.println(src.getName());
		if (null == src || !src.exists()) {
			return;
		}else if (src.isDirectory()) {
			for (File s:src.listFiles())
			{
				printFile(s, deep + 1);
			}
		}
	}
}
