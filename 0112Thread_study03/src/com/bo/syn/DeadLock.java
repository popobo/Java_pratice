package com.bo.syn;

/**
 * 死锁: 过多的同步可能造成相互不释放资源
 * 从而相互等待，一般发生于同步中持有多个对象的锁
 * 
 * 避免: 不要在同一个代码块中，同时持有多个对象的锁
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

//口红
class Libstick {
	
}

//镜子
class Mirror {
	
}

//化妆
class Makeup extends Thread {
	static Libstick libstick = new Libstick();
	static Mirror mirror = new Mirror();
	
	//选择
	int choice;
	//名字
	String girl;
	public Makeup(int choice, String girl) {
		this.choice = choice;
		this.girl = girl;
	}
	
	@Override
	public void run() {
		//化妆
		makeup();
	}
	
	//相互持有对方的对象锁-->可能造成死锁
	private void makeup() {
		if (0 == choice) {
			synchronized (libstick) {//获得口红的锁
				System.out.println(this.girl + "涂口红");
				//1秒后想拥有镜子的锁
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (mirror) {
//					System.out.println(this.girl + "照镜子");
//				}
			}
			synchronized (mirror) {
				System.out.println(this.girl + "照镜子");
			}
		} else {
			synchronized (mirror) {//获得镜子的锁
				System.out.println(this.girl + "涂镜子");
				//1秒后想拥有口红的锁
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (libstick) {
//					System.out.println(this.girl + "涂口红");
//				}
			}
			synchronized (libstick) {
				System.out.println(this.girl + "涂口红");
			}
		}
	}
}