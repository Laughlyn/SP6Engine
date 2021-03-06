package game.Engine;

import game.Engine.GFX.Sprite;

import java.awt.image.DataBufferInt;

public class Renderer {
	private int width, height;
	private int[] pixels;
	public Renderer(GameContainer gc){
		width = gc.getWidth();
		height = gc.getHeight();
		pixels = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	
	public void setPixel(int x, int y, int color){
		if (x<0 || x >= width || y < 0 || y >= height){	//|| a == 0
			return;
		}
		pixels[x+y*width] = color;
	}
	
	
	public void clear() {
		for(int x = 0; x <width; x++){
			for(int y = 0; y<height; y++){
				setPixel(x, y, 0xff000000);		//black, ff = alpha
			}
		}
	}
	
	public void drawSprite(Sprite sprite, int offX, int offY){
		for(int x = 0; x <sprite.getWidth(); x++){
			for(int y = 0; y<sprite.getHeight(); y++){
				setPixel(x + offX, y+offY, sprite.getPixels()[x + y * sprite.getWidth()]);
			}
		}
	}
}
