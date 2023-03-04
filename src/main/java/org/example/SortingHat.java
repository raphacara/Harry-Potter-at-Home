package org.example;
import java.util.Scanner;

public class SortingHat implements StoryStep {
    public static final String RESET = "\u001B[0m"; //fun
    public static final String RED_BOLD = "\033[1;31m"; //fun
    public static final String BLUE_BOLD = "\033[1;34m"; //fun
    public static final String GREEN_BOLD = "\033[1;32m"; //fun
    private final Wizard wizard; //the player
    private String houseName; //for the House of the player (that's the only point of the Sorting Hat)
    private int g, h, r, s = 0; //initials of the 4 houses for the system (you will see later in this class)
    private static final String[] input = {"1","2","3","4","5","6","7","8"}; //the player inputs
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs

    private int check = 0; //checking the loops


    //Constructor
    public SortingHat(Wizard player) {
        this.wizard = player;
    }

    @Override
    public void run() throws InterruptedException {
        System.out.println(GREEN_BOLD + "\n----------------- SORTING HAT -----------------\n" + RESET);
        Thread.sleep(4000);
        System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Well, well, well... Let's see what student we have here...\n");
        Thread.sleep(4000);
        System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + wizard.getName() + "... ");
        Thread.sleep(2000);
        System.out.print("what an intriguing name.\n");
        Thread.sleep(3000);
        //Little condition if you were specifically lucky/unlucky during the Introduction
        if (wizard.getPet() == Pet.SNAKE && wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Oh, that's very very clear...\n");
            Thread.sleep(5000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "SLYTHERIN !!!\n");
            houseName = "SLYTHERIN";
        } else if (wizard.getPet() == Pet.RAT && wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Oh, that's very very clear...\n");
            Thread.sleep(5000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "GRYFFINDOR !!!\n");
            houseName = "GRYFFINDOR";
        } else {
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Hmmm... Difficult, very difficult...\n");
            Thread.sleep(3000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Well, I will ask you some questions...\n");
            Thread.sleep(3000);
            //Ingenious system that I created to define a house.
            //Question 1
            while (check == 0) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Regarding the 4 natural elements, which one do you prefer?\n");
                System.out.println(GREEN_BOLD + "1. * AIR *\n" + "2. * FIRE *\n" + "3. * WATER *\n" + "4. * EARTH *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[0] = scanner.nextLine();
                check = 1;
                switch (input[0]) {
                    case "1" -> r += 1;
                    case "2" -> g += 1;
                    case "3" -> h += 1;
                    case "4" -> s += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "That is not an Element.");
                        check = 0;
                    }
                }
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Think carefully before answering.\n");
            Thread.sleep(2000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Next Question:\n");
            Thread.sleep(1000);
            //Question 2
            while (check == 1) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "What do you most Value in life?\n");
                System.out.println(GREEN_BOLD + "1. * YOUR REPUTATION *\n" + "2. * GRATITUDE *\n" + "3. * MEMORIES *\n" + "4. * LIFE EXPERIENCES *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[1] = scanner.nextLine();
                check = 0;
                switch (input[1]) {
                    case "1" -> s += 1;
                    case "2" -> h += 1;
                    case "3" -> g += 1;
                    case "4" -> r += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "Don't you have any values?");
                        check = 1;
                    }
                }
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "I was sure about that.\n");
            Thread.sleep(2000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Now:\n");
            Thread.sleep(1000);
            //Question 3
            while (check == 0) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "What characterizes you best?\n");
                System.out.println(GREEN_BOLD + "1. * INTELLIGENCE *\n" + "2. * AMBITION *\n" + "3. * BRAVERY *\n" + "4. * EMPATHY *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[2] = scanner.nextLine();
                check = 1;
                switch (input[2]) {
                    case "1" -> r += 1;
                    case "2" -> s += 1;
                    case "3" -> g += 1;
                    case "4" -> h += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "I would characterize you as incompetent.");
                        check = 0;
                    }
                }
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "basic answer...\n");
            Thread.sleep(2000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Anyway:\n");
            Thread.sleep(1000);
            //Question 4
            while (check == 1) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Do others see you as sociable?\n");
                System.out.println(GREEN_BOLD + "1. * YES, CLEARLY *\n" + "2. * YES *\n" + "3. * NOT REALLY *\n" + "4. * NOT AT ALL *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[3] = scanner.nextLine();
                check = 0;
                switch (input[3]) {
                    case "1" -> s += 1;
                    case "2" -> g += 1;
                    case "3" -> r += 1;
                    case "4" -> h += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "What is this answer? I asked:");
                        check = 1;
                    }
                }
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Hmmm... Okay.\n");
            Thread.sleep(1000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "One last question should be enough:\n");
            Thread.sleep(1000);
            //Question 5
            while (check == 0) {
                System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "If you could have any superpower, which would you choose?\n");
                System.out.println(GREEN_BOLD + "1. * FLY *\n" + "2. * INVISIBILITY *\n" + "3. * IMMORTALITY *\n" + "4. * FEARLESS *" + RED_BOLD);
                System.out.print("Enter a number to make your choice :\n" + RESET);
                input[4] = scanner.nextLine();
                check = 1;
                switch (input[4]) {
                    case "1" -> r += 1;
                    case "2" -> h += 1;
                    case "3" -> s += 1;
                    case "4" -> g += 1;
                    default -> {
                        System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "You have the superpower of being tiresome.");
                        check = 0;
                    }
                }
            }
            //Bonuses
            if (wizard.getPet() == Pet.SNAKE||wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
                s += 1;
            }
            if (wizard.getPet() == Pet.RAT||wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
                g += 1;
            }
            if (wizard.getPet() == Pet.OWL && wizard.getWand().getCore() == Core.DRAGON_HEARTSTRING ) {
                r += 1;
            }
            if (wizard.getPet() == Pet.TOAD && wizard.getWand().getCore() == Core.UNICORN_HAIR ) {
                h += 1;
            }
            // checking the max
            int max = h; //Pretending it is h (=Hufflepuff)
            if (r > max) {
                max = r;
            } else if (r == max) { //if it is equal.
                while (check <= 1) {
                    System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "I am wondering... Do you prefer Hufflepuff or Ravenclaw?\n");
                    System.out.println(GREEN_BOLD + "1. * HUFFLEPUFF *\n" + "2. * RAVENCLAW *" + RED_BOLD);
                    System.out.print("Enter a number to make your choice :\n" + RESET);
                    input[5] = scanner.nextLine();
                    check = 2;
                    switch (input[5]) {
                        case "1" :
                            r -= 1;
                            break;
                        case "2" :
                            h -= 1;
                            max = r;
                            break;
                        default :
                            System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "That is probably your final choice:");
                            check = 1;
                    }
                }
            }
            if (g > max) {
                max = g;
            } else if (g == max) { //if it is equal.
                while (check <= 2) {
                    System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "I am wondering... Do you like Gryffindor?\n");
                    System.out.println(GREEN_BOLD + "1. * YES *\n" + "2. * NO *" + RED_BOLD);
                    System.out.print("Enter a number to make your choice :\n" + RESET);
                    input[6] = scanner.nextLine();
                    check = 3;
                    switch (input[6]) {
                        case "1" :
                            h -= 1;
                            r -= 1;
                            max = g;
                            break;
                        case "2" :
                            g -= 1;
                            break;
                        default :
                            System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "That is probably your final choice:");
                            check = 2;
                    }
                }
            }
            if (s > max) {
                max = s;
            } else if (s == max) { //if it is equal.
                while (check <= 3) {
                    System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "I am wondering... Do you like Slytherin?\n");
                    System.out.println(GREEN_BOLD + "1. * YES *\n" + "2. * NO *" + RED_BOLD);
                    System.out.print("Enter a number to make your choice :\n" + RESET);
                    input[7] = scanner.nextLine();
                    check = 4;
                    switch (input[7]) {
                        case "1" :
                            s += 1;
                            max = s;
                            break;
                        case "2" :
                            s -= 1;
                            break;
                        default :
                            System.out.println(BLUE_BOLD + "Sorting Hat - " + RESET + "That is probably your final choice:");
                            check = 3;
                    }
                }
            }
            if (max == g) {
                houseName = "GRYFFINDOR";
            } else if (max == h) {
                houseName = "HUFFLEPUFF";
            } else if (max == r) {
                houseName = "RAVENCLAW";
            } else {
                houseName = "SLYTHERIN";
            }
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "Well, I have it...\n");
            Thread.sleep(4000);
            System.out.print(BLUE_BOLD + "Sorting Hat - " + RESET + "I would say");
            Thread.sleep(2000);
            System.out.print(".");
            Thread.sleep(2000);
            System.out.print(".");
            Thread.sleep(2000);
            System.out.print(". ");
            Thread.sleep(2000);
            System.out.print(houseName + "!!!\n");
        }
        Thread.sleep(3000);
        System.out.println(GREEN_BOLD + "** You are now a " + houseName + " student! **\n" + RESET);
        Thread.sleep(3000);
    }

    //Method to get the House
    public String getHouse() {
        return this.houseName;
    }
}
