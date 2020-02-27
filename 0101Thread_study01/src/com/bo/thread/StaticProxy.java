package com.bo.thread;

/**
 * 静态代理
 * 公共接口：
 * 1、真实角色
 * 2、代理角色
 * 
 * @author 33136
 *
 */

public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
	}
}

//真实角色
interface Marry {
	void happyMarry();
}

//真实角色
class You implements Marry {
	
	@Override
	public void happyMarry() {
		System.out.println("you and she get married");
	}
}

//代理角色
class WeddingCompany implements Marry {
	//真实角色
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