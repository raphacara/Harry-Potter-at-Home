package org.game.story;

import org.game.attributes.Potion;
import org.game.character.Wizard;
import org.game.character.enemies.Boss;
import org.game.spells.Spell;

import java.util.Scanner;

public class Chapter4 implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String BLUE_BOLD = "\033[1;34m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String BLACK_BOLD = "\033[1;30m"; //fun
    private static Wizard wizard; //the player
    private boolean check; //checking the loops
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private final boolean[] learn = new boolean[8]; //changing to true when the player learn a skill


    //Constructor
    public Chapter4(Wizard player) {
        wizard = player;
    }
    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 4 --
        System.out.println(GREEN_BOLD + "\n----------------- Chapter 4 -----------------");
        threadSleep(1000);
        System.out.println("------------- The Goblet of Fire ------------\n" + RESET);
        threadSleep(2000);
        threadSleep(1000);
        System.out.println("** And you have been chosen by the Goblet of Fire to participate in it. **");
        threadSleep(3000);
        System.out.println("** There are several tasks to achieve through this tournament, but there are not without danger. **");
        threadSleep(3000);
        System.out.println("** Before doing the tournament, you need to prepare yourself if you don't want to die... **");
        threadSleep(3000);
        System.out.println("** But you don't have much time, so you can learn one new skill. **");
        threadSleep(2000);
        //Preparation 1
        System.out.println("** What will your learn? **");
        learnSkill();
        threadSleep(2000);
        System.out.println("** You are now going to the 1st challenge. **");

        //-- 1st Challenge --
        System.out.println(BLUE_BOLD + "\n~~~~~~~~~~~~ 1st Challenge ~~~~~~~~~~~~");
        threadSleep(1000);
        System.out.println("~~~~~~~~~~~~~ Dragon Task ~~~~~~~~~~~~~\n" + RESET);
        dragon();

        //Preparation 2
        threadSleep(2000);
        System.out.println("** You don't waste more time and prepare yourself for the next task **");
        threadSleep(2000);
        System.out.println("** So what will your learn this time? **");
        learnSkill();
        threadSleep(2000);
        System.out.println("** You are now going to the 2nd challenge. **");

        //-- 2nd Challenge --
        System.out.println(BLUE_BOLD + "\n~~~~~~~~~~~~ 2nd Challenge ~~~~~~~~~~~~");
        threadSleep(1000);
        System.out.println("~~~~~~~~~~ Underwater Rescue ~~~~~~~~~~\n" + RESET);
        underwater();

        //Preparation 3


        //-- 3rd Challenge --
        System.out.println(BLUE_BOLD + "\n~~~~~~~~~~~~ 3rd Challenge ~~~~~~~~~~~~");
        threadSleep(1000);
        System.out.println("~~~~~~~~~~~~~~ Labyrinth ~~~~~~~~~~~~~~\n" + RESET);
        labyrinth();

        //Final battle in the Cemetery
    }

    public void learnSkill() {
        threadSleep(2000);
        System.out.println(GREEN_BOLD + "1. Aguamenti Spell\n2. Bubble-Head Charm\n3. Disillusionment Charm\n4. Protego Charm");
        System.out.println(GREEN_BOLD + "5. Gillyweed Potion\n6. Invisibility Potion\n7. Wiggenweld Potion");
        check = false;
        while (!check) {
            check = true;
            System.out.print(RED_BOLD + "Enter a number to make your choice :\n" + RESET);
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You are trying to learn Aguamenti... **");
                    threadSleep(2000);
                    System.out.println("** It is a spell that makes a water jet. **");
                    threadSleep(2000);
                    wizard.learnSpell(Spell.aguamenti);
                }
                case "2" -> {
                    System.out.println("** You are trying to learn Bubble-Head... **");
                    threadSleep(2000);
                    System.out.println("** It is a charm that makes bubble around your head, to breath underwater. **");
                    threadSleep(2000);
                    wizard.learnSpell(Spell.bubbleHead);
                }
                case "3" -> {
                    System.out.println("** You are trying to learn Disilluminatus... **");
                    threadSleep(2000);
                    System.out.println("** It is a charm that makes you invisible for a moment. **");
                    threadSleep(2000);
                    wizard.learnSpell(Spell.disilluminatus);
                }
                case "4" -> {
                    System.out.println("** You are trying to learn Protego... **");
                    threadSleep(2000);
                    System.out.println("** It is a charm that protect you against an attack. **");
                    threadSleep(2000);
                    wizard.learnSpell(Spell.protego);
                }
                case "5" -> {
                    System.out.println("** You are trying to learn the Gillyweed Potion... **");
                    threadSleep(2000);
                    System.out.println("** It is a potion that allows you to breath underwater for a moment. **");
                    threadSleep(2000);
                    wizard.learnPotion(Potion.gillyweed);
                }
                case "6" -> {
                    System.out.println("** You are trying to learn the Invisibility Potion... **");
                    threadSleep(2000);
                    System.out.println("** It is a potion that makes you invisible for a moment. **");
                    threadSleep(2000);
                    wizard.learnPotion(Potion.invisibility);
                }
                case "7" -> {
                    System.out.println("** You are trying to learn Wiggenweld Potion... **");
                    threadSleep(2000);
                    System.out.println("** It is a potion that heals you. **");
                    threadSleep(2000);
                    wizard.learnPotion(Potion.wiggenweld);
                }
                default -> {
                    System.out.println("** Your choice is important. **");
                    check = false;
                }
            }
        }
        threadSleep(2000);
    }

    public void dragon() throws InterruptedException {
        threadSleep(3000);
        System.out.println("** The goal of this task is to steal an egg from the dragon. **");
        threadSleep(2000);
        System.out.println("** So you enter in the arena, and face a ferocious dragon. **");
        threadSleep(2000);
        System.out.println("** How are you going to steal the egg? **");
        threadSleep(2000);
        System.out.println(GREEN_BOLD + "1. Fighting the dragon\n2. Trying to be stealthy" + RESET);
        while (check) {
            check = false;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You stand in front of the dragon, one of you have to die today. **");
                    wizard.attack(Boss.dragon);
                    threadSleep(1000);
                    System.out.println("** You really killed the Dragon! **");
                    threadSleep(2000);
                    System.out.println("** So you easily grab the egg, and pass the challenge. **");
                }
                case "2" -> {
                    for (Spell spell : wizard.getKnownSpells()) {
                        if (spell.getName().equals("Disilluminatus")) {
                            System.out.println("** You use the Disillusion spell to be really stealthy... **");
                            threadSleep(2000);
                        }
                    }
                    for (Potion potion: wizard.getPotions()) {
                        if (potion.getName().equals("Invisibility")) {
                            System.out.println("** You use the Gillyweed Potion to be extremely stealthy... **");
                            wizard.setAccuracy(wizard.getAccuracy() + 1);
                            threadSleep(2000);
                            System.out.println(GREEN_BOLD + "** It works very well so you gain +1 accuracy point! **" + RESET);
                            threadSleep(2000);
                        }
                    }
                    System.out.println("** You reach the egg without being spotted by the dragon! **");
                    threadSleep(2000);
                    System.out.println("** Congratulation! **");
                    threadSleep(2000);
                }
                default -> {
                    System.out.println("** Hurry up! You have to make a choice. **");
                    check = true;
                }
            }
        }
    }

    public void underwater() {
        threadSleep(3000);
    }

    public void labyrinth() {
        threadSleep(3000);
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