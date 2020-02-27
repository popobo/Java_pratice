package cn.zjb.oo;

public class TestSuper {
	public static void main(String[] args) {
		ChildClass c = new ChildClass();
		c.f();
	}
}

class FatherClass {
    public int value;
    
    public FatherClass() 
    {
		// TODO Auto-generated constructor stub
    	System.out.println("FatherClass.FatherClass()");
    }
    
    
    public void f(){
        value = 100;
        System.out.println ("FatherClass.value="+value);
    }
}
class ChildClass extends FatherClass {
    public int value;
    
    public ChildClass()
    {
    	super(); // 必须调用，没写系统会默认添加，这叫继承树回溯，
    			 // 先创建父类对象，再包裹形成子类对象，静态初始化，是类的回溯
    	System.out.println("ChildClass.ChildClass()");
    }
    
    public void f() {
        super.f();  //调用父类对象的普通方法
        value = 200;
        System.out.println("ChildClass.value="+value);
        System.out.println("child" + value);
        System.out.println("father" + super.value); //调用父类对象的成员变量
    }
}
