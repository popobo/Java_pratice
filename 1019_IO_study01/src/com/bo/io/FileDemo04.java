package com.bo.io;

import java.io.File;

/**
 * �ļ�״̬:
 * 
 * @author 33136
 *
 */
public class FileDemo04 {

	public static void main(String[] args) {
		File srcFile = new File("./src/com/bo/io/FileDemo01.java");
		System.out.println(srcFile.getAbsolutePath());
		System.out.println("�Ƿ����:" + srcFile.exists());
		System.out.println("�Ƿ��ļ�:" + srcFile.isFile());
		System.out.println("�Ƿ��ļ���" + srcFile.isDirectory());
		
		//�ļ�״̬
		srcFile = new File("xx");
		if (null == srcFile || !srcFile.exists()) {
			System.out.println("�ļ�������");
		}else {
			if (srcFile.isFile()) {
				System.out.println("�ļ�����");
			}else {
				System.out.println("�ļ��в���");
			}
		}
	}
}
