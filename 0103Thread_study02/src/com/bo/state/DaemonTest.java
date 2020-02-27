package com.bo.state;

/**
 * 守护线程:是为了用户线程服务的, jvm停止不用等待守护线程执行完毕
 * 默认:用户线程jvm等待用户线程执行完毕才会停止
 * 
 * @author 33136
 *
 */
public class DaemonTest {
	public static void main(String[] args) {
		new Thread(new You()).start();
		Thread thread = new Thread(new God());
		thread.setDaemon(true);
		thread.start();
	}
}

class You implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 365*100; i++) {
			System.out.println("happy live...");
		}
		System.out.println("dust");
	}
}

class God implements Runnable {
	@Override
	public void run() {
		for(;true;) {
			System.out.println("bless you");
		}
	}
}