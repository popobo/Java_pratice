package com.bo.syn;

/**
 * 线程安全:在并发时保证数据的正确性, 效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块, 目标明确
 * 
 * @author 33136
 *
 */

public class SynTest01 {
	public static void main(String[] args) {
		//一份资源
		SafeWeb12306 web12306 = new SafeWeb12306();
		//多个代理
		new Thread(web12306, "a").start();
		new Thread(web12306, "b").start();
		new Thread(web12306, "c").start();
	}

}

class SafeWeb12306 implements Runnable{
	//票数
	private int ticketNumber = 10;
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			test();
		}
	}
	
	//线程安全同步
	public synchronized void test() {
		if (ticketNumber <= 0) {
			flag = false;
			return;
		}
		
		//模拟延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
	}
}
