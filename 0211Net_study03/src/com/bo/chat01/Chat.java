package com.bo.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 单向
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作: 输入输出流操作
 * 4、释放资源 
 * @author bo
 *
 */

public class Chat {
	public static void main(String[] args) throws IOException {
		System.out.println("---server---");
		//1、指定端口 使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		//2、阻塞式等待连接 accept
		Socket client = server.accept();
		System.out.println("A client has been accepted!");
		//3、操作:输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String str = dis.readUTF();
		//分析
		String[] strArray = str.split("&");
		for(String temp:strArray) {
			String[] userInfo = temp.split("=");
			if (userInfo[0].equals("username")) {
				System.out.println("username is " + userInfo[1]);
			}else if (userInfo[0].equals("password")) {
				System.out.println("password is " + userInfo[1]);
			}
		}
		//4、释放资源
		dis.close();
		client.close();
		server.close();
	}
}
