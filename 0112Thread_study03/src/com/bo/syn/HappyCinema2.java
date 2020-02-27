package com.bo.syn;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultEditorKit.CopyAction;

public class HappyCinema2 {
	public static void main(String[] args) {
		//����λ��
		List<Integer> available =new ArrayList<Integer>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(6);
		available.add(7);
		Cinema2 Cinema2 = new Cinema2(available, "11");
		
		//�˿���Ҫ��λ��
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

//�˿�
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
				System.out.println("��Ʊ�ɹ�" + Thread.currentThread().getName() + "-->λ��Ϊ" + seats);
			}else {
				System.out.println("��Ʊʧ��λ�ò���");
			}
		}
	}
	
}

class Cinema2 {
	List<Integer> available;//���õ�λ��
	String name;//����
	public Cinema2(List<Integer> available, String name) {
		this.available = available;
		this.name = name;
	}
	
	//��Ʊ
	public boolean bookTickets(List<Integer> seats) {
		System.out.println("����λ��Ϊ:" + available);
		
		List<Integer> temp = new ArrayList<Integer>();
		temp.addAll(available);
		
		//���
		temp.removeAll(seats);
		
		//�жϴ�С
		if (available.size() - temp.size() != seats.size()) {
			return false;
		}
		
		//�ɹ�
		available = temp;
		
		return true;
	}
}