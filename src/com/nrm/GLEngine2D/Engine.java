package com.nrm.GLEngine2D;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

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
		this.textureManager.loadTexture("test.png", "test");
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity(); // Resets any previous projection matrices
		glOrtho(-1, 1, -1, 1, -1, 1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		//glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		
		while (!Display.isCloseRequested()) {
			window.update();
			this.render();
			this.update();
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
	int tick = 0;
	public void update() {
		for (GameObject GameObj : GameObjects) {
			GameObj.update();
		}
		tick++;
		this.ActiveCam.setZoom(1);
		//this.ActiveCam.position.x=(float) Math.sin(tick/10.0f)*10;
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-this.ActiveCam.getZoom(), this.ActiveCam.getZoom(), -this.ActiveCam.getZoom(),
				this.ActiveCam.getZoom(), -1, 1);
		glMatrixMode(GL_MODELVIEW);

	}

	public void render() {
		glLoadIdentity();
		glTranslatef(-this.ActiveCam.position.x, -this.ActiveCam.position.y, 0);
		glClear(GL_COLOR_BUFFER_BIT);
		for (GameObject GameObj : GameObjects) {
			GameObj.render();
		}
	}
}
