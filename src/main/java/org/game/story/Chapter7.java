package org.game.story;

import org.game.Color;
import org.game.GameContent;
import org.game.attributes.Core;
import org.game.attributes.House;
import org.game.character.Wizard;

import java.util.Objects;
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
        System.out.println("** You come back in front of the castle amongst the other members of the Order of the Phoenix. **");
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
        if (Objects.equals(wizard.getPatronus(), "Hare")) {
            System.out.println("** ALl the Order of the Phoenix thanks you for your actions, and you become a powerful Auror: One of the best wizard. **");
            waiting();
            wizard.setCondition("the " + Color.BLUE + "Great Auror" + Color.RESET); //You are now a hero
        } else {
            wizard.setCondition("a " + Color.BLUE + "Hero" + Color.RESET); //You are now a hero
        }
    }

    public void chooseWhatToDo() {
        while (!check) {
            check = true;
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
                default -> {
                    System.out.println("Enter a number between 1 and 4");
                    check = false;
                }
            }

        }
    }

    public void trainWithOrderMember() {
        System.out.println("** You decide to train with another Order member. **");
        waiting();
        System.out.println("** You find a girl called Luna who has a great knowledge in spells. **");
        waiting();
        System.out.println(Color.BLUE + "Luna - " + Color.RESET + "hi! Are you ready for the final battle?");
        waiting();
        System.out.println(Color.BLUE + "Luna - " + Color.RESET + "You don't have to worry about it. ALl that matters is enjoying life.");
        waiting();
        System.out.println(Color.BLUE + "Luna - " + Color.RESET + "Fights are easy when you know what to do, let me tell you a trick.");
        waiting();
        System.out.println(Color.BLUE + "Luna - " + Color.RESET + "You can use Incendio to burn your enemy, and Sectumsempra to make him bleed.");
        waiting();
        System.out.println(Color.BLUE + "Luna - " + Color.RESET + "Those to spells make damage over the fight, so don't hesitate to use them.");
        waiting();
        if (wizard.getHouse() == House.Ravenclaw) {
            secretEnding();
        } else {
            System.out.println(Color.BLUE + "Luna - " + Color.RESET + "You can also use the spell Lumos to see in the dark!");
            waiting();
            wizard.setBotanist(wizard.getBotanist() + 20); //huge buff
            System.out.println(Color.GREEN + "** You don't know why, but your potions are more powerful now! **" + Color.RESET);
            waiting();
            System.out.println("** You have heard that the dark forces are coming to Hogwarts. **");
            waiting();
        }
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
        System.out.println("** You can't train more, you have just seen a Death Eater, so they are all coming to Hogwarts! **");
        waiting();
    }

    public void studyPotions() {
        System.out.println("** You are going in the potion room to make potion in order to be prepared for the battle. **");
        waiting();
        System.out.println("** So you make a potion... **");
        waiting();
        wizard.learnPotion(game.potion("Wiggenweld"));
        waiting();
        System.out.println("** And an other one... **");
        waiting();
        wizard.learnPotion(game.potion("Felix Felicis"));
        waiting();
        System.out.println("** You don't stop... **");
        waiting();
        wizard.learnPotion(game.potion("Gillyweed"));
        waiting();
        System.out.println("** And again an other one... **");
        waiting();
        wizard.learnPotion(game.potion("Invisibility"));
        waiting();
        System.out.println("** Suddenly, a Slytherin Student come in the room and try to kill you: **");
        waiting();
        wizard.attack(game.enemy("Student"));
        System.out.println("** This fight meant that the final battle is coming! You have to leave this room. **");
        waiting();
    }

    public void searchingDarkForces() {
        System.out.println("** You decide to search the dark forces by yourself in Hogwarts. **");
        waiting();
        System.out.println("** You walk in the undergrounds of the castle... **");
        waiting();
        System.out.println("** You find a strange mirror in the Room of Requirement. **");
        waiting();
        System.out.println("** It seems like you can see your future in it. **");
        waiting();
        System.out.println("** What will you choose? **");
        boolean loop = true;
        while (loop) {
            loop = false;
            System.out.print(Color.GREEN + "1. Power\n2. Peace\n3. Fame\n4. Happiness" + Color.RESET);
            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "1" -> wizard.setPower(wizard.getPower() + 10);
                case "2" -> wizard.setBotanist(wizard.getBotanist() + 10);
                case "3" -> wizard.setMaxHealth(wizard.getMaxHealth() + 10);
                case "4" -> wizard.setAccuracy(wizard.getAccuracy() + 10);
                default -> {
                    System.out.println("** It seems that the mirror don't understand, what will you choose? **");
                    loop = true;
                }
            }
        }
        System.out.println("** It seems that the mirror listened to you, but you don't know what it did... **");
        waiting();
        System.out.println("** You continue to explore the castle. **");
        waiting();
        System.out.println("** You find a Death Eater in the corridor! **");
        waiting();
        wizard.attack(game.enemy("Death Eater"));
        System.out.println("** You can't search more, you have just seen a Death Eater, so they are all coming to Hogwarts! **");
        waiting();
    }

    public void secretEnding() {
        System.out.println(Color.BLUE + "Luna - " + Color.RESET + "Oh! I see that your patronus is a " + wizard.getPatronus() + "! I love it!");
        waiting();
        System.out.println(Color.BLUE + "Luna - " + Color.RESET + "I will tell you an other secret: There is something in fight that can be very useful: it is luck.");
        waiting();
        System.out.println(Color.BLUE + "Luna - " + Color.RESET + "You can be 100% lucky by using Felicis potion, Let me show you.");
        waiting();
        System.out.println("** You two are drinking a Felix Felicis potion **");
        waiting();
        wizard.learnPotion(game.potion("Felix Felicis"));
        wizard.setLuck(100);
        waiting();
        System.out.println(Color.BLUE + "Luna - " + Color.RESET + "You will start the next fight with 100% luck, so you will be able to use complicated spells!");
        waiting();
        wizard.setBotanist(wizard.getBotanist() + 50); //huge buff
        System.out.println(Color.GREEN + "** Your potion stats have been really boosted! **" + Color.RESET);
        waiting();
        System.out.println("** You have heard that the dark forces are coming to Hogwarts. **");
        waiting();
        wizard.setPatronus("Hare"); //The patronus can change in a life.
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