package com.bo.state;

import com.bo.state.BlockSleep01;

/**
 * sleepģ��������ʱ, �Ŵ��˷�������Ŀ�����
 * 
 * @author 33136
 *
 */

public class BlockSleep01 implements Runnable {
	//Ʊ��
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
		//һ����Դ
		BlockSleep01 BlockSleep01 = new BlockSleep01();
		System.out.println(Thread.currentThread().getName());
		
		//�������
		new Thread(BlockSleep01, "a").start();
		new Thread(BlockSleep01, "b").start();
		new Thread(BlockSleep01, "c").start();
	}
}
