package com.bo.syn;

/**
  * 线程安全: 在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块 
 * @author 33136
 *
 */

public class SynTest02 {
	public static void main(String[] args) {
		//账户
		Account account = new Account(100, "结婚礼金");
		SafeDrawing you = new SafeDrawing(account, 80, "you");
		SafeDrawing she = new SafeDrawing(account, 80, "she");
		you.start();
		she.start();
	}
}

//模拟存款
class SafeDrawing extends Thread {
	Account account;//取钱的账户
	int SafeDrawingMoney;//取得钱数
	int packetTotal;//口袋的总数
	
	public SafeDrawing(Account account, int SafeDrawingMoney, String name) {
		super(name);
		this.account =account;
		this.SafeDrawingMoney = SafeDrawingMoney;
	}
	
	
	@Override
	public void run() {
		test();
	}
	
	//目标不对锁定失败, 这里不是锁this, 应该锁定account
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
		System.out.println(this.getName() + "-->账户余额为:" + account.money);
		System.out.println(this.getName() + "-->口袋的钱为:" + packetTotal);
	}
}