package org.game.story;

import org.game.Color;
import org.game.GameContent;
import org.game.character.Wizard;

public class Chapter7Dark implements StoryStep {
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content

    //Constructor
    public Chapter7Dark(Wizard player) {
        wizard = player;
    }
    @Override
    public void runStory() throws InterruptedException {
        //-- Intro of Chapter 7 --
        System.out.println(Color.GREEN + "----------------- Chapter 7 -----------------");
        threadSleep(200);
        System.out.println("------------ The Deathly Hallows ------------\n" + Color.RESET);
        threadSleep(1000);

        //-- Story --
        System.out.println("** You are a Death Eater. **");
        threadSleep(200);
        System.out.println("You are with your fellow Death Eaters, Voldemort and Bellatrix Lestrange.");


    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}
