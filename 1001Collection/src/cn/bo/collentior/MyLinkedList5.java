package cn.bo.collentior;

/**
 * �Զ���һ������
 * @author 33136
 *
 */
public class MyLinkedList5<E> {
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
	
	private void checkRange(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("�������ֲ��Ϸ�:" + index);
		}
	}
	
	public E get(int index) {
		checkRange(index);
		Node temp = getNode(index);
		return temp != null ? (E)temp.element:null;
	}
	
	
	
	public void remove(int index) {
		checkRange(index);
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
	
	public void add(int index, E obj) {
		Node newNode = new Node(obj);
		Node temp = getNode(index);
		if (temp != null) {
			Node up = temp.previous;
			if (up != null) {
				up.next = newNode;
				newNode.previous = up;
			}
			newNode.next = temp;
			temp.previous = newNode;  
			if (index == 0) {
				first = newNode;
			}
			if (index == size - 1) {
				last = newNode;
			}
		}
	}
	
	
	//["a", "b", "c"]
	public void add(E obj) {
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
		MyLinkedList5<String> list01 = new MyLinkedList5();
		list01.add("a");
		list01.add("b");
		list01.add("c");
		list01.add("e");
		list01.add("f");
		list01.add("g");
		list01.add(0, "r");
		System.out.println(list01);
	}
	
}
