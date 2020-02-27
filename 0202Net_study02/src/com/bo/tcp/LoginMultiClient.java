package com.bo.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 模拟登录  多个客户端请求
 * 创建客户端
 * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 * 2、操作: 输入输出流操作
 * 3、释放资源 
 * @author 
 *
 */

public class LoginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("---client---");
		//1、建立连接：使用Socket创建客户端 + 服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		//2、操作：输入输出流操作，先请求后响应
		new Send(client).send();
		new Receive(client).reveice();
		client.close();
	}
	//发送
	static class Send{
		private Socket client;
		private DataOutputStream dos;
		private BufferedReader console;
		private String msg;
		public Send(Socket client) {
			console = new BufferedReader(new InputStreamReader(System.in));
			
		}
		private String init() {
			try {
				System.out.print("请输入用户名：");
				String username = console.readLine();
				System.out.println("请输入密码：");
				String password = console.readLine();
				return "username=" + username + "&" + "password=" + password; 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ""; 
		}
		
		private void send() {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//接收
	static class Receive{
		private Socket client;
		private DataInputStream dis;
		public Receive(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void reveice() {
			String result;
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
