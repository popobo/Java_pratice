package com.bo.state;

/**
 * ��ֹ�߳�
 * 1. �߳�����ִ�����-->����
 * 2. �ⲿ����-->�����ʶ
 * ��Ҫʹ��stop destroy
 * @author 33136
 *
 */

public class TerminateThread implements Runnable {
	//1. �����ʶ. ����߳����Ƿ��������
	private boolean flag = true;
	private String name;
	
	public TerminateThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		int i = 0;
		//2. ������ʶ, true-->���� false-->ֹͣ
		while(flag) {
			System.out.println(name + "-->" + i++);
		}
	}
	
	//3. �����ṩ�����ı��ʶ
	public void terminate() {
		this.flag = false;
	}
	
	public static void main(String[] args) {
		TerminateThread terminateThread = new TerminateThread("C��");
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