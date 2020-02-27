package cn.bo.string;


/**
 * String�����ɱ��ַ����У�
 * ������ҵ��
 * 1. ��ϰString��ĳ��÷���
 * 2. �������鿴Դ��
 * 3. ��ߣ�������ʦ�ķ�����String������ط�����Դ�뿴һ����
 * @author dell
 *
 */

public class TestString {
	public static void main(String[] args) {
		String string = new String("abcd");
		String string2 = new String("abcd");
		System.out.println(string.equals(string2)); // �Ƚ������Ƿ����
		System.out.println(string == string2); // ���Ƿ���ͬһString����
		
		System.out.println(string.charAt(2));
		
		String string3 = "aaad";
		String string4 = "aaad";
		System.out.println(string3 == string4);
		String string5 = string4;
		System.out.println(string3 == string5);
		
		System.out.println(string3.indexOf('d'));
		String string6 = string5.substring(0);
		System.out.println(string6);
		String string7 = string6.replace('d', 'e');
		System.out.println(string7);
		
		String string8 = "ab,cd,ef";
		String[] strings = string8.split(",");
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		String string9 = "   aaa bbb   ";
		String string10 = string9.trim();
		System.out.println(string10);
		
		System.out.println("ABC".equalsIgnoreCase("abc"));
		System.out.println("Abcbd".indexOf('b')); 
		System.out.println("Abcbd".lastIndexOf('b')); 
		System.out.println("Abcbd".startsWith("Ab")); 
		System.out.println("Abcbd".endsWith("bd")); 
		System.out.println("Abcbd".toLowerCase()); 
		System.out.println("Abcbd".toUpperCase());
		System.out.println("##################");
		String gh = new String("a");
		for (int i = 0; i < 1000; i++) {
			gh = gh + i;
		}
		System.out.println(gh); 
	}
}
