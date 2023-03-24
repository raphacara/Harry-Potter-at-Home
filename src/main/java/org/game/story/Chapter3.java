package org.game.story;

import org.game.Color;
import org.game.GameContent;
import org.game.attributes.Core;
import org.game.attributes.House;
import org.game.character.Wizard;

import java.util.Objects;
import java.util.Scanner;

public class Chapter3 implements StoryStep {
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private boolean check = false; //checking the loops
    private final boolean[] classesTaken = new boolean[7]; //changing to true when the player take a lesson

    //Constructor
    public Chapter3(Wizard player) {
        wizard = player;
    }
    @Override
    public void runStory() throws InterruptedException {
        //-- Intro of Chapter 3 --
        System.out.println(Color.GREEN + "----------------- Chapter 3 -----------------");
        threadSleep(200);
        System.out.println("---------- The Prisoner of Azkaban ----------\n" + Color.RESET);
        threadSleep(1000);
        System.out.println("** It is now your 3rd year at Hogwarts. **");
        threadSleep(200);
        System.out.println("** Let's hope it will be a normal year, without awful enemies. **");
        threadSleep(200);
        System.out.println("** Anyway, you know that this year you can take part in two new classes: **");
        threadSleep(200);
        System.out.println(Color.BLUE + "~~ DIVINATION ~~ " + Color.RESET + "and" + Color.BLUE + " ~~ CARE OF MAGICAL CREATURES ~~" + Color.RESET);
        threadSleep(200);
        System.out.println("** And you also remember about a dueling club... **");
        threadSleep(200);

        //-- 1st choice --
        System.out.println("** So, what are you going to do this year? **");
        chooseClass();

        //-- Learning Expecto Patronum --
        System.out.println("** Then, you have a mandatory lesson of Defense Against the Dark Arts, with the new teacher. **");
        threadSleep(200);
        defenseClass();
        System.out.println("** What a great spell! **");
        threadSleep(200);
        classesTaken[5] = true;

        //-- other choices choice --
        while (!classesTaken[4]) {
            System.out.println("** Now, what do you want to do? **");
            chooseClass();
        }

        //-- Final Dementors fight and end of the Chapter --
        System.out.println("** You hear a wolf howl not very far from you, so you quicky go back to the castle. **");
        threadSleep(200);
        System.out.println("** It is the end of the year.**");
        waiting();
        System.out.println("\n** Chapter 3 - THE END **\n");
        threadSleep(1000);
    }

