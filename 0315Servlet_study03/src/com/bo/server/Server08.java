package com.bo.server;

/**
 * 目标: 加入了Servlet解耦了业务代码
 * 
 * @author bo
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server08 {
	private ServerSocket serverSocket;
	private boolean isRunning;
	
	public static void main(String[] args) {
		Server08 server08 = new Server08();
		server08.start();
	}
	
	//启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			isRunning = true;
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}
	//接受连接并处理
	public void receive() {
		while(isRunning) {
			Socket clientSocket;
			try {
				clientSocket = serverSocket.accept();
				new Thread(new Dispacher02(clientSocket)).start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("客户端错误");
			}
		}
	}
	
	//停止服务
	public void stop() {
		isRunning = false;
		try {
			serverSocket.close();
			System.out.println("服务器已停止");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
