package com.bo.state;

import com.bo.state.BlockSleep02;

/**
 * sleep模拟休息
 * 
 * @author 33136
 *
 */
public class BlockSleep02 implements Runnable {
	private String winner;
	
	@Override
	public void run() {
		for (int steps = 0; steps <= 10000; steps++) {
			//模拟休息
			if (Thread.currentThread().getName().equals("rabbit") && steps%10 == 0 ) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "-->" + steps);
			//比赛是否结束
			boolean flag = gameOver(steps);
			if (flag) {
				break;
			}
		}
	}
	
	private boolean gameOver(int steps) {
		if (winner != null) {
			return true;
		}else {
			if (steps == 10000) {
				winner = Thread.currentThread().getName();
				System.out.println("winner-->" + winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		BlockSleep02 BlockSleep02 = new BlockSleep02();
		new Thread(BlockSleep02, "tortoise").start();
		new Thread(BlockSleep02, "rabbit").start();
	}
}
