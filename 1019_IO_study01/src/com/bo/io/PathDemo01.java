package com.bo.io;

import java.io.File;

/**
 * 
 * @author 33136
 *
 */
public class PathDemo01 {
	/**
	 * \ /名称分隔符 separator
	 * @param args
	 */
	public static void main(String[] args) {
		//java建议
		//1、/
		String path = "D:/temp.json";
		//2、常量拼接
		path = "D:" + File.separator + "temp.json";
		System.out.println(path);
	}
}
