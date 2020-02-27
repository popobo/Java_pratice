import java.awt.TexturePaint;
import java.math.*;

public class TestPermitiveDataType {
	public static void main(String[] args) {
		int a = 015; // �˽���
		int b = 0x15; // 16����
		int c = 0b101; // ������
		long d = 777777777777777777L; // long�������Ҫ��L��l������ʹ��int�洢
	
		// ������
		float e = 3.14F;  // ������Ĭ��Ϊdouble���ͣ���Ҫ������F��׺���ܴ���float����
		double f = 3.14;
		
		float g = 0.1f;
		double h = 1.0/10;
		System.out.println(g);
		System.out.println(h);
		System.out.println(g==h); // ��ӡfalse����Ϊ����������ȷ
		
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
		// ʹ�þ�ȷ�������㣬ʹ��BigDecimal
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
		char cb = '��';
		char cc = '\u0061';
		System.out.println(cc);
		// ת���ַ�
		System.out.println('a' + 'b');
		System.out.println("" + 'a' + 'b');
		System.out.println("" + 'a' + "\n" + 'b');
		
		// String�����ַ�����
		String abc = "abc";
		
		// boolean ֻռ1bit
		boolean man = true;
		
		if (man) 
		{
			
		}
		
	}
}
