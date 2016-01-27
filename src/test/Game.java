package test;

import java.awt.event.KeyEvent;

import com.G12.core.AbstractGame;
import com.G12.core.GameContainer;
import com.G12.core.Input;
import com.G12.core.Renderer;
import com.G12.core.fx.Image;

public class Game extends AbstractGame {

	private Image image = new Image("/characters.png");

	public static void main(String args[]) {
		GameContainer gc = new GameContainer(new Game());
		gc.start();
	}
	
	float y = 0;
	float x = 0;
	float xVel = 150;
	float yVel = 0;
	float GRAVITY = 100;

	@Override
	public void update(GameContainer gc, float dt) {
		if (Input.isKey(KeyEvent.VK_A)) {
			yVel += GRAVITY;
			y += yVel * dt;
			x += xVel * dt;
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(image, (int)x, (int)y);
	}
}
