package com.nrm.GLEngine2D.GameObject;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.nrm.EngineTest.Main;

public class GameObjectBox extends GameObject {
	public GameObjectBox(Vector2f pos, Vector3f rot, int lay) {
		super(pos,rot,lay);
		
	}
	public GameObjectBox(Vector2f pos,Vector3f rot,Vector2f s,int lay){
		this.position = pos;
		this.rotation = rot;
		this.size = s;
		this.layer = lay;
	}
	public GameObjectBox(){
		super();
	}
	public void render() {
		GL11.glPushMatrix();
		GL11.glTranslatef(this.position.x,this.position.y,this.layer);
		GL11.glRotatef(this.rotation.x, 0, 0, 1);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, Main.engine.textureManager.getTextureID("test"));
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(1f, 0f);
		GL11.glVertex2f(1f, 1f);
		GL11.glTexCoord2f(1f, 1f);
		GL11.glVertex2f(1f, -1f);
		GL11.glTexCoord2f(0f, 1f);
		GL11.glVertex2f(-1f, -1f);
		GL11.glTexCoord2f(0f, 0f);
		GL11.glVertex2f(-1f, 1f);
		GL11.glEnd();
		GL11.glPopMatrix();
	}
	int tick = 0;
	public void update(){
		tick++;
		this.position.x = (float) (Math.sin(tick/100.0f));
		this.position.y = (float) (Math.cos(tick/100.0f));
		//this.rotation.x+=1f;
		this.layer = 20;
	}
}
