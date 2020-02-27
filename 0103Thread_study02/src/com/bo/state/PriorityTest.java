package com.bo.state;

/**
 * 线程的优先级 1-10
 * 1. NORM_PRIORITY 5 默认
 * 2. MIN_PRIORITY 1
 * 3. MAX_PRIORITY 10
 * 概率, 不代表绝对的先后顺序
 * @author 33136
 *
 */

public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());
		
		MyPriority myPriority = new MyPriority();
		
		Thread t1 = new Thread(myPriority, "adidas");
		Thread t2 = new Thread(myPriority, "NIKE");
		Thread t3 = new Thread(myPriority, "回力");
		Thread t4 = new Thread(myPriority, "李宁");
		Thread t5 = new Thread(myPriority, "puma");
		
		//设置优先级在启动前
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

class MyPriority implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
		Thread.yield();
	}
}