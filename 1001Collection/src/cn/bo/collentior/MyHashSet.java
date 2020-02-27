package cn.bo.collentior;

import java.util.HashMap;

/**
 *  µœ÷HashSet
 * @author 33136
 *
 */
public class MyHashSet {
	HashMap map;
	
	private static final Object PRESENT = new Object();
	
	public MyHashSet() {
		map = new HashMap();
	}
	
	public int size() {
		return map.size();
	}
	
	public void add(Object o) {
		map.put(o, PRESENT);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Object key:map.keySet())
		{
			sb.append(key + ",");
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyHashSet set = new MyHashSet();
		set.add("aa");
		set.add("bb");
		set.add("aa");
		set.add("bb");
		System.out.println(set);
	}
}
