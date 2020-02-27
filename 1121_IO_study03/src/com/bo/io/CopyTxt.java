package com.bo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTxt {
	public static void main(String[] args) {
		copy("abc.txt", "dest.txt");
	}
	
	public static void copy(String srcTxt, String destTxt) {
		// 1、创建源
		File srcFile = new File(srcTxt);
		File desFile = new File(destTxt);
		// 2、选择流
		try(BufferedReader reader = new BufferedReader(new FileReader(srcFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(desFile));){
			// 3、操作(逐行读取)
			String line = null;
			while((line = reader.readLine()) != null) {
				writer.write(line);//逐行写出
				writer.newLine();
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
