package com.nrm.GLEngine2D.Audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;

public class AudioManager {

	private HashMap<String, Integer> bufferMap = new HashMap<String, Integer>();
	private HashMap<String, String> toLoad = new HashMap<String, String>();

	public AudioManager() {
		try {
			AL.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		AL10.alListener3f(AL10.AL_POSITION, 0, 0, 5);

	}

	public void setListenerData(Vector2f pos) {
		AL10.alListener3f(AL10.AL_POSITION, pos.x, pos.y, 5);
	}

	public int loadSound(String path, String name) {
		System.out.println("Loading: " + path + " as " + name);
		int buffer = AL10.alGenBuffers();
		this.bufferMap.put(name, buffer);
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
	public int getAudioBuffer(String name) {
		return this.bufferMap.get(name);
	}
	public void addAudio(String path, String name) {
		this.toLoad.put(name, path); 
	}
	public void registerAudio(){
		if(!this.toLoad.isEmpty()){
			for(Entry<String, String> e : this.toLoad.entrySet()) {
		        String key = e.getKey();
		        String value = e.getValue();
		        this.loadSound(value, key);
		    }
			this.toLoad.clear();
		}
	}
	public void cleanUp() {
		for (Map.Entry<String, Integer> entry : this.bufferMap.entrySet()) {
			int buff = entry.getValue();
			AL10.alDeleteBuffers(buff);
		}
		AL.destroy();
	}
}
