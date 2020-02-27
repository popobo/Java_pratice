package com.bo.syn;

/**
 * 线程安全:在并发时保证数据的正确性, 效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块, 目标明确
 * @author 33136
 *
 */

public class SynBlockTest03 {
	public static void main(String[] args) {
		//一份资源
		SynBlock12306 web12306 = new SynBlock12306();
		//多个代理
		new Thread(web12306, "a").start();
		new Thread(web12306, "b").start();
		new Thread(web12306, "c").start();
	}

}

class SynBlock12306 implements Runnable{
	//票数
	private int ticketNumber = 1000;
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			test5();
		}
	}
	
	//线程安全:尽可能锁定合理的范围(不是指代码, 指数据的完整性)
	//double checking
	public void test5() {
		if (ticketNumber <= 0) { //考虑的是没有票的情况
			flag = false;
			return;
		}
		
		synchronized (this) {//考虑的是最后的一张票
			if (ticketNumber <= 0) {
				flag = false;
				return;
			}
			
			//模拟延时
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
		}
		
	}
	
	public void test4() {
		synchronized (this) {
			if (ticketNumber <= 0) {
				flag = false;
				return;
			}
		}

		//模拟延时
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
	}
	
	//线程不安全 ticketNumber在变
	public void test3() {
		synchronized ((Integer)ticketNumber) {
			if (ticketNumber <= 0) {
				flag = false;
				return;
			}
			
			//模拟延时
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
		}
	}
	
	//线程范围太大, 范围太大 --> 效率低下
	public void test2() {
		synchronized (this) {
			if (ticketNumber <= 0) {
				flag = false;
				return;
			}
			
			//模拟延时
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
		}
		
	}
	
	//线程安全同步
	public synchronized void test1() {
		if (ticketNumber <= 0) {
			flag = false;
			return;
		}
		
		//模拟延时
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
	}
}
