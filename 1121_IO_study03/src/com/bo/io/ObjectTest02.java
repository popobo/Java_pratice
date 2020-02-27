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
 * 数据流:
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * 3、不是所有的对象都可以序列化Serializable
 * 
 * DataOutputStream
 * DataInputStream
 *
 */

public class ObjectTest02 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//写出-->序列化
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		//操作数据类型加数据
		oos.writeUTF("编码辛酸泪");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		//对象
		oos.writeObject("aaaa");
		oos.writeObject(new Date());
		Employee emp = new Employee("aaa", 12);
		oos.writeObject(emp);
		oos.flush();
		byte[] datas = baos.toByteArray();
		System.out.println("length:" + datas.length);
		//顺序与写出一致-->反序列化
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