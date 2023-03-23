package org.game.story;

import org.game.GameContent;
import org.game.attributes.House;
import org.game.character.Wizard;

import java.util.Scanner;

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
        threadSleep(1000);
        System.out.println("** You read the book and learn that it was written by: 'the half-blood prince'... **");
        threadSleep(1500);

        //-- Learning new stuff --
        System.out.println("** Oh! And there is the notice about an unknown new spell: Sectumsempra! **");
        threadSleep(1000);
        wizard.learnSpell(game.spell("Sectumsempra"));
        threadSleep(1000);
        System.out.println("** Unbelievable! You read the entire book... **");
        threadSleep(1000);
        wizard.setPower(wizard.getPower() + 5);
        wizard.setBotanist(wizard.getBotanist() + 5);
        System.out.println(GREEN + "** You gain +5 power! **");
        System.out.println("** You gain +5 botanist points! **" + RESET);
        threadSleep(1000);
        System.out.println("** The year is going on... **");
        threadSleep(1000);
        System.out.println("** At the end of the year, there is a terrible danger... Some Death Eaters entered in the castle! **");
        threadSleep(1500);
        System.out.println("** And you have heard that they have killed Dumbledore... **");
        threadSleep(1000);
        System.out.println("** So you go at the top of the Astronomy tower to see what happened. **");
        threadSleep(1000);

        //-- Death Eater fight --
        System.out.println("** You reach the top of the tower, and you face a Death Eater! **");
        threadSleep(1000);
        wizard.attack(game.enemy("Death Eater"));
        threadSleep(500);

        //-- 2nd fight or Option to become mean --
        System.out.println("** There is an other Death Eater behind you! **");
        finalChoice();

        //-- End of Chapter 6 --
        System.out.println("\n** Chapter 6 - THE END **\n");
        threadSleep(1000);
    }

    public void potionsClass() {
        threadSleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(500);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(500);
        System.out.println(BLACK + "           ~~~   POTIONS   ~~~\n" + RESET);
        threadSleep(1000);
        System.out.println(BLUE + "Potions Teacher - " + RESET + "Welcome to the Potions class!");
        threadSleep(500);
        System.out.println(BLUE + "Potions Teacher - " + RESET + "Today we will learn a potion that gives luck!");
        threadSleep(1000);
        System.out.println(BLUE + "Potions Teacher - " + RESET + "It is called : Felix Felicis!");
        threadSleep(1000);
        System.out.println("\n** You are trying to learn the potion... **");
        threadSleep(1000);
        System.out.println("** You find an old book that explains very well how to do it! **\n");
        threadSleep(1000);
        wizard.learnPotion(game.potion("Felix Felicis"));
        threadSleep(500);
        System.out.println(BLUE + "\nPotions Teacher  - " + RESET + "Congratulations " + wizard.getName() + "!");
        threadSleep(1000);
    }

    public void finalChoice() throws InterruptedException {
        if (wizard.getHouse() == House.Slytherin) {
            threadSleep(1000);
            System.out.println(RED + "Death Eater -" + RESET + "Hey, you are a Slytherin...");
            threadSleep(1000);
            System.out.println(RED + "Death Eater -" + RESET + "Would you like to join us?");
            threadSleep(1000);
            Scanner scanner = new Scanner(System.in);
            String input = "";
            while (!(input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("No"))) {
                System.out.print(RED + "Enter Yes or No :" + RESET);
                input = scanner.nextLine();
                switch (input.toLowerCase()) {
                    case "yes" -> {
                        darkEnd();
                        return;
                    }
                    case "no" -> System.out.println(RED + "Death Eater -" + RESET + "You are going to regret it!");
                    default -> System.out.println(RED + "Death Eater -" + RESET + "This is a serious choice.");
                }
            }
        } else {
            threadSleep(1000);
            wizard.stopAttack(game.spell("Lumos")); //Just for the story.
            wizard.attack(game.enemy("Death Eater"));
            threadSleep(500);
            System.out.println("** You killed the Death Eaters! **");
            threadSleep(1000);
            System.out.println("** Danger is everywhere now, you will have to fight it... **");
            threadSleep(1000);
        }
    }

    public void darkEnd() {
        System.out.println(RED + "Death Eater - " + RESET + "I knew it! Haha, you are smart.");
        threadSleep(1000);
        System.out.println(RED + "Death Eater - " + RESET + "By the way, my name is Bellatrix Lestrange.");
        threadSleep(1000);
        System.out.println(RED + "Bellatrix - " + RESET + "I will give you the Dark Mark: Then you will be a Death Eater like us!");
        threadSleep(1000);
        System.out.println(BLACK + "\n** You receive the Dark Mark on your left arm. **\n");
        threadSleep(1000);
        System.out.println("Dark Mark : " + RESET + "Magical 'Tattoo' on Death Eater's left arm, it looks like a snake ;\n" +
                "            It forces you to serve the Dark lord, if you betray him, you die instantly ;\n" +
                "            It allows you to fly through the air in a black smoke-like form ;\n" +
                "            By touching the mark with your wand, you can feel a burning sensation and will be able to locate Voldemort and join his ranks.\n");
        threadSleep(2000);
        System.out.println(RED + "Bellatrix - " + RESET + "Welcome among us! To celebrate that, I will teach you a special curse, Haha. ");
        threadSleep(1000);
        System.out.println(RED + "Bellatrix - " + RESET + "It is called crucio and it makes your enemies to suffer, Hahaha.");
        threadSleep(1000);
        wizard.learnSpell(game.spell("Crucio"));
        System.out.println(RED + "Bellatrix - " + RESET + "Wonderful, now follow me, we will join the Dark Lord to introduce him to his new recruit.");
        threadSleep(2000);
        System.out.println("\n** You follow Bellatrix and fly in a dark smoke to a distant destination...");
        threadSleep(1000);
        wizard.setCondition("Dark"); //Setting the wizard in the Dark end.
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