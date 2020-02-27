package cn.bo.test;

public class Test02 {
	public static void main(String[] args) {
//		Integer integer = new Integer(1000);
		Integer integer = 1000; // jdk5.0后, 自动装箱, 编译器帮我们改进代码, Integer a = new Integer(1000);
		Integer integer2 = null;
		int c = integer;
		System.out.println(c);
		
		Integer integer3 = 1234;
		Integer integer4 = 1234;
		System.out.println(integer3 == integer4);
		System.out.println(integer3.equals(integer4));
		
		System.out.println("=====================");
		Integer integer5 = -100;//[-128,127]之间的数，仍然当做基本数据类型来处理。
		Integer integer6 = -100;
		System.out.println(integer5 == integer6);
		System.out.println(integer5.equals(integer6));
	}
}
