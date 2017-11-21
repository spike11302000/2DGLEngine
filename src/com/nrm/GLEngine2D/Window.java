package com.nrm.GLEngine2D;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {
	private int WIDTH;
	private int HEIGHT;
	private String TITLE;
	public Window(int w, int h, String title) {
		WIDTH = w;
		HEIGHT = h;
		TITLE = title;
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle(TITLE);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
	}

	public Window() {

	}

	public void CreateWindow(int w, int h, String title) {
		WIDTH = w;
		HEIGHT = h;
		TITLE = title;
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle(TITLE);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public void setTitle(String title) {
		TITLE = title;
	}

	public void update() {
		Display.update();
		Display.sync(60);
	}
}
