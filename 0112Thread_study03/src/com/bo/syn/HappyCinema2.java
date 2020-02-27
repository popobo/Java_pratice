package com.bo.syn;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultEditorKit.CopyAction;

public class HappyCinema2 {
	public static void main(String[] args) {
		//可用位置
		List<Integer> available =new ArrayList<Integer>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(6);
		available.add(7);
		Cinema2 Cinema2 = new Cinema2(available, "11");
		
		//顾客需要的位置
		List<Integer> seats1 =new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2 =new ArrayList<Integer>();
		seats2.add(3);
		seats2.add(6);
		
		new Thread(new Cuntomer2(Cinema2, seats1), "a").start();
		new Thread(new Cuntomer2(Cinema2, seats2), "b").start();		
	}
}

//顾客
class Cuntomer2 implements Runnable {
    private Cinema2 Cinema2;
	private List<Integer> seats;
	
	public Cuntomer2(Cinema2 Cinema2, List<Integer> seats) {
		this.Cinema2 = Cinema2;
		this.seats = seats;
	}
	
	@Override
	public void run() {
		synchronized (Cinema2) {
			boolean flag = Cinema2.bookTickets(seats);
			if (flag) {
				System.out.println("出票成功" + Thread.currentThread().getName() + "-->位置为" + seats);
			}else {
				System.out.println("出票失败位置不够");
			}
		}
	}
	
}

class Cinema2 {
	List<Integer> available;//可用的位置
	String name;//名称
	public Cinema2(List<Integer> available, String name) {
		this.available = available;
		this.name = name;
	}
	
	//购票
	public boolean bookTickets(List<Integer> seats) {
		System.out.println("可用位置为:" + available);
		
		List<Integer> temp = new ArrayList<Integer>();
		temp.addAll(available);
		
		//相减
		temp.removeAll(seats);
		
		//判断大小
		if (available.size() - temp.size() != seats.size()) {
			return false;
		}
		
		//成功
		available = temp;
		
		return true;
	}
}