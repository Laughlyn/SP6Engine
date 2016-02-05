package test;

import java.awt.event.KeyEvent;

import com.G12.core.GameContainer;
import com.G12.core.Input;
import com.G12.core.InputState;
import com.G12.core.Renderer;
import com.G12.core.components.GameObject;
import com.G12.core.fx.Image;
import com.G12.core.fx.Sound;

public class Player extends GameObject {

	private Image player = new Image("/character.png");

	private Sound coin = new Sound("/bell_ding1.wav");

	float y = 50;
	float x = 50;
	float xVel = 150;
	float yVel = 0;

	@Override
	public void update(GameContainer gc, float dt) {
		if (Input.getKeyState(KeyEvent.VK_A) == InputState.JustPressed) {
			yVel += Game.GRAVITY;
			y += yVel * dt;
			x += xVel * dt;
			coin.play();
		}

	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(player, (int) x, (int) y);
	}

}
