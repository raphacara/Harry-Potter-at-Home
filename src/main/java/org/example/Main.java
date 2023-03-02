package org.example;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random; //test

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
            //story.run();

            // getting players infos
            String nameWizard = intro.getName();
            Pet petWizard = intro.getPet();
            int sizeWand = intro.getSize();
            Core coreWand = intro.getCore();
            // creating the wizard's wand
            Wand wandWizard = new Wand(coreWand, sizeWand);
            // setting the infos in the wizard
            wizard.setName(nameWizard);
            wizard.setPet(petWizard);
            wizard.setWand(wandWizard);

            //Intern tests
            Wizard test = new Wizard();
            Random random = new Random();
            Wand wandTest = new Wand(Core.values()[random.nextInt(Core.values().length)], 30);
            test.setName("Furty7");
            test.setPet(Pet.values()[random.nextInt(Pet.values().length)]);
            test.setWand(wandTest);


            // 2. --- SortingHat ---
            SortingHat sort = new SortingHat(test);
            story.removeStep(intro);
            story.addStep(sort);
            story.run();

            // getting players infos
            String houseWizard = sort.getHouse();
            // setting the infos in the wizard
            wizard.setHouse(houseWizard);

            //check
            System.out.println("You are " + test.getName() +
                    ", your Pet is a " + test.getPet() +
                    ", your have a " + test.getWand().getSize() + "cm wand with a " + test.getWand().getCore() + " core." +
                    " You are a " + test.getHouse() + "!");


            //Stop the music
            } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                music.stop();
        }
    }
}