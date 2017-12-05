package com.nrm.EngineTest;

import org.lwjgl.opengl.GL11;

import com.nrm.GLEngine2D.GameObject.GameObject;

public class GameObjectCircle extends GameObject {
	public void render() {
		GL11.glPushMatrix();
		GL11.glTranslatef(this.position.x, this.position.y, this.layer);
		GL11.glRotatef(this.rotation.x, 0, 0, 1);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, Main.engine.textureManager.getTextureID("color"));
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glVertex2f(0, 0);
		GL11.glTexCoord2d(0, 0);
		for (int i = 0; i <= 300; i++) {
			double angle = 2 * Math.PI * i / 300;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			GL11.glVertex2d(x * 10, y * 10);
			GL11.glTexCoord2d(x, y);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}
}
