package com.bo.io;

import java.io.File;

/**
 * 使用面向对象 统计文件夹大小
 * @author 33136
 *
 */
public class DirCount {
	//文件个数
	private int fileAmount;
	//文件夹个数
	private int dirAmount;
	//大小
	private long len;
	//文件夹
	private String path;
	//源
	private File src;
	public DirCount(String path) {
		this.path = path;
		this.src = new File(path);	
		count(src);
	}
	
	public void count(File src) {
		//获取大小
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
