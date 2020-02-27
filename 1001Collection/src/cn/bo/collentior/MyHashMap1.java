package cn.bo.collentior;

/**
 * �Զ���HashMap
 * @author 33136
 *
 */
public class MyHashMap1 {
	Node2[] table; //λͰ���� buket array
	int size; //��ŵļ�ֵ�Ը���
	public MyHashMap1() {
		table = new Node2[16]; //����һ�㶨��Ϊ2��������
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
		MyHashMap1 map01 = new MyHashMap1();
		map01.put(10, "aa");
		map01.put(20, "bb");
		map01.put(30, "cc");
		map01.put(10, "ee");
		for (int i = 0; i < 1000; i++) {
			map01.put(i, i*100);
		}
		System.out.println("e");
	}
}
