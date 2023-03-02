package org.example;
import java.util.Scanner;

public class SortingHat implements StoryStep {
    public static final String RESET = "\u001B[0m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String GREEN_BOLD = "\033[1;32m";
    private static final String[] HOUSE_NAMES = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    private final Wizard wizard;
    private String houseName;
    private Scanner scanner;


    //Constructor
    public SortingHat(Wizard test) {
        this.wizard = test;
    }

    @Override
    public void run() throws InterruptedException {
        System.out.println("\n----------------- SORTING HAT -----------------\n");
        Thread.sleep(3000);
        System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Well, well, well... Let's see what student we have here...\n");
        Thread.sleep(3000);
        System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + wizard.getName() + "... ");
        Thread.sleep(2000);
        System.out.print("what an intriguing name.\n");
        Thread.sleep(2000);
        //Little condition if you were specifically lucky/unlucky during the Introduction
        if (wizard.getPet()==Pet.SNAKE && wizard.getWand().getCore()==Core.PHOENIX_FEATHER) {
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Oh no, that's very very clear...\n");
            Thread.sleep(5000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "SLYTHERIN !!!\n");
            Thread.sleep(3000);
            houseName = "Slytherin";
        } else if (wizard.getPet()==Pet.RAT && wizard.getWand().getCore()==Core.PHOENIX_FEATHER) {
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Oh no, that's very very clear...\n");
            Thread.sleep(5000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "GRYFFINDOR !!!\n");
            Thread.sleep(3000);
            houseName = "Gryffindor";
        }
        //Ultra ingenious system that I created to define a house :)
        System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + wizard.getName() + "... ");
        Thread.sleep(2000);



        System.out.println(GREEN_BOLD + "You are now a " + houseName + " student!\n" + RESET);
    }

    //Method to get
    public String getHouse() {
        return this.houseName;
    }
}
