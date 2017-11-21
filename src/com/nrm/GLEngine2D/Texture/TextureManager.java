package com.nrm.GLEngine2D.Texture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureManager {
	private HashMap<String, Texture> TextureMap = new HashMap<String, Texture>();

	public void loadTexture(String path, String name) {
		System.out.println("Loading: " + path + " as " + name);
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/" + path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println(texture.getTextureID());
		TextureMap.put(name, texture);
	}
}
