package com.bo.syn;

/**
 * ����: �����ͬ����������໥���ͷ���Դ
 * �Ӷ��໥�ȴ���һ�㷢����ͬ���г��ж���������
 * 
 * ����: ��Ҫ��ͬһ��������У�ͬʱ���ж���������
 * 
 * @author 33136
 *
 */

public class DeadLock {
	public static void main(String[] args) {
		Makeup g1 = new Makeup(1, "a");
		Makeup g2 = new Makeup(0, "b");
		g1.start();
		g2.start();
	}
}

//�ں�
class Libstick {
	
}

//����
class Mirror {
	
}

//��ױ
class Makeup extends Thread {
	static Libstick libstick = new Libstick();
	static Mirror mirror = new Mirror();
	
	//ѡ��
	int choice;
	//����
	String girl;
	public Makeup(int choice, String girl) {
		this.choice = choice;
		this.girl = girl;
	}
	
	@Override
	public void run() {
		//��ױ
		makeup();
	}
	
	//�໥���жԷ��Ķ�����-->�����������
	private void makeup() {
		if (0 == choice) {
			synchronized (libstick) {//��ÿں����
				System.out.println(this.girl + "Ϳ�ں�");
				//1�����ӵ�о��ӵ���
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (mirror) {
//					System.out.println(this.girl + "�վ���");
//				}
			}
			synchronized (mirror) {
				System.out.println(this.girl + "�վ���");
			}
		} else {
			synchronized (mirror) {//��þ��ӵ���
				System.out.println(this.girl + "Ϳ����");
				//1�����ӵ�пں����
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (libstick) {
//					System.out.println(this.girl + "Ϳ�ں�");
//				}
			}
			synchronized (libstick) {
				System.out.println(this.girl + "Ϳ�ں�");
			}
		}
	}
}