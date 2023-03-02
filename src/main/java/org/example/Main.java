package org.example;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //create music
        BackgroundMusic music = new BackgroundMusic();
        try {
            music.play();

            // Create a new story
            Story story = new Story();

            //Adding Steps of the story in the Story
            Introduction intro = new Introduction();
            story.addStep(intro); //Introduction

            //Run the story
            story.run();

            // Create a new wizard
            Wizard wizard = new Wizard();
            // getting players infos
            String nameWizard = intro.getName();
            Pet petWizard = intro.getPet();
            int sizeWand = intro.getSize();
            Core coreWand = intro.getCore();
            //creating the wizard's wand
            Wand wandWizard = new Wand(coreWand, sizeWand);
            // setting the infos in the wizard
            wizard.setName(nameWizard);
            wizard.setPet(petWizard);
            wizard.setWand(wandWizard);

            //check
            System.out.println("You are " + wizard.getName() +
                    ", your Pet is a " + wizard.getPet() +
                    ", your have a " + wizard.getWand().getSize() + "cm wand with a " + wizard.getWand().getCore() + " core.");

            //Stop the music
            } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                music.stop();
        }
    }
}