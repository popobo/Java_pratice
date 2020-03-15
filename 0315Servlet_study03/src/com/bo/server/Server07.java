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

public class Server07 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server07 server07 = new Server07();
		server07.start();
	}
	
	//启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}
	//接受连接并处理
	public void receive() {
		try {
			Socket clientsSocket = serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			//获取请求协议
			Request request = new Request(clientsSocket);
			//获取响应协议
			Response response = new Response(clientsSocket);
			Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
			
			if (null != servlet) {
				servlet.service(request, response);
				response.pushToBrowser(200);
			}else {
				//错误
				response.pushToBrowser(404);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端连接失败");
		}
	}
	
	//停止服务
	public void stop() {
		
	}
}
