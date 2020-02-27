package cn.bo.collentior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * ���Ե���������List Set Map �߱�����ɾ��ʱ�Ƚ�����
 * @author 33136
 *
 */
public class TestIterator {
	public static void main(String[] args) {
		testIteratorList();
	}
	
	public static void testIteratorList() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		for (Iterator<String> iter = list.iterator();iter.hasNext();)
		{
			String temp = iter.next();
			System.out.println(temp);
		}
		
		Set<String> set = new HashSet<String>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		for (Iterator<String> iter = set.iterator();iter.hasNext();)
		{
			String temp = iter.next();
			System.out.println(temp);
		}
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "dd");
		map.put(101, "bb");
		map.put(102, "cc");
		
		//��һ�ֱ���Map�ķ�ʽ
		Set<Entry<Integer, String>> en = map.entrySet();
		for (Iterator<Entry<Integer, String>> iter = en.iterator();iter.hasNext();)
		{
			Entry<Integer, String> tempEntry = iter.next();
			System.out.println(tempEntry.getKey() + ":" + tempEntry.getValue());
		}
		
		//�ڶ��ֱ���Map�ķ�ʽ
		Set<Integer> keySet = map.keySet();
		for (Iterator<Integer> iter = keySet.iterator();iter.hasNext();)
		{
			Integer key = iter.next();
 			System.out.println(key + "::" + map.get(key));
		}
	}
}
