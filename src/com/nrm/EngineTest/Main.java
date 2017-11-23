package com.nrm.EngineTest;

import com.nrm.GLEngine2D.Engine;
import com.nrm.GLEngine2D.GameObject.Camera;
import com.nrm.GLEngine2D.GameObject.GameObjectBox;

public class Main {
	public static Engine engine = new Engine(640, 480, "engine test");
	public static Camera camera = new Camera(1);
	public static int ooff;
	public static void main(String[] args) {
		
		engine.start();
		engine.setActiveCamera(camera);
		engine.textureManager.addTexture("test.png", "test");
		ooff = engine.audioManager.loadSound("ooff.wav", "test");
		engine.add(new GameObjectBox());
		
	}
}
