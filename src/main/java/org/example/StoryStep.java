package org.example;

public interface StoryStep { //Maybe most useful class (more exactly interface) of my code.

    // Method to run a step of the story
    void run() throws InterruptedException;

    // Ultra powerful method that let my main class to get ALL the information (attributes) of the player.
    Wizard getWizard();
}