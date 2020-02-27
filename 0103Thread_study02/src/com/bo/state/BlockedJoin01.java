package com.bo.state;

/**
 * join:合并线程，插队线程
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
				thread.join();//插队main被阻塞
			}
			System.out.println("main..." + i);
		}
	}
}
