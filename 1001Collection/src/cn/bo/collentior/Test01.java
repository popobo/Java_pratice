package cn.bo.collentior;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 * 测试List中的方法
 * @author 33136
 *
 */

public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		//ArrayList：底层实现是数组，线程不安全，效率高，查询快。修改、插入、删除慢
		//LinkedList：底层实现是链表，线程不安全，效率高，与ArrayList相反
		//Vector：线程安全，效率低
		
		Date date = new Date();
		list.add("aaa");  
//		list.add(new Date());
		list.add(date);
		list.add(new Dog());
		list.add(1234); //包装类:自动装箱
		
		System.out.println(list.size()); // 4
		System.out.println(list.isEmpty()); // false
//		list.remove(new Date()); //hashCode和equals判断对象是否相等
		list.remove(date);
		System.out.println(list.size()); // 3
		list.remove("aaa");
		System.out.println(list.size()); // 2
		list.remove(new Dog());
		System.out.println(list.size()); // 2
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		System.out.println(list.size()); 
		
		//跟顺序有关的操作
		list.set(0,"ababa");
		String string = (String) list.get(0);
		System.out.println(string);
		list.set(1,"ababa");
		list.remove(0);  
	}
}

class Dog {
	
}