package com.bo.io;

/**
 * ģ�⿧��
 * 1���������:��Ҫװ�εĳ������(�ӿڻ������)
 * 2���������:��Ҫװ�εĶ���
 * 3������װ����:�����˶Գ�������������Լ�װ���Ź��еķ���
 * 4������װ����:��װ�εĶ���
 */
public class DecorateTest02 {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		Drink sugar = new Sugar(coffee);//װ��
		System.out.println(sugar.info() + " costs " + sugar.cost());
		Drink milk = new Milk(coffee);//װ��
		System.out.println(milk.info() + " costs " + milk.cost());
	}
}

//�������
interface Drink{
	double cost(); //����
	String info(); //˵��
}

//�������
class Coffee implements Drink{
	private String name = "ԭζ����";
	@Override
	public double cost() {
		return 10;
	}
	@Override
	public String info() {
		return name;
	}
}

//����װ����
abstract class Decorate implements Drink{
	//�Գ������������
	private Drink drink;
	public Decorate(Drink inDrink) {
		drink = inDrink;
	}
	@Override
	public double cost() {
		return drink.cost();
	}
	@Override
	public String info() {
		return drink.info();
	}
}

//����װ����
class Milk extends Decorate{
	public Milk(Drink inDrink) {
		super(inDrink);
	}
	@Override
	public double cost() {
		return super.cost() * 4;
	}
	@Override
	public String info() {
		return super.info() + "������ţ��";
	}
}

class Sugar extends Decorate{
	public Sugar(Drink inDrink) {
		super(inDrink);
	}
	@Override
	public double cost() {
		return super.cost() * 3;
	}
	@Override
	public String info() {
		return super.info() + "����������";
	}
}
