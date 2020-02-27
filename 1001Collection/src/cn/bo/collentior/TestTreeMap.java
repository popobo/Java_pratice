package cn.bo.collentior;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试TreeMap的使用 排序
 * @author 33136
 *
 */
public class TestTreeMap {
	public static void main(String[] args) {
		Map<Integer, String> treeMap1 = new TreeMap<>();
		treeMap1.put(10, "aa");
		treeMap1.put(20, "bb");
		treeMap1.put(30, "cc");
	
		for(Integer key:treeMap1.keySet()) {
			System.out.println(key + ":" + treeMap1.get(key));
		}
		
		Map<Stu, String> treeMap2 = new TreeMap<Stu, String>();
		treeMap2.put(new Stu(0, "a", 10000.1), "aaa");
		treeMap2.put(new Stu(1, "b", 10000.2), "bbb");
		treeMap2.put(new Stu(2, "c", 10000.1), "ccc");
		
		for(Stu key:treeMap2.keySet()) {
			System.out.println(key + ":" + treeMap2.get(key));
		}
	} 
}

class Stu implements Comparable<Stu>{
	int id;
	String name;
	double salary;
	
	@Override
	public String toString() {
		return this.id + "-" + this.name + "-" + this.salary;
	}
	public Stu(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public int compareTo(Stu o) { //负数 小于
		if (this.salary > o.salary) {
			return 1;
		}else if (this.salary < o.salary) {
			return -1;
		}else {
			return this.id - o.id;
		}
	}
	
	
	
	
}
