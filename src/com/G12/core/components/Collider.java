package com.G12.core.components;

import com.G12.core.GameContainer;
import com.G12.core.Renderer;

public class Collider extends Component{
	float x, y, hW, hH, xOffset=0, yOffset=0, wOffset=0, hOffset = 0;
	private GameObject owner;

	public Collider(GameObject object) {
		this.owner = object;
		x = owner.getX();
		y = owner.getY();
		Physics.addCollider(this);
	}
	
	public Collider (GameObject object, int x, int y, int w, int h) {
		this.owner = object;
		xOffset = x;
		yOffset = y;
		wOffset = w;
		hOffset = h;
		Physics.addCollider(this);
	}

	@Override
	public void update(GameContainer gc, GameObject object, float dt)
	{
		x = owner.getX()+xOffset;
		y = owner.getY()+yOffset;
		hW = owner.getW()/2+wOffset;
		hH = owner.getH()/2+hOffset;
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
