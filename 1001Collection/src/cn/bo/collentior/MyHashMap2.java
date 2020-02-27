package cn.bo.collentior;

/**
 * �Զ���HashMap ʵ��toString���� ����鿴Map�м�ֵ����Ϣ
 * @author 33136
 *
 */
public class MyHashMap2 {
	Node2[] table; //λͰ���� buket array
	int size; //��ŵļ�ֵ�Ը���
	public MyHashMap2() {
		table = new Node2[16]; //����һ�㶨��Ϊ2��������
	}
	
	@Override
	public String toString() {
		//{10:aa, 20:bb}
		StringBuilder sb = new StringBuilder("{");
		for (int i = 0; i < table.length; i++) {
			Node2 temp = table[i];
			while (temp != null) {
				sb.append(temp.key + ":" + temp.value + ",");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length() - 1, '}');
		return sb.toString();
	}
	
	public void put(Object key, Object value) {
		// �����µĽڵ����
		Node2 newNode2 = new Node2();
		newNode2.hash = myHash(key.hashCode(), table.length);
		newNode2.key = key;
		newNode2.value = value;
		newNode2.next = null;
		
		Node2 temp = table[newNode2.hash];
		Node2 last = null; //���������һ��Ԫ��
		
		if (temp == null) {
			//�˴�����Ԫ��Ϊ�� ��ֱ�ӷ���
			table[newNode2.hash] = newNode2;
		}else {
			//�˴�����Ԫ�ز�Ϊ�� �������������
			while(temp != null) {
				//key�ظ��򸲸�
				if (temp.key.equals(newNode2.key)) {
					System.out.println("�ظ���");
					temp.value = newNode2.value; // ֻ�Ǹ���value ��������
					break;
				}
				else {
					//key���ظ�
					last = temp;
					temp = temp.next;
				}
			}
			if (last != null) {
				last.next = newNode2;
			}
		}
	}
	
	public int myHash(int v, int length) {
		System.out.println("hash in myHash:" + (v & (length - 1))); //ֱ��λ���� Ч�ʸ�
		System.out.println("hash in myHash:" + (v % (length - 1))); //ȡģ���� Ч�ʵ�
		return v & (length - 1);
	}
	
	public static void main(String[] args) {
		MyHashMap2 map01 = new MyHashMap2();
		map01.put(10, "aa");
		map01.put(20, "bb");
		map01.put(30, "cc");
		map01.put(10, "ee");
		System.out.println(map01);
	}
}
