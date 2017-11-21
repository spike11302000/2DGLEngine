package com.nrm.GLEngine2D.GameObject;

public class Camera extends GameObject {
	public float zoom;
	public Camera(float z){
		super();
		this.setZoom(z);
	}
	public Camera(){
		super();
		this.setZoom(1);
	}
	public void setZoom(float z){
		this.zoom = z;
	}
	public float getZoom(){
		return this.zoom;
	}
}
