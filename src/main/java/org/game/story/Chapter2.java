package org.game.story;
import org.game.attributes.Potion;
import org.game.character.enemies.Boss;
import org.game.character.enemies.Enemy;
import org.game.character.Wizard;
import org.game.spells.Spell;

import java.util.Scanner;

public class Chapter2 implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String BLUE_BOLD = "\033[1;34m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String BLACK_BOLD = "\033[1;30m"; //fun
    private static Wizard wizard;
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private final boolean[] stuffDone = new boolean[5]; //changing to true when the player take a lesson
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
        System.out.println("** Dumbledore leave the Great Hall. **");
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

        //-- Learning Accio --
        defenseClass();

        //-- 2nd part of the free time --
        System.out.println("** You have some free time this afternoon. **");
        threadSleep(2000);
        System.out.println("** What will you do? **");
        threadSleep(1000);
        chooseWhatToDo();

        //-- 3rd part of the free time --
        if (!stuffDone[4]) {
            System.out.println("** It was interesting **");
            threadSleep(2000);
            System.out.println("** But the sun sets, so you are going to the " + wizard.getHouse() + " dormitory to sleep. **");
            threadSleep(3000);
            System.out.println("** ZzzzzZzzzZZzzzZZZZzzzzZZzzZZZzzZZzz... **");
            threadSleep(3000);
            System.out.println("** You wake up, what have you planned today? **");
            threadSleep(2000);
            chooseWhatToDo();
        }

        //-- 4th part of the free time --
        if (!stuffDone[4]) {
            System.out.println("** It was refreshing. **");
            threadSleep(2000);
            System.out.println("** The year goes on slowly. **");
            threadSleep(2000);
            System.out.println("** What will you do? **");
            chooseWhatToDo();
        }

        //-- The Basilisk BOSS fight --
        System.out.println("** You fall in front of a giant snake : the Basilisk!  **");
        threadSleep(3000);
        Boss Basilisk = new Boss("Basilisk", 500, 48); //Creating a Troll
        wizard.attack(Basilisk);
        threadSleep(2000);
        System.out.println("\n** What an intense fight! You leave the Chamber of Secrets to tell everything to Dumbledore. **");
        threadSleep(3000);
        System.out.println("** It thanks you for beating the Basilisk, and have made the castle safe. **");
        threadSleep(3000);
        System.out.println("** Since it's the end of the year, Dumbledore declare this : **\n");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "This year again, regarding what happened in Hogwarts, the winning house is...");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + wizard.getHouse() + "!");
        Thread.sleep(2000);
        System.out.println("\n** Chapter 2 - THE END **\n");
        Thread.sleep(2000);
    }


    @Override
    public Wizard getWizard() {
        return wizard;
    }

    public void defenseClass() {
        threadSleep(3000);
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
            if (input.equalsIgnoreCase("Accio")) {
                break;
            } else {
                System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "It is not exactly that, write: Accio");
            }
        }
        wizard.learnSpell(Spell.accio);
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "\nCharms Teacher - " + RESET + "Wonderful! That's it for today.\n");
        threadSleep(2000);
    }

    //Algorithm to let the player choose a class (I use it 3 times in the story)
    public void chooseWhatToDo() throws InterruptedException {
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
            if (stuffDone[2]) { //Hidden at first
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
                    if (stuffDone[3]) { //Still [3] for the story
                        System.out.println("** You have to do something. **");
                        check = ok;
                    } else {
                        System.out.println("** You walk in the corridors of the castle... **");
                        thirdChoice();
                    }
                    break;
                case "5":
                    if (!stuffDone[2]) {
                        System.out.println("** You have to do something. **");
                        check = ok;
                    } else {
                        System.out.println("** You are going in the forbidden forest... **");
                        spiderChoice();
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
                    System.out.println(GREEN_BOLD + "** You get +1 botanist point! **" + RESET);
                    wizard.setBotanist(wizard.getBotanist() + 1);
                }
                case "2" -> {
                    System.out.println("** You learn how to pronounce spells correctly... **");
                    threadSleep(3000);
                    System.out.println(GREEN_BOLD + "** You get +1 accuracy point! **" + RESET);
                    wizard.setAccuracy(wizard.getAccuracy() + 1);
                }
                case "3" -> {
                    System.out.println("** This book really clear your mind! **");
                    threadSleep(3000);
                    System.out.println(GREEN_BOLD + "** You get +5 health point! **" + RESET);
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
                    System.out.println(GREEN_BOLD + "** You get +1 of power! **" + RESET);
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
            if (input.equalsIgnoreCase("Incendio")) {
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
        System.out.println(GREEN_BOLD + "1. Aguamenti\n2. Reducto" + RESET);
        while (!stuffDone[3]) {
            stuffDone[3] = true;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> System.out.println(BLUE_BOLD + "Student - " + RESET + "Great choice! Water spells are fun.");
                case "2" -> System.out.println(BLUE_BOLD + "Student - " + RESET + "Great choice! I love Reducto too.");
                default -> {
                    System.out.println("So?");
                    stuffDone[3] = false;
                }
            }
        }
        threadSleep(2000);
        System.out.println(RED_BOLD + "Write the spell to learn it :" + RESET);
        while (stuffDone[3]) {
            stuffDone[3] = false;
            String input2 = scanner.nextLine();
            if (input2.equalsIgnoreCase("Aguamenti")) {
                wizard.learnSpell(Spell.aguamenti);
            } else if (input2.equalsIgnoreCase("Reducto")) {
                 wizard.learnSpell(Spell.reducto);
            } else {
                System.out.println(BLUE_BOLD + "Student - " + RESET + "Wrong spelling, try again.");
                stuffDone[3] = true;
            }
        }
        stuffDone[3] = true;
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "\nStudent - " + RESET + "Perfect, practice this spell, and next year, don't hesitate to come to the dueling club!\n");
        threadSleep(2000);
    }

    //Chapter 2 fights, and end of chapter 2
    public void spiderChoice() throws InterruptedException {
        threadSleep(2000);
        System.out.println("** It is a dense and mysterious woodland... **");
        threadSleep(2000);
        System.out.println("** It is home of a variety of dangerous creatures such as unicorns, centaurs, and giant spiders... **");
        threadSleep(3000);
        System.out.println("** But hopefully you exactly know where to go thanks to Hagrid. **");
        threadSleep(3000);
        System.out.println("** So you enter in the dark cave, where the Giant Spider is supposed to be... **");
        threadSleep(3000);
        System.out.println("** But suddenly a spider attacks you from behind! **");
        threadSleep(3000);
        Enemy spider = new Enemy("spider", 70, 20); //Creating a Troll
        wizard.attack(spider);
        System.out.println("\n** What a fight! **\n");
        threadSleep(2000);
        System.out.println(RED_BOLD + "Giant Spider - " + RESET + "Sorry for that, my spiders attack everyone except Hagrid.");
        threadSleep(3000);
        System.out.println(RED_BOLD + "Giant Spider - " + RESET + "But he told me be that you would come.");
        threadSleep(3000);
        System.out.println(RED_BOLD + "Giant Spider - " + RESET + "So I will tell you what I know about the Chamber of Secrets...");
        threadSleep(3000);
        System.out.println(RED_BOLD + "Giant Spider - " + RESET + "It contains a giant snake called: the Basilisk.");
        threadSleep(3000);
        System.out.println(RED_BOLD + "Giant Spider - " + RESET + "And the entrance of the Chamber of Secrets is located in the basement toilets...");
        threadSleep(3000);
        System.out.println("\n** You thanks the spider and don't waste time to find the secret room. **");
        threadSleep(3000);
        System.out.println("** Once you are in the lowest toilets of the castle, you find a hidden hole, and you decide to jump in... **");
        threadSleep(4000);
        stuffDone[4] = true;
    }

    public void threadSleep(int time) { //To use it in the while loop otherwise it is "busy waiting"
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}