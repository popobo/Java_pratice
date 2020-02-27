package cn.bo.collentior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Collections辅助类的使用
 * @author 33136
 *
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
//		Collections.shuffle(list);
//		Collections.reverse(list);
		Collections.sort(list);
		System.out.println(Collections.binarySearch(list, "dd"));
		for (Iterator<String> iter = list.iterator();iter.hasNext();)
		{
			String temp = iter.next();
			System.out.println(temp);
		}
	}
}
