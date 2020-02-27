package cn.zjb.oo;

public class TestEncapsulation {
	public static void main(String[] args) {
		Human h = new Human();
		System.out.println(h.getAge());
	}
}


class Human
{
	private int age;
	String name; // 可以被本包下的类访问
	
	int getAge()
	{
		return age;
	}
	
}

class PersonPravite
{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}