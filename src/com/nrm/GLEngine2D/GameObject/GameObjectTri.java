package com.nrm.GLEngine2D.GameObject;

import org.lwjgl.opengl.GL11;

public class GameObjectTri extends GameObject {
	public void render() {
		
		GL11.glPushMatrix();
		GL11.glTranslatef(this.position.x,this.position.y,this.layer);
		GL11.glRotatef(this.rotation.x, 0, 0, 1);
		GL11.glBegin(GL11.GL_TRIANGLES);
		//GL11.glColor3f(1, 0, 0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 1);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(0f, 0f);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(-1f, 0.5f);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(0.5f, 0.5f);
		GL11.glEnd();
		GL11.glPopMatrix();
	}
	int tick = 0;;
	public void update(){
		tick++;
		this.position.x = (float) (Math.sin(tick/100.0f));
		this.position.y = (float) (Math.cos(tick/100.0f));
		//this.rotation.x+=10f;
	}
}
