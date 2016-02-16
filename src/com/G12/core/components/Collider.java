package com.G12.core.components;

import com.G12.core.GameContainer;
import com.G12.core.Renderer;

public class Collider extends Component{
	float x, y, hW, hH;
	private GameObject owner;

	public Collider(GameObject object) {
		this.owner = object;
		x = owner.getX();
		y = owner.getY();
		Physics.addCollider(this);
	}

	@Override
	public void update(GameContainer gc, GameObject object, float dt)
	{
		x = owner.getX();
		y = owner.getY();
		hW = owner.getW()/2;
		hH = owner.getH()/2;
	}


	@Override
	public void render(GameContainer gc, Renderer r) {
		// TODO Auto-generated method stub
		
	}
	
	public void collision(GameObject object) {
		object.componentEvent(this);
	}

	@Override
	public String getType() {
		return "Collider";
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public GameObject getObject() {
		return owner;
	}

	public void setObject(GameObject object) {
		this.owner = object;
	}

	public float gethW() {
		return hW;
	}

	public float gethH() {
		return hH;
	}
}
