package com.bo.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java类中的各种结构（方法、属性、构造器、类名）映射成一个个java对象
 * 1、获取Class对象
 * 三种方式：Class.forName("完整路径");
 * 2、可以动态创建对象
 * clz.getContructor().newInstance()
 * @author 33136
 */

public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//三种方式
		//1、对象.getClass()
		Car car = new Car();
		Class clz = car.getClass();
		//2、类.class()
		clz = Car.class;
		//3、Class.forName("包名.类名")
		clz = Class.forName("com.bo.server.basic.Car");
		
		//创建对象
		/*Car car2 = (Car)clz.newInstance();
		System.out.println(car2);*/
		Car car2 = (Car)clz.getConstructor().newInstance();
		System.out.println(car2);
	}
}

class Car{
	public Car() {
	}
}