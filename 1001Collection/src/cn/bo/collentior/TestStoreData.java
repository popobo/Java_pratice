package cn.bo.collentior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ���Ա�����ݵĴ洢
 * ORM˼��:�����ϵӳ�� map�洢һ������   
 * @author 33136
 *
 */
public class TestStoreData {
	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<String, Object>();
		row1.put("id", 1001);
		row1.put("����", "a");
		row1.put("нˮ", 2000);
		row1.put("��ְ����", "2019.10.18");
		
		Map<String, Object> row2 = new HashMap<String, Object>();
		row2.put("id", 1002);
		row2.put("����", "b");
		row2.put("нˮ", 20000);
		row2.put("��ְ����", "2019.10.18");
		
		Map<String, Object> row3 = new HashMap<String, Object>();
		row3.put("id", 1003);
		row3.put("����", "c");
		row3.put("нˮ", 200000);
		row3.put("��ְ����", "2019.10.18");
		
		List<Map<String, Object>> table1 = new ArrayList<Map<String, Object>>();
		table1.add(row1);
		table1.add(row2);
		table1.add(row3);
		
		for (Map<String, Object> row:table1) {
			Set<String> keyset = row.keySet();
			for (String key:keyset) {
				System.out.print(key + ":" + row.get(key) + '\t');
			}
			System.out.println();
		}
	}
}
