package com.bo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 模拟龟兔赛跑
 * 
 * @author 33136
 *
 */
public class CRacer implements Callable<Integer> {
	private String winner;
	
	@Override
	public Integer call() throws Exception {
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
		//创键执行服务
		ExecutorService service = Executors.newFixedThreadPool(2);
		//提交执行
		Future<Integer> result1 = service.submit(racer);
		Future<Integer> result2 = service.submit(racer);
		//获取结果
		Integer r1 = result1.get();
		Integer r2 = result2.get();
		System.out.println(r1 + "-->" + r2);
		//关闭服务
		service.shutdownNow();
		
	}
}