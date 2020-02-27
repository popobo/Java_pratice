package com.bo.thread;

/**
 * Lambda���ʽ ���̣߳���һ�Σ���ʹ��
 * @author 33136
 *
 */

public class LambdaThread {
	//��̬�ڲ���
	static class Test implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 200; i++) {
				System.out.println("listening to songs1");
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Test()).start();
		
		//�ڲ��ֲ���
		class Test2 implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					System.out.println("listening to songs2");
				}
			}
		}
		new Thread(new Test2()).start();
		
		//�����ڲ��� ��������ӿڻ��߸���
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("listening to songs3");
			}
		}).start();
		
		//jdk8��lambda���ʽ
		new Thread(()->{
			for (int i = 0; i < 200; i++) {
				System.out.println("listening to songs4");
			}
		}).start();;
	}
}
