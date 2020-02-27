package com.bo.state;

/**
 * 其他方法
 * isAlive:线程是否还活着
 * Thread.currentThread()当前线程
 * setName, getName代理线程
 * 
 * @author 33136
 *
 */
public class InfoTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		
		//设置名称:真实角色+代理角色
		MyInfo info = new MyInfo("战斗机");
		Thread thread = new Thread(info);
		thread.setName("公鸡");
		Thread.sleep(1000);
		System.out.println(thread.isAlive());
	}
}

class MyInfo implements Runnable {
	private String name;
	
	public MyInfo(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-->" + name);
	}
}