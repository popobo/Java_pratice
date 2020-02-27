package com.bo.syn;

public class Happy12306 {
	public static void main(String[] args) {
		Web12306 web12306 = new Web12306(4, "bo");
		new Passenger(web12306, "a", 1);
		new Passenger(web12306, "b", 2);
		new Passenger(web12306, "b", 3);
	}
}

//�˿�
class Passenger extends Thread {
	int seats;
	
	public Passenger(Runnable target, String name, int seats) {
		super(target, name);
		this.seats = seats;
	}
}

class Web12306 implements Runnable {
	int available;//���õ�λ��
	String name;//����
	public Web12306(int available, String name) {
		this.available = available;
		this.name = name;
	}
	
	//��Ʊ
	public synchronized boolean bookTickets(int seats) {
		System.out.println("����λ��Ϊ:" + available);
		if (seats > available) {
			return false;
		}
		available -= seats;
		return true;
	}
	
	@Override
	public void run() {
		Passenger passenger = (Passenger)Thread.currentThread();
		boolean flag = this.bookTickets(passenger.seats);
		if (flag) {
			System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"->λ��Ϊ:"+passenger.seats);
		} else {
			System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"->λ�ò���");
		}
	}
}