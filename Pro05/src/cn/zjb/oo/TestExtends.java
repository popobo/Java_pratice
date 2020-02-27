package cn.zjb.oo;

public class TestExtends {
	public static void main(String[] args) {
		Student stu = new Student(100, "a", "major");
		
		stu.rest(); 
		
		System.out.println(stu instanceof Person);
	}
}

class Person
{
	String name;
	int height;
	
	public void rest()
	{
		System.out.println("rest");
	}
}

class Student extends Person
{
	String major;
	
	public void study()
	{
		System.out.println("study");
	}
	
	public Student(int height, String name, String major)
	{
		this.height = height;
		this.name = name;
		this.major = major;
	}
	
}