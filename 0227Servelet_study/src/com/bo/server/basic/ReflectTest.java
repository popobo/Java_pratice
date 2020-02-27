package com.bo.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * ���䣺��java���еĸ��ֽṹ�����������ԡ���������������ӳ���һ����java����
 * 1����ȡClass����
 * ���ַ�ʽ��Class.forName("����·��");
 * 2�����Զ�̬��������
 * clz.getContructor().newInstance()
 * @author 33136
 */

public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//���ַ�ʽ
		//1������.getClass()
		Car car = new Car();
		Class clz = car.getClass();
		//2����.class()
		clz = Car.class;
		//3��Class.forName("����.����")
		clz = Class.forName("com.bo.server.basic.Car");
		
		//��������
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