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
    	super(); // ������ã�ûдϵͳ��Ĭ����ӣ���м̳������ݣ�
    			 // �ȴ�����������ٰ����γ�������󣬾�̬��ʼ��������Ļ���
    	System.out.println("ChildClass.ChildClass()");
    }
    
    public void f() {
        super.f();  //���ø���������ͨ����
        value = 200;
        System.out.println("ChildClass.value="+value);
        System.out.println("child" + value);
        System.out.println("father" + super.value); //���ø������ĳ�Ա����
    }
}
