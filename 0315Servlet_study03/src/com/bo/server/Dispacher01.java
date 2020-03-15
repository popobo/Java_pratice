package com.bo.server;

import java.io.IOException;
import java.net.Socket;

public class Dispacher01 implements Runnable {
	private Socket clientSocket;
	private Request request;
	private Response response;
	
	public Dispacher01(Socket clientSocket) {
		this.clientSocket = clientSocket;
		try {
			//获取请求协议
			request = new Request(clientSocket);
			response = new Response(clientSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		try {
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
		}
	}
	
	//释放资源
	private void release() {
		try {
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
