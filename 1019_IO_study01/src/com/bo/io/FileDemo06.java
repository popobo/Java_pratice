package com.bo.io;

import java.io.File;
import java.io.IOException;

/**
 * ������Ϣ
 * createNewFile() �����ڲŴ��� ���ڴ���ʧ��
 * delete()ɾ���Ѿ����ڵ��ļ�
 * @author 33136
 *
 */
public class FileDemo06 {
	public static void main(String[] args) throws IOException {
		File srcFile = new File("./src/com/bo/io/pp");
		boolean flag = srcFile.createNewFile();
		System.out.println(flag);
		//�����ļ���
		flag = srcFile.delete();
		System.out.println(flag);
		//���� com com3 ����ϵͳ�豸��
	}
	
}
