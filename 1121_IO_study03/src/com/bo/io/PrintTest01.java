package com.bo.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintTest01 {
	public static void main(String[] args) throws FileNotFoundException {
		//打印流
		PrintStream ps = System.out;
		ps.println("打印流");
		ps.println(true);
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
		ps.println("aaaa");
		ps.println(true);
		ps.flush();
		
		//重定向
		System.setOut(ps);
		System.out.println("change");
		ps.flush();
		//重定向回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out))));
		System.out.println("change");
		System.out.flush();
	}
}
