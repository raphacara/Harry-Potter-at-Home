package org.game.story;

import org.game.Color;
import org.game.GameContent;
import org.game.character.Wizard;

import java.util.Scanner;

public class Chapter7Dark implements StoryStep {
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private boolean check = false; //checking the loops
    private final boolean[] classesTaken = new boolean[7]; //changing to true when the player take a lesson


    //Constructor
    public Chapter7Dark(Wizard player) {
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
        System.out.println("** You are a Death Eater. **");
        threadSleep(200);
        System.out.println("** You come to Lord Voldemort by flying in your Death Eater black smoke. **");
        waiting();
        System.out.println("** You are now with your fellow Death Eaters, Bellatrix Lestrange and Voldemort. **");
        threadSleep(200);
        System.out.println(Color.RED + "\nVoldemort - " + Color.RESET + "Well, well, well. Welcome " + wizard.getName() + "!");
        waiting();
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "You have made a great choice to join us.");
        threadSleep(200);
        System.out.println("\n** Voldemort is casting a mysterious spell on you... **");
        waiting();
        wizard.setPower(wizard.getPower() + 15); //You get 15 more power
        System.out.println(Color.GREEN + "** You have gained 15 power! **\n" + Color.RESET);
        threadSleep(200);
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "Every Death Eater needs to know the killing curse.");
        waiting();
        wizard.learnSpell(game.spell("Avada Kedavra")); //You learn the killing curse
        waiting();
        System.out.println(Color.RED + "Voldemort - " + Color.RESET + "You are now free to kill all the weak people, Hahaha!");
        threadSleep(200);
        System.out.println("** What will you do? **");
        threadSleep(200);
        chooseWhatToDo();
    }

    public void chooseWhatToDo() {
        boolean ok = check;
        while (check == ok) {
            System.out.print(Color.GREEN);
            if (!classesTaken[1]) { // hiding if the lesson was taken before
                System.out.println("1. Divinity class");
            }
            if (!classesTaken[2]) {
                System.out.println("2. Care of Magical Creatures class");
            }
            if (!classesTaken[3]) {
                System.out.println("3. Dueling club");
            }
            System.out.println("4. Sleeping");
            if (classesTaken[5]) {
                System.out.println("5. Forbidden Forest");
            }
            System.out.print(Color.RED + "Enter a number to make your choice :\n" + Color.RESET);
            String input = scanner.nextLine();
            check = !ok;
            switch (input) {
                case "1" :
                    if (classesTaken[1]) {
                        System.out.println("** What do you mean? **");
                        check = ok;
                    } else {
                    }
                    break;
                case "2":
                    if (classesTaken[2]) {
                        System.out.println("** What do you mean? **");
                        check = ok;
                    } else {
                    }
                    break;
                case "3":
                    if (classesTaken[3]) {
                        System.out.println("** What do you mean? **");
                        check = ok;
                    } else {
                    }
                    break;
                case "4":
                    System.out.println("** You go back in your bed and you sleep. **");
                    waiting();
                    System.out.println("** A long time after that, you wake up.  **");
                    threadSleep(1000);
                    break;
                case "5":
                    if (!classesTaken[5]) {
                        System.out.println("** What do you mean? **");
                        check = ok;
                    } else {
                    }
                    break;
                default :
                    System.out.println("** What do you mean? **");
                    check = ok;
            }
        }
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }
}
