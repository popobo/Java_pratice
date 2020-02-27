package com.bo.thread;

/**
 * 创建线程方式一：
 * 1、创建：继承Thread + 重写run
 * 2、启动：创建子类对象 + start
 * @author 33136
 *
 */
public class StartThread extends Thread{
	/**
	 * 线程入口点
	 */
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("singing");
		}
	}
	public static void main(String[] args) {
		//创建子类对象
		StartThread st = new StartThread();
		//启动
		st.start();//不保证立即运行CPU调用
		//st.run(); 普通方法调用
		for (int i = 0; i < 20; i++) {
			System.out.println("coding");
		}
	}
}
