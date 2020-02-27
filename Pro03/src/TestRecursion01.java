
public class TestRecursion01 {
	public static void main(String[] args) {
		long d1 = System.currentTimeMillis();
		System.out.println(a(10));
		long d2 = System.currentTimeMillis();
		System.out.println(d2 - d1);
	}
	
	static int count = 0;
	static int a(int i)
	{
		if (1 == i)
		{
			return 1;
		}
		return i * a(i -1);
	}
	
}
