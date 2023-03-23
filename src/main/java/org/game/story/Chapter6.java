package org.game.story;

import org.game.GameContent;
import org.game.character.Wizard;

public class Chapter6 implements StoryStep {
    private final String RESET = "\u001B[0m"; //fun
    private final String RED = "\033[1;31m"; //fun
    private final String BLUE = "\033[1;34m"; //fun
    private final String GREEN = "\033[1;32m"; //fun
    private final String BLACK = "\033[1;30m"; //fun
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content

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

        //-- Story --
        System.out.println("** You are starting this year with a potion class. **");
        potionsClass();
        System.out.println("\n** You leave the class, and keep the old book with you. **");
        threadSleep(2000);
        System.out.println("** You read the book and learn that it was written by: 'the half-blood prince'... **");
        threadSleep(3000);
        System.out.println("** Oh! And there is the notice about an unknown new spell: Sectumsempra! **");
        threadSleep(3000);
        wizard.learnSpell(game.spell("Sectumsempra"));
        threadSleep(2000);
        System.out.println("** Unbelievable! You read the entire book... **");
        threadSleep(2000);
        wizard.setPower(wizard.getPower() + 5);
        wizard.setBotanist(wizard.getBotanist() + 5);
        System.out.println(GREEN + "** You gain +5 power! **" + RESET);
        System.out.println(GREEN + "** You gain +5 botanist points! **" + RESET);
        threadSleep(2000);
        wizard.attack(game.enemy("Death Eater"));
        threadSleep(1000);
        System.out.println("** Well played! **");

        //-- End of Chapter 6 --
        threadSleep(2000);
        System.out.println("\n** Chapter 6 - THE END **\n");
        threadSleep(2000);
    }

    public void potionsClass() {
        threadSleep(2000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(1000);
        System.out.println(BLACK + "           ~~~   POTIONS   ~~~\n" + RESET);
        threadSleep(2000);
        System.out.println(BLUE + "Potions Teacher - " + RESET + "Welcome to the Potions class!");
        threadSleep(2000);
        System.out.println(BLUE + "Potions Teacher - " + RESET + "Today we will learn a potion that gives luck!");
        threadSleep(2000);
        System.out.println(BLUE + "Potions Teacher - " + RESET + "It is called : Felix Felicis!");
        threadSleep(3000);
        System.out.println("\n** You are trying to learn the potion... **");
        threadSleep(2000);
        System.out.println("** You find an old book that explains very well how to do it! **\n");
        threadSleep(2000);
        wizard.learnPotion(game.potion("Felix Felicis"));
        threadSleep(2000);
        System.out.println(BLUE + "\nPotions Teacher  - " + RESET + "Congratulations " + wizard.getName() + "!");
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