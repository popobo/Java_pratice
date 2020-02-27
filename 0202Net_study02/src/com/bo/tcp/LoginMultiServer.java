package com.bo.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼ ����ͻ�������
 * ����������
 * 1��ָ���˿� ʹ��ServerSocket����������
 * 2������ʽ�ȴ����� accept
 * 3������: �������������
 * 4���ͷ���Դ 
 * @author
 *
 */

public class LoginMultiServer {
	public static void main(String[] args) throws IOException {
		System.out.println("---server---");
		//1��ָ���˿ڣ�ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
		boolean isRunning = true;
		//2������ʽ�ȴ�����accept
		while(isRunning) {
			Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");
			new Thread(new Channel(client)).start();;
		}
		server.close();
	}
	
	//һ��channel�ʹ���һ���ͻ���
	static class Channel implements Runnable{
		private Socket client;
		//������
		private DataInputStream dis;
		//�����
		private DataOutputStream dos;
		public Channel(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
		}
		
		@Override
		public void run() {
			//3���������������������
			String username = "";
			String password = "";
			//����
			String[] strArray = receive().split("&");
			for(String info:strArray) {
				String[] userInfo = info.split("=");
				if (userInfo[0].equals("username")) {
					System.out.println("username:" + userInfo[1]);
					username = userInfo[1];
				}else if(userInfo[0].equals("password")) {
					System.out.println("password:" + userInfo[1]);
					password = userInfo[1];
				}
			}
			if (username.equals("bo") && password.equals("123")) {
				send("��½�ɹ�");
			}else {
				send("��½ʧ��");
			}
		}
		
		//��������
		private String receive() {
			String str = "";
			try {
				str = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
		}
		//��������
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//�ͷ���Դ
		private void release() {
			// 4���ͷ���Դ 
			try {
				if(null != dos) {
					dos.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(null != dis) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(null != client) {
					client.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
