package com.G12.core.components;

import java.util.ArrayList;

public class Physics {
	private static ArrayList<Collider> colliders = new ArrayList<Collider>();

	public Physics() {
		
	}

	public static void addCollider(Collider c) {
		colliders.add(c);
	}

	public void update() {
		for (int i = 0; i < colliders.size(); i++) {
			for (int j = i + 1; j < colliders.size(); j++) {
				Collider c0 = colliders.get(i);
				Collider c1 = colliders.get(j);

				if (Math.abs(c0.getX() - c1.getX()) < c0.gethW() + c1.gethW()) {
					if (Math.abs(c0.getY() - c1.getY()) < c0.gethH() + c1.gethH()) {
						c0.collision(c1.getObject());
						c1.collision(c0.getObject());
					}
				}
			}
		}
	}
}
