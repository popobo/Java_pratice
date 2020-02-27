package cn.bo.collentior;

import java.util.HashMap;

/**
 * 自定义HashMap 实现get方法
 * @author 33136
 *
 */
public class MyHashMap4<K, V> {
	Node3<K, V>[] table; //位桶数组 buket array
	int size; //存放的键值对个数
	public MyHashMap4() {
		table = (Node3<K, V>[])new Node3[16]; //长度一般定义为2的整数幂
	}
	
	public V get(K key) {
		int hash = myHash(key.hashCode(), table.length);
		V value = null;
		if (table[hash] != null) {
			Node3<K, V> temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key)) { //如果相等 说明找到了键值对 返回相应的value
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
		//如果要完善 还需要考虑数组 扩容问题
		// 定义新的节点对象
		Node3<K, V> newNode3 = new Node3<K, V>();
		newNode3.hash = myHash(key.hashCode(), table.length);
		newNode3.key = key;
		newNode3.value = value;
		newNode3.next = null;
		
		Node3<K, V> temp = table[newNode3.hash];
		Node3<K, V> last = null; //遍历的最后一个元素
		
		if (temp == null) {
			//此处数组元素为空 则直接放入
			table[newNode3.hash] = newNode3;
			size++;
		}else {
			//此处数组元素不为空 则遍历对象链表
			while(temp != null) {
				//key重复则覆盖
				if (temp.key.equals(newNode3.key)) {
					System.out.println("重复了");
					temp.value = newNode3.value; // 只是覆盖value 其他不变
					break;
				}
				else {
					//key不重复
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
		System.out.println("hash in myHash:" + (v & (length - 1))); //直接位运算 效率高
//		System.out.println("hash in myHash:" + (v % (length - 1))); //取模运算 效率低
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
