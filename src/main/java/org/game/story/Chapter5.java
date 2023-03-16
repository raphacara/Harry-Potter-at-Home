package org.game.story;

import org.game.attributes.Potion;
import org.game.character.Wizard;
import org.game.character.enemies.Boss;
import org.game.spells.Spell;

public class Chapter5 implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED = "\033[1;31m"; //fun
    private static final String GREEN = "\033[1;32m"; //fun
    private static final String BLACK = "\033[1;30m"; //fun
    private static Wizard wizard; //the player

    //Constructor
    public Chapter5(Wizard player) {
        wizard = player;
    }
    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 5 --
        System.out.println(GREEN + "\n----------------- Chapter 5 -----------------");
        threadSleep(1000);
        System.out.println("---------- The Order of the Phoenix ---------\n" + RESET);
        threadSleep(2000);
        System.out.println("** This is your 5th year at Hogwarts. **");
        threadSleep(2000);
        System.out.println("** This year is special, because of the coming back of Lord Voldemort. **");
        threadSleep(3000);
        System.out.println("** Dumbledore is not the headmaster of the school this year, because of the ministry of magic. **");
        threadSleep(3000);
        System.out.println("** Instead, there is an awful woman called: Dolores Umbridge. **");
        threadSleep(3000);
        System.out.println("** So you have to train alone with other students to become stronger, in case you fight Voldemort. **");
        threadSleep(4000);
        System.out.println("** All the nice students meet in the Room on Demand, and train. **");
        threadSleep(3000);

        //-- Training --
        System.out.println("** You learn a lot... **");
        threadSleep(1000);
        wizard.learnSpell(Spell.expelliarmus);
        threadSleep(1000);
        System.out.println("** Again and again... **");
        threadSleep(1000);
        wizard.learnSpell(Spell.stupefy);
        threadSleep(1000);
        System.out.println("** Still and always... **" + GREEN);
        threadSleep(1000);
        wizard.learnPotion(Potion.wiggenweld);
        threadSleep(1000);
        System.out.println(RESET + "** And increase your power... **");
        threadSleep(1000);
        wizard.setPower(wizard.getPower() + 1);
        System.out.println(GREEN + "** You gained +1 of power! **" + RESET);
        threadSleep(1000);
        System.out.println("** As you are training really hard, the year is going on. **");
        threadSleep(2000);
        System.out.println("** You now have to pass your B.U.S.E : Basic Understanding of Subjects Exam. **");
        threadSleep(3000);
        System.out.println("** Supervised by... Dolores Umbridge. **\n");
        threadSleep(3000);

        //B.U.S.E exam and final fight
        System.out.println(RED + "Umbridge - " + RESET + "Well, I hope you have revised for you exam... Good Luck.\n");
        threadSleep(3000);
        System.out.println("** The situation is so terrible that it's as if you were fighting Umbridge... **");
        threadSleep(3000);
        System.out.println(BLACK + "            |\n            |\n            |\n            |\n            |\n            |" + RESET);
        threadSleep(1000);
        System.out.println(BLACK + "            |\n            |\n            |\n            |\n            |\n            |\n" + RESET);
        threadSleep(1000);
        wizard.attack(Boss.umbridge);

        //-- End of Chapter 5--
        System.out.println("** Well played! Everyone get their exams this year! **");
        threadSleep(2000);
        System.out.println("\n** Chapter 5 - THE END **\n");
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