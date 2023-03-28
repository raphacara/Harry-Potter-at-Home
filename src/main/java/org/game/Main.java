package org.game;

import org.game.character.Wizard;
import org.game.story.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Wizard wizard = new Wizard(); //creating wizard
        BackgroundMusic music = new BackgroundMusic(); //creating music
        GameContent game = new GameContent(); // instantiate game content like Spells Enemies and Bosses
        try {
            // ----- MUSIC -----
            music.playMusic(); //playing the music

            // 1. ----- INTRODUCTION -----
            Introduction intro = new Introduction(wizard); //creating an Introduction
            playStory(intro, "Introduction", wizard, game); //playing it

            // 2. ----- CHAPTER 1 -----
            Chapter1 chapter1 = new Chapter1(wizard);
            playStory(chapter1, "Chapter 1", wizard, game);

            // 3. ----- CHAPTER 2 -----
            Chapter2 chapter2 = new Chapter2(wizard);
            playStory(chapter2, "Chapter 2", wizard, game);

            // 4. ----- CHAPTER 3 -----
            Chapter3 chapter3 = new Chapter3(wizard);
            playStory(chapter3, "Chapter 3", wizard, game);

            // 5. ----- CHAPTER 4 -----
            Chapter4 chapter4 = new Chapter4(wizard);
            playStory(chapter4, "Chapter 4", wizard, game);

            // 6. ----- CHAPTER 5 -----
            Chapter5 chapter5 = new Chapter5(wizard);
            playStory(chapter5, "Chapter 5", wizard, game);

            // 7. ----- CHAPTER 6 -----
            Chapter6 chapter6 = new Chapter6(wizard);
            playStory(chapter6, "Chapter 6", wizard, game);

            wizard.setCondition("Dark"); //intern test

            // 8. ----- CHAPTER 7 -----
            if (Objects.equals(wizard.getCondition(), "Dark")) { //If the enemy joined the Voldemort's army
                Chapter7Dark chapter7Dark = new Chapter7Dark(wizard); //Then it is an alternative Chapter 7
                playStory(chapter7Dark, "Chapter 7", wizard, game);
            } else { //Else: regular Chapter 7
                Chapter7 chapter7 = new Chapter7(wizard);
                playStory(chapter7, "Chapter 7", wizard, game);
            }

            //Stop the music
            } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                music.stop();
        }
    }

    //I created this method because my game is a bit long, so it will ask to skip steps of the game.
    public static void playStory(StoryStep step, String name, Wizard wizard, GameContent game) throws InterruptedException {
        System.out.println("\n=======================================");
        System.out.println("Do you want to play the " + name + "?");
        System.out.println("* 1. PLAY\n* 2. SKIP");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("1")) { //Play the step
                System.out.println("=======================================\n");
                step.runStory(); //runStory the step of history
                wizard = step.getWizard(); //Updating the wizard
                break;
            } else if (input.equals("2")) { //skip the step
                System.out.println("=======================================\n");
                if (wizard.getHouse() == null) { //= if you skipped the intro
                    wizard.randomWizard(wizard); //create a random wizard
                }
                //Un-aesthetic code to assign the player what he should no if he skips a part of the game. TEST ONLY.
                if (Objects.equals(name, "Introduction") ) { //If the player didn't playStory Introduction
                    wizard.bonusHouses(wizard); //adding House bonus
                    wizard.bonusPet(wizard); //adding Pet bonus
                    wizard.bonusWand(wizard);//adding Wand bonus
                }
                if (Objects.equals(name, "Chapter 1") ) { //If the player didn't playStory Chapter 1
                    wizard.learnSpell(game.spell("Wingardium Leviosa")); //assign spells
                    wizard.learnSpell(game.spell("Protego"));
                    wizard.learnPotion(game.potion("Wiggenweld"));
                }
                if (Objects.equals(name, "Chapter 2") ) { //If the player didn't playStory Chapter 2
                    wizard.learnSpell(game.spell("Accio"));
                    wizard.learnSpell(game.spell("Incendio"));
                }
                if (Objects.equals(name, "Chapter 3") ) { //If the player didn't playStory Chapter 3
                    wizard.setPatronus("Snail"); //This is a joke
                    wizard.learnSpell(game.spell("Expecto Patronum")); //assign spells
                    wizard.learnSpell(game.spell("Diffindo"));
                }
                if (Objects.equals(name, "Chapter 6") ) { //If the player didn't playStory Chapter 3
                    wizard.learnSpell(game.spell("Sectumsempra")); //assign spells
                    wizard.learnSpell(game.spell("Crucio"));
                    wizard.learnPotion(game.potion("Felix Felicis"));
                }
                System.out.println(" ");
                break;
            } else {
                System.out.println("You have to enter a number.");
            }
        }
        wizard.infoWizard(wizard); //checking the wizard infos
    }
}
