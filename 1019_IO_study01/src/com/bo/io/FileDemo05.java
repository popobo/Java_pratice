package com.bo.io;

import java.io.File;

/**
 * ������Ϣ
 * length:�ļ��ֽ���
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
