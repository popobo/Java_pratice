package com.bo.cooperation;

/**
 * 协作模型:生产者消费者实现方式一:管程法
 * 借助缓冲区 
 * 
 * @author 33136
 *
 */

public class CoTest01 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}
}

//生产者
class Productor extends Thread {
	SynContainer container;
	public Productor(SynContainer container) {
		this.container = container;
	}
	
	@Override
	public void run() {
		//生产
		for (int i = 0; i < 100; i++) {
			System.out.println("生产-->" + i + " product");
			container.push(new Product(i));
		}
	}
}

//消费者
class Consumer extends Thread {
	SynContainer container;
	public Consumer(SynContainer container) {
		this.container = container;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("消费-->" + container.pop().id + " product");
		}
	}
}

//缓冲区
class SynContainer {
	Product[] products = new Product[10];//存储容器
	int count = 0;//计数器
	//存储 生产
	public synchronized void push(Product product) {
		//何时能生产 容器存在空间
		//不能生产 只有等待
		if (count == products.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//存在空间 可以生产
		products[count] = product;
		count++;
		//存在数据了 可以通知消费了
		this.notifyAll();
	}
	//获取 消费
	public synchronized Product pop() {
		//何时消费 容器中是否存在数据
		//没有数据 只有等待
		if (count == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//存在数据可以消费
		count--;
		Product product = products[count];
		this.notifyAll();//存在空间了 可以唤醒对方生产了
		return product;
	}
}

//产品
class Product {
	int id;
	public Product(int id) {
		this.id = id;
	}
}