package org.game.story;
import org.game.Color;
import org.game.GameContent;
import org.game.attributes.Potion;
import org.game.character.Wizard;
import org.game.spells.AbstractSpell;

import java.util.Scanner;

public class Chapter4 implements StoryStep {
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
    public void runStory() {
        //-- Intro of Chapter 4 --
        System.out.println(Color.GREEN + "----------------- Chapter 4 -----------------");
        threadSleep(200);
        System.out.println("------------- The Goblet of Fire ------------\n" + Color.RESET);
        threadSleep(1000);
        System.out.println("** This year there is an important tournament: The Triwizard Tournament. **");
        threadSleep(200);
        System.out.println("** And you have been chosen by the Goblet of Fire to participate in it. **");
        threadSleep(200);
        System.out.println("** There are several tasks to achieve through this tournament, but there are not without danger. **");
        threadSleep(200);
        System.out.println("** Before doing the tournament, you need to prepare yourself if you don't want to die... **");
        waiting();
        System.out.println("** But you don't have much time, so you can learn one new skill. **");
        threadSleep(200);
        //Preparation 1
        System.out.println("** What will your learn? **");
        learnSkill();
        threadSleep(200);
        System.out.println("** You are now going to the 1st challenge. **");

        //-- 1st Challenge --
        System.out.println(Color.BLUE + "\n~~~~~~~~~~~~ 1st Challenge ~~~~~~~~~~~~");
        threadSleep(200);
        System.out.println("~~~~~~~~~~~~~ Dragon Task ~~~~~~~~~~~~~\n" + Color.RESET);
        dragon();
        waiting();

        //Preparation 2
        System.out.println("** You don't waste more time and prepare yourself for the next task **");
        threadSleep(200);
        System.out.println("** So what will your learn this time? **");
        learnSkill();
        threadSleep(200);
        System.out.println("** You are now going to the 2nd challenge. **");

        //-- 2nd Challenge --
        System.out.println(Color.BLUE + "\n~~~~~~~~~~~~ 2nd Challenge ~~~~~~~~~~~~");
        threadSleep(200);
        System.out.println("~~~~~~~~~~ Underwater Rescue ~~~~~~~~~~\n" + Color.RESET);
        underwater();
        waiting();

        //Preparation 3
        System.out.println("** What will you learn before your last challenge? **");
        learnSkill();

        //-- 3rd Challenge --
        System.out.println(Color.BLUE + "\n~~~~~~~~~~~~ 3rd Challenge ~~~~~~~~~~~~");
        threadSleep(200);
        System.out.println("~~~~~~~~~~~~~~ Labyrinth ~~~~~~~~~~~~~~\n" + Color.RESET);
        labyrinth();
        threadSleep(200);

        //Final battle in the Cemetery
        System.out.println(" ****** Little Hangleton Cemetery ******" + Color.RESET);
        cemetery();
        waiting();
        System.out.println("\n** Chapter 4 - THE END **\n");
        threadSleep(1000);
    }

