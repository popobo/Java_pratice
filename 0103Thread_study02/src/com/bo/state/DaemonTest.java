package com.bo.state;

/**
 * �ػ��߳�:��Ϊ���û��̷߳����, jvmֹͣ���õȴ��ػ��߳�ִ�����
 * Ĭ��:�û��߳�jvm�ȴ��û��߳�ִ����ϲŻ�ֹͣ
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