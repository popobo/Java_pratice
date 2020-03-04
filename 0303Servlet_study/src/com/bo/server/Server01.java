package com.bo.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		
	}
	
	//��������
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			System.out.println("����������ʧ��");
			e.printStackTrace();
		}
	}
	
	//�������Ӵ���
	public void receive() {
		Socket client;
		try {
			client = serverSocket.accept();
			System.out.println("һ���ͻ��˽���������");
			//��ȡЭ������
			InputStream is = client.getInputStream();
			byte[] datas = new byte[1024*1024];
			int len = is.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			System.out.println("�ͻ��˴���");
			e.printStackTrace();
		}
	}
	
	//ֹͣ����
	public void stop() {
		
	}
}
