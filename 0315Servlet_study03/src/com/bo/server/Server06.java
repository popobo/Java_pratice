package com.bo.server;

/**
 * 目标:加入了Servlet解耦了业务代码
 * 
 * @author bo
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server06 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server06 server06 = new Server06();
		server06.start();
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
			
			Response response = new Response(clientsSocket);
			
			Servlet servlet = null;
			
			if (request.getUrl().equals("login")) {
				servlet = new LoginServlet();
			}else if (request.getUrl().equals("reg")) {
				servlet = new RegisterServlet();
			}else {
				//首页
			}
			
			servlet.service(request, response);
			//关注了状态码
			response.pushToBrowser(200);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端连接失败");
		}
	}
	
	//停止服务
	public void stop() {
		
	}
}
