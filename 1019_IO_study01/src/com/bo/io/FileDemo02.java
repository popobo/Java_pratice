package com.bo.io;

import java.io.File;

/**
 * ���·�� ����·��
 * @author 33136
 *
 */
public class FileDemo02 {
	public static void main(String[] args) {
		String path = "FileDemo01.java";
		File src = new File(path);
		System.out.println(src.getAbsolutePath());;
	}
}
