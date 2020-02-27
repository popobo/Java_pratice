package com.bo.io;

import java.io.File;

/**
 * 文件状态:
 * 
 * @author 33136
 *
 */
public class FileDemo04 {

	public static void main(String[] args) {
		File srcFile = new File("./src/com/bo/io/FileDemo01.java");
		System.out.println(srcFile.getAbsolutePath());
		System.out.println("是否存在:" + srcFile.exists());
		System.out.println("是否文件:" + srcFile.isFile());
		System.out.println("是否文件夹" + srcFile.isDirectory());
		
		//文件状态
		srcFile = new File("xx");
		if (null == srcFile || !srcFile.exists()) {
			System.out.println("文件不存在");
		}else {
			if (srcFile.isFile()) {
				System.out.println("文件操作");
			}else {
				System.out.println("文件夹操作");
			}
		}
	}
}
