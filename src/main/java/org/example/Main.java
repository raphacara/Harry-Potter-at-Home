package org.example;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //create music
        BackgroundMusic music = new BackgroundMusic();
        try {
            music.play();

            // Create a new story
            Story story = new Story();

            //Introduction
            story.addStep(new Introduction());
            //more later

            //Run the story
            story.run();

            //Stop the music
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                music.stop();
        }
    }
}