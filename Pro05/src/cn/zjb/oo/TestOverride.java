package cn.zjb.oo;

public class TestOverride {
	public static void main(String[] args) {
		Horse h = new Horse();
		h.run();
	}
}


class Vehicle
{
	public void run() 
	{
		System.out.println("Vehicle.run()");
	}
	
	public void stop() 
	{
		System.out.println("Vehicle.stop()");
	}
	
	public Person whoIsPerson() 
	{
		return new Person();
	}
}

class Horse extends Vehicle
{
	public void run() 
	{
		System.out.println("Horse.run()");
	}
	
	// 返回值类型小与等于父类方法返回值
	public Student whoIsPerson() 
	{
		return new Student(100, "a", "b");
	}
	
}