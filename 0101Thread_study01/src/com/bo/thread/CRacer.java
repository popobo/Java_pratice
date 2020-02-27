package com.bo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ģ���������
 * 
 * @author 33136
 *
 */
public class CRacer implements Callable<Integer> {
	private String winner;
	
	@Override
	public Integer call() throws Exception {
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
		return null;
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
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CRacer racer = new CRacer();
		//����ִ�з���
		ExecutorService service = Executors.newFixedThreadPool(2);
		//�ύִ��
		Future<Integer> result1 = service.submit(racer);
		Future<Integer> result2 = service.submit(racer);
		//��ȡ���
		Integer r1 = result1.get();
		Integer r2 = result2.get();
		System.out.println(r1 + "-->" + r2);
		//�رշ���
		service.shutdownNow();
		
	}
}