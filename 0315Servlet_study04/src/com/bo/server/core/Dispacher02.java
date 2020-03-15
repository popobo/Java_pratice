package com.bo.server.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Dispacher02 implements Runnable {
	private Socket clientdSocket;
	private Request request;
	private Response response;
	
	public Dispacher02(Socket clientdSocket) {
		this.clientdSocket = clientdSocket;
		try {
			//获取请求协议
			request = new Request(clientdSocket);
			response = new Response(clientdSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		try {
			if (null == request.getUrl() || request.getUrl().equals("")) {
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				response.print((new String(is.readAllBytes())));
				response.pushToBrowser(200);
				is.close();
				return;
			}
			Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
			if (null != servlet) {
				servlet.service(request, response);
				response.pushToBrowser(200);
			}else {
				//错误
				InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				response.print((new String(is.readAllBytes())));
				response.pushToBrowser(404);
			}
		} catch (Exception e) {
			
			try {
				response.println("Bad Error");
				response.pushToBrowser(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//释放资源
	private void release() {
		try {
			clientdSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
