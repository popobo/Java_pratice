package cn.bo.stringbuilder;

/**
  * ���Կɱ��ַ�����, StringBuilder(�̲߳���ȫ, Ч�ʸ�), StringBuffer(�̰߳�ȫ, Ч�ʵ�)
 * String : ���ɱ��ַ�����
 * @author 33136
 *
 */

public class Test01 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();// �ַ����鳤�ȳ�ʼΪ16
		StringBuilder sb1 = new StringBuilder(32);// �ַ����鳤�ȳ�ʼΪ32
		StringBuilder sb2 = new StringBuilder("abcd");//�ַ����鳤�ȳ�ʼΪ20�� value[] = {'a', 'b', 'c', 'd', \u0000, \u0000, ...}
		sb2.append("efg");
		sb2.append(true).append(321).append("���");
		
		System.out.println(sb2);
		System.out.println("______________________");
		StringBuilder sb3 = new StringBuilder("a");
		for (int i = 0; i < 1000; i++) {
			sb3.append(i);
		}
		System.out.println(sb3);
	}
}
