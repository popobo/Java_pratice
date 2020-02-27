package com.bo.state;

/**
 * join:�ϲ��̣߳�����߳�
 * @author 33136
 *
 */

public class BlockedJoin01 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda..." + i);
			}
		});
		thread.start();
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				thread.join();//���main������
			}
			System.out.println("main..." + i);
		}
	}
}
