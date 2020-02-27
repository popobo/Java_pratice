package com.bo.state;

/**
 * ��������
 * isAlive:�߳��Ƿ񻹻���
 * Thread.currentThread()��ǰ�߳�
 * setName, getName�����߳�
 * 
 * @author 33136
 *
 */
public class InfoTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		
		//��������:��ʵ��ɫ+�����ɫ
		MyInfo info = new MyInfo("ս����");
		Thread thread = new Thread(info);
		thread.setName("����");
		Thread.sleep(1000);
		System.out.println(thread.isAlive());
	}
}

class MyInfo implements Runnable {
	private String name;
	
	public MyInfo(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-->" + name);
	}
}