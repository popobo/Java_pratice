package com.bo.io;

import java.io.File;

/**
 * 
 * @author 33136
 *
 */
public class PathDemo01 {
	/**
	 * \ /���Ʒָ��� separator
	 * @param args
	 */
	public static void main(String[] args) {
		//java����
		//1��/
		String path = "D:/temp.json";
		//2������ƴ��
		path = "D:" + File.separator + "temp.json";
		System.out.println(path);
	}
}
