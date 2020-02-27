package cn.bo.innerClass;

/**
 * 测试内部类的示例
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
		
		Face.color = "苍白";
		Face.Ear ear = new Face.Ear();
		ear.listen();
	}
}

class Face
{
	public int type;
	public String shape = "瓜子脸";
	public static String color = "红润";
	
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
			System.out.println("呼吸");
		}
	}
	
	static class Ear
	{
		void listen()
		{
			System.out.println(color);
			System.out.println("我在听");
		}
	}
}
