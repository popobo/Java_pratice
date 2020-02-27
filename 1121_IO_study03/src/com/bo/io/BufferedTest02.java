package com.bo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.io.BufferedOutputStream;;

/**
 * �ļ��ֽ������  ���뻺����
 *1������Դ
 *2��ѡ����
 *3������(д������)
 *4���ͷ���Դ
 */
public class BufferedTest02 {
	public static void main(String[] args) {
		//1������Դ
		File dest = new File("dest.txt");
		//2��ѡ����
		OutputStream os = null;
		try {
			os = new BufferedOutputStream(new FileOutputStream(dest));
			//3������(д��)
			String msg = "hello wrold!\r\n";
			byte[] datas = msg.getBytes();// �ַ���-->�ֽڱ���(����)
			os.write(datas, 0, datas.length); 
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
		}
	}
	
}
