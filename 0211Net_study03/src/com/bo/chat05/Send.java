package com.bo.chat05;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *  * 使用多线程封装:接收端
 * 1、发送消息
 * 2、从控制台获取消息
 * 3、释放资源
 * 4、重写run
 * 
 * @author 33136
 *
 */

public class Send implements Runnable {
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private String name;
	private boolean isRunning;
	public Send(Socket client, String name) {
		this.client = client;
		this.name = name;
		console = new BufferedReader(new InputStreamReader(System.in));
		this.isRunning = true;
		try {
			dos = new DataOutputStream(client.getOutputStream());
			//发送名称
			send(name);
		} catch (IOException e) {
			e.printStackTrace();
			release();
		}
	}
	
	private String getStrFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
			release();
		}
	}
	
	@Override
	public void run() {
		while(isRunning) {
			String msg = getStrFromConsole();
			if (!msg.equals("")) {
				send(msg);
			}
		}
	}
	
	//释放资源
	private void release() {
		this.isRunning = false;
		Utils.close(dos, client);
	}
}
