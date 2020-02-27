package com.bo.state;

/**
 * yield 礼让线程, 暂停线程, 直接进入就绪状态不是阻塞状态
 * @author 33136
 *
 */

public class YieldDemo01 {
	public static void main(String[] args) {
		MyYield myYield = new MyYield();
		new Thread(myYield, "a").start();
		new Thread(myYield, "b").start();
	}
}

class MyYield implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-->start");
		Thread.yield();
		System.out.println(Thread.currentThread().getName() + "-->end");
	}
}