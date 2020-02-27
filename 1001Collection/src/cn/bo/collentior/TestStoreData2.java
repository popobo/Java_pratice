package cn.bo.collentior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 测试表格数据的存储
 * 体会ORM思想
 * 每一行数据使用javabean对象存储 多行使用放到map或list中
 * @author 33136
 *
 */
public class TestStoreData2 {
	public static void main(String[] args) {
		User user1 = new User(1001, "a", 2000, "2019.10.18");
		User user2 = new User(1002, "b", 20000, "2019.10.18");
		User user3 = new User(1003, "c", 200000, "2019.10.18");
		User user4 = new User(1004, "d", 2000000, "2019.10.18");
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		for (User user:list) {
			System.out.println(user);
		}
		Map<Integer, User> map = new HashMap<Integer, User>();
		map.put(1001, user1);
		map.put(1002, user2);
		map.put(1003, user3);
		Set<Integer> keySet = map.keySet();
		for (Integer key:keySet) {
			System.out.println(map.get(key));
		}
	}
}

class User {
	private int id;
	private String name;
	private double salary;
	private String hireDate;
	
	@Override
	public String toString() {
		return "id:" + id + " name" + name + " salary" + salary + " data" + hireDate;
	}
	
	//一个完整的javabean 要有set和get方法 以及一个无参构造器
	public User() {
		
	}
	
	public User(int id, String name, double salary, String hireDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	
}