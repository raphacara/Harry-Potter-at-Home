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

            // 1. ----- INTRODUCTION -----
            Introduction intro = new Introduction();
            story.addStep(intro);
            //story.run(); //You can hide this Step to skip it (you will have to use the random test wizard)

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

                //Intern tests (use it to test only 1 Step of the story by creating a random wizard)
                Wizard test = new Wizard();
                Random random = new Random();
                Wand wandTest = new Wand(Core.values()[random.nextInt(Core.values().length)], 30);
                test.setName("Furty7");
                test.setPet(Pet.values()[random.nextInt(Pet.values().length)]);
                test.setWand(wandTest);

            // 2. ----- SortingHat -----
            SortingHat sort = new SortingHat(test); // !!! You can change this argument by: wizard (if you run the intro) / test (if you don't) !!!
            story.removeStep(intro);
            story.addStep(sort);
            story.run(); //You can hide this Step to skip it

            // getting players infos
            String houseWizard = sort.getHouse();
            // setting the infos in the wizard
            wizard.setHouse(houseWizard);

            // 3. ----- Chapter 1 -----
            //Code...

            //check
            System.out.println("You are " + wizard.getName() +
                    ", your Pet is a " + wizard.getPet() +
                    ", your have a " + wizard.getWand().getSize() + "cm wand with a " + wizard.getWand().getCore() + " core." +
                    " You are a " + wizard.getHouse() + "!");


            //Stop the music
            } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                music.stop();
        }
    }
}