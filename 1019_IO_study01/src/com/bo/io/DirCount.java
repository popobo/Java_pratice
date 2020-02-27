package com.bo.io;

import java.io.File;

/**
 * ʹ��������� ͳ���ļ��д�С
 * @author 33136
 *
 */
public class DirCount {
	//�ļ�����
	private int fileAmount;
	//�ļ��и���
	private int dirAmount;
	//��С
	private long len;
	//�ļ���
	private String path;
	//Դ
	private File src;
	public DirCount(String path) {
		this.path = path;
		this.src = new File(path);	
		count(src);
	}
	
	public void count(File src) {
		//��ȡ��С
		if(null != src && src.exists()) {
			if (src.isFile()) {
				this.fileAmount++;
				this.len += src.length();
			}else {
				this.dirAmount++;
				for(File s:src.listFiles()) {
					count(s);
				}
			}
		}
	}

	public long getLen() {
		return len;
	}

	public void setLen(long len) {
		this.len = len;
	}
	
	public int getFileAmount() {
		return fileAmount;
	}

	public void setFileAmount(int fileAmount) {
		this.fileAmount = fileAmount;
	}

	public int getDirAmount() {
		return dirAmount;
	}

	public void setDirAmount(int dirAmount) {
		this.dirAmount = dirAmount;
	}

	public static void main(String[] args) {
		DirCount dirCount = new DirCount("./");
		System.out.println(dirCount.getLen());
		System.out.println(dirCount.getDirAmount());
		System.out.println(dirCount.getFileAmount());;
	}
	
}
