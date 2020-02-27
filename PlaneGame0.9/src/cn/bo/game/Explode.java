package cn.bo.game;

import java.awt.Graphics;
import java.awt.Image;

/**
 * ��ը��
 * @author 33136
 *
 */
public class Explode {
	double x;
	double y;
	static Image[] imgs = new Image[16];
	
	static 
	{
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");
			imgs[i].getWidth(null);
		}
	}
	
	int count = 0;
	
	public void draw(Graphics g)
	{
		if (count <= imgs.length - 1) 
		{
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	
	public Explode(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
}
