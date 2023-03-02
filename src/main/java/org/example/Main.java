package org.example;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //create music
        BackgroundMusic music = new BackgroundMusic();
        try {
            // ----- MUSIC -----
            music.play();

            // ----- STORY -----
            Story story = new Story();
            Wizard wizard = new Wizard();

            // 1. --- INTRODUCTION ---
            Introduction intro = new Introduction();
            story.addStep(intro); //Introduction
            story.run();

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

            // 2. --- SortingHat ---
            SortingHat sort = new SortingHat(wizard);
            story.removeStepp(intro);
            story.addStep(sort);
            story.run();

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