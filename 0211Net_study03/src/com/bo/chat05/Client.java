package com.bo.chat05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 在线聊天室
 * 目标：私聊
 * 
 * @author 33136
 *
 */

public class Client {
	public static void main(String[] args) throws IOException {
		System.out.println("----client----");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String name = br.readLine();
		System.out.println("用户名：" + name);
		//1、建立连接：使用Socket创建客户端+服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		//2、客户端发送消息
		new Thread(new Send(client, name)).start();
		new Thread(new Receive(client)).start();
	}
}
