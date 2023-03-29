package org.game.story;

import org.game.Color;
import org.game.GameContent;
import org.game.attributes.Core;
import org.game.attributes.Pet;
import org.game.character.Wizard;

import java.util.Objects;
import java.util.Scanner;

public class Chapter7Dark implements StoryStep {
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private boolean check = false; //checking the loops
    private int i = 0; //to count the number of times the player has attacked

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
        System.out.println("** You come to Lord Voldemort by flying in your Death Eater black smoke. **");
        waiting();
        System.out.println("** You are now with your fellow Death Eaters, Bellatrix Lestrange and Voldemort. **");
        threadSleep(200);
        System.out.println(Color.RED + "\nVoldemort - " + Color.RESET + "Well, well, well. Welcome " + wizard.getName() + "!");
        waiting();
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "You have made a great choice to join us.");
        threadSleep(200);
        System.out.println("\n** Voldemort is casting a mysterious spell on you... **");
        waiting();
        wizard.setPower(wizard.getPower() + 15); //You get 15 more power
        System.out.println(Color.GREEN + "** You have gained 15 power! **\n" + Color.RESET);
        threadSleep(200);

        //Learning Avada Kedavra
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "Every Death Eater needs to know the killing curse.");
        waiting();
        wizard.learnSpell(game.spell("Avada Kedavra")); //You learn the killing curse
        waiting();
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "You are now free to kill all the weak people, Hahaha!");
        threadSleep(200);

        //-- Choosing what to do --
        System.out.println("** What will you do? **");
        threadSleep(200);
        chooseWhatToDo();

        //Checking if the player has killed Voldemort -> Secret Ending
        if (Objects.equals(wizard.getCondition(), "the" + Color.RED + "Dark Lord" + Color.RESET)) {
            return;
        }
        waiting();
        System.out.println(Color.RED + "\nVoldemort - " + Color.RESET + "Well done, " + wizard.getName() + ", I have seen your exploits.");
        waiting();
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "I've got the Elder Wand by the way.");
        waiting();
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "We are now unstoppable, we will rule the world!");
        waiting();
        System.out.println(Color.RED + "Bellatrix - " + Color.RESET + "Hahaha! I can't wait to kill all the mudbloods and muggles!");
        waiting();

        //Learning Imperio
        System.out.println("\n** To reward you to have proven your worth, Voldemort teach you the Imperius curse. **");
        wizard.learnSpell(game.spell("Imperio")); //You learn the Imperius curse
        System.out.println("** You now know all the forbidden curse, you are a powerful Death Eater! **");
        waiting();
        System.out.println(Color.GREEN + "** Voldemort, You, Bellatrix and all the other Death Eaters are now dominating the world! **" + Color.RESET);
        waiting();

        //-- End of Chapter 7 --
        System.out.println("\n********** THE END **********\n");
        threadSleep(1000);
        wizard.setCondition("a " + Color.RED + "Death Eater" + Color.RESET); //You are now a Death Eater
    }

    public void chooseWhatToDo() {
        while (!check) {
            System.out.print(Color.GREEN);
            System.out.println("""
                    1. Attack Hogwarts
                    2. Attack the Ministry of Magic
                    3. Attack the Muggle World
                    4. Attack Voldemort""");
            System.out.print(Color.RED + "Enter a number to make your choice :\n" + Color.RESET);
            String input = scanner.nextLine();
            check = true;
            switch (input) {
                case "1" -> attackHogwarts();
                case "2" -> attackMinistry();
                case "3" -> attackMuggle();
                case "4" -> attackVoldemort();
                default -> {
                    System.out.println("** You are a Death Eater, what's your project? **");
                    check = false;
                }
            }
        }
    }

    public void attackHogwarts() {
        System.out.println("** You arrive at Hogwarts with the other Death Eaters for the final battle. **");
        waiting();
        System.out.println("** There are some teachers that recognize you, so you have to kill them. **");
        waiting();
        wizard.attack(game.enemy("Teacher"));
        System.out.println("** You are now going to the Great Hall. **");
        waiting();
        System.out.println("** There is a troll in the middle of the hall. **");
        waiting();
        wizard.attack(game.enemy("Troll"));
        System.out.println("** Then, you see an Auror that came to kill you, That's a Death Eater hunter! **");
        waiting();
        wizard.attack(game.enemy("Auror"));
        System.out.println("** You came back in front of the castle, when Voldemort was supposed to be. **");
        waiting();
        System.out.println("** And there he is! He just killed all the other students! **");
        waiting();
        System.out.println("** All the other Death Eaters come to Voldemort in front of the Castle. **");
    }

    public void attackMinistry(){
        System.out.println("** On your way to the Ministry, you see some Dementors **");
        threadSleep(200);
        System.out.println("** You are a Death Eater, you can't be afraid of them. **");
        wizard.attack(game.enemy("Dementors"));
        System.out.println("** You arrive at the Ministry of Magic. **");
        threadSleep(200);
        System.out.println("** There is an Auror, someone who hunt Death Eaters, that is protecting the Ministry. **");
        threadSleep(200);
        System.out.println("** You have to kill him to enter the Ministry. **");
        wizard.attack(game.enemy("Auror"));
        System.out.println("** You enter the Ministry and kill all the muggles. **");
        threadSleep(200);
        System.out.println(Color.BLUE + "\n** Example of a fight with a muggle: **" + Color.RESET);
        waiting();
        wizard.attack(game.enemy("Muggle"));
        System.out.println("** You are now going to the main office of the Ministry of Magic. **");
        waiting();
        System.out.println("** You find the Minister of Magic, Cornelius Fudge. **");
        threadSleep(200);
        System.out.println("** You have to kill him to show your power to the world! **");
        waiting();
        wizard.attack(game.enemy("Minister of Magic"));
        System.out.println("** After a such fight you come back to see Voldemort. **");
    }

    public void attackMuggle() {
        System.out.println("** You are going to the Muggle World. **");
        waiting();
        System.out.println("** You arrive in London, because it is the nearest big city. **");
        threadSleep(200);
        System.out.println("** It's night, perfect time for you. **");
        threadSleep(200);
        System.out.println("** You find a little street with pretty houses, you break down doors and find some muggles... **");
        waiting();
        killingMuggle();
        System.out.println("** Suddenly, you hear a noise behind you... **");
        threadSleep(200);
        System.out.println("** You turn around and see a wizard that came to kill you. **");
        threadSleep(200);
        System.out.println("** He is hunting Death Eaters, that's an Auror. **");
        waiting();
        wizard.attack(game.enemy("Auror"));
        System.out.println("** After a such fight you come back to see Voldemort. **");
    }

    public void attackVoldemort() {
        System.out.println("** You are betraying Voldemort, your Dark Mark burns you! **");
        wizard.setHealth(wizard.getMaxHealth() - 50);
        wizard.setMaxHealth(wizard.getHealth());
        System.out.println(Color.RED + "** You lost 50hp from your maximum health! **");
        System.out.println(Color.GREEN + "Your health : " + wizard.getHealth() + "/" + wizard.getMaxHealth() + "hp" + Color.RESET);
        waiting();
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "How dare you betray me?");
        waiting();
        if (wizard.getPet() == Pet.SNAKE || wizard.getWand().getCore() == Core.PHOENIX_FEATHER) {
            System.out.println(Color.RED + "Bellatrix - " + Color.RESET + "Avada Kedavra!");
            waiting();
            System.out.println(Color.YELLOW + "You - " + Color.RESET + "Expelliarmus!");
            waiting();
            System.out.println("** You counter the spell with your wand. Now, you have to fight... **");
            waiting();
            wizard.attack(game.enemy("Bellatrix"));
            System.out.println(Color.RED + "Voldemort - " + Color.RESET + "You will regret it...");
            waiting();
            System.out.println("\n------------ Final Battle ------------");
            waiting();
            wizard.attack(game.enemy("Voldemort"));
            ultraSecretEnding();
        } else {
            System.out.println(Color.RED + "Bellatrix - " + Color.RESET + "Avada Kedavra!");
            waiting();
            System.out.println("** You died. **");
            waiting();
            System.out.println(Color.RED + "** Game Over **");
            waiting();
            System.exit(0);
        }
    }

    public void killingMuggle() {
        wizard.attack(game.enemy("Muggle"));
        System.out.println("** You destroyed the muggle! There is an other one in the house. **");
        waiting();
        GameContent game2 = new GameContent(); // instantiate new other game content
        wizard.attack(game2.enemy("Muggle"));
        System.out.println("** You cleaned this house **");
        threadSleep(200);
        i++;
        if (i < 10) {
            boolean ok = true;
            while (ok) {
                ok = false;
                System.out.println("** Do you want to go to the next house? **");
                System.out.print(Color.GREEN + "1. Yes\n2. No\n" + Color.RED);
                System.out.print("Enter a number to make your choice :\n" + Color.RESET);
                String input = scanner.nextLine();
                switch (input) {
                    case "1" -> {
                        System.out.println("** You are going to the next house! **");
                        waiting();
                        killingMuggle();
                    }
                    case "2" -> {
                    }
                    default -> {
                        System.out.println("Enter a number between 1 and 2");
                        ok = true;
                    }
                }
            }
        }
    }

    public void ultraSecretEnding() {
        System.out.println("** You killed Voldemort! **");
        waiting();
        System.out.println("** You are now the new Dark Lord! **");
        waiting();
        System.out.println("** You are the most powerful wizard in the world! **");
        waiting();
        System.out.println("** The other Death Eaters will serve you, as if they were under the Imperius curse. **");
        waiting();
        wizard.learnSpell(game.spell("Imperio"));
        waiting();
        System.out.println("** You now know all the forbidden spells, and you are dominating the world! **");
        waiting();
        System.out.println(Color.YELLOW + "\n** You have found the Secret Ending! **" + Color.RESET);

        //-- End of Chapter 7 --
        System.out.println("\n********** THE END **********\n");
        threadSleep(1000);
        wizard.setCondition("the" + Color.RED + "Dark Lord" + Color.RESET); // You are now a Dark Lord
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}