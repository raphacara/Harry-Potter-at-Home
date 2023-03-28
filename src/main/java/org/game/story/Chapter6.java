package org.game.story;

import org.game.Color;
import org.game.GameContent;
import org.game.attributes.House;
import org.game.character.Wizard;

import java.util.Scanner;

public class Chapter6 implements StoryStep {
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content

    //Constructor
    public Chapter6(Wizard player) {
        wizard = player;
    }
    @Override
    public void runStory() throws InterruptedException {
        //-- Intro of Chapter 6 --

        System.out.println(Color.GREEN + "----------------- Chapter 6 -----------------");
        threadSleep(200);
        System.out.println("----------- The Half-Blood Prince -----------\n" + Color.RESET);
        threadSleep(1000);

        //-- Story --
        System.out.println("** You are starting this year with a potion class. **");
        potionsClass();
        System.out.println("\n** You leave the class, and keep the old book with you. **");
        threadSleep(200);
        System.out.println("** You read the book and learn that it was written by: 'the half-blood prince'... **");
        threadSleep(200);

        //-- Learning new stuff --
        System.out.println("** Oh! And there is the notice about an unknown new spell: Sectumsempra! **");
        waiting();
        wizard.learnSpell(game.spell("Sectumsempra"));
        threadSleep(200);
        System.out.println("** Unbelievable! You read the entire book... **");
        threadSleep(200);
        wizard.setPower(wizard.getPower() + 5);
        wizard.setBotanist(wizard.getBotanist() + 5);
        System.out.println(Color.GREEN + "** You gain +5 power! **");
        System.out.println("** You gain +5 botanist points! **" + Color.RESET);
        threadSleep(200);
        System.out.println("** The year is going on... **");
        waiting();
        System.out.println("** At the end of the year, there is a terrible danger... Some Death Eaters entered in the castle! **");
        threadSleep(200);
        System.out.println("** And you have heard that they have killed Dumbledore... **");
        threadSleep(200);
        System.out.println("** So you go at the top of the Astronomy tower to see what happened. **");
        threadSleep(200);

        //-- Death Eater fight --
        System.out.println("** You reach the top of the tower, and you face a Death Eater! **");
        waiting();
        wizard.attack(game.enemy("Death Eater"));
        threadSleep(200);

        //-- 2nd fight or Option to become mean --
        System.out.println("\n** There is an other Death Eater behind you! **");
        waiting();
        finalChoice();

        //-- End of Chapter 6 --
        System.out.println("\n** Chapter 6 - THE END **\n");
        threadSleep(1000);
    }

    public void potionsClass() {
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println(Color.BLACK + "           ~~~   POTIONS   ~~~\n" + Color.RESET);
        threadSleep(1000);
        System.out.println(Color.BLUE + "Potions Teacher - " + Color.RESET + "Welcome to the Potions class!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Potions Teacher - " + Color.RESET + "Today we will learn a potion that gives luck!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Potions Teacher - " + Color.RESET + "It is called : Felix Felicis!");
        threadSleep(200);
        System.out.println("\n** You are trying to learn the potion... **");
        threadSleep(200);
        System.out.println("** You find an old book that explains very well how to do it! **");
        waiting();
        wizard.learnPotion(game.potion("Felix Felicis"));
        threadSleep(200);
        System.out.println(Color.BLUE + "\nPotions Teacher  - " + Color.RESET + "Congratulations " + wizard.getName() + "!");
        threadSleep(200);
    }

    public void finalChoice() {
        if (wizard.getHouse() == House.Slytherin) {
            threadSleep(200);
            System.out.println(Color.RED + "Death Eater -" + Color.RESET + "Hey, you are a Slytherin...");
            threadSleep(200);
            System.out.println(Color.RED + "Death Eater -" + Color.RESET + "Would you like to join us?");
            threadSleep(200);
            Scanner scanner = new Scanner(System.in);
            String input = "";
            while (!(input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("No"))) {
                System.out.print(Color.RED + "Enter Yes or No :" + Color.RESET);
                input = scanner.nextLine();
                switch (input.toLowerCase()) {
                    case "yes" -> {
                        darkEnd();
                        return;
                    }
                    case "no" -> System.out.println(Color.RED + "Death Eater -" + Color.RESET + "You are going to regret it!");
                    default -> System.out.println(Color.RED + "Death Eater -" + Color.RESET + "This is a serious choice.");
                }
            }
        } else {
            threadSleep(200);
            wizard.stopAttack(game.spell("Lumos")); //Just for the story.
            wizard.attack(game.enemy("Death Eater"));
            threadSleep(200);
            System.out.println("** You killed the Death Eaters! **");
            threadSleep(200);
            System.out.println("** Danger is everywhere now, you will have to fight it... **");
            waiting();
        }
    }

    public void darkEnd() {
        System.out.println(Color.RED + "Death Eater - " + Color.RESET + "I knew it! Haha, you are smart.");
        threadSleep(200);
        System.out.println(Color.RED + "Death Eater - " + Color.RESET + "By the way, my name is Bellatrix Lestrange.");
        threadSleep(200);
        System.out.println(Color.RED + "Bellatrix - " + Color.RESET + "I will give you the Dark Mark: Then you will be a Death Eater like us!");
        threadSleep(200);
        System.out.println(Color.BLACK + "\n** You receive the Dark Mark on your left arm. **\n");
        threadSleep(200);
        System.out.println("Dark Mark : " + Color.RESET + "Magical 'Tattoo' on Death Eater's left arm, it looks like a snake ;\n" +
                "            It forces you to serve the Dark lord, if you betray him, you die instantly ;\n" +
                "            It allows you to fly through the air in a black smoke-like form ;\n" +
                "            By touching the mark with your wand, you can feel a burning sensation and will be able to locate Voldemort and join his ranks.\n");
        waiting();
        System.out.println(Color.RED + "Bellatrix - " + Color.RESET + "Welcome among us! To celebrate that, I will teach you a special curse, Haha. ");
        threadSleep(200);
        System.out.println(Color.RED + "Bellatrix - " + Color.RESET + "It is called crucio and it makes your enemies to suffer, Hahaha.");
        waiting();
        wizard.learnSpell(game.spell("Crucio"));
        System.out.println(Color.RED + "Bellatrix - " + Color.RESET + "Wonderful, now follow me, we will join the Dark Lord to introduce him to his new recruit.");
        threadSleep(200);
        System.out.println("\n** You follow Bellatrix and fly in a dark smoke to a distant destination...");
        waiting();
        wizard.setCondition("Dark"); //Setting the wizard in the Dark end.
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}