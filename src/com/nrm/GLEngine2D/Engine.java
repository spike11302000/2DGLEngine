package com.nrm.GLEngine2D;

import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;
import java.util.ArrayList;
import com.nrm.GLEngine2D.GameObject.Camera;
import com.nrm.GLEngine2D.GameObject.GameObject;
import com.nrm.GLEngine2D.Texture.TextureManager;

public class Engine extends Thread {
	public Window window;
	private int w, h;
	private String t;
	private Camera ActiveCam = new Camera();
	private ArrayList<GameObject> GameObjects = new ArrayList<GameObject>();
	public TextureManager textureManager = new TextureManager();

	public Engine(int width, int height, String title) {
		this.w = width;
		this.h = height;
		this.t = title;
	}

	public void run() {
		window = new Window(this.w, this.h, this.t);

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-1, 1, -1, 1, -1, 1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);

		while (!Display.isCloseRequested()) {
			window.update();
			this.update();
			this.render();
		}
	}

	public void setActiveCamera(Camera cam) {
		this.ActiveCam = cam;
	}

	public Camera getActiveCamera() {
		return this.ActiveCam;
	}

	public void add(GameObject GameObj) {
		GameObjects.add(GameObj);
	}

	public void update() {
		for (GameObject GameObj : GameObjects) {
			GameObj.update();
		}
		this.textureManager.registerTexture();
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-this.ActiveCam.getZoom(), this.ActiveCam.getZoom(), -this.ActiveCam.getZoom(),
				this.ActiveCam.getZoom(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
	}

	public void render() {
		glLoadIdentity();
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTranslatef(-this.ActiveCam.position.x, -this.ActiveCam.position.y, 0);
		glClear(GL_COLOR_BUFFER_BIT);
		for (GameObject GameObj : GameObjects) {
			GameObj.render();
		}
	}
}
