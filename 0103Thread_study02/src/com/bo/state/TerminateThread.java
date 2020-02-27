package com.bo.state;

/**
 * 终止线程
 * 1. 线程正常执行完毕-->次数
 * 2. 外部干涉-->加入标识
 * 不要使用stop destroy
 * @author 33136
 *
 */

public class TerminateThread implements Runnable {
	//1. 加入标识. 标记线程体是否可以运行
	private boolean flag = true;
	private String name;
	
	public TerminateThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		int i = 0;
		//2. 关联标识, true-->运行 false-->停止
		while(flag) {
			System.out.println(name + "-->" + i++);
		}
	}
	
	//3. 对外提供方法改变标识
	public void terminate() {
		this.flag = false;
	}
	
	public static void main(String[] args) {
		TerminateThread terminateThread = new TerminateThread("C罗");
		Thread thread = new Thread(terminateThread);
		Thread thread2 = new Thread(terminateThread);
		thread.start();
		thread2.start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 88) {
				terminateThread.terminate();
				System.out.println("game over");
			}
			System.out.println("main-->" + i);
		}
		
//		Part part = new Part();
//		part.setFlag(false);
//		Total total = new Total(part);
//		System.out.println("total.part.flag --> " + total.part.flag);
//		part.setFlag(true);
//		System.out.println("total.part.flag --> " + total.part.flag);
	}
}


class Part {
	boolean flag;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

class Total {
	Part part;
	
	public Total(Part part) {
		this.part = part;
	}
}