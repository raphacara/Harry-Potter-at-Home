package org.game.story;

import org.game.character.Wizard;

public class Credits implements StoryStep {
    private final Wizard wizard;

    //Constructor
    public Credits(Wizard player) {
        wizard = player;
    }

    @Override
    public void runStory() {
        System.out.println("\n\n                                  ================ RESULTS ================");
        threadSleep(600);
        creditMovement();
        System.out.println("                                          Congratulation " + wizard.getName() + "!");
        threadSleep(600);
        System.out.println("                                            You are the " + wizard.getCondition() + ".");
        threadSleep(600);
        System.out.println("                                           And a real " + wizard.getHouse() + ".");
        threadSleep(600);
        creditMovement();
        creditMovement();
        System.out.println("                                  ================ CREDITS ================");
        threadSleep(600);
        creditMovement();
        System.out.println("                                          Game Design & Development:");
        threadSleep(600);
        System.out.println("                                               Raphaël CARABEUF\n");
        threadSleep(600);
        creditMovement();
        System.out.println("                                               Story & Writing:");
        threadSleep(600);
        System.out.println("                                               Raphaël CARABEUF");
        threadSleep(600);
        creditMovement();
        System.out.println("                                                   Music:");
        threadSleep(600);
        System.out.println("                                               John WILLIAMS");
        threadSleep(600);
        creditMovement();
        creditMovement();
        System.out.println("                         ================  THANK YOU FOR PLAYING! ================");
        int i;
        for (i = 0; i < 35; i++) {
            threadSleep(600);
            creditMovement();
        }
    }

    public void creditMovement() {
        System.out.println(" ");
        threadSleep(500);
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }  //To get the wizard's infos back
}
