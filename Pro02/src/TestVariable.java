public class TestVariable {
	int a; // 成员变量，会自动初始化， 生命周期与对象一致
	static int size; // 静态变量，从属于类，生命周期与类一致
	public static void main(String[] args) {
		{
			int age = 0; // age只在该大括号内有用
			age = 1;
		}
		// 局部变量使用前要初始化
	}
}
