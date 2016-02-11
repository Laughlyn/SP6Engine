package game.Engine.GFX;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	private int width, height;
	private int[] pixels;
	
	public Sprite(String path){
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(Sprite.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		width = image.getWidth();
		height = image.getHeight();
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
		

		
		image.flush(); 		//remove it from ram, java should do this by auto?
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getPixels() {
		return pixels;
	}
}
