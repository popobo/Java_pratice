package com.bo.io;

import java.io.File;

/**
 * ����Ŀ¼
 * �г���һ��
 * 1��list()�г��¼�����
 * 2���г��¼�File����
 * 3���г����е��̷�
 * @author 33136
 *
 */
public class DirDemo02 {
	public static void main(String[] args) {
		File dir = new File("./");
		//�г��¼����� list
		String[] subsNames = dir.list();
		for (String s:subsNames) {
			System.out.println(s);
		}
		//�¼�����
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
