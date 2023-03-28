package org.game;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BackgroundMusic {
    private Clip clip;

    public void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File musicFile = new File("src/main/resources/HP_music.wav"); //get the music file
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        //FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); //set the volume
        //volume.setValue(-30.0f); //reduce volume by 30 decibels !!!!! CHANGE THIS VALUE TO CHANGE THE VOLUME !!!!!
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
        clip.close();
    }
}