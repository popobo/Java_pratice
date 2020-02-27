package com.bo.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * ģ���¼  ����ͻ�������
 * �����ͻ���
 * 1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
 * 2������: �������������
 * 3���ͷ���Դ 
 * @author 
 *
 */

public class LoginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("---client---");
		//1���������ӣ�ʹ��Socket�����ͻ��� + ����ĵ�ַ�Ͷ˿�
		Socket client = new Socket("localhost", 8888);
		//2��������������������������������Ӧ
		new Send(client).send();
		new Receive(client).reveice();
		client.close();
	}
	//����
	static class Send{
		private Socket client;
		private DataOutputStream dos;
		private BufferedReader console;
		private String msg;
		public Send(Socket client) {
			console = new BufferedReader(new InputStreamReader(System.in));
			
		}
		private String init() {
			try {
				System.out.print("�������û�����");
				String username = console.readLine();
				System.out.println("���������룺");
				String password = console.readLine();
				return "username=" + username + "&" + "password=" + password; 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ""; 
		}
		
		private void send() {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//����
	static class Receive{
		private Socket client;
		private DataInputStream dis;
		public Receive(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void reveice() {
			String result;
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
