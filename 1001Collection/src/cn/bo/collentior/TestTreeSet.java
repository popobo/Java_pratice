package cn.bo.collentior;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * test TresSet<必须实现Compare接口>
 * @author 33136
 *
 */
public class TestTreeSet {
	public static void main(String[] args) {
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(100);
		treeSet.add(200);
		treeSet.add(300);
		
		//按照元素递增的方式排好序
		for (Integer m:treeSet)
		{
			System.out.println(m);
		}
		
		Set<Stu>treeSet2 = new TreeSet<Stu>();
		
		treeSet2.add(new Stu(100, "a", 10003));
		treeSet2.add(new Stu(101, "b", 10003));
		treeSet2.add(new Stu(102, "c", 10004));
		treeSet2.add(new Stu(100, "a", 10003));
		treeSet2.add(new Stu(101, "b", 10003));
		treeSet2.add(new Stu(102, "c", 10004));
		
		for (Stu stu:treeSet2)
		{
			System.out.println(stu);
		}
	}
}
