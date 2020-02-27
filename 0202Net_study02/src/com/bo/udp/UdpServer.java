package com.bo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端基本流程:
 * Address already in use:Can not bind 同一个协议下端口不允许冲突
 * 1、使用DatagramSocket指定端口，创建接收端
 * 2、准备容器，封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagarmPacket p)
 * 4、分析数据
 * 	  byte[] getData()
 * 			 getLength()
 * 5、释放资源
 *
 * @author 33136
 *
 */

public class UdpServer {
	public static void main(String[] args) throws IOException {
		System.out.println("reveiver starting...");
		//1、使用DatagramSocket指定端口，创建接收端
		DatagramSocket server = new DatagramSocket(6666);
		//2、准备容器，封装成DatagramPacket包裹
		byte[] container = new byte[1024*64];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		//3、阻塞式接收包裹receive(DatagramPacket p)
		server.receive(packet);//阻塞式
		//4、分析数据
		//byte[] getData()
		//getLength()
		byte[] datas = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(datas, 0, len));
		//5、释放资源
		server.close();
	}
}
