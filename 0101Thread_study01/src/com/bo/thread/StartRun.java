package com.bo.thread;

/**
 * �����̷߳�ʽ����
 * 1��������ʵ��Runnable+��дrun
 * 2������������ʵ�������+Thread����+start
 * 
 * �Ƽ������ⵥ�̳еľ����ԣ�����ʹ�ýӿ�
 * ���㹲����Դ
 * @author 33136
 *
 */

public class StartRun implements Runnable {
	/**
	 * �߳���ڵ�
	 */
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("singing");
		}
	}
	public static void main(String[] args) {
		//�����������
//		StartThread st = new StartThread();
		//�������������
//		Thread thread = new Thread(st);
		//����
//		thread.start();//����֤��������CPU����
		
		new Thread(new StartRun()).start();
		
		for (int i = 0; i < 200; i++) {
			System.out.println("coding");
		}
	}
}
