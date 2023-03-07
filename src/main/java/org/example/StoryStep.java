package org.example;

public interface StoryStep {

    // Method to run a step of the story
    void run() throws InterruptedException;

    //ultra powerful method that let my main class to get ALL the information (attributes) of the player.
    Wizard getWizard();
}