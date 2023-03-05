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
                test.setName("Raphaël");
                test.setPet(Pet.values()[random.nextInt(Pet.values().length)]);
                test.setWand(wandTest);

            // 2. ----- SortingHat -----
            SortingHat sort = new SortingHat(wizard); // !!! You can change this argument by: wizard (if you run the intro) / test (if you don't) !!!
            story.removeStep(intro);
            story.addStep(sort);
            //story.run(); //You can hide this Step to skip it

            // getting players infos
            String houseWizard = sort.getHouse();
            // setting the infos in the wizard
            wizard.setHouse(houseWizard);

                //Intern test
                if (houseWizard != null) {
                    test.setHouse(houseWizard);
                } else {
                    String randomHouseName = org.example.House.houseNames.get(new Random().nextInt(org.example.House.houseNames.size()));
                    test.setHouse(randomHouseName);
                }

            wizard.checkWizard(test); //checking
            wizard.bonusHouses(test); //adding houses bonuses

            // 3. ----- Chapter 1 -----
            Chapter1 one = new Chapter1(test); // !!! You can change this argument by: wizard (if you run the intro) / test (if you don't) !!!
            story.removeStep(sort);
            story.addStep(one);
            story.run();
            wizard = Chapter1.getWizard(); //I update the wizard
            wizard.checkWizard(test); //checking

            //Stop the music
            } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                music.stop();
        }
    }
}