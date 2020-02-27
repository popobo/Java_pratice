package cn.bo.collentior;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3, "three");
		
		System.out.println(m1.get(1));
		System.out.println(m1.isEmpty());
		System.out.println(m1.containsKey(2));
		System.out.println(m1.containsValue("four"));
		
		Map<Integer, String> m2 = new HashMap<Integer, String>();
		m2.put(4, "four");
		m2.put(5, "five");
		
		m1.putAll(m2);
		System.out.println(m1);
		
		//map�м������ظ�������ظ�(�Ƿ��ظ�����equals�������ж�)���ظ����µ��滻�ɵ�
		m1.put(3, "��");
		System.out.println(m1);
		
	}
}
