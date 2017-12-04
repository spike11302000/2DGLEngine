package com.nrm.GLEngine2D;

import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;
import java.util.ArrayList;

import com.nrm.GLEngine2D.Audio.AudioManager;
import com.nrm.GLEngine2D.GameObject.Camera;
import com.nrm.GLEngine2D.GameObject.GameObject;
import com.nrm.GLEngine2D.Texture.TextureManager;
import static org.lwjgl.opengl.EXTFramebufferObject.*;

public class Engine extends Thread {
	public Window window;
	private int w, h;
	private String t;
	private Camera ActiveCam = new Camera();
	private ArrayList<GameObject> GameObjects = new ArrayList<GameObject>();
	public TextureManager textureManager = new TextureManager();
	public AudioManager audioManager = new AudioManager();
	private int fbo;
	private int depthbuffer;
	private int fb_texture;

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
		glEnable(GL_BLEND);
		glEnable(GL_TEXTURE_2D);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glClearColor(0f, 0f, 0f, 0f);

		this.createFBO();
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

	private void createFBO() {
		fbo = glGenFramebuffersEXT();
		glBindFramebufferEXT(GL_FRAMEBUFFER_EXT, fbo);
		depthbuffer = glGenRenderbuffersEXT();
		glBindRenderbufferEXT(GL_RENDERBUFFER_EXT, depthbuffer);
		glRenderbufferStorageEXT(GL_RENDERBUFFER_EXT, GL_DEPTH_COMPONENT, window.WIDTH, window.HEIGHT);
		glFramebufferRenderbufferEXT(GL_FRAMEBUFFER_EXT, GL_DEPTH_ATTACHMENT_EXT, GL_RENDERBUFFER_EXT, depthbuffer);
		fb_texture = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, fb_texture);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, window.WIDTH, window.HEIGHT, 0, GL_RGBA, GL_UNSIGNED_BYTE,
				(java.nio.ByteBuffer) null);
		glFramebufferTexture2DEXT(GL_FRAMEBUFFER_EXT, GL_COLOR_ATTACHMENT0_EXT, GL_TEXTURE_2D, fb_texture, 0);
		if (glCheckFramebufferStatusEXT(GL_FRAMEBUFFER_EXT) == GL_FRAMEBUFFER_COMPLETE_EXT) {
			System.out.println("Frame buffer created sucessfully.");
		} else
			System.out.println("An error occured creating the frame buffer.");
	}

	public void update() {
		for (GameObject GameObj : GameObjects) {
			GameObj.update();
		}
		this.textureManager.registerTexture();
		this.audioManager.registerAudio();
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-this.ActiveCam.getZoom(), this.ActiveCam.getZoom(), -this.ActiveCam.getZoom(),
				this.ActiveCam.getZoom(), -100, 100);
		glMatrixMode(GL_MODELVIEW);
		this.ActiveCam.setZoom(10);
	}

	public void render() {
		glLoadIdentity();

		glPushAttrib(GL_VIEWPORT_BIT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTranslatef(-this.ActiveCam.position.x, -this.ActiveCam.position.y, 0);
		glClear(GL_COLOR_BUFFER_BIT);
		for (GameObject GameObj : GameObjects) {
			GameObj.render();
			glBindTexture(GL_TEXTURE_2D, 0);
		}
		glPopAttrib();
		glBindFramebufferEXT(GL_FRAMEBUFFER_EXT, 0);
		glBindTexture(GL_TEXTURE_2D, fb_texture);
		glBegin(GL_QUADS);
		glTexCoord2f(0f, 0f);
		glVertex2f(1f, -1f);
		glTexCoord2f(1f, 0f);
		glVertex2f(1f, 1f);
		glTexCoord2f(1f, 1f);
		glVertex2f(1f, -1f);
		glTexCoord2f(0f, 1f);
		glVertex2f(-1f, -1f);
		glEnd();
		glBindTexture(GL_TEXTURE_2D, 0);

	}
}
