package com.bo.state;

/**
 * join:合并线程，插队线程
 * @author 33136
 *
 */

public class BlockedJoin02 {
	public static void main(String[] args) {
		new Thread(new Father()).start();
	}
}

class Father implements Runnable {
	@Override
	public void run() {
		System.out.println("想抽烟，发现没有了");
		System.out.println("让儿子去买中华");
		Thread thread = new Thread(new Son());
		thread.start();
		try {
			thread.join();//father被阻塞了
			System.out.println("");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("出错了");
		}
	}
}

class Son implements Runnable {
	@Override
	public void run() {
		System.out.println("接过老爸的钱出去了。。。");
		System.out.println("路边有个游戏厅，玩了10秒");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "秒过去了");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("赶紧买烟去。。。");
		System.out.println("手拿一包中华回家了");
	}
} 