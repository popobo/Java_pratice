package com.bo.io;

import java.io.BufferedWriter;
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
 * �ĸ����� �ֽ�����������
 * 1������Դ
 * 2��ѡ����
 * 3������(д������)
 * 4���ͷ���Դ
 * @author 33136
 *
 */
public class BufferedTest04 {
	public static void main(String[] args) {
		//1������Դ
		File dest = new File("dest.txt");
		//2��ѡ����
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(dest));
			writer.append("aaaaaa").append("nnnn");
			writer.newLine();
			writer.append("wwwwww");
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