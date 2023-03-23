package org.game.story;

import org.game.GameContent;
import org.game.character.Wizard;

public class Chapter7_Dark implements StoryStep {
    private final String RESET = "\u001B[0m"; //fun
    private final String RED = "\033[1;31m"; //fun
    private final String BLUE = "\033[1;34m"; //fun
    private final String GREEN = "\033[1;32m"; //fun
    private final String BLACK = "\033[1;30m"; //fun
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content

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