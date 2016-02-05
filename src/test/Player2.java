package test;

import java.awt.event.KeyEvent;

import com.G12.core.GameContainer;
import com.G12.core.Input;
import com.G12.core.InputState;
import com.G12.core.Renderer;
import com.G12.core.components.GameObject;
import com.G12.core.components.Physics;
import com.G12.core.fx.Image;
import com.G12.core.fx.Sound;

public class Player2 extends GameObject {

	private Image player = new Image("/character.png");

	private Sound coin = new Sound("/bell_ding1.wav");
	
	float speed = 150;
	float y = 200;
	float x = 150;
	float xVel = 0;
	float yVel = -300;

	@Override
	public void update(GameContainer gc, float dt) {
		if (Input.getKeyState(KeyEvent.VK_UP) == InputState.JustPressed) {
			yVel -= 300;
		}
		if (Input.getKeyState(KeyEvent.VK_LEFT) == InputState.JustPressed) {
			xVel -= speed;
		}
		if (Input.getKeyState(KeyEvent.VK_RIGHT) == InputState.JustPressed) {
			xVel += speed;
		}
		if (Input.getKeyState(KeyEvent.VK_DOWN) == InputState.JustPressed) {
			yVel += 300;
		}
		yVel += Game.GRAVITY;
		y += yVel * dt;
		x += xVel * dt;
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(player, (int) x, (int) y);
	}

}
