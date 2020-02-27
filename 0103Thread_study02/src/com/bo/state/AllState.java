package com.bo.state;

import java.lang.Thread.State;

public class AllState {
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("......");
			}
		});
		//�۲�״̬
		State state = thread.getState();
		System.out.println(state);//NEW
		
		thread.start();
		state = thread.getState();//RUNABLE
		System.out.println(state);
		
//		while(state != Thread.State.TERMINATED) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			state = thread.getState();//TIMED_WATTING
//			System.out.println(state);
//		}
//		state = thread.getState();//TERMINATED
//		System.out.println(state);
		while(true) {
			//����߳���
			int num = Thread.activeCount();
			if (1 == num) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			state = thread.getState();//TIMED_WATTING
			System.out.println(state);
		}
	}
}
