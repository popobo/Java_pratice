package com.bo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���ն�:d
 * 
 * @author 33136
 *
 */

public class TalkReceive implements Runnable {
	private DatagramSocket server;
	private String fromIP;
	public TalkReceive(int port, String fromIP) {
		this.fromIP = fromIP;
		try {
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			//2��׼����������װ��DatagramPacket����
			byte[] container = new byte[1024 * 64];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);
			//3������ʽ���հ���receive(DatagramPacket p)
			try {
				server.receive(packet);
				//4����������
				byte[] datas = packet.getData();
				int len = packet.getLength();
				String data = new String(datas, 0, len);
				System.out.println(fromIP + ":" + data);
				if (data.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
