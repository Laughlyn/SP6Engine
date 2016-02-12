package com.G12.core.components;

public class Physics {
	private float gravity_x;
	private float gravity_y;

	public Physics() {
		gravity_x = 1;
		gravity_y = 1;
	}
	
	public Physics(float x, float y) {
		gravity_x = x;
		gravity_y = y;
	}

	public float getGravity_x() {
		return gravity_x;
	}
	
	public float getGravity_y() {
		return gravity_y;
	}

	public void setGravity(float x, float y) {
		gravity_x = x;
		gravity_y = y;
	}
}
