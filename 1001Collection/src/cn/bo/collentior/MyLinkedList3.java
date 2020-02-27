package cn.bo.collentior;

/**
 * �Զ���һ������
 * @author 33136
 *
 */
public class MyLinkedList3 {
	private Node first;
	private Node last;
	private int size;
	
	public Node getNode(int index) {
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
		return temp;
	}
	
	public Object get(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("�������ֲ��Ϸ�:" + index);
		}
		Node temp = getNode(index);
		return temp.element;
	}
	
	
	
	public void remove(int index) {
		Node temp = getNode(index);
		if (temp != null) {
			Node up = temp.previous;
			Node down = temp.next;
			if (up != null) {
				up.next = down;
			}
			if (down != null) {
				down.previous = up;
			}
			//��ɾ��Ԫ���ǵ�һ��Ԫ��ʱ
			if (index == 0) {
				first = down;
			}
			//��ɾ��Ԫ�������һ��Ԫ��ʱ
			if (index == size - 1) {
				last = up;
			}
			
			size--;
		}
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
		MyLinkedList3 list01 = new MyLinkedList3();
		list01.add("a");
		list01.add("b");
		list01.add("c");
		list01.add("e");
		list01.add("f");
		list01.add("g");
		list01.remove(2);
		System.out.println(list01);
	}
	
}
