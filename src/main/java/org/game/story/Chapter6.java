package org.game.story;

import org.game.character.Wizard;
import org.game.character.enemies.Boss;
import org.game.character.enemies.Enemy;
import org.game.spells.Spell;

public class Chapter6 implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED = "\033[1;31m"; //fun
    private static final String BLUE = "\033[1;34m"; //fun
    private static final String GREEN = "\033[1;32m"; //fun
    private static Wizard wizard;
    //Constructor
    public Chapter6(Wizard player) {
        wizard = player;
    }
    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 6 --
        System.out.println(GREEN + "\n----------------- Chapter 6 -----------------");
        threadSleep(1000);
        System.out.println("----------- The Half-Blood Prince -----------\n" + RESET);
        threadSleep(2000);

        //Story
        System.out.println(BLUE + "! Story in progress !\n" + RESET);
        threadSleep(3000);
        wizard.learnSpell(Spell.sectumsempra);
        threadSleep(1000);
        wizard.attack(Enemy.deathEater);
        threadSleep(1000);
        System.out.println("** Well played! **");

        //-- End of Chapter 6 --
        threadSleep(2000);
        System.out.println("\n** Chapter 6 - THE END **\n");
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