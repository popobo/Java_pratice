package com.bo.io;

import java.io.File;

/**
 * 其他信息
 * length:文件字节数
 * 
 * @author 33136
 *
 */
public class FileDemo05 {
	public static void main(String[] args) {
		File srcFile = new File("./src/com/bo/io/FileDemo01.java");
		System.out.println(srcFile.length());
		
	}
}
