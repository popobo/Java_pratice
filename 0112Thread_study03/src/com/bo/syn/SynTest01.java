package com.bo.syn;

/**
 * �̰߳�ȫ:�ڲ���ʱ��֤���ݵ���ȷ��, Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����, Ŀ����ȷ
 * 
 * @author 33136
 *
 */

public class SynTest01 {
	public static void main(String[] args) {
		//һ����Դ
		SafeWeb12306 web12306 = new SafeWeb12306();
		//�������
		new Thread(web12306, "a").start();
		new Thread(web12306, "b").start();
		new Thread(web12306, "c").start();
	}

}

class SafeWeb12306 implements Runnable{
	//Ʊ��
	private int ticketNumber = 10;
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			test();
		}
	}
	
	//�̰߳�ȫͬ��
	public synchronized void test() {
		if (ticketNumber <= 0) {
			flag = false;
			return;
		}
		
		//ģ����ʱ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
	}
}
