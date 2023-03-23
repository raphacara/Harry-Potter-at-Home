package org.game.story;
import org.game.attributes.Core;
import org.game.attributes.House;
import org.game.attributes.Pet;
import org.game.character.Wizard;

import java.util.Random;

public class SortingHat implements StoryStep {
    private final Wizard wizard; //the player

    //Constructor
    public SortingHat(Wizard player) {
        this.wizard = player;
    }

    @Override
    public void run() throws InterruptedException {
        String GREEN = "\033[1;32m"; //fun
        String RESET = "\u001B[0m"; //fun
        System.out.println(GREEN + "\n----------------- SORTING HAT -----------------\n" + RESET);
        threadSleep(1000);
        String BLUE = "\033[1;34m"; //fun
        System.out.print(BLUE + "Sorting Hat - " + RESET + "Well, well, well... Let's see what student we have here...\n");
        waiting();
        System.out.print(BLUE + "Sorting Hat - " + RESET + wizard.getName() + "... ");
        threadSleep(2000);
        System.out.print("what an intriguing name.\n");
        waiting();
        System.out.print(BLUE + "Sorting Hat - " + RESET + "Oh, that's very very clear...\n");
        waiting();
        //Little condition if you were specifically lucky/unlucky during the Introduction
        House houseName;
        if (wizard.getPet() == Pet.SNAKE && wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            houseName = House.Slytherin;
        } else if (wizard.getPet() == Pet.RAT && wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            houseName = House.Gryffindor;
        } else if (wizard.getPet() == Pet.OWL && wizard.getWand().getCore() == Core.DRAGON_HEARTSTRING) {
            houseName = House.Ravenclaw;
        } else if (wizard.getPet() == Pet.TOAD && wizard.getWand().getCore() == Core.UNICORN_HAIR) {
            houseName = House.Hufflepuff;
        } else {
            Random random = new Random(); //new random
            House[] houses = House.values(); //get an array of all House enum constants
            houseName = houses[random.nextInt(houses.length)]; //generate a random house
        }
        System.out.print(BLUE + "Sorting Hat - " + RESET + "I would say...");
        threadSleep(2000);
        System.out.print(houseName + "!!!\n");
        threadSleep(2000);
        wizard.setHouse(houseName);
        System.out.println(GREEN + "** You are now a " + wizard.getHouse() + " student! **" + RESET);
        threadSleep(500);
        wizard.bonusHouses(wizard); //setting the BONUS considering the House of the wizard
        waiting();
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}