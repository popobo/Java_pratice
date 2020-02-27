package cn.bo.collentior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试表格数据的存储
 * ORM思想:对象关系映射 map存储一行数据   
 * @author 33136
 *
 */
public class TestStoreData {
	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<String, Object>();
		row1.put("id", 1001);
		row1.put("姓名", "a");
		row1.put("薪水", 2000);
		row1.put("入职日期", "2019.10.18");
		
		Map<String, Object> row2 = new HashMap<String, Object>();
		row2.put("id", 1002);
		row2.put("姓名", "b");
		row2.put("薪水", 20000);
		row2.put("入职日期", "2019.10.18");
		
		Map<String, Object> row3 = new HashMap<String, Object>();
		row3.put("id", 1003);
		row3.put("姓名", "c");
		row3.put("薪水", 200000);
		row3.put("入职日期", "2019.10.18");
		
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
