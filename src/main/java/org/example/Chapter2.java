package org.example;

import java.util.Scanner;

public class Chapter2 implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String BLUE_BOLD = "\033[1;34m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String BLACK_BOLD = "\033[1;30m"; //fun
    private static Wizard wizard;
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private final boolean[] stuffDone = new boolean[4]; //changing to true when the player take a lesson
    private boolean check = true; //to check the loops

    //Constructor
    public Chapter2(Wizard player) {
        wizard = player;
    }
    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 2 --
        System.out.println(GREEN_BOLD + "\n----------------- Chapter 2 -----------------");
        threadSleep(1000);
        System.out.println("---------- The Chamber of Secrets -----------\n" + RESET);
        threadSleep(2000);
        System.out.println("** This is your 2nd year at Hogwarts. **");
        threadSleep(2000);
        System.out.println("** You are back in the Great Hall with the other Students. **\n");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Hello to all of you.");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "There is a great danger in the school this year.");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "The Chamber of Secrets has been opened.");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "No one knows where it is but it contains a deadly enemy.");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "So be very careful.\n");
        threadSleep(2000);
        System.out.println("** After a such warning, Dumbledore leave the Great Hall. **");
        threadSleep(2000);

        //-- 1st part of free time --
        System.out.println("** What do you want to do? **");
        threadSleep(1000);
        chooseWhatToDo();
        System.out.println("** It was a great experience. **");
        threadSleep(2000);
        System.out.println("** The next morning, you have to go to class.  **");
        threadSleep(2000);
        System.out.println("** But you have heard the the Defense Against the Dark Arts teacher was really bad this year... **");
        threadSleep(3000);

        //-- Learning Accio --
        System.out.println("** So you decide to go to the Charms class. **");
        threadSleep(2000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(1000);
        System.out.println(BLACK_BOLD + "            ~~~   CHARMS   ~~~\n" + RESET);
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "Welcome to the Charms class!");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "Today, we will learn how to attract objects with: Accio");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "Let's try to learn it.");
        threadSleep(2000);
        System.out.println(RED_BOLD + "Write Accio to learn the spell :" + RESET);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Accio")) {
                break;
            } else {
                System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "It is not exactly that, write: Accio");
            }
        }
        wizard.learnSpell(Spell.accio);
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "\nCharms Teacher - " + RESET + "Wonderful! That's it for today.\n");
        threadSleep(2000);

        //-- 2nd part of the free time --
        System.out.println("** You have some free time this afternoon. **");
        threadSleep(2000);
        System.out.println("** What will you do? **");
        threadSleep(1000);
        chooseWhatToDo();

        //-- 3rd part of the free time --
        System.out.println("** It was interesting **");
        threadSleep(2000);
        System.out.println("** But the sun sets, so you are going to the " + wizard.getHouse() + " dormitory to sleep. **");
        threadSleep(3000);
        System.out.println("** ZzzzzZzzzZZzzzZZZZzzzzZZzzZZZzzZZzz... **");
        threadSleep(3000);
        System.out.println("** You wake up, what have you planned today? **");
        threadSleep(2000);
        chooseWhatToDo();

        //-- 3rd part of the free time --
        chooseWhatToDo();
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }

    //Algorithm to let the player choose a class (I use it 3 times in the story)
    public void chooseWhatToDo() {
        boolean ok = check;
        while (check == ok) {
            System.out.print(GREEN_BOLD);
            if (!stuffDone[1]) { // hiding if the lesson was taken before
                System.out.println("1. Learn on your own at the library.");
            }
            if (!stuffDone[2]) {
                System.out.println("2. Go to see Hagrid near the castle.");
            }
            if (!stuffDone[3]) {
                System.out.println("3. Go to the " + wizard.getHouse() + " common room.");
            }
            if (!stuffDone[3]) { //Still [3] for the story
                System.out.println("4. Take a walk in the castle.");
            }
            if (stuffDone[2] && stuffDone[3]) { //Hidden at first
                System.out.println("5. Searching for the Giant Spider in the forbidden forest.");
            }
            System.out.print(RED_BOLD + "Enter a number to make your choice :\n" + RESET);
            String input = scanner.nextLine();
            check = !ok;
            switch (input) {
                case "1" :
                    if (stuffDone[1]) {
                        System.out.println("** You have to do something. **");
                        check = ok;
                    } else {
                        libraryChoice();
                    }
                    break;
                case "2":
                    if (stuffDone[2]) {
                        System.out.println("** You have to do something. **");
                        check = ok;
                    } else {
                        hagridChoice();
                    }
                    break;
                case "3":
                    if (stuffDone[3]) {
                        System.out.println("** You have to do something. **");
                        check = ok;
                    } else {
                        System.out.println("** You are now in the " + wizard.getHouse() + " common room. **");
                        threadSleep(2000);
                        System.out.println("** It's very spacious! **");
                        thirdChoice();
                    }
                    break;
                case "4":
                    if (!stuffDone[3]) { //Still [3] for the story
                        System.out.println("** You have to do something. **");
                        check = ok;
                    } else {
                        System.out.println("** You walk in the corridors of the castle... **");
                        thirdChoice();
                    }
                    break;
                case "5":
                    if (!stuffDone[2] || !stuffDone[3]) {
                        System.out.println("** Yu have to do something. **");
                        check = ok;
                    } else {
                        System.out.println("xxxxxxxxx");
                    }
                    break;
                default :
                    System.out.println("** You have to do something. **");
                    check = ok;
            }
        }
    }

    public void libraryChoice() {
        System.out.println("** You are now in the library. **");
        threadSleep(2000);
        System.out.println("** There are a lots of books here! So you starts with the easy ones. **");
        threadSleep(2000);
        System.out.println("** Which one will you choose? **" + GREEN_BOLD);
        threadSleep(1000);
        System.out.println("1. Magical plants\n2. Pronunciation of spells\n3. Cleaning your mind\n4. Wiggenweld potion\n5. All mighty" + RESET);
        while (!stuffDone[1]) {
            stuffDone[1] = true;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You learn plenty of things about magical plants... **");
                    threadSleep(3000);
                    System.out.println("** You get +1 botanist point! **");
                    wizard.setBotanist(wizard.getBotanist() + 1);
                }
                case "2" -> {
                    System.out.println("** You learn how to pronounce spells correctly... **");
                    threadSleep(3000);
                    System.out.println("** You get +1 accuracy point! **");
                    wizard.setAccuracy(wizard.getAccuracy() + 1);
                }
                case "3" -> {
                    System.out.println("** This book really clear your mind! **");
                    threadSleep(3000);
                    System.out.println("** You get +5 health point! **");
                    wizard.setMaxHealth(wizard.getMaxHealth() + 5);
                }
                case "4" -> {
                    System.out.println("** You read all the steps to do a healing potion called Wiggenweld... **");
                    threadSleep(3000);
                    wizard.learnPotion(Potion.wiggenweld);
                }
                case "5" -> {
                    System.out.println("** This is an intriguing book written by a Mr. Riddle... **");
                    threadSleep(3000);
                    System.out.println("** You get +1 of power! **");
                    wizard.setPower(wizard.getPower()+ 1);
                }
                default -> {
                    System.out.println("You are in the library so you have to choose a book.");
                    stuffDone[1] = false;
                }
            }
        }
        threadSleep(2000);
    }

    public void hagridChoice() {
        System.out.println("** You are now in the Hagrid's hut. **\n");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Hey " + wizard.getName() + "! I am happy to see you this year!");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Have you heard about the Chamber of Secrets?");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "I have an old friend who knows a lot on the subject.");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "It is a Giant Spider hidden in the forbidden forest.");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "I advise you to go there if you want some info...");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "However the forest is dangerous, so i will teach you a fire spell: Incendio");
        threadSleep(3000);
        System.out.println(RED_BOLD + "Write Incendio to learn the spell :" + RESET);
        while (!stuffDone[2]) {
            String input = scanner.nextLine();
            if (input.equals("Incendio")) {
                stuffDone[2] = true;
            } else {
                System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Haha, it is not so easy, right? try again.");
            }
        }
        wizard.learnSpell(Spell.incendio);
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "\nHagrid - " + RESET + "Nice! Make good use of it!");
        threadSleep(2000);
        System.out.println("\n** You go back to the castle **");
        threadSleep(2000);
    }

    public void thirdChoice() {
        threadSleep(2000);
        System.out.println("** Suddenly, you hear someone calling you. **\n");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "Hey! You are " + wizard.getName() + ", right?");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "It is my 3rd year at Hogwarts, and I am the boss of a secret dueling club for students.");
        threadSleep(4000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "You might be interested by our club because you have beaten a Troll last year.");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "But still, you are not enough strong as a 2nd year. So i will teach you a private spell lesson.");
        threadSleep(4000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "What spell would you like to learn?");
        threadSleep(2000);
        System.out.println(GREEN_BOLD + "1. xxxxxxxx\n2. xxxxxxxxxx" + RESET);
        while (!stuffDone[3]) {
            stuffDone[3] = true;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> System.out.println("1");
                case "2" -> System.out.println("2");
                default -> {
                    System.out.println("So?");
                    stuffDone[3] = false;
                }
            }
        }
    }

    public void threadSleep(int time) { //To use it in the while loop otherwise it is "busy waiting"
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}