    public void chooseClass() throws InterruptedException {
        boolean ok = check;
        while (check == ok) {
            System.out.print(Color.GREEN);
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
            System.out.print(Color.RED + "Enter a number to make your choice :\n" + Color.RESET);
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
                    waiting();
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
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println(Color.BLACK + "           ~~~   DIVINITY   ~~~\n" + Color.RESET);
        threadSleep(1000);
        System.out.println(Color.BLUE + "Divinity Teacher - " + Color.RESET + "Welcome to the Divinity class!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Divinity Teacher - " + Color.RESET + "Here we will try to see your future...");
        threadSleep(200);
        System.out.println(Color.BLUE + "Divinity Teacher - " + Color.RESET + wizard.getName() + ", I see some dark sides in your future, how do you interpret it?");
        threadSleep(200);
        System.out.println(Color.GREEN + "1. That's my fate.\n2. That's my enemies.\n3. I don't want to tell you.\n4. I don't care.");
        System.out.println(Color.RED + "Enter a number to make your choice :" + Color.RESET);
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
        System.out.println(Color.GREEN + "** One of your stats has secretly increased... **" + Color.RESET);
        waiting();
        System.out.println(Color.BLUE + "\nDivinity Teacher - " + Color.RESET + "Interesting...");
        threadSleep(200);
        System.out.println(Color.BLUE + "Divinity Teacher - " + Color.RESET + "That will be enough for today.\n");
        threadSleep(200);
    }

    public void creatureClass() {
        classesTaken[2] = true;
        System.out.println("** You are at the Care of Magical Creatures class. **");
        threadSleep(200);
        System.out.println("** You learn a lot of interesting features about a creature called: Hippogriff **");
        threadSleep(200);
        System.out.println("** They have the head and wings of an eagle and the body of a horse. **");
        threadSleep(200);
        System.out.println("** They are known for their strength and loyalty, but can be easily offended if not shown proper respect. **");
        waiting();
        System.out.println(Color.GREEN + "** You get +1 botanist point for this lesson! **" + Color.RESET);
        wizard.setBotanist(wizard.getBotanist() + 1);
        threadSleep(200);
    }

    public void duelingClub() throws InterruptedException {
        classesTaken[3] = true;
        System.out.println("** You are going at the secret Dueling Student Club. **");
        threadSleep(200);
        System.out.println(Color.BLUE + "Student - " + Color.RESET + "Hey " + wizard.getName() + "! Welcome here.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Student - " + Color.RESET + "I will explain you how this club works.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Student - " + Color.RESET + "You can practice your spells in a combat against an other student.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Student - " + Color.RESET + "No one dies, but the winner can learn a new spell that I will teach him.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Student - " + Color.RESET + "You came here by yourself, so I suppose you are ready to fight.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Student - " + Color.RESET + "Today you will fight against a Slytherin student.");
        waiting();
        System.out.println(Color.RED + "Slytherin Student - " + Color.RESET + "Good luck...");
        wizard.attack(game.enemy("Slytherin Student"));
        threadSleep(1000);
        if (Objects.equals(wizard.getCondition(), "Defeated")) {
            System.out.println(Color.BLUE + "\nStudent - " + Color.RESET + "You are not enough powerful, come back when you'll be better.\n");
            waiting();
        } else {
            System.out.println(Color.BLUE + "\nStudent - " + Color.RESET + "Congratulation " + wizard.getName() + "!");
            threadSleep(200);
            System.out.println(Color.BLUE + "Student - " + Color.RESET + "You deserve me to teach you a new Spell: Diffindo");
            threadSleep(200);
            System.out.println(Color.RED + "Write the spell to learn it :" + Color.RESET);
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("Diffindo")) {
                    wizard.learnSpell(game.spell("Diffindo"));
                    break;
                } else {
                    System.out.println(Color.BLUE + "Student - " + Color.RESET + "Try again.");
                }
            }
            System.out.println(Color.BLUE + "Student - " + Color.RESET + "Awesome, Come back next time to fight harder students!\n");
        }
        threadSleep(200);
    }

    public void forbiddenForest() throws InterruptedException {
        System.out.println("** You are going in the Forbidden forest. **");
        waiting();
        System.out.println("** It is really dark and mysterious. **");
        threadSleep(200);
        System.out.println("** The road splits into 3 paths, which one to choose? **");
        threadSleep(200);
        System.out.println(Color.GREEN + "1. Left side\n2. Right side\n3. Straight ahead" + Color.RESET);
        System.out.println(Color.RED + "Enter a number to make your choice" + Color.RESET);
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
        threadSleep(200);
        System.out.println("** You reach a lake. **");
        threadSleep(200);
        System.out.println("** Suddenly, you perceive dark beings coming for you... They are dementors! **");
        waiting();
        wizard.stopAttack(game.spell("Lumos")); //Just for the story.
        wizard.attack(game.enemy("Dementors")); //attacking the dementors.
        System.out.println("** Wow, that was crazy, you are exhausted. **");
        threadSleep(200);
    }

    public void defenseClass() {
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println(Color.BLACK + "~~~   DEFENSE AGAINST THE DARK ARTS   ~~~\n" + Color.RESET);
        threadSleep(1000);
        System.out.println(Color.BLUE + "Defense Teacher - " + Color.RESET + "Welcome to the Defense class! My name in Lupin.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Lupin - " + Color.RESET + "This year, there are some dark beeings outside the castle.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Lupin - " + Color.RESET + "They are called: the dementors");
        threadSleep(200);
        System.out.println(Color.BLUE + "Lupin - " + Color.RESET + "To defeat them, you will need to use a specific spell: Expecto Patronum.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Lupin - " + Color.RESET + "It's hard to cast it, but it released a positive light energy, we called it: a patronus");
        threadSleep(200);
        System.out.println(Color.BLUE + "Lupin - " + Color.RESET + "A patronus takes the form of an animal that protects you from dark magic.");
        threadSleep(200);
        System.out.println(Color.RED + "Write Expecto Patronum to learn the spell :" + Color.RESET);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("EXPECTO PATRONUM")) { //Not IgnoreCase on purpose.
                break;
            } else {
                System.out.println(Color.BLUE + "Lupin - " + Color.RESET + "This one is difficult, to learn it, try writing using ALL CAPS.");
            }
        }
        wizard.learnSpell(game.spell("Expecto Patronum"));
        System.out.println("** Your wand is casting a intense light, and it create...  **");
        waiting();
        createPatronus();
        System.out.println("** a " + wizard.getPatronus() + "!!! **");
        System.out.println(Color.GREEN + "** Your Patronus is a " + wizard.getPatronus() + "! **" + Color.RESET); //telling the player what he/she got.
        waiting();
        System.out.println(Color.BLUE + "\nLupin - " + Color.RESET + "Unbelievable! You did it!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Lupin - " + Color.RESET + "A lot of dementors have been seen in the Forbidden Forest, so be careful.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Lupin - " + Color.RESET + "Anyway, see you next time.");
        waiting();
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

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}