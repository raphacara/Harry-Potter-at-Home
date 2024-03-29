package org.game.story;

import org.game.Color;
import org.game.GameContent;
import org.game.character.Wizard;

public class Chapter5 implements StoryStep {
    private final Wizard wizard; //the player
    private final GameContent game = new GameContent(); //to have access to the game content

    //Constructor
    public Chapter5(Wizard player) {
        wizard = player;
    }
    @Override
    public void runStory() throws InterruptedException {
        //-- Intro of Chapter 5 --
        System.out.println(Color.GREEN + "----------------- Chapter 5 -----------------");
        threadSleep(200);
        System.out.println("---------- The Order of the Phoenix ---------\n" + Color.RESET);
        threadSleep(1000);
        System.out.println("** This is your 5th year at Hogwarts. **");
        threadSleep(200);
        System.out.println("** This year is special, because of the coming back of Lord Voldemort. **");
        threadSleep(200);
        System.out.println("** Dumbledore is not the headmaster of the school this year, because of the ministry of magic. **");
        threadSleep(200);
        System.out.println("** Instead, there is an awful woman called: Dolores Umbridge. **");
        threadSleep(200);
        System.out.println("** So you have to train alone with other students to become stronger, in case you fight Voldemort. **");
        threadSleep(200);
        System.out.println("** All the nice students meet in the Room on Demand, and train. **");
        threadSleep(200);

        //-- Training --
        System.out.println("** You learn a lot... **");
        waiting();
        wizard.learnSpell(game.spell("Expelliarmus"));
        threadSleep(200);
        System.out.println("** Again and again... **");
        waiting();
        wizard.learnSpell(game.spell("Stupefy"));
        threadSleep(200);
        System.out.println("** Still and always... **" + Color.GREEN);
        waiting();
        wizard.learnPotion(game.potion("Wiggenweld"));
        threadSleep(200);
        System.out.println(Color.RESET + "** And increase your power... **");
        waiting();
        wizard.setPower(wizard.getPower() + 1);
        System.out.println(Color.GREEN + "** You gained +1 of power! **" + Color.RESET);
        threadSleep(200);
        System.out.println("** As you are training really hard, the year is going on. **");
        threadSleep(200);
        System.out.println("** You now have to pass your B.U.S.E : Basic Understanding of Subjects Exam. **");
        threadSleep(200);
        System.out.println("** Supervised by... Dolores Umbridge. **\n");
        threadSleep(200);

        //B.U.S.E exam and final fight
        System.out.println(Color.RED + "Umbridge - " + Color.RESET + "Well, I hope you have revised for you exam... Good Luck.\n");
        threadSleep(200);
        System.out.println("** The situation is so terrible that it's as if you were fighting Umbridge... **");
        waiting();
        System.out.println(Color.BLACK + "            |\n            |\n            |\n            |\n            |\n            |" + Color.RESET);
        threadSleep(200);
        System.out.println(Color.BLACK + "            |\n            |\n            |\n            |\n            |\n            |\n" + Color.RESET);
        threadSleep(200);
        wizard.attack(game.enemy("Umbridge"));

        //-- End of Chapter 5--
        System.out.println("** Well played! Everyone get their exams this year! **");
        waiting();
        System.out.println("\n** Chapter 5 - THE END **\n");
        threadSleep(1000);
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}