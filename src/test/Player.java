package com.G12.core;

import com.G12.core.GameContainer;
import com.G12.core.Input;
import com.G12.core.InputState;
import com.G12.core.Loader;
import com.G12.core.Renderer;
import com.G12.core.components.GameObject;
import com.G12.core.fx.Image;
import com.G12.core.fx.Sound;

import java.awt.event.KeyEvent;

public class Player extends GameObject {


	private Loader load = Loader.getInstance();
	private Image player = load.getImage("/Tank_tiny.png");
	private Sound coin = load.getSound("/bell_ding1.wav");
	//private Sound coin = new Sound("/bell_ding1.wav");
	//private Image player = new Image("/Tank_tiny.png");

	float speed = 50;
	float airSpeedMod = (float) 0.1;
	float maxSpeed = 200;
	float y = 50;
	float x = 50;
	float xVel = 0;
	float yVel = 0;
	private boolean grounded = false;

	@Override
	public void update(GameContainer gc, float dt) {
		if (Input.getKeyState(KeyEvent.VK_W) == InputState.JustPressed) {
			if (grounded){
				yVel -= 150;
				coin.play();
				grounded = false;
			}
		}
		if (Input.getKeyState(KeyEvent.VK_A) == InputState.StillPressed) {
			if(grounded){
				xVel -= speed;
			}
			else 
				xVel -= speed*airSpeedMod;
		}
		if (Input.getKeyState(KeyEvent.VK_D) == InputState.StillPressed) {
			if(grounded)
				xVel += speed;
			else 
				xVel += speed*airSpeedMod;
		}
		if (Input.getKeyState(KeyEvent.VK_S) == InputState.JustPressed) {
			if(!grounded)
				yVel += 150;
		}
		
		yVel += Game.GRAVITY_Y;
		xVel += Game.GRAVITY_X;
		yVel += yVel * 0;
		
		if(grounded)
			xVel += -1*xVel * 0.1;
		
		if (xVel > maxSpeed)
			xVel = maxSpeed;
		
		if (xVel < -1*maxSpeed)
			xVel = -1*maxSpeed;
		
		y += yVel * dt;
		if (y < 0){
			y = 0;
			yVel = (float) (yVel* -0.5);
		}
		if (y > 240-player.getHeight()){
			y = 240 - player.getHeight();
			yVel = (float) (yVel* -0.0);
			grounded = true;
		}
		x += xVel * dt;
		if (x > 320-player.getWidth()){
			x = 320 - player.getWidth();
			xVel = (float) (xVel* -0.5);
		}
		if (x < 0){
			x = 0;
			xVel = (float) (xVel* -0.5);
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(player, (int) x, (int) y);
	}

}
