package com.nrm.GLEngine2D.GameObject;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import com.nrm.GLEngine2D.Collision.Collision;

public class GameObject {
	public Vector2f position;
	public Vector3f rotation;
	public Collision collision;
	public int layer;
	
	public GameObject(Vector2f pos,Vector3f rot,int lay){
		this.position = pos;
		this.rotation = rot;
		this.layer = lay;
	}
	public GameObject() {
		this.layer = 0;
		this.position = new Vector2f(0f, 0f);
		this.rotation = new Vector3f(0f, 0f, 0f);
	}
	
	public void update() {

	}

	public void render() {

	}

}
