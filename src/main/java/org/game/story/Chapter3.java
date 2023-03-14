package org.game.story;

import org.game.attributes.Core;
import org.game.attributes.House;
import org.game.character.enemies.Enemy;
import org.game.character.Wizard;
import org.game.spells.Spell;

import java.util.Objects;
import java.util.Scanner;

public class Chapter3 implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String BLUE_BOLD = "\033[1;34m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String BLACK_BOLD = "\033[1;30m"; //fun
    private static Wizard wizard;
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private boolean check = false; //checking the loops
    private final boolean[] classesTaken = new boolean[7]; //changing to true when the player take a lesson

    //Constructor
    public Chapter3(Wizard player) {
        wizard = player;
    }
    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 3 --
        System.out.println(GREEN_BOLD + "\n----------------- Chapter 3 -----------------");
        Thread.sleep(1000);
        System.out.println("---------- The Prisoner of Azkaban ----------\n" + RESET);
        Thread.sleep(2000);
        System.out.println("** It is now your 3rd year at Hogwarts. **");
        Thread.sleep(2000);
        System.out.println("** Let's hope it will be a normal year, without awful enemies. **");
        Thread.sleep(2000);
        System.out.println("** Anyway, you know that this year you can take part in two new classes: **");
        Thread.sleep(3000);
        System.out.println(BLACK_BOLD + "~~ DIVINATION ~~ " + RESET + "and" + BLACK_BOLD + " ~~ CARE OF MAGICAL CREATURES ~~" + RESET);
        Thread.sleep(300);
        System.out.println("** And you also remember about a dueling club... **");
        Thread.sleep(3000);

        //-- 1st choice --
        System.out.println("** So, what are you going to do this year? **");
        chooseClass();

        //-- Learning Expecto Patronum --
        System.out.println("** Then, you have a mandatory lesson of Defense Against the Dark Arts, with the new teacher. **");
        Thread.sleep(3000);
        defenseClass();
        System.out.println("** What a great spell! **");
        Thread.sleep(2000);
        classesTaken[5] = true;

        //-- other choices choice --
        while (!classesTaken[4]) {
            System.out.println("** Now, what do you want to do? **");
            chooseClass();
        }

        //-- Final Dementors fight and end of the Chapter --
        System.out.println("** You hear a wolf howl not very far from you, so you quicky go back to the castle. **");
        Thread.sleep(3000);
        System.out.println("** It is the end of the year, and you have heard that the winning house of this year was Ravenclaw. **");
        Thread.sleep(4000);
        System.out.println("\n** Chapter 3 - THE END **\n");
        Thread.sleep(2000);
    }

    public void chooseClass() throws InterruptedException {
        boolean ok = check;
        while (check == ok) {
            System.out.print(GREEN_BOLD);
            if (!classesTaken[1]) { // hiding if the lesson was taken before
                System.out.println("1. Divinity class");
            }
            if (!classesTaken[2]) {
                System.out.println("2. Care of Magical Creatures class");
            }
            if (!classesTaken[3]) {
                System.out.println("3. Dueling club");
            }
            System.out.println("4. Sleeping");
            if (classesTaken[5]) {
                System.out.println("5. Forbidden Forest");
            }
            System.out.print(RED_BOLD + "Enter a number to make your choice :\n" + RESET);
            String input = scanner.nextLine();
            check = !ok;
            switch (input) {
                case "1" :
                    if (classesTaken[1]) {
                        System.out.println("** What do you mean? **");
                        check = ok;
                    } else {
                        divinityClass();
                    }
                    break;
                case "2":
                    if (classesTaken[2]) {
                        System.out.println("** What do you mean? **");
                        check = ok;
                    } else {
                        creatureClass();
                    }
                    break;
                case "3":
                    if (classesTaken[3]) {
                        System.out.println("** What do you mean? **");
                        check = ok;
                    } else {
                        duelingClub();
                    }
                    break;
                case "4":
                    System.out.println("** You go back in your bed and you sleep. **");
                    threadSleep(2000);
                    System.out.println("** A long time after that, you wake up.  **");
                    threadSleep(1000);
                    break;
                case "5":
                    if (!classesTaken[5]) {
                        System.out.println("** What do you mean? **");
                        check = ok;
                    } else {
                        forbiddenForest();
                    }
                    break;
                default :
                    System.out.println("** What do you mean? **");
                    check = ok;
            }
        }
    }

    public void divinityClass() {
        System.out.println("** So you decide to go to the Divinity class. **");
        threadSleep(2000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(1000);
        System.out.println(BLACK_BOLD + "           ~~~   DIVINITY   ~~~\n" + RESET);
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Divinity Teacher - " + RESET + "Welcome to the Divinity class!");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Divinity Teacher - " + RESET + "Here we will try to see your future...");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Divinity Teacher - " + RESET + wizard.getName() + ", I see some dark sides in your future, how do you interpret it?");
        threadSleep(1000);
        System.out.println(GREEN_BOLD + "1. That's my fate.\n2. That's my enemies.\n3. I don't want to tell you.\n4. I don't care.");
        System.out.println(RED_BOLD + "Enter a number to make your choice :" + RESET);
        while (!classesTaken[1]) {
            classesTaken[1] = true;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> wizard.setPower(wizard.getPower() + 1);
                case "2" -> wizard.setMaxHealth(wizard.getMaxHealth() + 5);
                case "3" -> wizard.setAccuracy(wizard.getAccuracy() + 1);
                case "4" -> wizard.setBotanist(wizard.getBotanist() + 1);
                default -> {
                    System.out.println("You have chosen to come to this course, so answer my question.");
                    classesTaken[1] = false;
                }
            }
        }
        System.out.println(GREEN_BOLD + "** One of your stats has secretly increased... **" + RESET);
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "\nDivinity Teacher - " + RESET + "Interesting...");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Divinity Teacher - " + RESET + "That will be enough for today.\n");
        threadSleep(2000);
    }

    public void creatureClass() {
        classesTaken[2] = true;
        System.out.println("** You are at the Care of Magical Creatures class. **");
        threadSleep(2000);
        System.out.println("** You learn a lot of interesting features about a creature called: Hippogriff **");
        threadSleep(3000);
        System.out.println("** They have the head and wings of an eagle and the body of a horse. **");
        threadSleep(2000);
        System.out.println("** They are known for their strength and loyalty, but can be easily offended if not shown proper respect. **");
        threadSleep(3000);
        System.out.println(GREEN_BOLD + "** You get +1 botanist point for this lesson! **" + RESET);
        wizard.setBotanist(wizard.getBotanist() + 1);
        threadSleep(2000);
    }

    public void duelingClub() throws InterruptedException {
        classesTaken[3] = true;
        System.out.println("** You are going at the secret Dueling Student Club. **");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "Hey " + wizard.getName() + "! Welcome here.");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "I will explain you how this club works.");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "You can practice your spells in a combat against an other student.");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "No one dies, but the winner can learn a new spell that I will teach him.");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "You came here by yourself, so I suppose you are ready to fight.");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Student - " + RESET + "Today you will fight against a Slytherin student.\n");
        threadSleep(2000);
        System.out.println(RED_BOLD + "Slytherin Student - " + RESET + "Good luck...");
        Enemy student = new Enemy("Slytherin Student", 120, 40); //Creating a Troll
        wizard.attack(student);
        threadSleep(1000);
        if (Objects.equals(wizard.getCondition(), "Defeated")) {
            System.out.println(BLUE_BOLD + "\nStudent - " + RESET + "You are not enough powerful, come back when you'll be better.\n");
        } else {
            System.out.println(BLUE_BOLD + "\nStudent - " + RESET + "Congratulation " + wizard.getName() + "!");
            threadSleep(2000);
            System.out.println(BLUE_BOLD + "Student - " + RESET + "You deserve me to teach you a new Spell: Diffindo");
            threadSleep(2000);
            System.out.println(RED_BOLD + "Write the spell to learn it :" + RESET);
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("Diffindo")) {
                    wizard.learnSpell(Spell.diffindo);
                    break;
                } else {
                    System.out.println(BLUE_BOLD + "Student - " + RESET + "Try again.");
                }
            }
            System.out.println(BLUE_BOLD + "Student - " + RESET + "Awesome, Come back next time to fight harder students!\n");
        }
        threadSleep(2000);
    }

    public void forbiddenForest() throws InterruptedException {
        System.out.println("** You are going in the Forbidden forest. **");
        threadSleep(2000);
        System.out.println("** It is really dark and mysterious. **");
        threadSleep(2000);
        System.out.println("** The road splits into 3 paths, which one to choose? **");
        threadSleep(2000);
        System.out.println(GREEN_BOLD + "1. Left side\n2. Right side\n3. Straight ahead" + RESET);
        while (!classesTaken[4]) {
            classesTaken[4] = true;
            String input = scanner.nextLine();
            switch (input) {
                case "1", "2", "3" -> System.out.println("** You take this way, and continue walking... **");
                default -> {
                    System.out.println("** You can't go back, you have to choose. **");
                    classesTaken[4] = false;
                }
            }
        }
        threadSleep(2000);
        System.out.println("** You reach a lake. **");
        threadSleep(2000);
        System.out.println("** Suddenly, you perceive dark beings coming for you... They are dementors! **");
        threadSleep(2000);
        Enemy dementors = new Enemy("Dementors", 99999, 10); //Creating a Troll
        wizard.stopAttack(Spell.lumos); //Just for the story.
        wizard.attack(dementors); //attacking the dementors.
        System.out.println("** Wow, that was crazy, you are exhausted. **");
        threadSleep(2000);
    }

    public void defenseClass() {
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(1000);
        System.out.println(BLACK_BOLD + "~~~   DEFENSE AGAINST THE DARK ARTS   ~~~\n" + RESET);
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Defense Teacher - " + RESET + "Welcome to the Defense class! My name in Lupin.");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Lupin - " + RESET + "This year, there are some dark beeings outside the castle.");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Lupin - " + RESET + "They are called: the dementors");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Lupin - " + RESET + "To defeat them, you will need to use a specific spell: Expecto Patronum.");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Lupin - " + RESET + "It's hard to cast it, but it released a positive light energy, we called it: a patronus");
        threadSleep(3000);
        System.out.println(BLUE_BOLD + "Lupin - " + RESET + "A patronus takes the form of an animal that protects you from dark magic.");
        threadSleep(3000);
        System.out.println(RED_BOLD + "Write Expecto Patronum to learn the spell :" + RESET);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("EXPECTO PATRONUM")) {
                break;
            } else {
                System.out.println(BLUE_BOLD + "Lupin - " + RESET + "This one is difficult, to learn it, try writing using ALL CAPS.");
            }
        }
        wizard.learnSpell(Spell.expectoPatronum);
        System.out.println("** Your wand is casting a intense light, and it create...  **");
        threadSleep(3000);
        createPatronus();
        System.out.println("** a " + wizard.getPatronus() + "!!! **");
        System.out.println(GREEN_BOLD + "** Your Patronus is a " + wizard.getPatronus() + "! **" + RESET); //telling the player what he/she got.
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "\nLupin - " + RESET + "Unbelievable! You did it!");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Lupin - " + RESET + "A lot of dementors have been seen in the Forbidden Forest, so be careful.");
        threadSleep(2000);
        System.out.println(BLUE_BOLD + "Lupin - " + RESET + "Anyway, see you next time.\n");
        threadSleep(2000);
    }

    //Huge and ugly algorithm to assign a patronus to the wizard
    public void createPatronus() {
        if (wizard.getHouse() == House.Gryffindor) {
            if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
                wizard.setPatronus("Lion");
            } else if (wizard.getWand().getCore() == Core.DRAGON_HEARTSTRING) {
                wizard.setPatronus("Bear");
            } else {
                wizard.setPatronus("Cat");
            }
        } else if (wizard.getHouse() == House.Hufflepuff) {
            if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
                wizard.setPatronus("Dog");
            } else if (wizard.getWand().getCore() == Core.DRAGON_HEARTSTRING) {
                wizard.setPatronus("Penguin");
            } else {
                wizard.setPatronus("Badger");
            }
        } else if (wizard.getHouse() == House.Ravenclaw) {
            if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
                wizard.setPatronus("Eagle");
            } else if (wizard.getWand().getCore() == Core.DRAGON_HEARTSTRING) {
                wizard.setPatronus("Fox");
            } else {
                wizard.setPatronus("Raven");
            }
        } else {
            if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
                wizard.setPatronus("Snake");
            } else if (wizard.getWand().getCore() == Core.DRAGON_HEARTSTRING) {
                wizard.setPatronus("Shark");
            } else {
                wizard.setPatronus("Wolf");
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

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}