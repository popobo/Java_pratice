package cn.bo.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject
{
	int speed = 3;
	boolean left;
	boolean up;
	boolean right;
	boolean down;
	boolean alive = true;
	
	public void drawSelf(Graphics g)
	{
		if (alive)
		{
			g.drawImage(img, (int)x, (int)y, null);
			
			if (left) 
			{
				x -= speed;
			}
			if (right)
			{
				x += speed;
			}
			if (up)
			{
				y -= speed;
			}
			if (down)
			{
				y += speed;
			}
		}
		else
		{	
		}
	}
	
	public Plane(Image img, double x, double y)
	{
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	// ����ĳ����, ������Ӧ�ķ���
	public void addDirection(KeyEvent e) 
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	
	// ����ĳ����, ȡ����Ӧ�ķ���
	public void minusDirection(KeyEvent e) 
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}
	
}
