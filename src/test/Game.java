package test;

import com.G12.core.*;

import java.awt.event.KeyEvent;

import com.G12.core.AbstractGame;
import com.G12.core.GameContainer;
import com.G12.core.InputState;
import com.G12.core.Renderer;
import com.G12.core.fx.Image;
import com.G12.core.fx.Sound;

public class Game extends AbstractGame {

	private Image characters = new Image("/characters.png");
	
	private Sound coin = new Sound("/coin pickup.wav");

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
			coin.play();
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(characters, (int)x, (int)y);
		
		//		r.drawString("Hello!", 0, 0);
	}
}
