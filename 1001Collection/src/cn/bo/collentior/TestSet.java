package cn.bo.collentior;

import java.util.HashSet;
import java.util.Set;

/**
 * ����HashSet�Ļ����÷�
 * @author 33136
 *
 */
public class TestSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("aa");
		set.add("aa");
		set.add("bb");
		System.out.println(set);
	}
}
