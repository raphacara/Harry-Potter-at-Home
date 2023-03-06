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

            //instance of wizard
            Wizard wizard = new Wizard();

            // 1. ----- INTRODUCTION -----
            Introduction intro = new Introduction(wizard);
            //intro.run(); //You can hide this Step to skip it (you will have to use the random test wizard)

            //getting players infos
            wizard = Introduction.getWizard(); //Updating the wizard
            wizard.checkWizard(wizard); //checking
            wizard.bonusHouses(wizard); //adding houses bonuses

                //Intern tests (use it to test the story by creating a random wizard)
                Wizard test = new Wizard();
                if (wizard.getHouse() == null) {
                    Random random = new Random();
                    Wand wandTest = new Wand(Core.values()[random.nextInt(Core.values().length)], 30);
                    String randomHouseName = org.example.House.houseNames.get(new Random().nextInt(org.example.House.houseNames.size()));
                    test.setName("Raphaël");
                        test.setPet(Pet.values()[random.nextInt(Pet.values().length)]);
                        test.setWand(wandTest);
                        test.setHouse(randomHouseName);
                    }

            // 2. ----- CHAPTER 1 -----
            Chapter1 chapter1 = new Chapter1(test); //Change the (wizard) by (test) if you skipped the intro
            chapter1.run();
            wizard = Chapter1.getWizard(); //Updating the wizard (don't need to change wizard for test if you skipped the intro)
            wizard.checkWizard(wizard); //checking

            //Stop the music
            } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                music.stop();
        }
    }
}