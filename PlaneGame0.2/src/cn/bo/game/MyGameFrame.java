package cn.bo.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * �ɻ���Ϸ������
 * @author 33136
 *
 */
public class MyGameFrame extends JFrame
{
	
	Image ball = GameUtil.getImage("images/ball.png");
	
	@Override
	public void paint(Graphics g) // �Զ�������, g�൱��һֻ����
	{
		Color color = g.getColor();
		Font f = g.getFont();
		g.setColor(Color.BLUE);
		
		g.drawLine(100, 100, 300, 300);
		g.drawRect(100, 100, 100, 100);
		g.drawOval(100, 100, 100, 100);
		g.fillRect(100, 100, 40, 40);
		g.setColor(color.RED);
		g.setFont(new Font("����", Font.BOLD, 50));
		g.drawString("who am I", 200, 200);
		
		g.drawImage(ball, 250, 250, null);
		
		g.setColor(color);
		g.setFont(f);
	}
	
	/**
	 * ��ʼ������
	 */
	public void launchFrame() {
		this.setTitle("bo");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(300, 300);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		MyGameFrame frame = new MyGameFrame();
		frame.launchFrame();
	}
}
