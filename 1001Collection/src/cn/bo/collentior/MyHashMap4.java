package cn.bo.collentior;

import java.util.HashMap;

/**
 * �Զ���HashMap ʵ��get����
 * @author 33136
 *
 */
public class MyHashMap4<K, V> {
	Node3<K, V>[] table; //λͰ���� buket array
	int size; //��ŵļ�ֵ�Ը���
	public MyHashMap4() {
		table = (Node3<K, V>[])new Node3[16]; //����һ�㶨��Ϊ2��������
	}
	
	public V get(K key) {
		int hash = myHash(key.hashCode(), table.length);
		V value = null;
		if (table[hash] != null) {
			Node3<K, V> temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key)) { //������ ˵���ҵ��˼�ֵ�� ������Ӧ��value
					value = temp.value;
					break;
				} else {
					temp = temp.next;
				}
			}
		}
		return value;
	}
	
	@Override
	public String toString() {
		//{10:aa, 20:bb}
		StringBuilder sb = new StringBuilder("{");
		for (int i = 0; i < table.length; i++) {
			Node3<K, V> temp = table[i];
			while (temp != null) {
				sb.append(temp.key + ":" + temp.value + ",");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length() - 1, '}');
		return sb.toString();
	}
	
	public void put(K key, V value) {
		//���Ҫ���� ����Ҫ�������� ��������
		// �����µĽڵ����
		Node3<K, V> newNode3 = new Node3<K, V>();
		newNode3.hash = myHash(key.hashCode(), table.length);
		newNode3.key = key;
		newNode3.value = value;
		newNode3.next = null;
		
		Node3<K, V> temp = table[newNode3.hash];
		Node3<K, V> last = null; //���������һ��Ԫ��
		
		if (temp == null) {
			//�˴�����Ԫ��Ϊ�� ��ֱ�ӷ���
			table[newNode3.hash] = newNode3;
			size++;
		}else {
			//�˴�����Ԫ�ز�Ϊ�� �������������
			while(temp != null) {
				//key�ظ��򸲸�
				if (temp.key.equals(newNode3.key)) {
					System.out.println("�ظ���");
					temp.value = newNode3.value; // ֻ�Ǹ���value ��������
					break;
				}
				else {
					//key���ظ�
					last = temp;
					temp = temp.next;
				}
			}
			if (last != null) {
				last.next = newNode3;
				size++;
			}
		}
	}
	
	public int myHash(int v, int length) {
		System.out.println("hash in myHash:" + (v & (length - 1))); //ֱ��λ���� Ч�ʸ�
//		System.out.println("hash in myHash:" + (v % (length - 1))); //ȡģ���� Ч�ʵ�
		return v & (length - 1);
	}
	
	public static void main(String[] args) {
		MyHashMap4<Integer, String> map01 = new MyHashMap4<Integer, String>();
		map01.put(10, "aa");
		map01.put(20, "bb");
		map01.put(30, "cc");
		map01.put(10, "ee");
		System.out.println(map01.size);
		System.out.println(map01.get(20));
	}
}
