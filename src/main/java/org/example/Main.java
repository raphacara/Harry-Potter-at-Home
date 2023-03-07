package org.example;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Wizard wizard = new Wizard(); //The player

    public static void main(String[] args) {
        BackgroundMusic music = new BackgroundMusic(); //create music
        try {
            // ----- MUSIC -----
            music.play();

            // 1. ----- INTRODUCTION -----
            Introduction intro = new Introduction(wizard);
            play(intro, "Introduction");

            // 2. ----- CHAPTER 1 -----
            Chapter1 chapter1 = new Chapter1(wizard); //Change the (wizard) by (test) if you skipped the intro
            play(chapter1, "Chapter 1");

            // 3. ----- CHAPTER 2 -----

            //Stop the music
            } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                music.stop();
        }
    }

    //I created this method because my game is a bit long, so it will ask to skip steps of the game.
    public static void play(StoryStep step, String name) throws InterruptedException {
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
                break;
            } else {
                System.out.println("You have to enter a number.");
            }
        }
        wizard.checkWizard(wizard); //checking the wizard infos
    }
}