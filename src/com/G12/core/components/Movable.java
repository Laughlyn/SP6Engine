package com.G12.core.components;

import com.G12.core.GameContainer;
import com.G12.core.Renderer;

public class Movable extends Component {
	private GameObject owner;
	
	float xVel = 4;
	float yVel = 4;
	
	public Movable(GameObject object) {
		this.owner = object;
	}
	
	public GameObject getObject() {
		return owner;
	}

	@Override
	public void update(GameContainer gc, GameObject object, float dt) {
		//object.setX(object.getX()+xVel*dt);
		//object.setY(object.getY()+yVel*dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		return "Movable";
	}

}
