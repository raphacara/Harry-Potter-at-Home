package org.game.story;

import org.game.Color;
import org.game.GameContent;
import org.game.attributes.Core;
import org.game.character.Wizard;

import java.util.Scanner;

public class Chapter7 implements StoryStep {
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private boolean check = false; //checking the loops

    //Constructor
    public Chapter7(Wizard player) {
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
        System.out.println("** You are a member of the Order of the Phoenix. **");
        threadSleep(200);
        System.out.println("** You have been fighting against the dark forces led by Lord Voldemort. **");
        waiting();
        System.out.println("** You are now in a secret hiding place with other members of the Order, planning the final battle. **");
        threadSleep(200);
        System.out.println(Color.BLUE + "\nOrder Member - " + Color.RESET + "Welcome " + wizard.getName() + "!");
        waiting();
        System.out.println(Color.BLUE + "Order Member - " + Color.RESET + "We are glad to have you with us in this fight against darkness.");
        threadSleep(200);

        //Gaining power
        System.out.println("\n** A powerful wizard casts a protective charm on you... **");
        waiting();
        wizard.setPower(wizard.getPower() + 10); //You get 10 more power
        System.out.println(Color.GREEN + "** You have gained 10 power! **\n" + Color.RESET);
        threadSleep(200);

        //-- Choosing what to do --
        System.out.println("** What will you do to prepare for the final battle? **");
        threadSleep(200);
        chooseWhatToDo();

        //-- The Final Battle --
        System.out.println("\n** The time has come for the final battle against Bellatrix Lestrange and Lord Voldemort. **");
        waiting();

        //Battle against Bellatrix
        System.out.println("** You confront Bellatrix Lestrange, one of Voldemort's most loyal and dangerous followers. **");
        waiting();
        wizard.attack(game.enemy("Bellatrix"));
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "You will regret that.");
        waiting();

        //Battle against Voldemort
        System.out.println("** Now, you must face the Dark Lord himself, Voldemort. **");
        waiting();
        if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            secretEnding();
            return;
        }
        wizard.attack(game.enemy("Voldemort"));
        System.out.println("** You have defeated Voldemort and vanquished the dark forces! **");
        waiting();

        System.out.println(Color.GREEN + "** Peace and harmony are restored to the wizarding world. **" + Color.RESET);
        waiting();

        //-- End of Chapter 7 --
        System.out.println("\n********** THE END **********\n");
        threadSleep(1000);
        wizard.setCondition("Hero"); //You are now a hero
    }

    public void chooseWhatToDo() {
        while (!check) {
            System.out.print(Color.GREEN);
            System.out.println("""
                    1. Train with another Order member
                    2. Gather intelligence on the Death Eaters' plans
                    3. Boost your power with a potion
                    4. I am ready for the final battle
                    """ + Color.RED + """
                    Enter a number to make your choice:
                    """ + Color.RESET);
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> trainWithOrderMember();
                case "2" -> gatherIntelligence();
                case "3" -> boostPowerWithPotion();
                case "4" -> check = true;
                default -> System.out.println("Enter a number between 1 and 4");
            }
        }
    }

    public void trainWithOrderMember() {
        System.out.println("** You decide to train with another Order member. **");
        waiting();
        wizard.setPower(wizard.getPower() + 5);
        System.out.println(Color.GREEN + "** You gained 5 power! **" + Color.RESET);
        waiting();
    }

    public void gatherIntelligence() {
        System.out.println("** You decide to gather intelligence on the Death Eaters' plans. **");
        waiting();
        System.out.println("** You find out about their secret hideout, which gives you an advantage in the upcoming battle. **");
        waiting();
    }

    public void boostPowerWithPotion() {
        System.out.println("** You decide to boost your power with a potion. **");
        waiting();
        wizard.setPower(wizard.getPower() + 10);
        System.out.println(Color.GREEN + "** You gained 10 power! **" + Color.RESET);
        waiting();
    }

    public void secretEnding() {
        if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            System.out.println("** As you are fighting against Voldemort, you suddenly feel a surge of power from your wand. **");
            waiting();
            System.out.println("** The phoenix feather core in your wand seems to be resonating with the great courage and determination you have shown. **");
            waiting();
            System.out.println("** You channel the energy into a powerful spell and release it towards Voldemort. **");
            waiting();
            System.out.println("** The spell hits him, and he is unable to resist its immense power. **");
            waiting();
            System.out.println("** Voldemort is finally defeated, and you have saved the wizarding world from his tyranny. **");
            waiting();
            System.out.println("** Your actions and the phoenix feather core in your wand will be remembered as legendary. **");
            waiting();
            System.out.println(Color.YELLOW + "\n** You have found the Secret Ending! **" + Color.RESET);

            //-- End of Chapter 7 Normal Secret Ending --
            System.out.println("\n********** THE END **********\n");
            threadSleep(1000);
            wizard.setCondition("Legendary Hero");
        }
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}