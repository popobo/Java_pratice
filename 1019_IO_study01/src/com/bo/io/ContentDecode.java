package com.bo.io;

import java.io.UnsupportedEncodingException;

/**
 * ����:�ַ���-->�ֽ�
 * @author 33136
 *
 */
public class ContentDecode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "��������ʹ��";
		//����
		byte[] datas = msg.getBytes(); //Ĭ��ʹ�ù��̵��ַ���
		System.out.println(datas.length); 
		datas = msg.getBytes("UTF-16LE");
		System.out.println(datas.length);
	}
}
