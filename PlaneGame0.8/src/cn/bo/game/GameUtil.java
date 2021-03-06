package cn.bo.game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class GameUtil 
{
	// 工具类最好将构造器私有化
	private GameUtil()
	{
	}
	
	/**
	 * 返回指定路径文件的图片对象
	 */
	public static Image	getImage(String path)
	{
		BufferedImage image = null;
		try {
			URL u = GameUtil.class.getClassLoader().getResource(path);
			image = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
