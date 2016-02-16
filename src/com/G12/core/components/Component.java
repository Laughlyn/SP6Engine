package com.G12.core.components;

import com.G12.core.GameContainer;
import com.G12.core.Renderer;

public abstract class Component {
	public abstract void update(GameContainer gc, GameObject object, float dt);
	public abstract void render(GameContainer gc, Renderer r);
	public abstract String getType();
}
