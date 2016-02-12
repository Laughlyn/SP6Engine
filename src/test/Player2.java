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
	
	float speed = 50;
	float maxSpeed = 200;
	float y = 100;
	float x = 150;
	float xVel = 0;
	float yVel = 0;
	private boolean grounded = false;

	@Override
	public void update(GameContainer gc, float dt) {
		if (Input.getKeyState(KeyEvent.VK_UP) == InputState.JustPressed) {
			if (grounded) {yVel -= 150;
			coin.play();
			grounded = false;}
		}
		if (Input.getKeyState(KeyEvent.VK_LEFT) == InputState.StillPressed) {
			if(grounded)xVel -= speed;
			else xVel -= speed*0.1;
		}
		if (Input.getKeyState(KeyEvent.VK_RIGHT) == InputState.StillPressed) {
			if(grounded)xVel += speed;
			else xVel += speed*0.1;
		}
		if (Input.getKeyState(KeyEvent.VK_DOWN) == InputState.JustPressed) {
			if(!grounded) yVel += 150;
		}
		yVel += Game.GRAVITY_Y;
		xVel += Game.GRAVITY_X;
		if (xVel > maxSpeed) xVel = maxSpeed;
		if (-1*xVel < -1*maxSpeed) xVel = -1*maxSpeed;
		y += yVel * dt;
		if (y < 0) {y = 0; yVel = (float) (yVel* -0.7);;}
		if (y > 240-player.getHeight()) {y = 240 - player.getHeight(); yVel = (float) (yVel* -0.7);}
		x += xVel * dt;
		if (x > 320-player.getWidth()) {x = 320 - player.getWidth(); xVel = (float) (xVel* -0.7);}
		if (x < 0) {x = 0; xVel = (float) (xVel* -0.7);}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(player, (int) x, (int) y);
	}

}
