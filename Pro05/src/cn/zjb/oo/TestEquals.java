package cn.zjb.oo;

public class TestEquals {
	public static void main(String[] args) {
		User u1 = new User(11);
		User u2 = new User(11);
		
		System.out.println(u1 == u2);
		System.out.println(u1.equals(u2));
	}
}


class User extends Person
{
	int age;
	
	public User(int age)
	{
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		return true;
	}

}