//import java.awt.*;
//
//import javax.swing.JFrame;
//
//public class BallGame2 extends JFrame {
//	
//	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
//	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
//	
//	
//	double x = 100;
//	double y = 100;
//	boolean right = true;
//	
//	double degree = 3.14/3; // ����
//	
//	// �����ڵķ���
//	public void paint(Graphics g)
//	{
//		g.drawImage(desk, 0, 0, null);
//		g.drawImage(ball, (int)x, (int)y, null);
//		System.out.println("���ڻ���һ��");
//		
//		x += 10*Math.cos(degree);
//		y += 10*Math.sin(degree);
//		
//		if (y > 500 - 40 - 30 || y < 80) 
//		{
//			degree = -degree;
//		}
//		if (x < + 40 || x > 856 - 40 -30)
//		{
//			degree = 3.14 - degree;
//		}
//		
//	}
//	
//	//���ڼ���
//	void launchFrame()
//	{
//		setSize(856, 500);
//		setLocation(50, 50);
//		setVisible(true);
//		
//		// �ػ�����
//		while(true)
//		{
//			repaint();
//			try {
//				Thread.sleep(20);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
//	
//	
//	// main�����ǳ���ִ�е����
//	public static void main(String[] args) 
//	{
//		System.out.println("hello world");
//		BallGame2 game = new BallGame2();
//		game.launchFrame();
//	}
//}
