package com.bo.io;

import java.io.File;

/**
 * getName()
 * getPath()
 * getAbsolutePath()
 * getParent():��·��
 * @author 33136
 *
 */
public class FileDemo03 {
	public static void main(String[] args) {
		File srcFile = new File("./src/com/bo/io/FileDemo01.java");
		System.out.println("����·��" + srcFile.getAbsolutePath());
		System.out.println("��·��" + srcFile.getParent());
		System.out.println("·��" + srcFile.getPath());
		System.out.println("������" + srcFile.getParentFile().getName());
	}
}
