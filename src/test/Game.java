package test;

import com.G12.core.*;

import java.awt.event.KeyEvent;

import com.G12.core.AbstractGame;
import com.G12.core.GameContainer;
import com.G12.core.InputState;
import com.G12.core.Renderer;
import com.G12.core.fx.Image;
import com.G12.core.fx.Text;

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
		if (Input.getKeyState(KeyEvent.VK_A)==InputState.JustPressed) {
			yVel += GRAVITY;
			y += yVel * dt;
			x += xVel * dt;
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(image, (int)x, (int)y);
//		r.drawString("Hello!", 0, 0);
	}
}
