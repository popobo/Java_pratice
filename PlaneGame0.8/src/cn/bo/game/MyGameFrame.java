package cn.bo.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	Image planeImg = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Plane plane = new Plane(planeImg, 250, 250);
	Shell[] shells = new Shell[50];
	
	int planeX = 250, planeY = 250;
	
	@Override
	public void paint(Graphics g) // �Զ�������, g�൱��һֻ����
	{
		g.drawImage(bg, 0, 0, null);
		
		plane.drawSelf(g); // ���ɻ�
		
		// �������е��ڵ�
		for (int i = 0; i < shells.length; i++) 
		{
			shells[i].drawSelf(g);
			
			// �ɻ����ڵ�����ײ���
			boolean peng = shells[i].getRect().intersects(plane.getRect());
			if (peng)
			{
				plane.alive = false;
			}
		}
	}
	
	
	// �������Ƿ������ػ�����
	class PaintThread extends Thread
	{
		@Override
		public void run() 
		{
			while(true)
			{
				repaint(); // �ػ�
				try 
				{
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * ������̼������ڲ���
	 */
	class KeyMonitor extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{
			plane.addDirection(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e) 
		{
			plane.minusDirection(e);
		}
		
	}
	
	/**
	 * ��ʼ������
	 */
	public void launchFrame() {
		this.setTitle("bo");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(300, 300);
		
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		new PaintThread().start(); // �����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor()); // ���������Ӽ��̵ļ���
	
		// ��ʼ��50���ڵ�
		
		for (int i = 0; i < 50; i++) 
		{
			shells[i] = new Shell();
		}
	}
	
	public static void main(String[] args)
	{
		MyGameFrame frame = new MyGameFrame();
		frame.launchFrame();
	}
	
	private Image offScreenImage = null;
	
	public void update(Graphics g)
	{
		if (offScreenImage == null)
		{
			offScreenImage = this.createImage(Contant.GAME_WIDTH, Contant.GAME_HEIGHT); // ������Ϸ���ڵĿ�Ⱥ͸߶�
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
}
