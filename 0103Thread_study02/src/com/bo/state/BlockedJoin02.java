package com.bo.state;

/**
 * join:�ϲ��̣߳�����߳�
 * @author 33136
 *
 */

public class BlockedJoin02 {
	public static void main(String[] args) {
		new Thread(new Father()).start();
	}
}

class Father implements Runnable {
	@Override
	public void run() {
		System.out.println("����̣�����û����");
		System.out.println("�ö���ȥ���л�");
		Thread thread = new Thread(new Son());
		thread.start();
		try {
			thread.join();//father��������
			System.out.println("");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("������");
		}
	}
}

class Son implements Runnable {
	@Override
	public void run() {
		System.out.println("�ӹ��ϰֵ�Ǯ��ȥ�ˡ�����");
		System.out.println("·���и���Ϸ��������10��");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "���ȥ��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�Ͻ�����ȥ������");
		System.out.println("����һ���л��ؼ���");
	}
} 