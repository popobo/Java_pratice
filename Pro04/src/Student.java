
public class Student {
	// ����
	
	// ����field
	int id;
	String name;
	int age;
	
	Computer comp;
	
	// ����
	void study()
	{
		System.out.println(id + name + "study" + " " + "use" + comp.brand);
	}
	
	void play()
	{
		System.out.println("play");
	}
	
	// ���췽�� �޲εĹ��췽������ϵͳ�Զ�����
	Student() 
	{
		
	}
	
	// ����ִ����ڣ�������
	public static void main(String[] args) {
		Student stu = new Student(); // ����һ������
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