package com.bo.chat05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在线聊天室:服务器
 * 
 * @author 33136
 *
 */


public class Server {
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
	
	public static void main(String[] args) throws IOException {
		System.out.println("---server---");
		//1、指定端口 使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		//2、阻塞式等待连接
		while(true) {
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			Channel c = new Channel(client);
			all.add(c);//管理所有成员
			new Thread(c).start();
 		}
	}
	//一个客户代表一个Channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name;
		public Channel(Socket client) {
			this.client = client;
			try {
				dos = new DataOutputStream(client.getOutputStream());
				dis = new DataInputStream(client.getInputStream());
				isRunning = true;
				//获取名称
				this.name = receive();
				this.send("欢迎您进入聊天室");
				sendOthers(this.name + "来到了聊天室", true);
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
			
 		}
		
		//接受消息
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
			return msg;
		}
		
		//发送消息
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
		}
		
		/**
		 * 群聊：获取自己的消息，发给其他人
		 * 私聊：约定数据格式：@xxx:msg
		 * 
		 */
		private void sendOthers(String msg, boolean isSys) {
			boolean isPrivate = msg.startsWith("@");
			if (isPrivate) {
				int idx = msg.indexOf(":");
				//获取目标和数据
				String targetName = msg.substring(1, idx);
				msg = msg.substring(idx + 1);
				for(Channel other:all) {
					if (other.name.equals(targetName)) {
						other.send(this.name + "悄悄地对您说" + msg);
						break;
					}
				}
			}
			else {
				for(Channel other:all) {
					if (isPrivate) {
						if (this == other) {
							continue;
						}
					}
					if (!isSys) {
						other.send(this.name + "对所有人说" + msg);//群聊消息
					}else {
						other.send(msg);
					}
				}
			}
		}
		
		
		//释放资源
		private void release() {
			this.isRunning = false;
			Utils.close(dis, dos, client);
			//退出
			all.remove(this);
			sendOthers(this.name + "离开聊天群", true);
		}
		
		@Override
		public void run() {
			while(isRunning) {
				String msg = receive();
				if (!msg.equals("")) {
					sendOthers(msg, false);
				}
			}
		}
	}
}
