package cn.bo.collentior;

/**
 * 自定义一个链表
 * @author 33136
 *
 */
public class MyLinkedList1 {
	private Node first;
	private Node last;
	private int size;
	
	//["a", "b", "c"]
	public void add(Object obj) {
		Node node = new Node(obj);
		
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
		MyLinkedList1 list01 = new MyLinkedList1();
		list01.add("a");
		list01.add("b");
		list01.add("c");
		System.out.println(list01);
	}
	
}
