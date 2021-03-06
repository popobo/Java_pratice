package com.bo.chat05;

import java.io.DataInputStream;
import java.net.Socket;

/**
 * 使用多线程封装:接收端
 * 1、发送消息
 * 2、从控制台获取消息
 * 3、释放资源
 * 4、重写run
 * 
 * @author 33136
 *
 */

public class Receive implements Runnable {
	private DataInputStream dis;
	private Socket client;
	private boolean isRuning;
	public Receive(Socket client) {
		this.client = client;
		this.isRuning = true;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (Exception e) {
			System.out.println("====2====");
			release();
		}
	}
	
	//接收消息
	private String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (Exception e) {
			System.out.println("====4====");
			release();
		}
		return msg;
	}
	
	@Override
	public void run() {
		while(isRuning) {
			String msg = receive();
			if (!msg.equals("")) {
				System.out.println(msg);
			}
		}
	}
	//释放资源
	private void release() {
		this.isRuning = false;
		Utils.close(client, dis);
	}
}
