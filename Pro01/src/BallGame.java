//import java.awt.*;
//
//import javax.swing.JFrame;
//
//public class BallGame extends JFrame {
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
//		if (right) 
//		{
//			x += 10;
//		}
//		else 
//		{
//			x -= 10;
//		}
//		
//		if (x < 0) 
//		{
//			right = true;
//		}
//		else if (x > 856 - 40 -30)
//		{
//			right = false;
//		}	
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
//				Thread.sleep(40);
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
//		BallGame game = new BallGame();
//		game.launchFrame();
//	}
//}
