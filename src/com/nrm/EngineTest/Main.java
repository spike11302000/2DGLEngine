package com.nrm.EngineTest;
import com.nrm.GLEngine2D.Engine;
import com.nrm.GLEngine2D.GameObject.GameObjectTri;
import com.nrm.GLEngine2D.Texture.TextureManager;

public class Main {
	public static Engine engine = new Engine(640, 480, "engine test");

	public static void main(String[] args) {
		engine.start();
		engine.add(new GameObjectTri());
		//engine.textureManager.loadTexture("dirt.png", "test");
	}

}
