package com.nrm.GLEngine2D.GameObject;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import com.nrm.GLEngine2D.Collision.Collision;

public class GameObject {
	public Vector2f position;
	public Vector2f size;
	public Vector3f rotation;
	public Collision collision;
	public int layer;
	
	public GameObject(Vector2f pos,Vector3f rot,Vector2f s,int lay){
		this.position = pos;
		this.rotation = rot;
		this.size = s;
		this.layer = lay;
		this.collision = new Collision(pos,s);
	}
	public GameObject(Vector2f pos,Vector3f rot,int lay){
		this.position = pos;
		this.rotation = rot;
		this.layer = lay;
		this.collision = new Collision();
	}
	public GameObject() {
		this.layer = 0;
		this.position = new Vector2f();
		this.size = new Vector2f();
		this.rotation = new Vector3f();
		this.collision = new Collision();
	}
	public boolean hasCollision(){
		return false;
	}
	public void update() {

	}

	public void render() {

	}

}
