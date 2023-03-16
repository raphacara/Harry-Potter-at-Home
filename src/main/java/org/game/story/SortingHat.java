package org.game.story;
import org.game.attributes.Core;
import org.game.attributes.House;
import org.game.attributes.Pet;
import org.game.character.Wizard;

import java.util.Random;

public class SortingHat implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String BLUE_BOLD = "\033[1;34m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private final Wizard wizard; //the player

    //Constructor
    public SortingHat(Wizard player) {
        this.wizard = player;
    }

    @Override
    public void run() throws InterruptedException {
        System.out.println(GREEN_BOLD + "\n----------------- SORTING HAT -----------------\n" + RESET);
        Thread.sleep(2000);
        System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Well, well, well... Let's see what student we have here...\n");
        Thread.sleep(3000);
        System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + wizard.getName() + "... ");
        Thread.sleep(2000);
        System.out.print("what an intriguing name.\n");
        Thread.sleep(2000);
        System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Oh, that's very very clear...\n");
        Thread.sleep(4000);
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
        System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "I would say");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(". ");
        Thread.sleep(2000);
        System.out.print(houseName + "!!!\n");
        Thread.sleep(2000);
        wizard.setHouse(houseName);
        System.out.println(GREEN_BOLD + "** You are now a " + wizard.getHouse() + " student! **" + RESET);
        Thread.sleep(1000);
        wizard.bonusHouses(wizard); //setting the BONUS considering the House of the wizard
        Thread.sleep(2000);
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}