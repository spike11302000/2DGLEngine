package com.nrm.EngineTest;
import com.nrm.GLEngine2D.Engine;
import com.nrm.GLEngine2D.GameObject.Camera;
import com.nrm.GLEngine2D.GameObject.GameObjectTri;

public class Main {
	public static Engine engine = new Engine(640, 480, "engine test");
	public static Camera camera = new Camera(1);
	public static void main(String[] args) {
		engine.start();
		engine.setActiveCamera(camera);
		engine.textureManager.addTexture("dirt.png", "test");
		engine.add(new GameObjectTri());	
	}
}
