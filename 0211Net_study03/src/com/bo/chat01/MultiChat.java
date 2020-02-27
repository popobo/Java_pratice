package com.bo.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室: 服务器
 * 目标: 实现一个客户可以正常收发多条消息 
 * 
 * @author bo
 *
 */
public class MultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("-----Server-----");
		// 1、指定端口 使用ServerSocket创建服务器
		ServerSocket server =new ServerSocket(8888);
		// 2、阻塞式等待连接 accept
		Socket  client =server.accept(); 
		System.out.println("一个客户端建立了连接");
		
		DataInputStream dis =new DataInputStream(client.getInputStream());
		DataOutputStream dos =new DataOutputStream(client.getOutputStream());		
		boolean isRunning = true;
		while(isRunning) {
			//3、接收消息
			String msg =dis.readUTF();
			//4、返回消息
			dos.writeUTF(msg);
			//释放资源
			dos.flush();
		}
		dos.close();
		dis.close();
		client.close();
	}
}
