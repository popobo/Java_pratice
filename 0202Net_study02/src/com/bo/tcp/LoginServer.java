package com.bo.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼ ����
 * ����������
 * 1��ָ���˿� ʹ��ServerSocket����������
 * 2������ʽ�ȴ����� accept
 * 3������: �������������
 * 4���ͷ���Դ 
 * @author ���� QQ:3401997271
 *
 */
public class LoginServer {

	public static void main(String[] args) throws IOException {
		System.out.println("-----Server-----");
		// 1��ָ���˿� ʹ��ServerSocket����������
		ServerSocket server =new ServerSocket(8888);
		// 2������ʽ�ȴ����� accept
		Socket  client =server.accept(); 
		System.out.println("һ���ͻ��˽���������");
		// 3������: �������������
		DataInputStream dis =new DataInputStream(client.getInputStream());
		String datas =dis.readUTF();
		//����
		String[] dataArray = datas.split("&");
		for(String info:dataArray) {
			String[] userInfo =info.split("=");
				if(userInfo[0].equals("uname")) {
					System.out.println("����û���Ϊ:"+userInfo[1]);
				}else if(userInfo[0].equals("upwd")) {
					System.out.println("�������Ϊ:"+userInfo[1]);
				}
				
		}
		// 4���ͷ���Դ 
		dis.close();
		client.close();
		
		server.close();
	}

}
