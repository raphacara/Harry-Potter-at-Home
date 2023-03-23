package org.game.story;
import org.game.GameContent;
import org.game.character.Wizard;

import java.util.Scanner;

public class Chapter2 implements StoryStep {
    private final String RESET = "\u001B[0m"; //fun
    private final String RED = "\033[1;31m"; //fun
    private final String BLUE = "\033[1;34m"; //fun
    private final String GREEN = "\033[1;32m"; //fun
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content
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
        System.out.println(GREEN + "\n----------------- Chapter 2 -----------------");
        threadSleep(200);
        System.out.println("---------- The Chamber of Secrets -----------\n" + RESET);
        threadSleep(1000);
        System.out.println("** This is your 2nd year at Hogwarts. **");
        threadSleep(200);
        System.out.println("** You are back in the Great Hall with the other Students. **\n");
        threadSleep(200);
        System.out.println(BLUE + "Dumbledore - " + RESET + "Hello to all of you.");
        threadSleep(200);
        System.out.println(BLUE + "Dumbledore - " + RESET + "There is a great danger in the school this year.");
        threadSleep(200);
        System.out.println(BLUE + "Dumbledore - " + RESET + "The Chamber of Secrets has been opened.");
        threadSleep(200);
        System.out.println(BLUE + "Dumbledore - " + RESET + "No one knows where it is but it contains a deadly enemy.");
        threadSleep(200);
        System.out.println(BLUE + "Dumbledore - " + RESET + "So be very careful.\n");
        waiting();
        System.out.println("** Dumbledore leave the Great Hall. **");
        threadSleep(200);

        //-- 1st part of free time --
        System.out.println("** What do you want to do? **");
        threadSleep(200);
        chooseWhatToDo();
        System.out.println("** It was a great experience. **");
        waiting();
        System.out.println("** The next morning, you have to go to class.  **");
        threadSleep(200);
        System.out.println("** But you have heard the the Defense Against the Dark Arts teacher was really bad this year... **");

        //-- Learning Accio --
        defenseClass();

        //-- 2nd part of the free time --
        System.out.println("** You have some free time this afternoon. **");
        threadSleep(200);
        System.out.println("** What will you do? **");
        threadSleep(200);
        chooseWhatToDo();

        //-- 3rd part of the free time --
        if (!stuffDone[4]) {
            System.out.println("** It was interesting **");
            threadSleep(200);
            System.out.println("** But the sun sets, so you are going to the " + wizard.getHouse() + " dormitory to sleep. **");
            threadSleep(200);
            System.out.println("** ZzzzzZzzzZZzzzZZZZzzzzZZzzZZZzzZZzz... **");
            waiting();
            System.out.println("** You wake up, what have you planned today? **");
            threadSleep(200);
            chooseWhatToDo();
        }

        //-- 4th part of the free time --
        if (!stuffDone[4]) {
            System.out.println("** It was refreshing. **");
            threadSleep(200);
            System.out.println("** The year goes on slowly. **");
            threadSleep(200);
            System.out.println("** What will you do? **");
            chooseWhatToDo();
        }

