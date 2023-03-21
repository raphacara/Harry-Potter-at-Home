package org.game.story;

import org.game.character.Wizard;

public class Chapter7_Dark implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED = "\033[1;31m"; //fun
    private static final String BLUE = "\033[1;34m"; //fun
    private static final String GREEN = "\033[1;32m"; //fun
    private static final String BLACK = "\033[1;30m"; //fun
    private static Wizard wizard;
    //Constructor
    public Chapter7_Dark(Wizard player) {
        wizard = player;
    }
    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 7 --
        System.out.println(GREEN + "\n----------------- Chapter 7 -----------------");
        threadSleep(1000);
        System.out.println("------------ The Deathly Hallows ------------\n" + RESET);
        threadSleep(2000);
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
