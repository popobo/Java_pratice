package com.bo.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintTest02 {
	public static void main(String[] args) throws FileNotFoundException {
		//´òÓ¡Á÷
		PrintWriter ps = null;
		ps = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")));
		ps.println("aaaa");
		ps.println(true);
		ps.flush();
		ps.close();
	}
}
