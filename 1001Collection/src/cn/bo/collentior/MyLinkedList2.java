package cn.bo.collentior;

/**
 * 自定义一个链表
 * @author 33136
 *
 */
public class MyLinkedList2 {
	private Node first;
	private Node last;
	private int size;
	
	public Object get(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("索引数字不合法:" + index);
		}
		Node temp = null;
		if (index < (size >> 1)) {
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		}else {
			temp = last;
			for (int i = size - 1; i > index; i--) {
				temp = temp.previous;
			}
		}
		
		
		return temp.element;
	}
	
	
	//["a", "b", "c"]
	public void add(Object obj) {
		Node node = new Node(obj);
		size++;
		if (first == null) {
			node.previous = null;
			node.next = null;
			first = node;
			last = node;
		}else {
			node.previous = last;
			node.next = null;
			last.next = node;
			last = node;
		}
	}
	
	@Override
	public String toString() {
		Node temp = first;
		StringBuilder sb = new StringBuilder("[");
		while (temp != null) {
			sb.append(temp.element + ",");
			temp = temp.next;
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyLinkedList2 list01 = new MyLinkedList2();
		list01.add("a");
		list01.add("b");
		list01.add("c");
		list01.add("e");
		list01.add("f");
		list01.add("g");
		System.out.println(list01.get(5));
	}
	
}