        //-- The Basilisk BOSS fight --
        System.out.println("** You fall in front of a giant snake : the Basilisk!  **");
        waiting();
        wizard.attack(game.enemy("Basilisk"));
        threadSleep(200);
        System.out.println("\n** What an intense fight! You leave the Chamber of Secrets to tell everything to Dumbledore. **");
        threadSleep(200);
        System.out.println("** He thanks you for beating the Basilisk, and have made the castle safe. **");
        threadSleep(200);
        System.out.println("** Since it's the end of the year, Dumbledore declare this : **\n");
        threadSleep(200);
        System.out.println(BLUE + "Dumbledore - " + RESET + "This year again, regarding what happened in Hogwarts, the winning house is...");
        waiting();
        System.out.println(BLUE + "Dumbledore - " + RESET + wizard.getHouse() + "!");
        waiting();
        System.out.println("\n** Chapter 2 - THE END **\n");
        Thread.sleep(1000);
    }

    public void defenseClass() {
        threadSleep(200);
        System.out.println("** So you decide to go to the Charms class. **");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        //fun
        String BLACK = "\033[1;30m";
        System.out.println(BLACK + "            ~~~   CHARMS   ~~~\n" + RESET);
        threadSleep(1000);
        System.out.println(BLUE + "Charms Teacher - " + RESET + "Welcome to the Charms class!");
        threadSleep(200);
        System.out.println(BLUE + "Charms Teacher - " + RESET + "Today, we will learn how to attract objects with: Accio");
        threadSleep(200);
        System.out.println(BLUE + "Charms Teacher - " + RESET + "Let's try to learn it.");
        threadSleep(200);
        System.out.println(RED + "Write Accio to learn the spell :" + RESET);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Accio")) {
                break;
            } else {
                System.out.println(BLUE + "Charms Teacher - " + RESET + "It is not exactly that, write: Accio");
            }
        }
        wizard.learnSpell(game.spell("Accio"));
        threadSleep(200);
        System.out.println(BLUE + "\nCharms Teacher - " + RESET + "Wonderful! That's it for today.\n");
        threadSleep(200);
    }

    //Algorithm to let the player choose a class (I use it 3 times in the story)
    public void chooseWhatToDo() throws InterruptedException {
        boolean ok = check;
        while (check == ok) {
            System.out.print(GREEN);
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
            System.out.print(RED + "Enter a number to make your choice :\n" + RESET);
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
                        threadSleep(200);
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
        threadSleep(200);
        System.out.println("** There are a lots of books here! So you starts with the easy ones. **");
        threadSleep(200);
        System.out.println("** Which one will you choose? **" + GREEN);
        threadSleep(200);
        System.out.println("1. Magical plants\n2. Pronunciation of spells\n3. Cleaning your mind\n4. Wiggenweld potion\n5. All mighty" + RESET);
        while (!stuffDone[1]) {
            stuffDone[1] = true;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You learn plenty of things about magical plants... **");
                    waiting();
                    System.out.println(GREEN + "** You get +1 botanist point! **" + RESET);
                    wizard.setBotanist(wizard.getBotanist() + 1);
                }
                case "2" -> {
                    System.out.println("** You learn how to pronounce spells correctly... **");
                    waiting();
                    System.out.println(GREEN + "** You get +1 accuracy point! **" + RESET);
                    wizard.setAccuracy(wizard.getAccuracy() + 1);
                }
                case "3" -> {
                    System.out.println("** This book really clear your mind! **");
                    waiting();
                    System.out.println(GREEN + "** You get +5 health point! **" + RESET);
                    wizard.setMaxHealth(wizard.getMaxHealth() + 5);
                }
                case "4" -> {
                    System.out.println("** You read all the steps to do a healing potion called Wiggenweld... **");
                    waiting();
                    wizard.learnPotion(game.potion("Wiggenweld"));
                }
                case "5" -> {
                    System.out.println("** This is an intriguing book written by a Mr. Riddle... **");
                    waiting();
                    System.out.println(GREEN + "** You get +1 of power! **" + RESET);
                    wizard.setPower(wizard.getPower()+ 1);
                }
                default -> {
                    System.out.println("You are in the library so you have to choose a book.");
                    stuffDone[1] = false;
                }
            }
        }
        threadSleep(200);
    }

    public void hagridChoice() {
        System.out.println("** You are now in the Hagrid's hut. **\n");
        threadSleep(200);
        System.out.println(BLUE + "Hagrid - " + RESET + "Hey " + wizard.getName() + "! I am happy to see you this year!");
        threadSleep(200);
        System.out.println(BLUE + "Hagrid - " + RESET + "Have you heard about the Chamber of Secrets?");
        threadSleep(200);
        System.out.println(BLUE + "Hagrid - " + RESET + "I have an old friend who knows a lot on the subject.");
        threadSleep(200);
        System.out.println(BLUE + "Hagrid - " + RESET + "It is a Giant Spider hidden in the forbidden forest.");
        threadSleep(200);
        System.out.println(BLUE + "Hagrid - " + RESET + "I advise you to go there if you want some info...");
        threadSleep(200);
        System.out.println(BLUE + "Hagrid - " + RESET + "However the forest is dangerous, so i will teach you a fire spell: Incendio");
        threadSleep(200);
        System.out.println(RED + "Write Incendio to learn the spell :" + RESET);
        while (!stuffDone[2]) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Incendio")) {
                stuffDone[2] = true;
            } else {
                System.out.println(BLUE + "Hagrid - " + RESET + "Haha, it is not so easy, right? try again.");
            }
        }
        wizard.learnSpell(game.spell("Incendio"));
        threadSleep(200);
        System.out.println(BLUE + "\nHagrid - " + RESET + "Nice! Make good use of it!");
        threadSleep(200);
        System.out.println("\n** You go back to the castle **");
        waiting();
    }

    public void thirdChoice() {
        threadSleep(200);
        System.out.println("** Suddenly, you hear someone calling you. **\n");
        threadSleep(200);
        System.out.println(BLUE + "Student - " + RESET + "Hey! You are " + wizard.getName() + ", right?");
        threadSleep(200);
        System.out.println(BLUE + "Student - " + RESET + "It is my 3rd year at Hogwarts, and I am the boss of a secret dueling club for students.");
        threadSleep(200);
        System.out.println(BLUE + "Student - " + RESET + "You might be interested by our club because you have beaten a Troll last year.");
        threadSleep(200);
        System.out.println(BLUE + "Student - " + RESET + "But still, you are not enough strong as a 2nd year. So i will teach you a private spell lesson.");
        threadSleep(200);
        System.out.println(BLUE + "Student - " + RESET + "What spell would you like to learn?");
        threadSleep(200);
        System.out.println(GREEN + "1. Aguamenti\n2. Reducto" + RESET);
        while (!stuffDone[3]) {
            stuffDone[3] = true;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> System.out.println(BLUE + "Student - " + RESET + "Great choice! Water spells are fun.");
                case "2" -> System.out.println(BLUE + "Student - " + RESET + "Great choice! I love Reducto too.");
                default -> {
                    System.out.println("So?");
                    stuffDone[3] = false;
                }
            }
        }
        threadSleep(200);
        System.out.println(RED + "Write the spell to learn it :" + RESET);
        while (stuffDone[3]) {
            stuffDone[3] = false;
            String input2 = scanner.nextLine();
            if (input2.equalsIgnoreCase("Aguamenti")) {
                wizard.learnSpell(game.spell("Aguamenti"));
            } else if (input2.equalsIgnoreCase("Reducto")) {
                 wizard.learnSpell(game.spell("Reducto"));
            } else {
                System.out.println(BLUE + "Student - " + RESET + "Wrong spelling, try again.");
                stuffDone[3] = true;
            }
        }
        stuffDone[3] = true;
        threadSleep(200);
        System.out.println(BLUE + "\nStudent - " + RESET + "Perfect, practice this spell, and next year, don't hesitate to come to the dueling club!\n");
        waiting();
    }

    //Chapter 2 fights, and end of chapter 2
    public void spiderChoice() throws InterruptedException {
        threadSleep(200);
        System.out.println("** It is a dense and mysterious woodland... **");
        threadSleep(200);
        System.out.println("** It is home of a variety of dangerous creatures such as unicorns, centaurs, and giant spiders... **");
        threadSleep(200);
        System.out.println("** But hopefully you exactly know where to go thanks to Hagrid. **");
        threadSleep(200);
        System.out.println("** So you enter in the dark cave, where the Giant Spider is supposed to be... **");
        threadSleep(200);
        System.out.println("** But suddenly a spider attacks you from behind! **");
        waiting();
        wizard.attack(game.enemy("Spider"));
        System.out.println("\n** What a fight! **\n");
        threadSleep(200);
        System.out.println(RED + "Giant Spider - " + RESET + "Sorry for that, my spiders attack everyone except Hagrid.");
        threadSleep(200);
        System.out.println(RED + "Giant Spider - " + RESET + "But he told me be that you would come.");
        threadSleep(200);
        System.out.println(RED + "Giant Spider - " + RESET + "So I will tell you what I know about the Chamber of Secrets...");
        waiting();
        System.out.println(RED + "Giant Spider - " + RESET + "It contains a giant snake called: the Basilisk.");
        threadSleep(200);
        System.out.println(RED + "Giant Spider - " + RESET + "And the entrance of the Chamber of Secrets is located in the basement toilets...");
        waiting();
        System.out.println("\n** You thanks the spider and don't waste time to find the secret room. **");
        threadSleep(200);
        System.out.println("** Once you are in the lowest toilets of the castle, you find a hidden hole, and you decide to jump in... **");
        threadSleep(200);
        stuffDone[4] = true;
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}