package com.bo.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		
	}
	
	//启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			System.out.println("服务器启动失败");
			e.printStackTrace();
		}
	}
	
	//接受连接处理
	public void receive() {
		Socket client;
		try {
			client = serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			//获取协议请求
			InputStream is = client.getInputStream();
			byte[] datas = new byte[1024*1024];
			int len = is.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			System.out.println("客户端错误");
			e.printStackTrace();
		}
	}
	
	//停止服务
	public void stop() {
		
	}
}
