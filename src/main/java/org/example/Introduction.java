package org.example;
import java.util.Scanner;

public class Introduction implements StoryStep {
    public static final String RESET = "\u001B[0m"; //fun
    public static final String RED_BOLD = "\033[1;31m"; //fun
    public static final String BLUE_BOLD = "\033[1;34m"; //fun
    public static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String[] input = {"1","2","3","4","5","6","7","8"}; //the player inputs
    private static Wizard wizard; //the player
    private String name;
    private int size;
    private Core core = null;

    //Constructor
    public Introduction(Wizard player) {
        wizard = player;
    }

    // Method to run this step of the story
    public void run() throws InterruptedException {
        //Introduction
        Scanner scanner = new Scanner(System.in);
        System.out.print(GREEN_BOLD + "\n----------------- INTRODUCTION -----------------\n\n" + RESET);
        Thread.sleep(2000);
        System.out.print("** Welcome in the Wizarding World, a world full of magic, hidden away for those who do not know magic, muggles. **\n");
        Thread.sleep(2000);
        System.out.print("** And you were a muggle, until today. Because today your door got kicked in by a half-giant. **\n\n");
        Thread.sleep(2000);

        //Player Name
        System.out.print(BLUE_BOLD + "??? - " + RESET + "Hey, you! What's your name ?\n");
        Thread.sleep(1000);
        System.out.print(RED_BOLD + "Enter your name :\n" + RESET);
        this.name = scanner.nextLine();
        wizard.setName(name);

        //Story
        System.out.print(BLUE_BOLD + "??? - " + RESET + "OH! So you are " + name + "! Sorry, I didn't introduce myself, I am Hagrid.\n");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "I was looking for you, and I have a letter for you :\n");
        Thread.sleep(2000);
        System.out.println(GREEN_BOLD + "~  Dear " + name + ",\n");
        Thread.sleep(1000);
        System.out.println("~  We are happy to inform you that you have been accepted");
        Thread.sleep(500);
        System.out.println("~  at the Hogwarts witchcraft school. ");
        Thread.sleep(500);
        System.out.println("~  You are therefore invited to join our community of wizards and witches");
        Thread.sleep(500);
        System.out.println("~  for an unforgettable school year.\n");
        Thread.sleep(500);
        System.out.println("~  Sincerely,");
        Thread.sleep(500);
        System.out.println("~                          Albus Dumbledore, Headmaster of Hogwarts\n" + RESET);
        Thread.sleep(5000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Congratulations " + name + "! Follow me, I will help you to go to Hogwarts.\n");
        Thread.sleep(2000);
        System.out.print("** You and Hagrid are now on the way to Hogwarts, the school of wizards ... **\n\n");
        Thread.sleep(2000);

        //Choosing a Pet
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "First, you will have to choose a pet for your adventure,");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Usually, students choose an Owl, a Cat, or a Toad.");
        Thread.sleep(2000);
        Pet pet = null;
        while (pet == null) {
            System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Which Pet do you want?");
            System.out.println(GREEN_BOLD + "1. Owl\n" + "2. Cat\n" + "3. Toad\n" + "4. I really don't like those" + RED_BOLD );
            System.out.print("Enter a number to make your choice :\n" + RESET);
            input[0] = scanner.nextLine();
            switch (input[0]) {
                case "1" -> pet = Pet.OWL;
                case "2" -> pet = Pet.CAT;
                case "3" -> pet = Pet.TOAD;
                case "4" -> {
                    while (pet == null) {
                        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Well, I have one last idea: Do you want a Really Kind Pet or a Really Dangerous Pet ?");
                        System.out.println(GREEN_BOLD + "1. Really Kind Pet\n" + "2. Really Dangerous Pet" + RED_BOLD);
                        System.out.print("Enter a number to make your choice :\n" + RESET);
                        input[1] = scanner.nextLine();
                        switch (input[1]) {
                            case "1" -> {
                                System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Nice choice! I give you a Rat.");
                                pet = Pet.RAT;
                            }
                            case "2" -> {
                                System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Interesting choice... I give you a Snake. ");
                                pet = Pet.SNAKE;
                            }
                            default -> System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "You really have to choose between the two last choices because you must have a Pet!");
                        }
                    }
                }
                default -> System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Seriously, choose a Pet with the numbers.");
            }
        }
        Thread.sleep(500);
        System.out.println(GREEN_BOLD + "** You now have a " + pet + "! **\n");
        Thread.sleep(2000);
        wizard.setPet(pet);

        //Choosing a wand
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Perfect! The last thing you need is a magic wand.");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Let's meet Ollivander, He's the best when it comes to wands ;)\n");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Hello " + name + "! Let's find you the perfect wand. Let me see...");
        Thread.sleep(2000);

        //Size of the wand
        int check = 0;
        while (check == 0) { //The size based on player ambition
            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "What's is the best definition of magic according to you ?");
            Thread.sleep(1000);
            System.out.println(GREEN_BOLD + "1. Power\n" + "2. Art\n" + "3. Miracle\n" + "4. Scam" + RED_BOLD);
            System.out.print("Enter a number to make your choice :\n" + RESET);
            input[2] = scanner.nextLine();
            check = 1;
            switch (input[2]) {
                case "1" -> size = 25;
                case "2" -> size = 31;
                case "3" -> size = 29;
                case "4" -> size = 27;
                default -> {
                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "That is not a joke, please focus.");
                    check = 0;
                }
            }
        }
        while (check == 1) { //modification of the size based on the player height
            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Okay... And how do you consider your own height?");
            Thread.sleep(1000);
            System.out.println(GREEN_BOLD + "1. Giant\n" + "2. Tall\n" + "3. Average\n" + "4. Little\n" + "5. Dwarf" + RED_BOLD);
            System.out.print("Enter a number to make your choice :\n" + RESET);
            input[3] = scanner.nextLine();
            check = 2;
            switch (input[3]) {
                case "1":
                    size += 3;
                    break;
                case "2":
                    size += 2;
                    break;
                case "3":
                    break;
                case "4":
                    size -= 2;
                    break;
                case "5":
                    size -= 3;
                    break;
                default:
                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "That is not an appropriate answer.");
                    check = 1;
            }
        }

        //Core of the Wand
        Thread.sleep(1000);
        System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "I see...");
        Thread.sleep(2000);
        while (core == null) {
            switch (pet) { //the pet influence the core
                case RAT, SNAKE -> { //if you have a special pet
                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "How do you imagine your future? ");
                    System.out.println(GREEN_BOLD + "1. Rich\n" + "2. Normal\n" + "3. Powerful\n" + "4. Famous\n" + "5. Sad\n" + "6. Cheerful\n" + "7. no idea" + RED_BOLD);
                    System.out.print("Enter a number to make your choice :\n" + RESET);
                    input[4] = scanner.nextLine();
                    switch (input[4]) {
                        case "3", "6" -> {
                            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Really... And Do you prefer Odd or Even numbers ?");
                            System.out.println(GREEN_BOLD + "1. Odd\n" + "2. Even\n" + "3. It doesn't matter" + RED_BOLD);
                            System.out.print("Enter a number to make your choice :\n" + RESET);
                            input[5] = scanner.nextLine();
                            switch (pet) {
                                case RAT, SNAKE:
                                    switch (input[5]) {
                                        case "1" -> core = Core.PHOENIX_FEATHER;
                                        case "2", "3" -> core = Core.DRAGON_HEARTSTRING;
                                        default -> System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Please focus... I will ask again from the question about the future:");
                                    }
                            }
                        }
                        case "1", "2", "5" -> core = Core.UNICORN_HAIR;
                        case "4", "7" -> core = Core.DRAGON_HEARTSTRING;
                        default -> System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "You must think again about your future.");
                    }
                }
                case CAT, TOAD, OWL -> { //if you don't have a special pet
                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "I see that you have a " + pet + ", why did you choose it ?");
                    System.out.println(GREEN_BOLD + "1. It is cute\n" + "2. It is strong\n" + "3. It is beautiful\n" + "4. It is useful\n" + "5. It is smart\n" + "6. I don't know" + RED_BOLD);
                    System.out.print("Enter a number to make your choice :\n" + RESET);
                    input[4] = scanner.nextLine();
                    switch (input[4]) {
                        case "1", "3", "6" -> core = Core.UNICORN_HAIR;
                        case "2", "5" -> core = Core.DRAGON_HEARTSTRING;
                        case "4" -> {
                            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Really... And Do you prefer Odd or Even numbers ?");
                            System.out.println(GREEN_BOLD + "1. Odd\n" + "2. Even\n" + "3. It doesn't matter" + RED_BOLD);
                            System.out.print("Enter a number to make your choice :\n" + RESET);
                            input[5] = scanner.nextLine();
                            switch (input[5]) {
                                case "1" -> { //only case to get PHOENIX_FEATHER if you have a basic pet
                                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "I also prefer Odd numbers.");
                                    core = Core.PHOENIX_FEATHER;
                                }
                                case "2" -> {
                                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Even numbers are beautiful, I agree.");
                                    core = Core.DRAGON_HEARTSTRING;
                                }
                                case "3" -> {
                                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "If you say so...");
                                    core = Core.UNICORN_HAIR;
                                }
                                default -> System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Please focus... I will ask again from the question about the pet:");
                            }
                        }
                        default -> System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "You have to answer my question!");
                    }
                }
            }
        }
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "I think I exactly know what is the best for you.");
        Thread.sleep(2000);
        System.out.println("** Ollivander gives you a magic wand **");
        Thread.sleep(2000);
        System.out.println("** You take it, and... You feel very comfortable with it! **");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Awesome, I knew it!");
        Thread.sleep(2000);
        System.out.println(GREEN_BOLD + "** You got a " + size + "cm Wand, with a " + core + " core. **\n" + RESET);
        Wand wandWizard = new Wand(core, size);
        wizard.setWand(wandWizard);

        //End of the Introduction
        Thread.sleep(2000);
        System.out.println("** You are now ready to go to Hogwarts, so you go to the platform 9 3/4 at King's Cross Station. **");
        Thread.sleep(4000);
        System.out.println("** And you take the Hogwarts™ Express's train right to Hogwarts! **");
        Thread.sleep(5000);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        Thread.sleep(500);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        Thread.sleep(500);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        Thread.sleep(500);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        Thread.sleep(500);
        System.out.println("** Finally, you arrive at Hogwarts Castle. **");
        Thread.sleep(2000);
        System.out.println("** You follow the other students to a Great Hall, with a Sorting Hat. **");
        Thread.sleep(2000);
        System.out.println("** Now it is your turn to pass the Sorting Hat test... Good Luck! **");
        Thread.sleep(2000);

        //Sorting Hat test
        SortingHat sort = new SortingHat(wizard); //Instance of sorting hat
        sort.run(); //Calling Class SortingHat for the sorting hat test
        String houseWizard = sort.getHouse(); //getting the house that the sorting hat choose
        wizard.setHouse(houseWizard); //setting the house of the wizard
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }

    // Method to get the wizard's name
    public String getName() {
        return this.name;
    }
}