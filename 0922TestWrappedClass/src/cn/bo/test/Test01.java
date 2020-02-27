package cn.bo.test;

/**
 * 测试包装类的基本用法
 * @author 33136
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Integer integer = new Integer(1000);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toHexString(integer));
		Integer integer2 = Integer.parseInt("24");
		Integer integer3 = new Integer("333");
		System.out.println(integer2.intValue());
		String string = 234 + "";
	}
}
