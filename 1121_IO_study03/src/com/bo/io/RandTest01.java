package com.bo.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RandTest01 {

	public static void main(String[] args) throws IOException {
//		test1();
//		test2();
		
		//�ֶ��ٿ�
		File src = new File("src/com/bo/io/Copy.java");
		//�ܳ���
		long len = src.length();
		//ÿ���С
		int blockSize = 128;
		//����
		int amount = (int)Math.ceil(len*1.0/blockSize);
		System.out.println(amount);
		//��ʼλ�ú�ʵ�ʴ�С
		int beginPos = 0;
		int actualSize = (int)(blockSize>len?len:blockSize);
		for (int i = 0; i < amount; i++) {
			beginPos = i*blockSize;
			if (amount - 1 == i) {//���һ��
				actualSize = (int)len;
			}else {
				actualSize = blockSize;
				len -= actualSize;//ʣ����
			}
			System.out.println(i+"-->"+beginPos+"-->"+actualSize);
			split(i, beginPos, actualSize);
		}
	}

	/**
	 * ָ����i�����ʼλ�� ��ʵ�ʳ���
	 * @param i
	 * @param beginPos
	 * @param actualSize
	 * @throws IOException
	 */
	public static void split(int i, int beginPos, int actualSize) throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile(new File("src/com/bo/io/Copy.java"), "r");
		//��ʼλ��
		//�����ȡ
		raf.seek(beginPos);
		//��ȡ
		//3������(�ֶζ�ȡ)
		byte[] flush = new byte[1024]; //��������
		int len = -1;
		while((len = raf.read(flush)) != -1) {
			if (actualSize > len) {
				System.out.println(new String(flush, 0, len));
				actualSize -= len;
			}else {
				System.out.println(new String(flush, 0, actualSize));
				break;
			}
		}
	}
	
	//�ֿ�˼��
	public static void test2() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("src/com/bo/io/Copy.java"), "r");
		//��ʼλ��
		int beginPos = 2 + 130;
		//ʵ�ʴ�С
		int actualSize = 130;
		//�����ȡ
		raf.seek(beginPos);
		//��ȡ
		//3������(�ֶζ�ȡ)
		byte[] flush = new byte[128]; //��������
		int len = -1;
		while((len = raf.read(flush)) != -1) {
			if (actualSize > len) {
				System.out.println(new String(flush, 0, len));
				actualSize -= len;
			}else {
				System.out.println(new String(flush, 0, actualSize));
				break;
			}
		}
	}
	
	public static void test1() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("src/com/bo/io/Copy.java"), "r");
		//�����ȡ
		raf.seek(2);
		//��ȡ
		//3������(�ֶζ�ȡ)
		byte[] flush = new byte[1024]; //��������
		int len = -1;
		while((len = raf.read(flush)) != -1) {
			System.out.println(new String(flush, 0, len));
		}
	}
}

