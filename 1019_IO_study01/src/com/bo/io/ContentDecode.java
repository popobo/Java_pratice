package com.bo.io;

import java.io.UnsupportedEncodingException;

/**
 * 编码:字符串-->字节
 * @author 33136
 *
 */
public class ContentDecode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命";
		//编码
		byte[] datas = msg.getBytes(); //默认使用工程的字符集
		System.out.println(datas.length); 
		datas = msg.getBytes("UTF-16LE");
		System.out.println(datas.length);
	}
}
