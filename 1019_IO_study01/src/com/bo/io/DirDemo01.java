package com.bo.io;

import java.io.File;

/**
 * 创建目录
 * 1、mkdir() 确保上级目录存在
 * 2、mkdirs() 上级目录可以不存在 不存在会被创建
 * 
 * @author 33136
 *
 */
public class DirDemo01 {
	public static void main(String[] args) {
		File dir = new File("./test");
		//创建目录
		boolean flag = dir.mkdirs();
		System.out.println(flag);
	}
}
