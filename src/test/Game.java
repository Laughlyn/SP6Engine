package test;

import com.G12.core.AbstractGame;
import com.G12.core.GameContainer;
import com.G12.core.Renderer;
import com.G12.core.components.GOManager;

public class Game extends AbstractGame {

	public GOManager manager;

	public Game() {
		manager = new GOManager();
		manager.addObject(new Player());
		manager.addObject(new Player2());
		manager.addObject(new Player3());
	}

	public static void main(String args[]) {
		GameContainer gc = new GameContainer(new Game(), "Cool game!");
		gc.setWidth(640);
		gc.setHeight(480);
		gc.setScale(2.0f);
		gc.start();
	}

	static float GRAVITY_X = 0;
	static float GRAVITY_Y = 5;

	@Override
	public void update(GameContainer gc, float dt) {
		manager.updateObjects(gc, dt);

	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		manager.renderObjects(gc, r);

	}
}
