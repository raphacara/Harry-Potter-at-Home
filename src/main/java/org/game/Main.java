package org.game;
import org.game.attributes.Potion;
import org.game.character.Wizard;
import org.game.spells.Spell;
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
        try {
            // ----- MUSIC -----
            music.play(); //playing the music

            // 1. ----- INTRODUCTION -----
            Introduction intro = new Introduction(wizard); //creating an Introduction
            play(intro, "Introduction", wizard); //playing it

            // 2. ----- CHAPTER 1 -----
            Chapter1 chapter1 = new Chapter1(wizard);
            play(chapter1, "Chapter 1", wizard);

            // 3. ----- CHAPTER 2 -----
            Chapter2 chapter2 = new Chapter2(wizard);
            play(chapter2, "Chapter 2", wizard);

            // 4. ----- CHAPTER 3 -----
            Chapter3 chapter3 = new Chapter3(wizard);
            play(chapter3, "Chapter 3", wizard);

            // 5. ----- CHAPTER 4 -----
            Chapter4 chapter4 = new Chapter4(wizard);
            play(chapter4, "Chapter 4", wizard);

            // 6. ----- CHAPTER 5 -----
            Chapter5 chapter5 = new Chapter5(wizard);
            play(chapter5, "Chapter 5", wizard);

            // 7. ----- CHAPTER 6 -----
            Chapter6 chapter6 = new Chapter6(wizard);
            play(chapter6, "Chapter 6", wizard);

            // 8. ----- CHAPTER 7 -----
            if (Objects.equals(wizard.getCondition(), "Dark")) { //If the enemy joined the Voldemort's army
                Chapter7_Dark chapter7_dark = new Chapter7_Dark(wizard); //Then it is an alternative Chapter 7
                play(chapter7_dark, "Chapter 7", wizard);
            } else { //Else: regular Chapter 7
                Chapter7 chapter7 = new Chapter7(wizard);
                play(chapter7, "Chapter 7", wizard);
            }

            //Stop the music
            } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                music.stop();
        }
    }

    //I created this method because my game is a bit long, so it will ask to skip steps of the game.
    public static void play(StoryStep step, String name, Wizard wizard) throws InterruptedException {
        System.out.println("\n=======================================");
        System.out.println("Do you want to play the " + name + "?");
        System.out.println("* 1. PLAY\n* 2. SKIP");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("1")) { //Play the step
                System.out.println("=======================================\n");
                step.run(); //run the step of history
                wizard = step.getWizard(); //Updating the wizard
                break;
            } else if (input.equals("2")) { //skip the step
                System.out.println("=======================================\n");
                if (wizard.getHouse() == null) { //= if you skipped the intro
                    wizard.randomWizard(wizard); //create a random wizard
                }
                //Un-aesthetic code to assign the player what he should no if he skips a part of the game. TEST ONLY.
                if (Objects.equals(name, "Introduction") ) { //If the player didn't play Introduction
                    wizard.bonusHouses(wizard); //adding House bonus
                    wizard.bonusPet(wizard); //adding Pet bonus
                    wizard.bonusWand(wizard);//adding Wand bonus
                    System.out.println(" ");
                }
                if (Objects.equals(name, "Chapter 1") ) { //If the player didn't play Chapter 1
                    wizard.learnSpell(Spell.wingardiumLeviosa); //assign spells
                    wizard.learnSpell(Spell.protego);
                    wizard.learnPotion(Potion.wiggenweld);
                    System.out.println(" ");
                }
                if (Objects.equals(name, "Chapter 2") ) { //If the player didn't play Chapter 2
                    wizard.learnSpell(Spell.accio);
                    wizard.learnSpell(Spell.incendio);
                    System.out.println(" ");
                }
                if (Objects.equals(name, "Chapter 3") ) { //If the player didn't play Chapter 3
                    wizard.setPatronus("Snail"); //This is a joke
                    wizard.learnSpell(Spell.expectoPatronum); //assign spells
                    wizard.learnSpell(Spell.diffindo);
                    System.out.println(" ");
                }
                break;
            } else {
                System.out.println("You have to enter a number.");
            }
        }
        wizard.checkWizard(wizard); //checking the wizard infos
    }
}