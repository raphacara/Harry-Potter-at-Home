package org.example;
import java.util.Scanner;

public class SortingHat implements StoryStep {
    public static final String RESET = "\u001B[0m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String GREEN_BOLD = "\033[1;32m";
    private static final String[] input = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
    private final Wizard wizard;
    private String houseName;
    private final Scanner scanner = new Scanner(System.in);
    private int g, h, r, s = 0;
    private int check = 0;


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
        if (wizard.getPet() == Pet.SNAKE && wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Oh no, that's very very clear...\n");
            Thread.sleep(5000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "SLYTHERIN !!!\n");
            Thread.sleep(3000);
            houseName = "Slytherin";
        } else if (wizard.getPet() == Pet.RAT && wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Oh no, that's very very clear...\n");
            Thread.sleep(5000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "GRYFFINDOR !!!\n");
            Thread.sleep(3000);
            houseName = "Gryffindor";
        } else {
            //Ingenious system that I created to define a house.
            //Question 1
            while (check == 0) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Regarding the 4 natural elements, which one do you prefer?\n");
                System.out.println(GREEN_BOLD + "1. * AIR *\n" + "2. * FIRE *\n" + "3. * WATER *\n" + "4. * EARTH *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[1] = scanner.nextLine();
                check = 1;
                switch (input[1]) {
                    case "1" -> r += 1;
                    case "2" -> g += 1;
                    case "3" -> h += 1;
                    case "4" -> s += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "Do not mess with me!");
                        check = 0;
                    }
                }
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Next Question:\n");
            Thread.sleep(1000);
            //Question 2
            while (check == 1) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "What do you most Value in life?\n");
                System.out.println(GREEN_BOLD + "1. * YOUR REPUTATION *\n" + "2. * GRATITUDE *\n" + "3. * MEMORIES *\n" + "4. * LIFE EXPERIENCES *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[2] = scanner.nextLine();
                check = 0;
                switch (input[2]) {
                    case "1" -> s += 1;
                    case "2" -> h += 1;
                    case "3" -> g += 1;
                    case "4" -> r += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "How funny...");
                        check = 1;
                    }
                }
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "basic answer...\n");
            Thread.sleep(1000);
            //Question 3
            while (check == 0) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Do you like this game?\n");
                System.out.println(GREEN_BOLD + "1. * YES *\n" + "2. * NO *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[3] = scanner.nextLine();
                check = 1;
                switch (input[3]) {
                    case "1" -> {
                        g += 1;
                        r += 1;
                    }
                    case "2" -> {
                        s += 1;
                        h += 1;
                    }
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "I want to know if you like this game!");
                        check = 0;
                    }
                }
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "I was sure about that.\n");
            Thread.sleep(1000);
            //Question 4
            while (check == 1) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "what characterizes you best?\n");
                System.out.println(GREEN_BOLD + "1. * INTELLIGENCE *\n" + "2. * AMBITION *\n" + "3. * BRAVERY *\n" + "4. * EMPATHY *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[4] = scanner.nextLine();
                check = 0;
                switch (input[4]) {
                    case "1" -> r += 1;
                    case "2" -> s += 1;
                    case "3" -> g += 1;
                    case "4" -> h += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "I would characterize you as incompetent.");
                        check = 1;
                    }
                }
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "but not so modest.\n");
            Thread.sleep(1000);
            //Question 5
            while (check == 0) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Do others see you as sociable?\n");
                System.out.println(GREEN_BOLD + "1. * YES, CLEARLY *\n" + "2. * YES *\n" + "3. * NOT REALLY *\n" + "4. * NOT AT ALL *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[5] = scanner.nextLine();
                check = 1;
                switch (input[5]) {
                    case "1" -> s += 1;
                    case "2" -> g += 1;
                    case "3" -> r += 1;
                    case "4" -> h += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "What ? I repeat:");
                        check = 0;
                    }
                }
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Hmmm... Okay.\n");
            Thread.sleep(1000);
            //Question 6
            while (check == 1) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "If you could have any superpower, which would you choose?\n");
                System.out.println(GREEN_BOLD + "1. * FLY *\n" + "2. * INVISIBILITY *\n" + "3. * IMMORTALITY *\n" + "4. * FEARLESS *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[6] = scanner.nextLine();
                check = 0;
                switch (input[6]) {
                    case "1" -> r += 1;
                    case "2" -> h += 1;
                    case "3" -> s += 1;
                    case "4" -> g += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "You have the superpower of tiresome.");
                        check = 1;
                    }
                }
            }

            //Bonus
            if (wizard.getPet() == Pet.SNAKE) {
                s += 1;
            }
            if (wizard.getPet() == Pet.RAT) {
                g += 1;
            }
            if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
                s += 1;
                g += 1;
            }
            if (wizard.getWand().getCore() == Core.DRAGON_HEARTSTRING && wizard.getPet() == Pet.OWL) {
                r += 1;
            }

            // checking the max
            int max = h;
            if (r > max) {
                max = r;
            }
            if (g > max) {
                max = g;
            }
            if (s > max) {
                max = s;
            }
            if (max == g) {
                houseName = "Gryffindor";
            } else if (max == h) {
                houseName = "Hufflepuff";
            } else if (max == r) {
                houseName = "Ravenclaw";
            } else {
                houseName = "Slytherin";
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Well, I have it...\n");
            Thread.sleep(5000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + houseName + "!!!\n");
            Thread.sleep(3000);
            System.out.println(GREEN_BOLD + "You are now a " + houseName + " student!\n" + RESET);
        }
    }

    //Method to get the House
    public String getHouse() {
        return this.houseName;
    }
}
