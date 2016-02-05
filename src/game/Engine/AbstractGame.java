package game.Engine;

public abstract class AbstractGame {
	public abstract void update(GameContainer gc, float dt);	//implementera senare, delta tid och gc f�r w / h
	public abstract void render(GameContainer gc, Renderer ren);
}
