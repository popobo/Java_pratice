package com.bo.syn;

/**
 * 线程不安全:数据有负数, 相同
 * 
 * @author 33136
 *
 */

public class UnsafeTest01 {
	public static void main(String[] args) {
		//一份资源
		UnSafeWeb12306 web12306 = new UnSafeWeb12306();
		//多个代理
		new Thread(web12306, "a").start();
		new Thread(web12306, "b").start();
		new Thread(web12306, "c").start();
	}

}

class UnSafeWeb12306 implements Runnable{
	//票数
	private int ticketNumber = 10;
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			test();
		}
	}
	
	public void test() {
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
