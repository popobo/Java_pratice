package com.bo.udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *1�� ͼƬ��ȡ���ֽ�����
 *2�� �ֽ�����д�����ļ�
 *  @author bo         
 *
 */
public class IOUtils {
	/**
	 * 1��ͼƬ��ȡ���ֽ�����
	 * 1)��ͼƬ������  FileInputStream
	 * 2)�������ֽ�����	ByteArrayOutputStream
	 */
	public static byte[] fileToByteArray(String filePath) {
		//1������Դ��Ŀ�ĵ�
		File src = new File(filePath);
		byte[] dest =null;
		//2��ѡ����
		InputStream  is =null;
		ByteArrayOutputStream baos =null;
		try {
			is =new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			//3������ (�ֶζ�ȡ)
			byte[] flush = new byte[1024*10]; //��������
			int len = -1; //���ճ���
			while((len=is.read(flush))!=-1) {
				baos.write(flush,0,len);		 //д�����ֽ�������			
			}		
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4���ͷ���Դ
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;		
	}
	/**
	 * 2���ֽ�����д����ͼƬ
	 * 1)���ֽ����鵽���� ByteArrayInputStream
	 * 2)�������ļ� FileOutputStream
	 */
	public static void byteArrayToFile(byte[] src,String filePath) {
		//1������Դ
		File dest = new File(filePath);
		//2��ѡ����
		InputStream  is =null;
		OutputStream os =null;
		try {
			is =new ByteArrayInputStream(src);
			os = new FileOutputStream(dest);
			//3������ (�ֶζ�ȡ)
			byte[] flush = new byte[5]; //��������
			int len = -1; //���ճ���
			while((len=is.read(flush))!=-1) {
				os.write(flush,0,len);			//д�����ļ�	
			}		
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4���ͷ���Դ
			try {
				if (null != os) {
					os.close();
				} 
			} catch (Exception e) {
			}
		}
	}
}