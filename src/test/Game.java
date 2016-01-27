package test;

import gfx.Image;

import java.awt.event.KeyEvent;

import com.G12.core.AbstractGame;
import com.G12.core.GameContainer;
import com.G12.core.Input;
import com.G12.core.Renderer;

public class Game extends AbstractGame {

	private Image image = new Image("/characters.png");

	public static void main(String args[]) {
		GameContainer gc = new GameContainer(new Game());
		gc.start();
	}
	
	float x = 0;

	@Override
	public void update(GameContainer gc, float dt) {
		if (Input.isKey(KeyEvent.VK_A)) {
			x += dt * 50;
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(image, (int)x, 50);
	}
}
