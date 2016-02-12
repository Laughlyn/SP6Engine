package com.G12.core;


public class GameContainer implements Runnable {
	private Thread thread;
	private AbstractGame game;
	private Window window;
	private Renderer ren;
	private Input input;

	private boolean isRunning = false;
	private double frameCap = 1.0 / 60.0;
	private int width;
	private int height;
	private float scale;	
	private String fpsCounter = "";
	private String title = "Game Engine - Training";


	public GameContainer(AbstractGame game, String title) {
		this.game = game;
		this.title = title;
	}


	public void start() {
		if (isRunning)
			return;

		// initialize engine components
		window = new Window(this);
		ren = new Renderer(this);
		input = new Input(this);

		thread = new Thread(this);
		thread.run();
	}

	public void stop() {
		if (!isRunning)
			return;
		isRunning = false;
	}

	public void run() {
		//control frame-rate and how often we update
		isRunning = true;
		/* delta time */
		double firstTime = 0;
		double lastTime = System.currentTimeMillis() / 1000.0; // to convert
															// nanosec to sec;
		double passedTime = 0;
		double unprocessedTime = 0;

		/* fps counter */
		double frameTime = 0;
		int frames = 0;

		while (isRunning) {
			boolean render = true;

			firstTime = System.currentTimeMillis() / 1000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;

			unprocessedTime += passedTime;
			frameTime += passedTime;

			while (unprocessedTime > frameCap) {
				game.update(this, (float) frameCap);
				input.update();
				unprocessedTime -= frameCap;
				render = true;

				if (frameTime >= 1) {
					frameTime = 0;
					fpsCounter = "" + frames;
					frames = 0;
				}
			}

			if (render) {
				ren.clear();
				game.render(this, ren); //render game
				// render game
				// update window
				window.update();
				frames++;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			cleanUp();

		}
	}

	private void cleanUp() {

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public String getTitle() {
		return title+ " - FPS: " + fpsCounter;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Window getWindow() {
		return window;
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> origin/Loader
