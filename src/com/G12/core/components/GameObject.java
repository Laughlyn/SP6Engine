package com.G12.core.components;

import java.util.ArrayList;

import com.G12.core.GameContainer;
import com.G12.core.Renderer;

public abstract class GameObject {
	
	protected float x, y, w, h;
	protected boolean obsolete = false;
	protected ArrayList<Component> components = new ArrayList<Component>();
	
	public abstract void update(GameContainer gc, float dt);
	public abstract void render(GameContainer gc, Renderer r);
	public abstract void componentEvent(Component component);
	
	public void updateComponents(GameContainer gc, float dt) {
		for(Component c :components) {
			c.update(gc, this, dt);
		}
	}
	
	public boolean isObsolete() {
		return obsolete;
	}
	
	public void addComponent(Component c) {
		components.add(c);
		if(c.getType().equals("Collider")) {
			
		}
	}
	
	public void removeComponent(Component c) {
		components.remove(c);
	}
	
	public float getY() {
		return y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getW() {
		return w;
	}
	
	public float getH() {
		return h;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setW(float w) {
		this.w = w;
	}
	
	public void setH (float h) {
		this.h = h;
	}
}
