package org.game.story;
import org.game.GameContent;
import org.game.attributes.Potion;
import org.game.character.Wizard;
import org.game.spells.AbstractSpell;

import java.util.Scanner;

public class Chapter4 implements StoryStep {
    private final String RESET = "\u001B[0m"; //fun
    private final String RED = "\033[1;31m"; //fun
    private final String BLUE = "\033[1;34m"; //fun
    private final String GREEN = "\033[1;32m"; //fun
    private final String BLACK = "\033[1;30m"; //fun
    private final Wizard wizard; //the player
    private final GameContent game = new GameContent(); //to have access to the game content
    private boolean check; //checking the loops
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private final boolean[] verify = new boolean[3]; //to verify loops

    //Constructor
    public Chapter4(Wizard player) {
        wizard = player;
    }
    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 4 --
        System.out.println(GREEN + "\n----------------- Chapter 4 -----------------");
        threadSleep(1000);
        System.out.println("------------- The Goblet of Fire ------------\n" + RESET);
        threadSleep(2000);
        System.out.println("** This year there is an important tournament: The Triwizard Tournament. **");
        threadSleep(1000);
        System.out.println("** And you have been chosen by the Goblet of Fire to participate in it. **");
        threadSleep(3000);
        System.out.println("** There are several tasks to achieve through this tournament, but there are not without danger. **");
        threadSleep(3000);
        System.out.println("** Before doing the tournament, you need to prepare yourself if you don't want to die... **");
        threadSleep(3000);
        System.out.println("** But you don't have much time, so you can learn one new skill. **");
        threadSleep(2000);
        //Preparation 1
        System.out.println("** What will your learn? **");
        learnSkill();
        threadSleep(2000);
        System.out.println("** You are now going to the 1st challenge. **");

        //-- 1st Challenge --
        System.out.println(BLUE + "\n~~~~~~~~~~~~ 1st Challenge ~~~~~~~~~~~~");
        threadSleep(1000);
        System.out.println("~~~~~~~~~~~~~ Dragon Task ~~~~~~~~~~~~~\n" + RESET);
        dragon();

        //Preparation 2
        threadSleep(2000);
        System.out.println("** You don't waste more time and prepare yourself for the next task **");
        threadSleep(2000);
        System.out.println("** So what will your learn this time? **");
        learnSkill();
        threadSleep(2000);
        System.out.println("** You are now going to the 2nd challenge. **");

        //-- 2nd Challenge --
        System.out.println(BLUE + "\n~~~~~~~~~~~~ 2nd Challenge ~~~~~~~~~~~~");
        threadSleep(1000);
        System.out.println("~~~~~~~~~~ Underwater Rescue ~~~~~~~~~~\n" + RESET);
        underwater();

        //Preparation 3
        System.out.println("** What will you learn before your last challenge? **");
        learnSkill();

        //-- 3rd Challenge --
        System.out.println(BLUE + "\n~~~~~~~~~~~~ 3rd Challenge ~~~~~~~~~~~~");
        threadSleep(1000);
        System.out.println("~~~~~~~~~~~~~~ Labyrinth ~~~~~~~~~~~~~~\n" + RESET);
        labyrinth();

