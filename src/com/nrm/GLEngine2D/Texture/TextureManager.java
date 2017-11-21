package com.nrm.GLEngine2D.Texture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureManager {
	private HashMap<String, Texture> TextureMap = new HashMap<String, Texture>();
	private HashMap<String, String> toLoad = new HashMap<String, String>();

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
		
		this.TextureMap.put(name, texture);
		System.out.println(this.getTextureID(name));
	}

	public void addTexture(String path, String name) {
		this.toLoad.put(name, path);
	}
	public int getTextureID(String name){
		return this.TextureMap.get(name).getTextureID();
	}
	public void registerTexture(){
		if(!this.toLoad.isEmpty()){
			for(Entry<String, String> e : this.toLoad.entrySet()) {
		        String key = e.getKey();
		        String value = e.getValue();
		        this.loadTexture(value, key);
		    }
			this.toLoad.clear();
		}
	}
}
