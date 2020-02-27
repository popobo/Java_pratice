import java.awt.TexturePaint;
import java.math.*;

public class TestPermitiveDataType {
	public static void main(String[] args) {
		int a = 015; // 八进制
		int b = 0x15; // 16进制
		int c = 0b101; // 二进制
		long d = 777777777777777777L; // long变量最后要加L或l，否则使用int存储
	
		// 浮点数
		float e = 3.14F;  // 浮点数默认为double类型，需要在最后加F后缀才能存入float变量
		double f = 3.14;
		
		float g = 0.1f;
		double h = 1.0/10;
		System.out.println(g);
		System.out.println(h);
		System.out.println(g==h); // 打印false，因为浮点数不精确
		
		float i = 77777777f;
		float i1 = i + 1;
		if (i == i1) 
		{
			System.out.println("i == i1");
		}
		else
		{
			System.out.println("i != i1");
		}
		
		System.out.println("####################");
		// 使用精确浮点运算，使用BigDecimal
		BigDecimal bd = BigDecimal.valueOf(1.0);
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		System.out.println(bd);
		System.out.println(1 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);
		
		BigDecimal bd2 = BigDecimal.valueOf(0.1);
		BigDecimal bd3 = BigDecimal.valueOf(1.0/10);
		
		System.out.println(bd2.equals(bd3));
			
		char ca = 't';
		char cb = '是';
		char cc = '\u0061';
		System.out.println(cc);
		// 转义字符
		System.out.println('a' + 'b');
		System.out.println("" + 'a' + 'b');
		System.out.println("" + 'a' + "\n" + 'b');
		
		// String就是字符序列
		String abc = "abc";
		
		// boolean 只占1bit
		boolean man = true;
		
		if (man) 
		{
			
		}
		
	}
}
