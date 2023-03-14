package org.game;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class BackgroundMusic {
    private Clip clip;

    public void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File musicFile = new File("src/main/resources/HP_music.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
        clip.close();
    }
}