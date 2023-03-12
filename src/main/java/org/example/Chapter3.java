package org.example;

import java.util.Objects;

public class Chapter3 implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String BLUE_BOLD = "\033[1;34m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String BLACK_BOLD = "\033[1;30m"; //fun
    private static Wizard wizard;
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
        //Duelling club
        //Lupin DADA //Expecto Patronum
        //Divination class and Care of Magical Creatures class
        //Dementors
    }

    //Huge and ugly algorithm to assign a patronus to the wizard
    public void createPatronus() {
        if (Objects.equals(wizard.getHouse(), "Gryffindor")) {
            if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
                wizard.setPatronus("Lion");
            } else if (wizard.getWand().getCore() == Core.DRAGON_HEARTSTRING) {
                wizard.setPatronus("Bear");
            } else {
                wizard.setPatronus("Cat");
            }
        } else if (Objects.equals(wizard.getHouse(), "Hufflepuff")) {
            if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
                wizard.setPatronus("Dog");
            } else if (wizard.getWand().getCore() == Core.DRAGON_HEARTSTRING) {
                wizard.setPatronus("Penguin");
            } else {
                wizard.setPatronus("Badger");
            }
        } else if (Objects.equals(wizard.getHouse(), "Ravenclaw")) {
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
        System.out.println("** Your Patronus is a " + wizard.getPatronus() + "! **"); //telling the player what he/she got.
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}