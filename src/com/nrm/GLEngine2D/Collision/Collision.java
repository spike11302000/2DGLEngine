package com.nrm.GLEngine2D.Collision;

import org.lwjgl.util.vector.Vector2f;

public class Collision {
	public Vector2f position;
	public Vector2f size;

	public Collision() {
		this.position = new Vector2f();
		this.size = new Vector2f();
	}

	public Collision(Vector2f pos, Vector2f s) {
		this.position = pos;
		this.size = s;
	}

	public boolean contains(Vector2f point) {
		return point.x >= this.position.x && point.y >= this.position.y && point.x <= (this.size.x + this.position.x)
				&& point.y <= (this.size.y + this.position.y);
	}

	public boolean intersects(Collision col) {
		return this.position.x < col.position.x + col.size.x && this.position.x + this.size.x > col.position.x
				&& this.position.y < col.position.y + col.size.y && this.position.y + this.size.y > col.position.y;
	}
}
