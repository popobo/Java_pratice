package com.bo.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ϴ��ļ�
 * �����ͻ���
 * 1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
 * 2������: �������������
 * 3���ͷ���Դ 
 * @author
 *
 */

public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("---Client---");
		//1���������ӣ� ʹ��socket�����ͻ��� + ����ĵ�ַ�Ͷ˿�
		Socket client = new Socket("localhost", 8888);
		//2������������ �ϴ�
		InputStream is = new BufferedInputStream(new FileInputStream("src/logo.png"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] flush = new byte[1024];
		int len = -1;
		while((len = is.read(flush)) != -1) {
			os.write(flush, 0, len);
		}
		os.flush();
		//3���ͷ���Դ
		os.close();
		is.close();
		client.close();
	}
}
