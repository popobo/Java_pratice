package com.bo.state;

import com.bo.state.BlockSleep01;

/**
 * sleep模拟网络延时, 放大了发生问题的可能性
 * 
 * @author 33136
 *
 */

public class BlockSleep01 implements Runnable {
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
		BlockSleep01 BlockSleep01 = new BlockSleep01();
		System.out.println(Thread.currentThread().getName());
		
		//多个代理
		new Thread(BlockSleep01, "a").start();
		new Thread(BlockSleep01, "b").start();
		new Thread(BlockSleep01, "c").start();
	}
}
