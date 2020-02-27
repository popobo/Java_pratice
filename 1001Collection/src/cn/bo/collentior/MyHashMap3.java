package cn.bo.collentior;

/**
 * 自定义HashMap 实现get方法
 * @author 33136
 *
 */
public class MyHashMap3 {
	Node2[] table; //位桶数组 buket array
	int size; //存放的键值对个数
	public MyHashMap3() {
		table = new Node2[16]; //长度一般定义为2的整数幂
	}
	
	public Object get(Object key) {
		int hash = myHash(key.hashCode(), table.length);
		Object value = null;
		if (table[hash] != null) {
			Node2 temp = table[hash];
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
		//如果要完善 还需要考虑数组 扩容问题
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
			size++;
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
		MyHashMap3 map01 = new MyHashMap3();
		map01.put(10, "aa");
		map01.put(20, "bb");
		map01.put(30, "cc");
		map01.put(10, "ee");
		System.out.println(map01.size);
		System.out.println(map01.get(20));
	}
}
