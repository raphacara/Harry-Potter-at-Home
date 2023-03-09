package org.example;

public class Chapter2 implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String BLUE_BOLD = "\033[1;34m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String BLACK_BOLD = "\033[1;30m"; //fun
    private static Wizard wizard;
    //Constructor
    public Chapter2(Wizard player) {
        wizard = player;
    }
    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 2 --
        System.out.println(GREEN_BOLD + "\n----------------- Chapter 2 -----------------");
        Thread.sleep(1000);
        System.out.println("---------- The Chamber of Secrets -----------\n" + RESET);
        Thread.sleep(2000);
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}
