package cn.bo.collentior;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 * ����List�еķ���
 * @author 33136
 *
 */

public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		//ArrayList���ײ�ʵ�������飬�̲߳���ȫ��Ч�ʸߣ���ѯ�졣�޸ġ����롢ɾ����
		//LinkedList���ײ�ʵ���������̲߳���ȫ��Ч�ʸߣ���ArrayList�෴
		//Vector���̰߳�ȫ��Ч�ʵ�
		
		Date date = new Date();
		list.add("aaa");  
//		list.add(new Date());
		list.add(date);
		list.add(new Dog());
		list.add(1234); //��װ��:�Զ�װ��
		
		System.out.println(list.size()); // 4
		System.out.println(list.isEmpty()); // false
//		list.remove(new Date()); //hashCode��equals�ж϶����Ƿ����
		list.remove(date);
		System.out.println(list.size()); // 3
		list.remove("aaa");
		System.out.println(list.size()); // 2
		list.remove(new Dog());
		System.out.println(list.size()); // 2
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		System.out.println(list.size()); 
		
		//��˳���йصĲ���
		list.set(0,"ababa");
		String string = (String) list.get(0);
		System.out.println(string);
		list.set(1,"ababa");
		list.remove(0);  
	}
}

class Dog {
	
}