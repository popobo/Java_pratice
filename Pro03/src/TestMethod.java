
public class TestMethod {
	public static void main(String[] args) {
		TestMethod test = new TestMethod();
		test.print_hello_world("bo");
		test.print_hello_world(111); 
	}
	
	// java��ѭֵ���ݵ�ԭ��
	void print_hello_world(String name)
	{
		System.out.println(name);
	}
	
	void print_hello_world(int id)
	{
		System.out.println(id);
	}
}
