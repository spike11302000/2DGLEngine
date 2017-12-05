package com.nrm.EngineTest;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.nrm.GLEngine2D.GameObject.GameObject;
public class GameObjectTri extends GameObject {
	public GameObjectTri(Vector2f pos, Vector3f rot, int lay) {
		super(pos,rot,lay);
		
	}
	public GameObjectTri(){
		super();
	}
	public void render() {
		GL11.glPushMatrix();
		GL11.glTranslatef(this.position.x,this.position.y,this.layer);
		GL11.glRotatef(this.rotation.x, 0, 0, 1);
		
		GL11.glColor3f(this.layer/10.0f, this.layer/10.0f, 1);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, Main.engine.textureManager.getTextureID("test"));
		GL11.glBegin(GL11.GL_TRIANGLES);
		
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(0.5f, 0.5f);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(0f, 0f);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(-1f, 0.5f);
		GL11.glEnd();
		GL11.glPopMatrix();
		
	}
	int tick = new Random().nextInt(10000);
	public void update(){
		tick++;
		//this.position.x = (float) (Math.sin(tick/100.0f));
		//this.position.y = (float) (Math.cos(tick/100.0f));
		//this.rotation.x+=1f;
		
	}
}
