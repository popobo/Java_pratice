package com.bo.thread;

/**
 * Lambda表达式 简化线程（用一次）的使用
 * @author 33136
 *
 */

public class LambdaThread {
	//静态内部类
	static class Test implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 200; i++) {
				System.out.println("listening to songs1");
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Test()).start();
		
		//内部局部类
		class Test2 implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					System.out.println("listening to songs2");
				}
			}
		}
		new Thread(new Test2()).start();
		
		//匿名内部类 必须借助接口或者父类
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("listening to songs3");
			}
		}).start();
		
		//jdk8简化lambda表达式
		new Thread(()->{
			for (int i = 0; i < 200; i++) {
				System.out.println("listening to songs4");
			}
		}).start();;
	}
}
