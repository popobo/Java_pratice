package cn.bo.array;

public class Test02 {
	public static void main(String[] args) 
	{
		// ����
		int[] a;
		int b[];
		
		//�����������
		a = new int[4];
		b = new int[5];
		
		// ��ʼ��(������Ԫ�صĳ�ʼ��)
		// Ĭ�ϳ�ʼ��, ����Ԫ���൱�ڶ���ĳ�Ա����, Ĭ��ֵ����Ա�����Ĺ���һ��. ����0, ����false, char\u0000. ���� : null
		// ��̬��ʼ��
		for (int i = 0; i < a.length; i++) 
		{
			a[i] = i * 12;
		}
		
		// ��̬��ʼ��
		int c[] = {23, 45, 21, 54}; // ���� : 4, ������Χ : [0, 3]
		Car[] cars = {
				new Car("����"),
				new Car("���ǵ�"),
				new Car("����")
		};
		Car c2 = new Car("����");
		System.out.println(c2 == cars[0]);
	}
}
