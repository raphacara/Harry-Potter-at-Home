package org.game.story;

import org.game.Color;
import org.game.GameContent;
import org.game.character.Wizard;

public class Chapter7 implements StoryStep {
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content

    //Constructor
    public Chapter7(Wizard player) {
        wizard = player;
    }
    @Override
    public void runStory() throws InterruptedException {
        //-- Intro of Chapter 7 --
        System.out.println(Color.GREEN + "----------------- Chapter 7 -----------------");
        threadSleep(1000);
        System.out.println("------------ The Deathly Hallows ------------\n" + Color.RESET);
        threadSleep(1000);
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}