package com.G12.core.components;

import java.util.LinkedList;
import java.util.List;

import com.G12.core.GameContainer;
import com.G12.core.Renderer;

public class GOManager {

	private List<GameObject> gameObjects = new LinkedList<GameObject>();

	public void updateObjects(GameContainer gc, float dt) {
		for (int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).update(gc, dt);

			if (gameObjects.get(i).isObsolete())
				gameObjects.remove(i);
		}
	}
	
	public void renderObjects(GameContainer gc, Renderer r)
	{
		for(int i = 0; i < gameObjects.size(); i++)
		{
			gameObjects.get(i).render(gc, r);
		}
	}
	
	public void addObject(GameObject object)
	{
		gameObjects.add(object);
	}
	
}
