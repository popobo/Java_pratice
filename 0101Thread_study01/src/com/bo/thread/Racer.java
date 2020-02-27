package com.bo.thread;
/**
 * ģ���������
 * 
 * @author 33136
 *
 */
public class Racer implements Runnable {
	private String winner;
	
	@Override
	public void run() {
		for (int steps = 0; steps <= 10000; steps++) {
			//ģ����Ϣ
			if (Thread.currentThread().getName().equals("rabbit") && steps%10 == 0 ) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "-->" + steps);
			//�����Ƿ����
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
		Racer racer = new Racer();
		new Thread(racer, "tortoise").start();
		new Thread(racer, "rabbit").start();
	}
}
