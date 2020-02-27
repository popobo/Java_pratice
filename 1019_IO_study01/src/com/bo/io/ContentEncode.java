package com.bo.io;

import java.io.UnsupportedEncodingException;

/**
 * ����:�ֽ�-->�ַ���
 * @author 33136
 *
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "姓名生命使命";
		//编码
		byte[] datas = msg.getBytes(); //Ĭ��ʹ�ù��̵��ַ���
		System.out.println(datas.length); 
//		datas = msg.getBytes("UTF-16LE");
//		System.out.println(datas.length);
		
		//解码:字符串String(byte[] bytes, int offset, int length, String charsetName);
		msg = new String(datas, 0, datas.length, "utf8");
		System.out.println(msg);
		
		//乱码
		//1、字节数不够
		msg = new String(datas, 0, datas.length - 2, "utf8");
		System.out.println(msg);
		//2、字符集不统一
		msg = new String(datas, 0, datas.length - 2, "gbk");
		System.out.println(msg);
	}
}
