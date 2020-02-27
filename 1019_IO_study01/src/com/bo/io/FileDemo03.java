package com.bo.io;

import java.io.File;

/**
 * getName()
 * getPath()
 * getAbsolutePath()
 * getParent():上路径
 * @author 33136
 *
 */
public class FileDemo03 {
	public static void main(String[] args) {
		File srcFile = new File("./src/com/bo/io/FileDemo01.java");
		System.out.println("绝对路径" + srcFile.getAbsolutePath());
		System.out.println("父路径" + srcFile.getParent());
		System.out.println("路径" + srcFile.getPath());
		System.out.println("父对象" + srcFile.getParentFile().getName());
	}
}
