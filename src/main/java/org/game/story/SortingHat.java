package org.game.story;
import org.game.Color;
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
    public void runStory() throws InterruptedException {
        System.out.println(Color.GREEN + "\n----------------- SORTING HAT -----------------\n" + Color.RESET);
        threadSleep(1000);
        System.out.print(Color.BLUE + "Sorting Hat - " + Color.RESET + "Well, well, well... Let's see what student we have here...\n");
        waiting();
        System.out.print(Color.BLUE + "Sorting Hat - " + Color.RESET + wizard.getName() + "... ");
        threadSleep(2000);
        System.out.print("what an intriguing name.\n");
        waiting();
        System.out.print(Color.BLUE + "Sorting Hat - " + Color.RESET + "Oh, that's very very clear...\n");
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
        System.out.print(Color.BLUE + "Sorting Hat - " + Color.RESET + "I would say...");
        threadSleep(2000);
        System.out.print(Color.BLUE + "Sorting Hat - " + Color.RESET + houseName + "!!!\n");
        threadSleep(2000);
        wizard.setHouse(houseName);
        System.out.println(Color.GREEN + "** You are now a " + wizard.getHouse() + " student! **" + Color.RESET);
        threadSleep(500);
        wizard.bonusHouses(wizard); //setting the BONUS considering the House of the wizard
        waiting();
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}