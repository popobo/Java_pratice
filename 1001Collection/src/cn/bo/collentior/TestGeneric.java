package cn.bo.collentior;

import java.util.Map;

/**
 * ≤‚ ‘∑∫–Õ
 * @author 33136
 *
 */
public class TestGeneric {
	public static void main(String[] args) {
		MyCollction mc = new MyCollction();
		mc.set(0, 100);
		mc.set(1, "100");
		
		Integer temp = (Integer)mc.get(0);
		String tempString = (String)mc.get(1);
		System.out.println(tempString);
	
		MyCollection1<String> mc1 = new MyCollection1<String>();
		mc1.set(0, "aaa");
		System.out.println(mc1.get(0));
	}
}

class MyCollction {
	Object[] objs = new Object[5];
	
	public void set(int index, Object obj) {
		objs[index] = obj;
	}
	
	public Object get(int index) {
		return objs[index];
	}
}

class MyCollection1 <E> {
	Object[] objs = new Object[5];

	public void set(int index, E obj) {
		objs[index] = obj;
	}
	
	public Object get(int index) {
		return (E) objs[index];
	}
}