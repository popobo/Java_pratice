package com.bo.thread;

/**
 * 共享资源，并发（线程安全）
 * 
 * @author 33136
 *
 */

public class Web12306 implements Runnable {
	//票数
	private int ticketNums = 99;
	
	@Override
	public void run() {
		while(true) {
			if (ticketNums < 0) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + ticketNums);
			ticketNums--;
		}
	}
	public static void main(String[] args) {
		//一份资源
		Web12306 web12306 = new Web12306();
		System.out.println(Thread.currentThread().getName());
		
		//多个代理
		new Thread(web12306, "a").start();
		new Thread(web12306, "b").start();
		new Thread(web12306, "c").start();
	}
}
