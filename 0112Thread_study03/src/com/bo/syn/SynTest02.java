package com.bo.syn;

/**
  * �̰߳�ȫ: �ڲ���ʱ��֤���ݵ���ȷ�ԡ�Ч�ʾ����ܸ�
 * synchronized
 * 1��ͬ������
 * 2��ͬ���� 
 * @author 33136
 *
 */

public class SynTest02 {
	public static void main(String[] args) {
		//�˻�
		Account account = new Account(100, "������");
		SafeDrawing you = new SafeDrawing(account, 80, "you");
		SafeDrawing she = new SafeDrawing(account, 80, "she");
		you.start();
		she.start();
	}
}

//ģ����
class SafeDrawing extends Thread {
	Account account;//ȡǮ���˻�
	int SafeDrawingMoney;//ȡ��Ǯ��
	int packetTotal;//�ڴ�������
	
	public SafeDrawing(Account account, int SafeDrawingMoney, String name) {
		super(name);
		this.account =account;
		this.SafeDrawingMoney = SafeDrawingMoney;
	}
	
	
	@Override
	public void run() {
		test();
	}
	
	//Ŀ�겻������ʧ��, ���ﲻ����this, Ӧ������account
	public synchronized void test() {
		if (account.money - SafeDrawingMoney < 0) {
			return;
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.money -= SafeDrawingMoney;
		packetTotal += SafeDrawingMoney;
		System.out.println(this.getName() + "-->�˻����Ϊ:" + account.money);
		System.out.println(this.getName() + "-->�ڴ���ǮΪ:" + packetTotal);
	}
}