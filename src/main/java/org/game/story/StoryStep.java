package org.game.story;

import org.game.character.Wizard;

import java.io.IOException;

public interface StoryStep { //Maybe most useful class (more exactly interface) of my code.

    // Method to runStory a step of the story
    void runStory() throws InterruptedException;

    // Ultra powerful method that let my main class to get ALL the information (attributes) of the player :)
    Wizard getWizard();

    // To wait a bit before printing text
    default void threadSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // To wait for the user before printing the text
    default void waiting() {
        System.out.print("-");
        try {
            int readChar;
            do {
                readChar = System.in.read();
            } while (readChar != '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}