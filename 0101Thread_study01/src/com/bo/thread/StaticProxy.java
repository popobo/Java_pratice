package com.bo.thread;

/**
 * ��̬����
 * �����ӿڣ�
 * 1����ʵ��ɫ
 * 2�������ɫ
 * 
 * @author 33136
 *
 */

public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
	}
}

//��ʵ��ɫ
interface Marry {
	void happyMarry();
}

//��ʵ��ɫ
class You implements Marry {
	
	@Override
	public void happyMarry() {
		System.out.println("you and she get married");
	}
}

//�����ɫ
class WeddingCompany implements Marry {
	//��ʵ��ɫ
	private Marry real;
	
	public WeddingCompany(Marry real) {
		super();
		this.real = real;
	}
	
	public void prepare() {
		System.out.println("preparing");
	}

	public void after() {
		System.out.println("sleep");
	}
	
	@Override
	public void happyMarry() {
		prepare();
		real.happyMarry();
		after();
	}
}