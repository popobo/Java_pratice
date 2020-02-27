package com.bo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.security.MessageDigest;

/**
 * 四个步骤 字节数组输入流
 * 1、创建源
 * 2、选择流
 * 3、操作(写出内容)
 * 4、释放资源
 * @author 33136
 *
 */
public class IOtest06 {
	public static void main(String[] args) {
		//1、创建源
		File dest = new File("dest.txt");
		//2、选择流
		Writer writer = null;
		try {
			writer = new FileWriter(dest);
			//3、操作(写出)
			//写法一
//			String msg = "hello wrold!\r\n";
//			char[] datas = msg.toCharArray();//字符串-->字节数组（编码）
//			writer.write(datas, 0, datas.length); 
//			writer.flush();
			//写法二
//			String msg = "hello wrold!\r\n";
//			writer.write(msg);
//			writer.flush();
			//写法三
			writer.append("aaaaaa").append("nnnn");
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
		}
	}
	
}
