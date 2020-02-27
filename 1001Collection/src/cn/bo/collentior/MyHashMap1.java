package cn.bo.collentior;

/**
 * 自定义HashMap
 * @author 33136
 *
 */
public class MyHashMap1 {
	Node2[] table; //位桶数组 buket array
	int size; //存放的键值对个数
	public MyHashMap1() {
		table = new Node2[16]; //长度一般定义为2的整数幂
	}
	
	public void put(Object key, Object value) {
		// 定义新的节点对象
		Node2 newNode2 = new Node2();
		newNode2.hash = myHash(key.hashCode(), table.length);
		newNode2.key = key;
		newNode2.value = value;
		newNode2.next = null;
		
		Node2 temp = table[newNode2.hash];
		Node2 last = null; //遍历的最后一个元素
		
		if (temp == null) {
			//此处数组元素为空 则直接放入
			table[newNode2.hash] = newNode2;
		}else {
			//此处数组元素不为空 则遍历对象链表
			while(temp != null) {
				//key重复则覆盖
				if (temp.key.equals(newNode2.key)) {
					System.out.println("重复了");
					temp.value = newNode2.value; // 只是覆盖value 其他不变
					break;
				}
				else {
					//key不重复
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
		System.out.println("hash in myHash:" + (v & (length - 1))); //直接位运算 效率高
		System.out.println("hash in myHash:" + (v % (length - 1))); //取模运算 效率低
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
