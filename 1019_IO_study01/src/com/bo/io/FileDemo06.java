package com.bo.io;

import java.io.File;
import java.io.IOException;

/**
 * 其他信息
 * createNewFile() 不存在才创建 存在创建失败
 * delete()删除已经存在的文件
 * @author 33136
 *
 */
public class FileDemo06 {
	public static void main(String[] args) throws IOException {
		File srcFile = new File("./src/com/bo/io/pp");
		boolean flag = srcFile.createNewFile();
		System.out.println(flag);
		//不是文件夹
		flag = srcFile.delete();
		System.out.println(flag);
		//补充 com com3 操作系统设备名
	}
	
}
