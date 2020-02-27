
public class Student {
	// 类体
	
	// 属性field
	int id;
	String name;
	int age;
	
	Computer comp;
	
	// 方法
	void study()
	{
		System.out.println(id + name + "study" + " " + "use" + comp.brand);
	}
	
	void play()
	{
		System.out.println("play");
	}
	
	// 构造方法 无参的构造方法可由系统自动创建
	Student() 
	{
		
	}
	
	// 程序执行入口，必须有
	public static void main(String[] args) {
		Student stu = new Student(); // 创建一个对象
		stu.id = 1001;
		stu.name = "bo";
		stu.age = 18;
		
		Computer c1 = new Computer();
		c1.brand = "mi";
		
		stu.comp = c1;
		
		stu.study();
	}
	
}

class Computer
{
	String brand;
	
	
	
}