package cn.bo.myCollection;

import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.Other;

/**
 * ģ��ʵ��JDK���ṩ��ArrayList��
 * @author 33136
 *
 */
public class MyArrayList {
	/**
     * The value is used for object storage.
     */
    private Object[] value;
    
    /**
     * The size is the number of objects used.
     */
    private int size;
    
    public MyArrayList()
    {
    	this(10);
    }
    
    public MyArrayList(int size)
    {
    	if (size < 0) {
			try {
				throw new Exception(); // �ֶ��׳�һ���쳣
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	value = new Object[size];
    }
    
    public int size() {
		return size;
	}
    
    public boolean isEmpty() {
		return size == 0;
	}
    
    public void add(Object obj) {
		value[size] = obj;
		size++;
		if (size >= value.length) {
			// ����
			int newCapacity = value.length * 2;
			Object[] newList = new Object[newCapacity];
			for (int i = 0; i < value.length; i++) {
				newList[i] = value[i];
			}
			value = newList;
		}
	}
    
    public Object get(int index) {
		rangeCheck(index);
		return value[index];
	}
    
    public int indexOf(Object obj) {
		if (obj == null) {
			return -1;
		}
		else {
			for (int i = 0; i < value.length; i++) {
				if (obj == value[i]) {
					return i;
				}
			}
			return -1;
		}
	}
    
    public int lastIndexOf(Object obj) {
		if (obj == null) {
			return -1;
		}
		else {
			for (int i = value.length - 1; i >= 0; i--) {
				if (obj == value[i]) {
					return i;
				}
			}
			return -1;
		}
	}
    
    public Object set(int index, Object obj) {
		rangeCheck(index);
		Object old = value[index];
		value[index] = obj;
		return old;
	}
    
    public void rangeCheck(int index) {
		if (index < 0 || index > size -1) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
    
    public static void main(String[] args) {
		MyArrayList  list = new MyArrayList(2);
		list.add("aaa");
		list.add(new Human("����"));
		list.add("bbbb");
		list.add("bbbb");
		list.add("bbbb");
		list.add("bbbb");
		ArrayList list2;
		
		Human h = (Human) list.get(1);
		System.out.println(h.getName());
		
//		System.out.println(list.get(3)); 
		System.out.println(list.size());
		
	}
}
