package com.bo.syn;

/**
 * �̰߳�ȫ:�ڲ���ʱ��֤���ݵ���ȷ��, Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����, Ŀ����ȷ
 * @author 33136
 *
 */

public class SynBlockTest03 {
	public static void main(String[] args) {
		//һ����Դ
		SynBlock12306 web12306 = new SynBlock12306();
		//�������
		new Thread(web12306, "a").start();
		new Thread(web12306, "b").start();
		new Thread(web12306, "c").start();
	}

}

class SynBlock12306 implements Runnable{
	//Ʊ��
	private int ticketNumber = 1000;
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			test5();
		}
	}
	
	//�̰߳�ȫ:��������������ķ�Χ(����ָ����, ָ���ݵ�������)
	//double checking
	public void test5() {
		if (ticketNumber <= 0) { //���ǵ���û��Ʊ�����
			flag = false;
			return;
		}
		
		synchronized (this) {//���ǵ�������һ��Ʊ
			if (ticketNumber <= 0) {
				flag = false;
				return;
			}
			
			//ģ����ʱ
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
		}
		
	}
	
	public void test4() {
		synchronized (this) {
			if (ticketNumber <= 0) {
				flag = false;
				return;
			}
		}

		//ģ����ʱ
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
	}
	
	//�̲߳���ȫ ticketNumber�ڱ�
	public void test3() {
		synchronized ((Integer)ticketNumber) {
			if (ticketNumber <= 0) {
				flag = false;
				return;
			}
			
			//ģ����ʱ
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
		}
	}
	
	//�̷߳�Χ̫��, ��Χ̫�� --> Ч�ʵ���
	public void test2() {
		synchronized (this) {
			if (ticketNumber <= 0) {
				flag = false;
				return;
			}
			
			//ģ����ʱ
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
		}
		
	}
	
	//�̰߳�ȫͬ��
	public synchronized void test1() {
		if (ticketNumber <= 0) {
			flag = false;
			return;
		}
		
		//ģ����ʱ
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + ticketNumber--);
	}
}
