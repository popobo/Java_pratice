package com.bo.thread;

/**
 * 创建线程方式二：
 * 1、创建：实现Runnable+重写run
 * 2、启动：创建实现类对象+Thread对象+start
 * 
 * 推荐：避免单继承的局限性，优先使用接口
 * 方便共享资源
 * @author 33136
 *
 */

public class StartRun implements Runnable {
	/**
	 * 线程入口点
	 */
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("singing");
		}
	}
	public static void main(String[] args) {
		//创建子类对象
//		StartThread st = new StartThread();
		//创建代理类对象
//		Thread thread = new Thread(st);
		//启动
//		thread.start();//不保证立即运行CPU调用
		
		new Thread(new StartRun()).start();
		
		for (int i = 0; i < 200; i++) {
			System.out.println("coding");
		}
	}
}
