package com.nrm.EngineTest;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.nrm.GLEngine2D.Engine;
import com.nrm.GLEngine2D.GameObject.Camera;
import com.nrm.GLEngine2D.GameObject.GameObject;
import com.nrm.GLEngine2D.GameObject.GameObjectBox;
import com.nrm.GLEngine2D.GameObject.GameObjectTri;

public class Main {
	public static Engine engine = new Engine(640, 480, "engine test");
	public static Camera camera = new Camera(1);

	public static void main(String[] args) {
		engine.start();
		engine.setActiveCamera(camera);
		engine.textureManager.addTexture("test.png", "test");
		//engine.add(new GameObjectTri());
		
		engine.add(new GameObjectBox(new Vector2f(0f,.0f),new Vector3f(0,0,0),5));
		engine.add(new GameObjectBox(new Vector2f(0f,.2f),new Vector3f(0,0,0),0));
	}
}
