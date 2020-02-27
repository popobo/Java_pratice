class Point
{
	double x;
	double y;
	
	public Point(double _x, double _y)
	{
		// super(); ���췽���ĵ�һ������super(); �����������Զ����
		x = _x;
		y = _y;
	}
	
	
	public double getDistance(Point p) 
	{
		return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
	}
	
}


public class TestConstructor {
	public static void main(String[] args) {
		Point p1 = new Point(3, 4);
		Point p2 = new Point(0, 0  );
		System.out.println(p1.getDistance(p2));
	}
}
