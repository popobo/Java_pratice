package com.bo.udp;

/**
 * ������̣߳�ʵ��˫���� ģ��������ѯ
 * 
 * @author bo
 */

public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(7777,"localhost",9999)).start(); //����		
		new Thread(new TalkReceive(8888,"��ʦ")).start(); //����
	}
}
