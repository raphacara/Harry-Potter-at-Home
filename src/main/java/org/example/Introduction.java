package org.example;
import java.util.Scanner;

public class Introduction implements StoryStep {
    public static final String RESET = "\u001B[0m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String GREEN_BOLD = "\033[1;32m";

    // Implementation of the run() method for this step
    public void run() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("------------ INTRODUCTION ------------\n");
        Thread.sleep(2000);
        System.out.print("Welcome in the Wizarding World, a world full of magic, hidden away for those who do not know magic, muggles.\n");
        Thread.sleep(3000);
        System.out.print("And you were a muggle, until today. Because today your door got kicked in by a half-giant.\n");
        Thread.sleep(3000);
        System.out.print(BLUE_BOLD + "??? - " + RESET + "Hey, you ! What's your name ?\n");
        Thread.sleep(3000);
        System.out.print(RED_BOLD + "Enter your name\n" + RESET);
        String nameWizard = scanner.nextLine();
        System.out.print(BLUE_BOLD + "??? - " + RESET + "OH ! So you are " + nameWizard + " ! Sorry, I didn't introduce myself, I am Hagrid,\n");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "I have been looking for you, and I have a letter for you :\n");
        Thread.sleep(3000);
        System.out.println(GREEN_BOLD + "*  Dear " + nameWizard + ",\n");
        Thread.sleep(2000);
        System.out.println("~  We are happy to inform you that you have been accepted");
        Thread.sleep(1000);
        System.out.println("~  at the Hogwarts witchcraft school. ");
        Thread.sleep(1000);
        System.out.println("~  You are therefore invited to join our community of wizards and witches");
        Thread.sleep(1000);
        System.out.println("~  for an unforgettable school year.\n");
        Thread.sleep(2000);
        System.out.println("~  Sincerely,");
        Thread.sleep(1000);
        System.out.println("~                          Albus Dumbledore, Headmaster of Hogwarts\n" + RESET);
        Thread.sleep(6000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Congratulations " + nameWizard + " ! Follow me, I will help you to go to Hogwarts.\n");
        Thread.sleep(1000);
    }

}

