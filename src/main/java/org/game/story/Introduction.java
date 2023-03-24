package org.game.story;
import org.game.Color;
import org.game.attributes.Core;
import org.game.attributes.Pet;
import org.game.attributes.Wand;
import org.game.character.Wizard;

import java.util.Scanner;

public class Introduction implements StoryStep {
    private final String[] input = {"1","2","3","4","5","6","7","8"}; //the player inputs
    private Wizard wizard; //the player
    private int size;
    private Core core = null;

    //Constructor
    public Introduction(Wizard player) {
        wizard = player;
    }

    // Method to runStory this step of the story
    public void runStory() throws InterruptedException {
        //Introduction
        Scanner scanner = new Scanner(System.in);
        System.out.print(Color.GREEN + "----------------- INTRODUCTION -----------------\n\n" + Color.RESET);
        threadSleep(1000);
        System.out.print("** Welcome in the Wizarding World, a world full of magic, hidden away for those who do not know magic, muggles. **\n");
        threadSleep(200);
        System.out.print("** And you were a muggle, until today. Because today your door got kicked in by a half-giant. **\n\n");
        threadSleep(200);

        //Player Name
        System.out.print(Color.BLUE + "??? - " + Color.RESET + "Hey, you! What's your name ?\n");
        threadSleep(200);
        System.out.print(Color.RED + "Enter your name :\n" + Color.RESET);
        String name = scanner.nextLine();
        wizard.setName(name);

        //Story
        System.out.print(Color.BLUE + "??? - " + Color.RESET + "OH! So you are " + name + "! Sorry, I didn't introduce myself, I am Hagrid.\n");
        threadSleep(200);
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "I was looking for you, and I have a letter for you :\n");
        waiting();
        System.out.println(Color.GREEN + "~  Dear " + name + ",\n");
        threadSleep(200);
        System.out.println("~  We are happy to inform you that you have been accepted");
        threadSleep(200);
        System.out.println("~  at the Hogwarts witchcraft school. ");
        threadSleep(200);
        System.out.println("~  You are therefore invited to join our community of wizards and witches");
        threadSleep(200);
        System.out.println("~  for an unforgettable school year.\n");
        threadSleep(200);
        System.out.println("~  Sincerely,");
        threadSleep(200);
        System.out.println("~                          Albus Dumbledore, Headmaster of Hogwarts\n" + Color.RESET);
        waiting();
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Congratulations " + name + "! Follow me, I will help you to go to Hogwarts.\n");
        threadSleep(200);
        System.out.print("** You and Hagrid are now on the way to Hogwarts, the school of wizards ... **\n\n");
        threadSleep(200);

