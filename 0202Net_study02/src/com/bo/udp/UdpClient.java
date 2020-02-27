package com.bo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 基本流程: 发送端
 * 1、使用DatagramSocket指定端口 创建发送端
 * 2、准备数据转换成字节和数据
 * 3、封装成DatagramPacket包裹，需要指定目的地
 * 4、发送包裹send(DatagramPacket p)
 * 5、释放资源
 * @author 33136
 *
 */

public class UdpClient {
	public static void main(String[] args) throws IOException {
		System.out.println("Sender starting...");
		//1、使用DatagarmSocket指定端口创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		//2、准备数据转成字节数据
		String str = "网络测试";
		byte[] datas = str.getBytes();
		//3、封装成DatagramPacket包裹，需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
		//4、发送包裹send(DatagramPacket p)
		client.send(packet);
		//5、释放资源
		client.close();
	}
}