        //Final battle in the Cemetery
        System.out.println(" ****** Little Hangleton Cemetery ******\n" + RESET);
        cemetery();
        System.out.println("\n** Chapter 4 - THE END **\n");
        threadSleep(2000);
    }

    public void learnSkill() {
        threadSleep(2000);
        System.out.println(GREEN + "1. Aguamenti Spell\n2. Bubble-Head Charm\n3. Disillusionment Charm\n4. Protego Charm");
        System.out.println(GREEN + "5. Gillyweed Potion\n6. Invisibility Potion\n7. Wiggenweld Potion");
        check = false;
        while (!check) {
            check = true;
            System.out.print(RED + "Enter a number to make your choice :\n" + RESET);
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You are trying to learn Aguamenti... **");
                    threadSleep(2000);
                    System.out.println("** It is a spell that makes a water jet. **");
                    threadSleep(2000);
                    wizard.learnSpell(game.spell("Aguamenti"));
                }
                case "2" -> {
                    System.out.println("** You are trying to learn Bubble-Head... **");
                    threadSleep(2000);
                    System.out.println("** It is a charm that makes bubble around your head, to breath underwater. **");
                    threadSleep(2000);
                    wizard.learnSpell(game.spell("Bubble-Head"));
                }
                case "3" -> {
                    System.out.println("** You are trying to learn Disilluminatus... **");
                    threadSleep(2000);
                    System.out.println("** It is a charm that makes you invisible for a moment. **");
                    threadSleep(2000);
                    wizard.learnSpell(game.spell("Disilluminatus"));
                }
                case "4" -> {
                    System.out.println("** You are trying to learn Protego... **");
                    threadSleep(2000);
                    System.out.println("** It is a charm that protect you against an attack. **");
                    threadSleep(2000);
                    wizard.learnSpell(game.spell("protego"));
                }
                case "5" -> {
                    System.out.println("** You are trying to learn the Gillyweed Potion... **");
                    threadSleep(2000);
                    System.out.println("** It is a potion that allows you to breath underwater for a moment. **");
                    threadSleep(2000);
                    wizard.learnPotion(game.potion("Gillyweed"));
                }
                case "6" -> {
                    System.out.println("** You are trying to learn the Invisibility Potion... **");
                    threadSleep(2000);
                    System.out.println("** It is a potion that makes you invisible for a moment. **");
                    threadSleep(2000);
                    wizard.learnPotion(game.potion("Invisibility"));
                }
                case "7" -> {
                    System.out.println("** You are trying to learn Wiggenweld Potion... **");
                    threadSleep(2000);
                    System.out.println("** It is a potion that heals you. **");
                    threadSleep(2000);
                    wizard.learnPotion(game.potion("Wiggenweld"));
                }
                default -> {
                    System.out.println("** Your choice is important. **");
                    check = false;
                }
            }
        }
        threadSleep(2000);
    }

    public void dragon() throws InterruptedException {
        threadSleep(3000);
        System.out.println("** The goal of this task is to steal an egg from the dragon. **");
        threadSleep(2000);
        System.out.println("** So you enter in the arena, and face a ferocious dragon. **");
        threadSleep(2000);
        System.out.println("** How are you going to steal the egg? **");
        threadSleep(2000);
        System.out.println(GREEN + "1. Fighting the dragon\n2. Trying to be stealthy" + RESET);
        while (check) {
            check = false;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You stand in front of the dragon, one of you have to die today. **");
                    wizard.attack(game.enemy("Dragon"));
                    threadSleep(1000);
                    System.out.println("** You really killed the Dragon! **");
                    threadSleep(2000);
                    System.out.println("** So you easily grab the egg, and pass the challenge. **");
                }
                case "2" -> {
                    boolean invisible = true;
                    while (invisible) {
                        for (AbstractSpell spell : wizard.getKnownSpells()) {
                            if (spell.getName().equals("Disilluminatus")) {
                                System.out.println("** You use the Disillusion spell to be really stealthy... **");
                                threadSleep(2000);
                                invisible = false;
                            }
                        }
                        for (Potion potion : wizard.getPotions()) {
                            if (potion.getName().equals("Invisibility")) {
                                System.out.println("** You use the Gillyweed Potion to be extremely stealthy... **");
                                wizard.setAccuracy(wizard.getAccuracy() + 1);
                                threadSleep(2000);
                                System.out.println(GREEN + "** It works very well so you gain +1 accuracy point! **" + RESET);
                                threadSleep(2000);
                                invisible = false;
                            }
                        }
                        if (invisible) {
                            System.out.println("You don't have any invisible spell or potion... So you have to fight the boss.");
                            wizard.attack(game.enemy("Dragon"));
                            threadSleep(1000);
                            System.out.println("** You really killed the Dragon! **");
                            threadSleep(2000);
                            System.out.println("** So you easily grab the egg, and pass the challenge. **");
                            invisible = false;
                        }
                    }
                    System.out.println("** You reach the egg without being spotted by the dragon! **");
                    threadSleep(2000);
                    System.out.println("** Congratulation! **");
                    threadSleep(2000);
                }
                default -> {
                    System.out.println("** Hurry up! You have to make a choice. **");
                    check = true;
                }
            }
        }
    }

    public void underwater() {
        threadSleep(3000);
        System.out.println("** The goal of this challenge is to save a target from the water. **");
        threadSleep(2000);
        System.out.println("** But have to dive deep, how will you do? **");
        threadSleep(2000);
        System.out.println(GREEN + "1. Just swim and dive" + RESET);
        for (AbstractSpell spell : wizard.getKnownSpells()) {
            if (spell.getName().equals("Bubble-Head")) {
                System.out.println(GREEN + "2. Use the Bubble-Head Charm" + RESET);
                verify[1] = true;
            }
        }
        for (Potion potion: wizard.getPotions()) {
            if (potion.getName().equals("Gillyweed")) {
                System.out.println(GREEN + "3. Use the Gillyweed Potion" + RESET);
                verify[2] = true;
            }
        }
        while (check) {
            check = false;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You dive as much as you can, but you realise this is impossible without magic... **");
                    threadSleep(3000);
                    System.out.println("** you come back to the surface, and abandon the task. **");
                    threadSleep(2000);
                    System.out.println("** It is not a big deal, but you will start the final task after the other participants... **");
                    wizard.setCondition("Last"); //Story needs to know the position of the player in the tournament
                }
                case "2" -> {
                    if (!verify[1]) {
                        System.out.println("The challenge just started, you have to make a decision.");
                        check = true;
                    } else {
                        System.out.println("** You use the spell to create a bubble of oxygen around your head. **");
                        threadSleep(3000);
                        System.out.println("** It works well, but it is not the most practical way to swim. **");
                        threadSleep(2000);
                        System.out.println("** You still save your target! You are currently at the 2nd place in this tournament. **");
                        threadSleep(2-3000);
                        System.out.println("** And there is one last task to do... **");
                        threadSleep(2000);
                        wizard.setCondition("2nd"); //Story needs to know the position of the player in the tournament
                    }
                }
                case "3" -> {
                    if (!verify[2]) {
                        System.out.println("** The challenge just started, you have to make a decision. **");
                        check = true;
                    } else {
                        System.out.println("** You use the Gillyweed and can perfectly breath underwater! **");
                        threadSleep(3000);
                        System.out.println("** You easily save your target, this potion is awesome. **");
                        threadSleep(2000);
                        System.out.println(GREEN + "** You gain +1 Botanist point for using this potion! **" + RESET);
                        threadSleep(2000);
                        System.out.println("** There is only one last task in this tournament, and you are currently in the 1st place! **");
                        wizard.setCondition("1st"); //Story needs to know the position of the player in the tournament
                    }
                }
                default -> {
                    System.out.println("The challenge just started, you have to make a decision.");
                    check = true;
                }
            }
        }
        threadSleep(3000);
        System.out.println("** Anyway, you come back to train before the last task. **");
        threadSleep(2000);
    }

    public void labyrinth() throws InterruptedException {
        threadSleep(3000);
        System.out.println("** You are in front of a immense and deadly Labyrinth. **");
        threadSleep(2000);
        System.out.println("** There is a trophy in it, your goal is to grab it. **");
        threadSleep(2000);
        System.out.println("** There are 3 participant left in this tournament. **");
        threadSleep(2000);
        System.out.println("** You step inside the labyrinth at the " + wizard.getCondition() + " place, because of the previous task. **");
        threadSleep(3000);
        System.out.println(BLUE + "\n!!! This is the Beta Test, the full labyrinth will be available later in the game with JavaFX !!!\n" + RESET);
        threadSleep(3000);
        System.out.println("** You turn right, and see the trophy at the end of the corridor. **");
        threadSleep(2000);
        System.out.println("** But an other participant reaches you, he also saw trophy... **\n");
        threadSleep(2000);
        System.out.println(RED + "Tournament Champion - " + RESET + "I'm gonna kill you to get the trophy!!");
        threadSleep(2000);
        wizard.attack(game.enemy("Tournament Champion"));
        System.out.println("** You killed him! But you had to... Anyway, you run to grab the trophy... **");
        threadSleep(3000);
        System.out.println("** But the 3rd participant arrives in the same time... **");
        threadSleep(3000);
        System.out.println("** And you are... in a teleportation??? **");
        threadSleep(2000);
        System.out.println(BLACK + "          * * * * * * * * * *\n           * * * * * * * * *");
        threadSleep(500);
        System.out.println("            * * * * * * * *\n             * * * * * * *");
        threadSleep(500);
        System.out.println("              * * * * * *\n               * * * * *");
        threadSleep(500);
        System.out.println("                * * * *\n                 * * *");
        threadSleep(500);
        System.out.println("                  * *\n                   *");
        threadSleep(500);
    }

    public void cemetery() {
        threadSleep(3000);
        System.out.println(BLUE + "Other participant - " + RESET + "The trophy was a Portkey...");
        threadSleep(3000);
        System.out.println(BLUE + "Other participant - " + RESET + "So when we touched it, it teleported us.");
        threadSleep(2000);
        System.out.println(RED + "??? - " + RESET + "AH AH AH AH!!! What a wonderful evening to kill you, both!");
        threadSleep(3000);
        System.out.println(RED + "??? - " + RESET + "I am " + BLACK + "Voldemort" + RESET + "And thanks to you, i will become the lord of the world again!");
        threadSleep(3000);
        System.out.println("\n** Voldemort is in front of you two, and he has a partisan called Peter Pettigrew next to him. **\n");
        threadSleep(3000);
        System.out.println("** You have to act, what do you do? **");
        System.out.println(GREEN + "1. attack them\n 2. Trying to go back at the Portkey\n3. To play dead." + RESET);
        threadSleep(4000);
        System.out.println("\n** You don't even have the time to do anything that Voldemort said: **\n");
        threadSleep(3000);
        System.out.println(RED + "Lord Voldemort - " + RESET + "Kill them.");
        threadSleep(2000);
        System.out.println("\n** His partisan instantly take his wand and look at the other participant... **\n");
        threadSleep(3000);
        System.out.println(RED + "Peter Pettigrew - " + RESET + "AVADA KEDAVRA!");
        threadSleep(4000);
        System.out.println("\n** The other participant immediately dies. **");
        threadSleep(3000);
        System.out.println("** You don't have the time to think, just attract the Portkey... NOW! **");
        threadSleep(3000);
        System.out.println(RED + "Write Accio to attract the Portkey :" + RESET);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Accio")) {
            System.out.println("** You attract the portkey and instantly teleport to the castle. **\n");
        } else {
            System.out.println(RED + "\nPeter Pettigrew - " + RESET + "AVADA KEDAVRA!");
            threadSleep(3000);
            System.out.println(RED + "** You died. **");
            threadSleep(2000);
            System.exit(0);
        }
        threadSleep(2000);
        System.out.println("** You attract the portkey and instantly teleport to the castle. **");
        threadSleep(2000);
        System.out.println("** Now, you can be sure the Voldemort is alive... **");
        threadSleep(2000);
        System.out.println("** Anyway, you won the Triwizard Tournament! **");
        threadSleep(2000);
        System.out.println(GREEN + "** All your stats have increased! **" + RESET);
        wizard.setAccuracy(wizard.getAccuracy() + 1);
        wizard.setBotanist(wizard.getBotanist() + 1);
        wizard.setMaxHealth(wizard.getMaxHealth() + 5);
        wizard.setPower(wizard.getPower() + 1);
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