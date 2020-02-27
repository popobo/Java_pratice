package com.bo.thread;

public class LambdaTest04 {
	public static void main(String[] args) {
		new Thread(()->{
			for (int i = 0; i < 200; i++) {
				System.out.println("studying lambda");
			}
		}).start();
		
		new Thread(()->{
			for (int i = 0; i < 200; i++) {
				System.out.println("studying others");
			}
		}).start();
		
		new Thread(()->System.out.println("collapsing")).start(); 
	} 
}
