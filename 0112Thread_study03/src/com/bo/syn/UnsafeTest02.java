package com.bo.syn;

/**
 * �̲߳���ȫ:ȡǮ
 * 
 * @author 33136
 *
 */

public class UnsafeTest02 {
	public static void main(String[] args) {
		//�˻�
		Account account = new Account(100, "������");
		Drawing you = new Drawing(account, 80, "you");
		Drawing she = new Drawing(account, 80, "she");
		you.start();
		she.start();
	}
}

//ģ����
class Drawing extends Thread {
	Account account;//ȡǮ���˻�
	int drawingMoney;//ȡ��Ǯ��
	int packetTotal;//�ڴ�������
	
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account =account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		if (account.money - drawingMoney < 0) {
			return;
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.money -= drawingMoney;
		packetTotal += drawingMoney;
		System.out.println(this.getName() + "-->�˻����Ϊ:" + account.money);
		System.out.println(this.getName() + "-->�ڴ���ǮΪ:" + packetTotal);
	}
}