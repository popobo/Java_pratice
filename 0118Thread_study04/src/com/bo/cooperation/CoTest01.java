package com.bo.cooperation;

/**
 * Э��ģ��:������������ʵ�ַ�ʽһ:�̷ܳ�
 * ���������� 
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

//������
class Productor extends Thread {
	SynContainer container;
	public Productor(SynContainer container) {
		this.container = container;
	}
	
	@Override
	public void run() {
		//����
		for (int i = 0; i < 100; i++) {
			System.out.println("����-->" + i + " product");
			container.push(new Product(i));
		}
	}
}

//������
class Consumer extends Thread {
	SynContainer container;
	public Consumer(SynContainer container) {
		this.container = container;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("����-->" + container.pop().id + " product");
		}
	}
}

//������
class SynContainer {
	Product[] products = new Product[10];//�洢����
	int count = 0;//������
	//�洢 ����
	public synchronized void push(Product product) {
		//��ʱ������ �������ڿռ�
		//�������� ֻ�еȴ�
		if (count == products.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//���ڿռ� ��������
		products[count] = product;
		count++;
		//���������� ����֪ͨ������
		this.notifyAll();
	}
	//��ȡ ����
	public synchronized Product pop() {
		//��ʱ���� �������Ƿ��������
		//û������ ֻ�еȴ�
		if (count == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//�������ݿ�������
		count--;
		Product product = products[count];
		this.notifyAll();//���ڿռ��� ���Ի��ѶԷ�������
		return product;
	}
}

//��Ʒ
class Product {
	int id;
	public Product(int id) {
		this.id = id;
	}
}