package com.bo.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �洢�ļ�
 * ����������
 * 1��ָ���˿� ʹ��ServerSocket����������
 * 2������ʽ�ȴ����� accept
 * 3������: �������������
 * 4���ͷ���Դ 
 * @author 
 *
 */

public class FileServer {
	public static void main(String[] args) throws IOException {
		System.out.println("---server---");
		//1��ָ���˿�
		ServerSocket server = new ServerSocket(8888);
		//2������ʽ�ȴ�����
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
		//3���������ļ����� �洢
		InputStream is = new BufferedInputStream(client.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("src/tcp_copy.png"));
		byte[] flush = new byte[1024];
		int len = -1;
		while((len = is.read(flush)) != -1) {
			os.write(flush, 0, len);
		}
		os.flush();
		//3���ͷ���Դ
		os.close();
		is.close();
		//4���ͷ���Դ
		client.close();
		server.close();
	}
}
