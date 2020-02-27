package com.bo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据流:
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * 
 * DataOutputStream
 * DataInputStream
 *
 */

public class DataTest {
	public static void main(String[] args) throws IOException {
		//写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		//操作数据类型加数据
		dos.writeUTF("编码辛酸泪");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas = baos.toByteArray();
		System.out.println("length:" + datas.length);
		//顺序与写出一致
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean temp = dis.readBoolean();
		char c = dis.readChar();
		System.out.println(msg + age + temp + c);
	}
}
