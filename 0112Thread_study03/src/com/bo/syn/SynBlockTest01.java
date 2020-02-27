package com.bo.syn;

/**
 * �̰߳�ȫ:�ڲ���ʱ��֤���ݵ���ȷ��, Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����, Ŀ����ȷ
 * @author 33136
 *
 */

public class SynBlockTest01 {
	public static void main(String[] args) {
		//�˻�
		Account account = new Account(100, "������");
		SynDrawing you = new SynDrawing(account, 80, "you");
		SynDrawing she = new SynDrawing(account, 80, "she");
		you.start();
		she.start();
	}
}

//ģ����
class SynDrawing extends Thread {
	Account account;//ȡǮ���˻�
	int drawingMoney;//ȡ��Ǯ��
	int packetTotal;//�ڴ�������
	
	public SynDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account =account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		test();
	}
	
	public void test() {
		//�������
		if (account.money <= 0) {
			return;
		}
		synchronized (account) {
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
}