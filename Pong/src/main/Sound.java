package main;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	private Clip clip;
	private AudioInputStream audioIn;
	public Sound (String sound) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	}
		public void boop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		this.audioIn = AudioSystem.getAudioInputStream(Sound.class.getResource("/resources/" + "Randomize9.wav"));
		this.clip = AudioSystem.getClip();
		this.clip.open(audioIn);
	}
		public void jump() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		this.audioIn = AudioSystem.getAudioInputStream(Sound.class.getResource("/resources/" + "Jump4.wav"));
		this.clip = AudioSystem.getClip();
		this.clip.open(audioIn);
	}	
	public void start() {
		this.clip.start();
		
	}
	
	public void end() {
		this.clip.stop();
	}
}