    public void learnSkill() {
        threadSleep(200);
        System.out.println(Color.GREEN + "1. Aguamenti Spell\n2. Bubble-Head Charm\n3. Disillusionment Charm\n4. Protego Charm");
        System.out.println(Color.GREEN + "5. Gillyweed Potion\n6. Invisibility Potion\n7. Wiggenweld Potion");
        check = false;
        while (!check) {
            check = true;
            System.out.print(Color.RED + "Enter a number to make your choice :\n" + Color.RESET);
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You are trying to learn Aguamenti... **");
                    threadSleep(200);
                    System.out.println("** It is a spell that makes a water jet. **");
                    waiting();
                    wizard.learnSpell(game.spell("Aguamenti"));
                }
                case "2" -> {
                    System.out.println("** You are trying to learn Bubble-Head... **");
                    threadSleep(200);
                    System.out.println("** It is a charm that makes bubble around your head, to breath underwater. **");
                    waiting();
                    wizard.learnSpell(game.spell("Bubble-Head"));
                }
                case "3" -> {
                    System.out.println("** You are trying to learn Disilluminatus... **");
                    threadSleep(200);
                    System.out.println("** It is a charm that makes you invisible for a moment. **");
                    waiting();
                    wizard.learnSpell(game.spell("Disilluminatus"));
                }
                case "4" -> {
                    System.out.println("** You are trying to learn Protego... **");
                    threadSleep(200);
                    System.out.println("** It is a charm that protect you against an attack. **");
                    waiting();
                    wizard.learnSpell(game.spell("protego"));
                }
                case "5" -> {
                    System.out.println("** You are trying to learn the Gillyweed Potion... **");
                    threadSleep(200);
                    System.out.println("** It is a potion that allows you to breath underwater for a moment. **");
                    waiting();
                    wizard.learnPotion(game.potion("Gillyweed"));
                }
                case "6" -> {
                    System.out.println("** You are trying to learn the Invisibility Potion... **");
                    threadSleep(200);
                    System.out.println("** It is a potion that makes you invisible for a moment. **");
                    waiting();
                    wizard.learnPotion(game.potion("Invisibility"));
                }
                case "7" -> {
                    System.out.println("** You are trying to learn Wiggenweld Potion... **");
                    threadSleep(200);
                    System.out.println("** It is a potion that heals you. **");
                    waiting();
                    wizard.learnPotion(game.potion("Wiggenweld"));
                }
                default -> {
                    System.out.println("** Your choice is important. **");
                    check = false;
                }
            }
        }
        threadSleep(200);
    }

    public void dragon() {
        threadSleep(1000);
        System.out.println("** The goal of this task is to steal an egg from the dragon. **");
        threadSleep(200);
        System.out.println("** So you enter in the arena, and face a ferocious dragon. **");
        threadSleep(200);
        System.out.println("** How are you going to steal the egg? **");
        threadSleep(200);
        System.out.println(Color.GREEN + "1. Fighting the dragon\n2. Trying to be stealthy" + Color.RESET);
        while (check) {
            check = false;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You stand in front of the dragon, one of you have to die today. **");
                    wizard.attack(game.enemy("Dragon"));
                    threadSleep(200);
                    System.out.println("** You really killed the Dragon! **");
                    waiting();
                    System.out.println("** So you easily grab the egg, and pass the challenge. **");
                }
                case "2" -> {
                    boolean invisible = true;
                    while (invisible) {
                        for (AbstractSpell spell : wizard.getKnownSpells()) {
                            if (spell.getName().equals("Disilluminatus")) {
                                System.out.println("** You use the Disillusion spell to be really stealthy... **");
                                waiting();
                                invisible = false;
                            }
                        }
                        for (Potion potion : wizard.getPotions()) {
                            if (potion.getName().equals("Invisibility")) {
                                System.out.println("** You use the Gillyweed Potion to be extremely stealthy... **");
                                waiting();
                                wizard.setAccuracy(wizard.getAccuracy() + 1);
                                System.out.println(Color.GREEN + "** It works very well so you gain +1 accuracy point! **" + Color.RESET);
                                threadSleep(200);
                                invisible = false;
                            }
                        }
                        if (invisible) {
                            System.out.println("You don't have any invisible spell or potion... So you have to fight the boss.");
                            wizard.attack(game.enemy("Dragon"));
                            threadSleep(200);
                            System.out.println("** You really killed the Dragon! **");
                            threadSleep(200);
                            System.out.println("** So you easily grab the egg, and pass the challenge. **");
                            invisible = false;
                        }
                    }
                    System.out.println("** You reach the egg without being spotted by the dragon! **");
                    threadSleep(200);
                    System.out.println("** Congratulation! **");
                }
                default -> {
                    System.out.println("** Hurry up! You have to make a choice. **");
                    check = true;
                }
            }
        }
    }

    public void underwater() {
        threadSleep(1000);
        System.out.println("** The goal of this challenge is to save a target from the water. **");
        threadSleep(200);
        System.out.println("** But have to dive deep, how will you do? **");
        threadSleep(200);
        System.out.println(Color.GREEN + "1. Just swim and dive" + Color.RESET);
        for (AbstractSpell spell : wizard.getKnownSpells()) {
            if (spell.getName().equals("Bubble-Head")) {
                System.out.println(Color.GREEN + "2. Use the Bubble-Head Charm" + Color.RESET);
                verify[1] = true;
            }
        }
        for (Potion potion: wizard.getPotions()) {
            if (potion.getName().equals("Gillyweed")) {
                System.out.println(Color.GREEN + "3. Use the Gillyweed Potion" + Color.RESET);
                verify[2] = true;
            }
        }
        while (check) {
            check = false;
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("** You dive as much as you can, but you realise this is impossible without magic... **");
                    threadSleep(200);
                    System.out.println("** you come back to the surface, and abandon the task. **");
                    threadSleep(200);
                    System.out.println("** It is not a big deal, but you will start the final task after the other participants... **");
                    wizard.setCondition("Last"); //The story needs to know the position of the player in the tournament
                }
                case "2" -> {
                    if (!verify[1]) {
                        System.out.println("The challenge just started, you have to make a decision.");
                        check = true;
                    } else {
                        System.out.println("** You use the spell to create a bubble of oxygen around your head. **");
                        threadSleep(200);
                        System.out.println("** It works well, but it is not the most practical way to swim. **");
                        threadSleep(200);
                        System.out.println("** You still save your target! You are currently at the 2nd place in this tournament. **");
                        threadSleep(200);
                        System.out.println("** And there is one last task to do... **");
                        wizard.setCondition("2nd"); //Story needs to know the position of the player in the tournament
                    }
                }
                case "3" -> {
                    if (!verify[2]) {
                        System.out.println("** The challenge just started, you have to make a decision. **");
                        check = true;
                    } else {
                        System.out.println("** You use the Gillyweed and can perfectly breath underwater! **");
                        threadSleep(200);
                        System.out.println("** You easily save your target, this potion is awesome. **");
                        threadSleep(200);
                        System.out.println(Color.GREEN + "** You gain +1 Botanist point for using this potion! **" + Color.RESET);
                        threadSleep(200);
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
        threadSleep(200);
        System.out.println("** Anyway, you come back to train before the last task. **");
    }

    public void labyrinth() {
        threadSleep(1000);
        System.out.println("** You are in front of a immense and deadly Labyrinth. **");
        threadSleep(200);
        System.out.println("** There is a trophy in it, your goal is to grab it. **");
        threadSleep(200);
        System.out.println("** There are 3 participant left in this tournament. **");
        threadSleep(200);
        System.out.println("** You step inside the labyrinth at the " + wizard.getCondition() + " place, because of the previous task. **");
        threadSleep(200);
        System.out.println(Color.BLUE + "\n!!! There will be a real labyrinth in the JavaFX game !!!\n" + Color.RESET);
        threadSleep(200);
        System.out.println("** You turn right, and see the trophy at the end of the corridor. **");
        threadSleep(200);
        System.out.println("** But an other participant reaches you, he also saw trophy... **\n");
        threadSleep(200);
        System.out.println(Color.RED + "Tournament Champion - " + Color.RESET + "I'm gonna kill you to get the trophy!!");
        waiting();
        wizard.attack(game.enemy("Champion"));
        System.out.println("** You killed him! But you had to... Anyway, you runStory to grab the trophy... **");
        threadSleep(200);
        System.out.println("** But the 3rd participant arrives in the same time... **");
        threadSleep(200);
        System.out.println("** And you are... in a teleportation??? **");
        threadSleep(200);
        System.out.println(Color.BLACK + "          * * * * * * * * * *\n           * * * * * * * * *");
        threadSleep(200);
        System.out.println("            * * * * * * * *\n             * * * * * * *");
        threadSleep(200);
        System.out.println("              * * * * * *\n               * * * * *");
        threadSleep(200);
        System.out.println("                * * * *\n                 * * *");
        threadSleep(200);
        System.out.println("                  * *\n                   *");
    }

    public void cemetery() {
        waiting();
        System.out.println(Color.BLUE + "Other participant - " + Color.RESET + "The trophy was a Portkey...");
        threadSleep(200);
        System.out.println(Color.BLUE + "Other participant - " + Color.RESET + "So when we touched it, it teleported us.");
        waiting();
        System.out.println(Color.RED + "??? - " + Color.RESET + "AH AH AH AH!!! What a wonderful evening to kill you, both!");
        threadSleep(200);
        System.out.println(Color.RED + "??? - " + Color.RESET + "I am " + Color.BLACK + "Voldemort " + Color.RESET + "and thanks to you, i will become the lord of the world again!");
        threadSleep(200);
        System.out.println("\n** Voldemort is in front of you two, and he has a partisan called Peter Pettigrew next to him. **\n");
        threadSleep(200);
        System.out.println("** You have to act, what do you do? **");
        System.out.println(Color.GREEN + "1. Attack them\n2. Trying to go back at the Portkey\n3. To play dead." + Color.RESET);
        threadSleep(3000);
        System.out.println("\n** You don't even have the time to do anything that Voldemort said: **\n");
        threadSleep(200);
        System.out.println(Color.RED + "Lord Voldemort - " + Color.RESET + "Kill them.");
        waiting();
        System.out.println("\n** His partisan instantly take his wand and look at the other participant... **\n");
        threadSleep(200);
        System.out.println(Color.RED + "Peter Pettigrew - " + Color.RESET + "AVADA KEDAVRA!");
        waiting();
        System.out.println("\n** The other participant immediately dies. **");
        threadSleep(200);
        System.out.println("** You don't have the time to think, just attract the Portkey... NOW! **");
        threadSleep(200);
        System.out.println(Color.RED + "Write Accio to attract the Portkey :" + Color.RESET);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Accio")) {
            System.out.println("** You attract the portkey and instantly teleport to the castle. **\n");
        } else {
            System.out.println(Color.RED + "\nPeter Pettigrew - " + Color.RESET + "AVADA KEDAVRA!");
            waiting();
            System.out.println(Color.RED + "** You died. **" + Color.RESET);
            waiting();
            System.exit(0);
        }
        threadSleep(200);
        System.out.println("** You attract the portkey and instantly teleport to the castle. **");
        threadSleep(200);
        System.out.println("** Now, you can be sure the Voldemort is alive... **");
        threadSleep(200);
        System.out.println("** Anyway, you won the Triwizard Tournament! **");
        waiting();
        System.out.println(Color.GREEN + "** All your stats have increased! **" + Color.RESET);
        wizard.setAccuracy(wizard.getAccuracy() + 1);
        wizard.setBotanist(wizard.getBotanist() + 1);
        wizard.setMaxHealth(wizard.getMaxHealth() + 5);
        wizard.setPower(wizard.getPower() + 1);
    }
    @Override
    public Wizard getWizard() {
        return wizard;
    }
}