package cn.bo.collentior;

public class MyArrayList {
	private Object[] elementData;
	
	private int size;
	
	public MyArrayList(){
		this(10);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		elementData = new Object[initialCapacity];
	}
	
	public void add(Object obj) {
		// 数组扩容和数据的拷贝
		if (size == elementData.length) {
			Object[] newArray = new Object[size * 2 + 1];
			System.arraycopy(elementData, 0, newArray, 0, size);
			elementData = newArray;
		}
		
		elementData[size++] = obj;
	} 
	
	public Object get(int index) {
		RangeCheck(index);
		return elementData[index]; 
	}
	
	private void RangeCheck(int index) {
		if (index < 0 || index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void remove(int index) {
		RangeCheck(index);
		int numMoved = size - index -1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		elementData[--size] = null;// let gc do its work
	}
	
	public boolean remove(Object obj) {
		for (int i = 0; i < size; i++) {
			if (obj.equals (elementData[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Object set(int index, Object obj) {
		 RangeCheck(index);
		 Object oldObject = elementData[index];
		 elementData[index] = obj;
		 return oldObject;
	}
	
	private void ensureCapacity() {
		if (size == elementData.length) {
			Object[] newArray = new Object[size * 2 + 1];
			System.arraycopy(elementData, 0, newArray, 0, size);
			elementData = newArray;
		}
	}
	
	public void add(int index, Object obj) {
		RangeCheck(index);
		ensureCapacity();
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = obj;
	}
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(3);
		list.add("aaa");
		list.add("aaa");
		list.add("aaa");
		list.add("aaa");
		System.out.println(list.size());
		System.out.println(list.get(1));
	}
}
