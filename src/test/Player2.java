package test;

import java.awt.event.KeyEvent;

import com.G12.core.GameContainer;
import com.G12.core.Input;
import com.G12.core.InputState;
import com.G12.core.Renderer;
import com.G12.core.components.Collider;
import com.G12.core.components.Component;
import com.G12.core.components.GameObject;
import com.G12.core.components.Movable;
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
	float lastX;
	float lastY;
	private boolean grounded = false;
	
	public Player2() {
		setX(x);
		setY(y);
		setW(player.getWidth());
		setH(player.getHeight());
		addComponent(new Collider(this));
		addComponent(new Movable(this));
	}

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
		yVel += yVel * 0;

		if (grounded)
			xVel += -1 * xVel * 0.15;

		if (xVel > maxSpeed)
			xVel = maxSpeed;

		if (xVel < -1 * maxSpeed)
			xVel = -1 * maxSpeed;

		setY(getY() + yVel * dt);
		if (getY() < 0) {
			setY(0);
			yVel = (float) (yVel * -0.5);
		}
		
		if (getY() > gc.getHeight()-player.getHeight()){
			setY(gc.getHeight() - player.getHeight());
			yVel = (float) (yVel* -0.0);
			grounded = true;
		}
		
		setX(getX() + xVel * dt);
		if (getX() > gc.getWidth()-player.getWidth()){
			setX(gc.getWidth() - player.getWidth());
			xVel = (float) (xVel* -0.5);
		}
		
		if (getX() < 0) {
			setX(0);
			xVel = (float) (xVel * -0.5);
		}
		lastX = getX();
		lastY = getY();
		updateComponents(gc, dt);		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(player, (int) getX(), (int) getY());
	}

	@Override
	public void componentEvent(Component component) {
		if(component.getType().equals("Collider")) {
			System.out.println("Heydsfdgfdgfdgah");
			setX(lastX);
			setY(lastY);
			setxVel(0);
			setyVel(0);
		}
	}

	public float getxVel() {
		return xVel;
	}

	public void setxVel(float xVel) {
		this.xVel = xVel;
	}

	public float getyVel() {
		return yVel;
	}

	public void setyVel(float yVel) {
		this.yVel = yVel;
	}

}
