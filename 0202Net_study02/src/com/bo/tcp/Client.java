package com.bo.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ��Ϥ����
 * �����ͻ���
 * 1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
 * 2������: �������������
 * 3���ͷ���Դ 
 * @author 
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----Client-----");
		//1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
		Socket client =new Socket("localhost",8888);
		//2������: �������������
		DataOutputStream dos =new DataOutputStream(client.getOutputStream());
		String data ="hello";
		dos.writeUTF(data);
		dos.flush();
		//3���ͷ���Դ 
		dos.close();
		client.close();
	}

}
