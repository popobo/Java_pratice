package com.bo.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * 引用类型: 接收�?
 * Address already in use: Cannot bind  同一个协议下端口不允许冲�?
 * 1、使用DatagramSocket  指定端口 创建接收�?
 * 2、准备容�? 封装成DatagramPacket 包裹
 * 3、阻塞式接收包裹receive�?(DatagramPacket p)
 * 4、分析数�?    将字节数组还原为对应的类�?
 *    byte[]  getData�?()
 *                getLength�?()
 * 5、释放资�?
 * @author 裴新 QQ:3401997271
 *
 */
public class UdpObjServer {

	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中.....");
		// 1、使用DatagramSocket  指定端口 创建接收�?
		DatagramSocket server =new DatagramSocket(6666);
		// 2、准备容�? 封装成DatagramPacket 包裹
		byte[] container =new byte[1024*60];
		DatagramPacket packet = new DatagramPacket(container,0,container.length);
		// 3、阻塞式接收包裹receive�?(DatagramPacket p)
		server.receive(packet); //阻塞�?
		// 4、分析数�?    将字节数组还原为对应的类�?
		//    byte[]  getData�?()
		//                getLength�?()
		 byte[]  datas =packet.getData();
		 int len = packet.getLength();		 
		//读取 -->反序列化
		ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序与写出一�?
		String msg = ois.readUTF(); 
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		System.out.println(flag);
		//对象的数据还�?  
		Object str = ois.readObject();
		Object date = ois.readObject();
		Object employee = ois.readObject();
		
		if(str instanceof String) {
			String strObj = (String) str;
			System.out.println(strObj);
		}
		if(date instanceof Date) {
			Date dateObj = (Date) date;
			System.out.println(dateObj);
		}
		if(employee instanceof Employee) {
			Employee empObj = (Employee) employee;
			System.out.println(empObj.getName()+"-->"+empObj.getSalary());
		}
		 
		 
		// 5、释放资�?
		 server.close();
	}

}
