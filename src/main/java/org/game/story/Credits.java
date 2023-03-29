package org.game.story;

import org.game.Color;
import org.game.character.Wizard;

import java.util.Objects;

public class Credits implements StoryStep {
    private final Wizard wizard;
    private String ending;

    //Constructor
    public Credits(Wizard player) {
        wizard = player;
    }

    @Override
    public void runStory() {
        waiting();
        System.out.println("Thanks for playing!");
        threadSleep(200);
        System.out.println("Don't hesitate to start an other game, there are several endings in this game:");
        waiting();
        System.out.println(Color.BLUE + """
        * Standard Ending
        * Dark Ending
        * Golden Ending
        * Secret Ending
        * Ultra-Secret Ending
        """ + Color.RESET);
        waiting();
        defineEnding();
        System.out.println(Color.GREEN + "And you have found the " + ending + "!" + Color.RESET);
        System.out.println("\n\n                                         ================ RESULTS ================");
        threadSleep(600);
        creditMovement();
        System.out.println("                                                  Congratulation " + wizard.getName() + "!");
        threadSleep(600);
        System.out.println("                                                     You are " + wizard.getCondition() + ".");
        threadSleep(600);
        System.out.println("                                                   And a real " + wizard.getHouse() + ".");
        threadSleep(600);
        creditMovement();
        creditMovement();
        System.out.println("                                         ================ CREDITS ================");
        threadSleep(600);
        creditMovement();
        System.out.println("                                                 Game Design & Development:");
        threadSleep(600);
        System.out.println("                                                     Raphaël CARABEUF");
        threadSleep(600);
        creditMovement();
        System.out.println("                                                      Story & Writing:");
        threadSleep(600);
        System.out.println("                                                     Raphaël CARABEUF");
        threadSleep(600);
        creditMovement();
        System.out.println("                                                          Music:");
        threadSleep(600);
        System.out.println("                                                      John WILLIAMS");
        threadSleep(600);
        creditMovement();
        creditMovement();
        System.out.println("                                ================  THANK YOU FOR PLAYING! ================");
        int i;
        for (i = 0; i < 35; i++) {
            threadSleep(300);
            creditMovement();
        }
    }

    public void creditMovement() {
        System.out.println(" ");
        threadSleep(500);
    }

    public void defineEnding() {
        if (Objects.equals(wizard.getCondition(), "a " + Color.BLUE + "Hero" + Color.RESET)) {
            this.ending = "Standard Ending";
        } else if (Objects.equals(wizard.getCondition(), "the " + Color.BLUE + "Legendary Hero" + Color.RESET)) {
            this.ending = "Golden Ending";
        } else if (Objects.equals(wizard.getCondition(), "a " + Color.RED + "Death Eater" + Color.RESET)) {
            this.ending = "Dark Ending";
        } else if (Objects.equals(wizard.getCondition(), "the" + Color.RED + "Dark Lord" + Color.RESET)) {
            this.ending = "Ultra-Secret Ending";
        } else if (Objects.equals(wizard.getCondition(), "the" + Color.BLUE + "Great Auror" + Color.RESET)) {
        } else {
            this.ending = "Secret Ending";
        }
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }  //To get the wizard's infos back
}
