package com.bo.syn;

public class HappyCinema {
	public static void main(String[] args) {
		Cinema cinema = new Cinema(3, "11");
		new Thread(new Cuntomer(cinema, 2), "a").start();
		new Thread(new Cuntomer(cinema, 1), "b").start();		
	}
}

//�˿�
class Cuntomer implements Runnable {
    private Cinema cinema;
	private int seats;
	
	public Cuntomer(Cinema cinema, int seats) {
		this.cinema = cinema;
		this.seats = seats;
	}
	
	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag = cinema.bookTickets(seats);
			if (flag) {
				System.out.println("��Ʊ�ɹ�" + Thread.currentThread().getName() + "-->λ��Ϊ" + seats);
			}else {
				System.out.println("��Ʊʧ��λ�ò���");
			}
		}
	}
	
}

class Cinema {
	int available;//���õ�λ��
	String name;//����
	public Cinema(int available, String name) {
		this.available = available;
		this.name = name;
	}
	
	//��Ʊ
	public boolean bookTickets(int seats) {
		System.out.println("����λ��Ϊ:" + available);
		if (seats > available) {
			return false;
		}
		available -= seats;
		return true;
	}
}