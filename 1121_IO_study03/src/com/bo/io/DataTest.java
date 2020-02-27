package com.bo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * ������:
 * 1��д�����ȡ
 * 2����ȡ��˳����д������һ��
 * 
 * DataOutputStream
 * DataInputStream
 *
 */

public class DataTest {
	public static void main(String[] args) throws IOException {
		//д��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		//�����������ͼ�����
		dos.writeUTF("����������");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas = baos.toByteArray();
		System.out.println("length:" + datas.length);
		//˳����д��һ��
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean temp = dis.readBoolean();
		char c = dis.readChar();
		System.out.println(msg + age + temp + c);
	}
}
