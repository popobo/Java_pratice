package com.bo.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * �̰߳�ȫ:�ڲ���ʱ��֤���ݵ���ȷ��, Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����, Ŀ����ȷ
 * @author 33136
 *
 */

public class SynBlockTest02 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()->{
				//ͬ����
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		Thread.sleep(10000);
		System.out.println(list.size());
	}
}
