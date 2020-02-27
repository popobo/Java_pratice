package com.bo.syn;

public class HappyCinema {
	public static void main(String[] args) {
		Cinema cinema = new Cinema(3, "11");
		new Thread(new Cuntomer(cinema, 2), "a").start();
		new Thread(new Cuntomer(cinema, 1), "b").start();		
	}
}

//顾客
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
				System.out.println("出票成功" + Thread.currentThread().getName() + "-->位置为" + seats);
			}else {
				System.out.println("出票失败位置不够");
			}
		}
	}
	
}

class Cinema {
	int available;//可用的位置
	String name;//名称
	public Cinema(int available, String name) {
		this.available = available;
		this.name = name;
	}
	
	//购票
	public boolean bookTickets(int seats) {
		System.out.println("可用位置为:" + available);
		if (seats > available) {
			return false;
		}
		available -= seats;
		return true;
	}
}