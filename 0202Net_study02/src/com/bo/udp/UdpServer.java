package com.bo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���ն˻�������:
 * Address already in use:Can not bind ͬһ��Э���¶˿ڲ������ͻ
 * 1��ʹ��DatagramSocketָ���˿ڣ��������ն�
 * 2��׼����������װ��DatagramPacket����
 * 3������ʽ���հ���receive(DatagarmPacket p)
 * 4����������
 * 	  byte[] getData()
 * 			 getLength()
 * 5���ͷ���Դ
 *
 * @author 33136
 *
 */

public class UdpServer {
	public static void main(String[] args) throws IOException {
		System.out.println("reveiver starting...");
		//1��ʹ��DatagramSocketָ���˿ڣ��������ն�
		DatagramSocket server = new DatagramSocket(6666);
		//2��׼����������װ��DatagramPacket����
		byte[] container = new byte[1024*64];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		//3������ʽ���հ���receive(DatagramPacket p)
		server.receive(packet);//����ʽ
		//4����������
		//byte[] getData()
		//getLength()
		byte[] datas = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(datas, 0, len));
		//5���ͷ���Դ
		server.close();
	}
}
