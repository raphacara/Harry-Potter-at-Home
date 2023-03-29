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
        System.out.println(Color.BLUE + "Order Member - " + Color.RESET + "We will train ourselves to be ready for the final battle. **");
        threadSleep(200);

        //Gaining power
        System.out.println("\n** You are training a lot... **");
        waiting();
        wizard.setPower(wizard.getPower() + 10); //You get 10 more power
        System.out.println(Color.GREEN + "** You have gained 10 power! **\n" + Color.RESET);
        threadSleep(200);

        //-- Choosing what to do --
        System.out.println("** You don't have much time, the Death Eaters and Voldemort will soon attack hogwarts. **");
        threadSleep(200);
        System.out.println("** What will you do to prepare for the final battle? **");
        threadSleep(200);
        chooseWhatToDo();

        //-- The Final Battle --
        System.out.println("\n** You come back in front of the castle amongst the other members of the Order of the Phoenix. **");
        waiting();
        System.out.println("** The time has come for the final battle against the dark forces. **");
        waiting();
        System.out.println("** You see plenty of Death Eaters coming in front of Hogwarts by flying in a dark smoke. **");
        waiting();

        //Battle against Bellatrix
        System.out.println("** You confront Bellatrix Lestrange, one of Voldemort's most loyal and dangerous followers. **");
        waiting();
        wizard.attack(game.enemy("Bellatrix"));
        System.out.println("** That was an intense fight against the most powerful Death Eater... **");
        waiting();
        System.out.println("** Everyone stop fighting and watch the final fight between you, and the Dark Lord himself, Voldemort. **");
        waiting();

        //Battle against Voldemort
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "You will regret that.");
        waiting();
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "Avada Kedavra!" + Color.RESET);
        waiting();
        System.out.println(Color.RED + "You - " + Color.RESET + "Expelliarmus!" + Color.RESET);
        waiting();
        if (wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            goldenEnding();
            return;
        }
        System.out.println("** You countered the spell, but you can't avoid the fight. **");
        waiting();
        wizard.attack(game.enemy("Voldemort"));
        System.out.println("** You have defeated Voldemort and vanquished the dark forces! **");
        waiting();
        System.out.println(Color.GREEN + "** Peace and harmony are restored to the wizarding world. **" + Color.RESET);
        waiting();

        //-- End of Chapter 7 --
        System.out.println("\n********** THE END **********\n");
        threadSleep(1000);
        wizard.setCondition("a " + Color.BLUE+ "Hero" + Color.RESET); //You are now a hero
    }

    public void chooseWhatToDo() {
        while (!check) {
            System.out.print(Color.GREEN);
            System.out.println("""
                    1. Train with another Order member
                    2. Going in the forbidden forest to train by yourself
                    3. Study some potions to boost your power
                    4. Searching the dark forces by yourself in Hogwarts
                    """ + Color.RED + """
                    Enter a number to make your choice:
                    """ + Color.RESET);
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> trainWithOrderMember();
                case "2" -> trainInTheForest();
                case "3" -> studyPotions();
                case "4" -> searchingDarkForces();
                default -> System.out.println("Enter a number between 1 and 4");
            }
            check = true;
        }
    }

    public void trainWithOrderMember() {
        System.out.println("** You decide to train with another Order member. **");
        waiting();
        System.out.println("** You find a girl called Luna who has a great knowledge in spells. **");
        waiting();
        System.out.println(Color.BLUE + "\nLuna - " + Color.RESET + "hi! Are you ready for the final battle?");
        waiting();
        System.out.println(Color.BLUE + "\nLuna - " + Color.RESET + "This ");
        waiting();
        System.out.println("** You decide to train with another Order member. **");
        waiting();
        waiting();
    }

    public void trainInTheForest() {
        System.out.println("** You decide to go to the forbidden forest to train**");
        waiting();
        System.out.println("** You find a troll fighting a giant spider, they see you, and decide to attack you! **");
        waiting();
        wizard.attack(game.enemy("Troll"));
        System.out.println("** The spider also jump on you! **");
        waiting();
        wizard.attack(game.enemy("Giant Spider"));
        System.out.println("** You now go further in the forest. **");
        waiting();
        System.out.println("** You perceives deer and sometimes even unicorns. **");
        waiting();
        System.out.println("** Suddenly, you see a Death Eater walking in your way... **");
        waiting();
        wizard.attack(game.enemy("Death Eater"));
        System.out.println("** You can't train more, you hav just seen a Death Eater, so they are all going to Hogwarts! **");
        waiting();
    }

    public void studyPotions() {
        System.out.println("** You decide to boost your power with a potion. **");
        waiting();
        wizard.setPower(wizard.getPower() + 10);
        System.out.println(Color.GREEN + "** You gained 10 power! **" + Color.RESET);
        waiting();
    }

    public void searchingDarkForces() {
        System.out.println("** You decide to search the dark forces by yourself in Hogwarts. **");
        waiting();
        System.out.println("** You find a secret passage to the Death Eaters' hideout. **");
        waiting();
        System.out.println("** You find out about their plans, which gives you an advantage in the upcoming battle. **");
        waiting();
    }

    public void goldenEnding() {
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
            System.out.println(Color.YELLOW + "\n** You have found the Golden Ending! **" + Color.RESET);

            //-- End of Chapter 7 Normal Secret Ending --
            System.out.println("\n********** THE END **********\n");
            threadSleep(1000);
            wizard.setCondition("the " + Color.BLUE + "Legendary Hero" + Color.RESET);
        }
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}