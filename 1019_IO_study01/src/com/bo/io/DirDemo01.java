package com.bo.io;

import java.io.File;

/**
 * ����Ŀ¼
 * 1��mkdir() ȷ���ϼ�Ŀ¼����
 * 2��mkdirs() �ϼ�Ŀ¼���Բ����� �����ڻᱻ����
 * 
 * @author 33136
 *
 */
public class DirDemo01 {
	public static void main(String[] args) {
		File dir = new File("./test");
		//����Ŀ¼
		boolean flag = dir.mkdirs();
		System.out.println(flag);
	}
}
