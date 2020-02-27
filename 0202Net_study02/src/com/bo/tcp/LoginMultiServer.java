package com.bo.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 多个客户端请求
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作: 输入输出流操作
 * 4、释放资源 
 * @author
 *
 */

public class LoginMultiServer {
	public static void main(String[] args) throws IOException {
		System.out.println("---server---");
		//1、指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		boolean isRunning = true;
		//2、阻塞式等待连接accept
		while(isRunning) {
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start();;
		}
		server.close();
	}
	
	//一个channel就代表一个客户端
	static class Channel implements Runnable{
		private Socket client;
		//输入流
		private DataInputStream dis;
		//输出流
		private DataOutputStream dos;
		public Channel(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
		}
		
		@Override
		public void run() {
			//3、操作：输入输出流操作
			String username = "";
			String password = "";
			//分析
			String[] strArray = receive().split("&");
			for(String info:strArray) {
				String[] userInfo = info.split("=");
				if (userInfo[0].equals("username")) {
					System.out.println("username:" + userInfo[1]);
					username = userInfo[1];
				}else if(userInfo[0].equals("password")) {
					System.out.println("password:" + userInfo[1]);
					password = userInfo[1];
				}
			}
			if (username.equals("bo") && password.equals("123")) {
				send("登陆成功");
			}else {
				send("登陆失败");
			}
		}
		
		//接受数据
		private String receive() {
			String str = "";
			try {
				str = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
		}
		//发送数据
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//释放资源
		private void release() {
			// 4、释放资源 
			try {
				if(null != dos) {
					dos.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(null != dis) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(null != client) {
					client.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
