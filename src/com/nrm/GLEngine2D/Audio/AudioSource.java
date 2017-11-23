package com.nrm.GLEngine2D.Audio;

import org.lwjgl.openal.AL10;
import org.lwjgl.util.vector.Vector2f;

public class AudioSource {
	private int sourceID;

	public AudioSource() {
		sourceID = AL10.alGenSources();
		//System.out.println(this.sourceID);
		AL10.alSourcef(sourceID, AL10.AL_GAIN, 1);
		AL10.alSourcef(sourceID, AL10.AL_PITCH, 1);
		AL10.alSource3f(sourceID, AL10.AL_POSITION, 0, 0, 0);
	}

	public void delete() {
		this.stop();
		AL10.alDeleteSources(sourceID);
	}

	public void setBuffer(int buffer) {
		AL10.alSourcei(sourceID, AL10.AL_BUFFER, buffer);
	}
	
	public void play(int buffer){
		this.stop();
		this.setBuffer(buffer);
		this.play();
	}
	
	public void play() {
		
		AL10.alSourcePlay(sourceID);
	}

	public void pause() {
		AL10.alSourcePause(sourceID);
	}

	public void stop() {
		AL10.alSourceStop(sourceID);
	}

	public void setVelocity(Vector2f vel) {
		AL10.alSource3f(sourceID, AL10.AL_VELOCITY, vel.x, vel.y, 0);
	}

	public void setVolume(float volume) {
		AL10.alSourcef(sourceID, AL10.AL_GAIN, volume);
	}
	public void setPosition(Vector2f pos){
		AL10.alSource3f(sourceID, AL10.AL_POSITION, pos.x, pos.y, 0);
	}

	public void setPitch(float pitch) {
		AL10.alSourcef(sourceID, AL10.AL_PITCH, pitch);
	}
}
