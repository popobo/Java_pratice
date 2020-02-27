package com.bo.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基本类型: 接收�?
 * Address already in use: Cannot bind  同一个协议下端口不允许冲�?
 * 1、使用DatagramSocket  指定端口 创建接收�?
 * 2、准备容�? 封装成DatagramPacket 包裹
 * 3、阻塞式接收包裹receive�?(DatagramPacket p)
 * 4、分析数�?    将字节数组还原为对应的类�?
 *    byte[]  getData�?()
 *                getLength�?()
 * 5、释放资�?
 * @author bo
 *
 */
public class UdpTypeServer {

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
		//  ·               getLength�?()
		byte[]  datas =packet.getData();
		int len = packet.getLength();		 
		DataInputStream dis =new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序与写出一�?
		String msg = dis.readUTF(); 
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println(msg+"-->"+flag);
		// 5、释放资�?
		server.close();
	}

}