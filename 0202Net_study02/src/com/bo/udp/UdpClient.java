package com.bo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * ��������: ���Ͷ�
 * 1��ʹ��DatagramSocketָ���˿� �������Ͷ�
 * 2��׼������ת�����ֽں�����
 * 3����װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4�����Ͱ���send(DatagramPacket p)
 * 5���ͷ���Դ
 * @author 33136
 *
 */

public class UdpClient {
	public static void main(String[] args) throws IOException {
		System.out.println("Sender starting...");
		//1��ʹ��DatagarmSocketָ���˿ڴ������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		//2��׼������ת���ֽ�����
		String str = "�������";
		byte[] datas = str.getBytes();
		//3����װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
		//4�����Ͱ���send(DatagramPacket p)
		client.send(packet);
		//5���ͷ���Դ
		client.close();
	}
}
