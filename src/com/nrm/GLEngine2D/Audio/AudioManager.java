package com.nrm.GLEngine2D.Audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;
import org.lwjgl.util.vector.Vector2f;

public class AudioManager {
	private ArrayList<Integer> buffers = new ArrayList<Integer>();
	public AudioManager() {
		try {
			AL.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		AL10.alListener3f(AL10.AL_POSITION, 0, 0, 5);
		
	}
	public void setListenerData(Vector2f pos){
		AL10.alListener3f(AL10.AL_POSITION, pos.x,pos.y, 5);
	}
	public int loadSound(String path, String name) {
		System.out.println("Loading: " + path + " as " + name);
		int buffer = AL10.alGenBuffers();
		this.buffers.add(buffer);
		WaveData waveFile = null;
		try {
			waveFile = WaveData.create(new BufferedInputStream(new FileInputStream("res/" + path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		AL10.alBufferData(buffer, waveFile.format, waveFile.data, waveFile.samplerate);
		waveFile.dispose();
		return buffer;
	}

	public void cleanUp() {
		for(int buffer:this.buffers)
			AL10.alDeleteBuffers(buffer);
		AL.destroy();
	}
}
