package cn.bo.innerClass;

/**
 * �����ڲ����ʾ��
 * @author 33136
 *
 */
public class Outer 
{
	public static void main(String[] args) 
	{
		Face face = new Face(11, "long face");
		Face face2 = new Face(12, "short face");
		
		Face.Nose nose = face.new Nose();
		nose.breath();
		Face.Nose nose2 = face2.new Nose();
		nose2.breath();
		
		Face.color = "�԰�";
		Face.Ear ear = new Face.Ear();
		ear.listen();
	}
}

class Face
{
	public int type;
	public String shape = "������";
	public static String color = "����";
	
	public Face(int type, String shape) 
	{
		this.type = type;
		this.shape = shape;
	}
	
	
	class Nose
	{
		void breath()
		{
			System.out.println(shape);
			System.out.println(Face.this.type);
			System.out.println("����");
		}
	}
	
	static class Ear
	{
		void listen()
		{
			System.out.println(color);
			System.out.println("������");
		}
	}
}
