import java.security.spec.DSAGenParameterSpec;

public class TestOperator {
	public static void main(String[] args) {
		byte a = 1;
		byte a1 = 1;
		int b = 2;
		long c = 11L;
		
		// byte d = a + a1; // a + a1Ϊint����
		
		System.out.println(-9%5); // -4
		
		// && ��·�����
		boolean b3 = 1 > 2 && 2 < (3 / 0); 
		
		// λ�����
		int d = 3;
		int e = d << 2; // ������λ *4
		
		//�ַ������ӷ� 
		System.out.println("3" + 4);
		 
		String f = "3";
		int g = 4;
		int h = 5;
		System.out.println(h+ f + g);
		
		System.out.println(h + g + f);
		
		System.out.println('a' + 4);
	}
}
