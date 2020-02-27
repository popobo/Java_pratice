package com.bo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		
	}
	
	public static void copy(String srcPath, String destPath) {
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		
		try(InputStream is = new BufferedInputStream(new FileInputStream(srcFile));
			OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile));) {
			byte[] buf = new byte[1024];
			int len = -1;
			while((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
