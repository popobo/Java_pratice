package com.bo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * ������:
 * 1��д�����ȡ
 * 2����ȡ��˳����д������һ��
 * 3���������еĶ��󶼿������л�Serializable
 * 
 * DataOutputStream
 * DataInputStream
 *
 */

public class ObjectTest02 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//д��-->���л�
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		//�����������ͼ�����
		oos.writeUTF("����������");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		//����
		oos.writeObject("aaaa");
		oos.writeObject(new Date());
		Employee emp = new Employee("aaa", 12);
		oos.writeObject(emp);
		oos.flush();
		byte[] datas = baos.toByteArray();
		System.out.println("length:" + datas.length);
		//˳����д��һ��-->�����л�
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean temp = ois.readBoolean();
		char c = ois.readChar();
		System.out.println(msg + age + temp + c);
		Object strObj = ois.readObject();
		Object dateObj = ois.readObject();
		Object empObj = ois.readObject();
		if (strObj instanceof String) {
			String str = (String)strObj;
			System.out.println(str);
		}
		if (dateObj instanceof Date) {
			Date outDate = (Date)dateObj;
			System.out.println(outDate);
		}
		if (empObj instanceof Employee) {
			Employee outEmp = (Employee)empObj;
			System.out.println(outEmp.getName() + ":" + outEmp.getAge());
		}
		
	}
}