        //Choosing a Pet
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "First, you will have to choose a pet for your adventure,");
        Thread.sleep(200);
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Usually, students choose an Owl, a Cat, or a Toad.");
        Thread.sleep(200);
        Pet pet = null;
        while (pet == null) {
            System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Which Pet do you want?");
            System.out.println(Color.GREEN + "1. Owl\n" + "2. Cat\n" + "3. Toad\n" + "4. I really don't like those" + Color.RED);
            System.out.print("Enter a number to make your choice :\n" + Color.RESET);
            input[0] = scanner.nextLine();
            switch (input[0]) {
                case "1" -> pet = Pet.OWL;
                case "2" -> pet = Pet.CAT;
                case "3" -> pet = Pet.TOAD;
                case "4" -> {
                    while (pet == null) {
                        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Well, I have one last idea: Do you want a Really Kind Pet or a Really Dangerous Pet ?");
                        System.out.println(Color.GREEN + "1. Really Kind Pet\n" + "2. Really Dangerous Pet" + Color.RED);
                        System.out.print("Enter a number to make your choice :\n" + Color.RESET);
                        input[1] = scanner.nextLine();
                        switch (input[1]) {
                            case "1" -> {
                                System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Nice choice! I give you a Rat.");
                                pet = Pet.RAT;
                            }
                            case "2" -> {
                                System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Interesting choice... I give you a Snake. ");
                                pet = Pet.SNAKE;
                            }
                            default -> System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "You really have to choose between the two last choices because you must have a Pet!");
                        }
                    }
                }
                default -> System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Seriously, choose a Pet with the numbers.");
            }
        }
        threadSleep(200);
        System.out.println(Color.GREEN + "** You now have a " + pet + "! **");
        threadSleep(200);
        wizard.setPet(pet); //setting the Pet to the wizard
        wizard.bonusPet(wizard); //Setting the BONUS of the PET's wizard
        waiting();

        //Choosing a wand
        System.out.println(Color.BLUE + "\nHagrid - " + Color.RESET + "Perfect! The last thing you need is a magic wand.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Let's meet Ollivander, He's the best when it comes to wands ;)\n");
        threadSleep(200);
        System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "Hello " + name + "! Let's find you the perfect wand. Let me see...");
        threadSleep(200);

        //Size of the wand
        int check = 0;
        while (check == 0) { //The size based on player ambition
            System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "What's is the best definition of magic according to you ?");
            Thread.sleep(1000);
            System.out.println(Color.GREEN + "1. Power\n" + "2. Art\n" + "3. Miracle\n" + "4. Fraud" + Color.RED);
            System.out.print("Enter a number to make your choice :\n" + Color.RESET);
            input[2] = scanner.nextLine();
            check = 1;
            int random = (int)(Math.random() * 4); //random num
            switch (input[2]) {
                case "1" -> size = 25 + random;
                case "2" -> size = 31 + random;
                case "3" -> size = 29 + random;
                case "4" -> size = 27 + random;
                default -> {
                    System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "That is not a joke, please focus.");
                    check = 0;
                }
            }
        }

        //Core of the Wand
        threadSleep(200);
        System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "I see...");
        Thread.sleep(1000);
        while (core == null) {
            switch (pet) { //the pet influence the core
                case RAT, SNAKE -> { //if you have a special pet
                    System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "And how do you imagine your future? ");
                    System.out.println(Color.GREEN + "1. Rich\n" + "2. Normal\n" + "3. Powerful\n" + "4. Famous\n" + "5. Sad\n" + "6. Cheerful\n" + "7. No idea" + Color.RED);
                    System.out.print("Enter a number to make your choice :\n" + Color.RESET);
                    input[4] = scanner.nextLine();
                    switch (input[4]) {
                        case "3", "6" -> core = Core.PHOENIX_FEATHER;
                        case "1", "2", "5" -> core = Core.UNICORN_HAIR;
                        case "4", "7" -> core = Core.DRAGON_HEARTSTRING;
                        default -> System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "You must think again about your future.");
                    }
                }
                case CAT, TOAD, OWL -> { //if you don't have a special pet
                    System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "I see that you have a " + pet + ", why did you choose it ?");
                    System.out.println(Color.GREEN + "1. It is cute\n" + "2. It is strong\n" + "3. It is beautiful\n" + "4. It is useful\n" + "5. It is smart\n" + "6. I don't know" + Color.RED);
                    System.out.print("Enter a number to make your choice :\n" + Color.RESET);
                    input[4] = scanner.nextLine();
                    switch (input[4]) {
                        case "1", "3", "6" -> core = Core.UNICORN_HAIR;
                        case "2", "5" -> core = Core.DRAGON_HEARTSTRING;
                        case "4" -> core = Core.PHOENIX_FEATHER;
                        default -> System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "You have to answer my question!");
                    }
                }
            }
        }
        System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "I think I exactly know what is the best for you.");
        threadSleep(200);
        System.out.println("\n** Ollivander gives you a magic wand **");
        waiting();
        System.out.println("** You take it, and... You feel very comfortable with it! **\n");
        threadSleep(200);
        System.out.println(Color.BLUE + "Ollivander - " + Color.RESET + "Awesome, I knew it!");
        threadSleep(200);
        System.out.println(Color.GREEN + "** You got a " + size + "cm Wand, with a " + core + " core. **" + Color.RESET);
        threadSleep(200);
        Wand wandWizard = new Wand(core, size); //creating the wizard's wand
        wizard.setWand(wandWizard); //setting the wand to the wizard
        wizard.bonusWand(wizard); //setting the BONUS of the core's wand
        waiting();

        //End of the Introduction
        System.out.println("\n** You are now ready to go to Hogwarts, so you go to the platform 9 3/4 at King's Cross Station. **");
        threadSleep(200);
        System.out.println("** And you take the Hogwarts™ Express's train right to Hogwarts! **");
        waiting();
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        threadSleep(500);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        threadSleep(500);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        threadSleep(500);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        threadSleep(500);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        threadSleep(500);
        System.out.println("** Finally, you arrive at Hogwarts Castle. **");
        waiting();
        System.out.println("** You follow the other students to a Great Hall, with a Sorting Hat. **");
        threadSleep(200);
        System.out.println("** Now it is your turn to pass the Sorting Hat test... Good Luck! **");
        waiting();

        //Sorting Hat test
        SortingHat sort = new SortingHat(wizard); //Instance of sorting hat
        sort.runStory(); //Calling Class SortingHat for the sorting hat test
        System.out.println(" "); //for story needs.
        wizard = sort.getWizard(); //Get the Wizard's infos
    }

    //Ultra powerful method to return all the wizard infos :)
    @Override
    public Wizard getWizard() {
        return wizard;
    }

}