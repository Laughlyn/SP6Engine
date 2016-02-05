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
	
	public void updateComponents(GameContainer gc, float dt) {
		
		for(Component c :components) {
			c.update(gc, this, dt);
		}
		
	}
	
	public boolean isObsolete() {
		return obsolete;
	}
	
}
