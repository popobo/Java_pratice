package com.bo.cooperation;

/**
 * Э��ģ��:������������ʵ�ַ�ʽ��:�źŵƷ�
 * ������־λ
 * 
 * @author 33136
 *
 */

public class CoTest02 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		new Player(tv).start();
		new Watcher(tv).start();
	}
}

//������ ��Ա
class Player extends Thread {
	Tv tv;
	public Player(Tv tv) {
		this.tv = tv;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				this.tv.play("aaaa");
			} else {
				this.tv.play("bbbb");
			}
		}
	}
}

//������
class Watcher extends Thread {
	Tv tv;
	public Watcher(Tv tv) {
		this.tv = tv;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			this.tv.watch();;
		}
	}
}

//ͬһ����Դ ����
class Tv {
	String voice;
	//�źŵ�
	//T ��ʾ��Ա���� ���ڵȴ�
	//F ��ʾ���ڹۿ� ��Ա�ȵ�
	boolean flag = true;
	
	//����
	public synchronized void play(String voice) {
		//��Ա�ȴ�
		if (false == flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//����
		System.out.println("������:" + voice);
		this.voice = voice;
		//����
		this.notifyAll();
		//�л���־
		this.flag = !this.flag;
	}
	
	//�ۿ�
	public synchronized void watch() {
		//���ڵȴ�
		if (true == flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//�ۿ�
		System.out.println("�ۿ���:" + voice);
		//����
		this.notifyAll();
		//�л���־
		this.flag = !this.flag;
	}
}