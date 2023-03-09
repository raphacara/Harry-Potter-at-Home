package org.example;

public class Chapter5 implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String BLUE_BOLD = "\033[1;34m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String BLACK_BOLD = "\033[1;30m"; //fun
    private static Wizard wizard;
    //Constructor
    public Chapter5(Wizard player) {
        wizard = player;
    }
    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 5 --
        System.out.println(GREEN_BOLD + "\n----------------- Chapter 5 -----------------");
        Thread.sleep(1000);
        System.out.println("---------- The Order of the Phoenix ----------\n" + RESET);
        Thread.sleep(2000);
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}