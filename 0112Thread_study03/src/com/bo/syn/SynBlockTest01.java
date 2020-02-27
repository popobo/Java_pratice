package com.bo.syn;

/**
 * 线程安全:在并发时保证数据的正确性, 效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块, 目标明确
 * @author 33136
 *
 */

public class SynBlockTest01 {
	public static void main(String[] args) {
		//账户
		Account account = new Account(100, "结婚礼金");
		SynDrawing you = new SynDrawing(account, 80, "you");
		SynDrawing she = new SynDrawing(account, 80, "she");
		you.start();
		she.start();
	}
}

//模拟存款
class SynDrawing extends Thread {
	Account account;//取钱的账户
	int drawingMoney;//取得钱数
	int packetTotal;//口袋的总数
	
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
		//提高性能
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
			System.out.println(this.getName() + "-->账户余额为:" + account.money);
			System.out.println(this.getName() + "-->口袋的钱为:" + packetTotal);
		}		
	}
}