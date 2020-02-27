package com.bo.io;

import java.io.File;

/**
 * 创建目录
 * 列出下一级
 * 1、list()列出下级名称
 * 2、列出下级File对象
 * 3、列出所有的盘符
 * @author 33136
 *
 */
public class DirDemo02 {
	public static void main(String[] args) {
		File dir = new File("./");
		//列出下级名称 list
		String[] subsNames = dir.list();
		for (String s:subsNames) {
			System.out.println(s);
		}
		//下级对象
		File[] subFiles = dir.listFiles();
		for (File file:subFiles) {
			System.out.println(file.getName());
		}
		
		File[] roots = dir.listRoots();
		for (File r:roots) {
			System.out.println(r.getAbsolutePath());
		}
		
	}
}
