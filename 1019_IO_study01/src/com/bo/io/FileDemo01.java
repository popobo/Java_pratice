package com.bo.io;

import java.io.File;

/**
 * 
 * @author 33136
 *
 */
public class FileDemo01 {
	public static void main(String[] args) {
		//1
		File srcFile = new File("./src/com/bo/io/FileDemo01.java");
		System.out.println(srcFile.length());
		//2
		srcFile = new File("./src/com/bo/io/", "FileDemo01.java");
		System.out.println(srcFile.length());
		//3
		srcFile = new File(new File("./src/com/bo/io/"), "FileDemo01.java");
		System.out.println(srcFile.length());
	}
}
