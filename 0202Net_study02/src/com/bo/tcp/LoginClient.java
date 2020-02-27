package com.bo.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ģ���¼ ����
 * �����ͻ���
 * 1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
 * 2������: �������������
 * 3���ͷ���Դ 
 * @author ���� QQ:3401997271
 *
 */
public class LoginClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----Client-----");
		BufferedReader console =new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�������û���:");
		String uname =console.readLine();
		System.out.print("����������:");
		String upwd =console.readLine();
		
		//1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
		Socket client =new Socket("localhost",8888);
		//2������: �������������
		DataOutputStream dos =new DataOutputStream(client.getOutputStream());		
		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		dos.flush();
		//3���ͷ���Դ 
		dos.close();
		client.close();
	}

}