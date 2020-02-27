package com.bo.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ĸ�����: �ֶζ�ȡ �ļ��ֽ�������  ���뻺����
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * 
 */

public class BufferedTest01 {
	
	public static void main(String[] args) {
		// 1������Դ
		File src = new File("abc.txt");
		// 2��ѡ����
		InputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(src));
			// 3������(�ֶζ�ȡ)
			int len = 0;
			byte[] flush = new byte[1024];//��������
			while((len = is.read(flush)) != -1) {
				//�ֽ�����-->�ַ���(����)
				String string = new String(flush, 0, len);
				System.out.println(string);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4���ͷ���Դ
			try {
				if (null != is) {
					is.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void test1()
	{
		//1������Դ
		File srcFile = new File("abc.txt");
		//2��ѡ����
		InputStream is = null;
		BufferedInputStream bis = null;
		try {
			is = new FileInputStream(srcFile);
			bis = new BufferedInputStream(is);
			//3������(�ֶζ�ȡ)
			byte[] flush = new byte[1024];
			int len = -1; //���ܳ���
			while((len = is.read(flush)) != -1) {
				//�ֽ�����-->�ַ���(����)
				String string = new String(flush, 0, len);
				System.out.println(string);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4���ͷ���Դ �����������ͷ�
			try {
				if (null != is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			try {
				if (null != bis) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
