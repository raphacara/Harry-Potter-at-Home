package org.example;
import java.util.Scanner;

public class Introduction implements StoryStep {
    public static final String RESET = "\u001B[0m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String GREEN_BOLD = "\033[1;32m";
    private String name;
    private Pet pet;
    private int size;
    private Core core;

    // Method to run this step of the story
    public void run() throws InterruptedException {
        //Introduction
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n----------------- INTRODUCTION -----------------\n\n");
        Thread.sleep(2000);
        System.out.print("** Welcome in the Wizarding World, a world full of magic, hidden away for those who do not know magic, muggles. **\n");
        Thread.sleep(3000);
        System.out.print("** And you were a muggle, until today. Because today your door got kicked in by a half-giant. **\n\n");
        Thread.sleep(3000);

        //Player Name
        System.out.print(BLUE_BOLD + "??? - " + RESET + "Hey, you! What's your name ?\n");
        Thread.sleep(2000);
        System.out.print(RED_BOLD + "Enter your name :\n" + RESET);
        this.name = scanner.nextLine();
        System.out.print(BLUE_BOLD + "??? - " + RESET + "OH! So you are " + name + "! Sorry, I didn't introduce myself, I am Hagrid.\n");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "I was looking for you, and I have a letter for you :\n");
        Thread.sleep(3000);
        System.out.println(GREEN_BOLD + "~  Dear " + name + ",\n");
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
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Congratulations " + name + "! Follow me, I will help you to go to Hogwarts.\n");
        Thread.sleep(3000);
        System.out.print("** You and Hagrid are now on the way to Hogwarts, the school of wizards ... **\n\n");
        Thread.sleep(3000);

        //Choosing a Pet
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "First, you will have to choose a pet for your adventure,");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Usually, students choose an Owl, a Cat, or a Toad.");
        Thread.sleep(3000);
        String input;
        pet = null;
        while (pet == null) {
            System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Which Pet do you want?");
            System.out.println(GREEN_BOLD + "1. Owl\n" + "2. Cat\n" + "3. Toad\n" + "4. I really don't like those" + RED_BOLD );
            System.out.print("Enter a number to make your choice :\n" + RESET);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> pet = Pet.OWL;
                case "2" -> pet = Pet.CAT;
                case "3" -> pet = Pet.TOAD;
                case "4" -> {
                    System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Oh, you really don't like those... But you need to have a Pet...");
                    Thread.sleep(3000);
                    while (pet == null) {
                        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Well, I have one last idea: Do you want a Really Kind Pet or a Really Dangerous Pet ?");
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD + "1. Really Kind Pet\n" + "2. Really Dangerous Pet" + RED_BOLD);
                        System.out.print("Enter a number to make your choice :\n" + RESET);
                        input = scanner.nextLine();
                        switch (input) {
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
        Thread.sleep(3000);

        //Choosing a wand
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Perfect! The last thing you need is a magic wand.");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Let's meet Ollivander, He's the best when it comes to wands ;)\n");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Hello " + name + "! Let's find you the perfect wand. Let me see...");
        Thread.sleep(3000);
        String input2;
        String input3;
        int check = 0;
        while (check == 0) { //The size
            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "What's is the best definition of magic according to you ?");
            Thread.sleep(3000);
            System.out.println(GREEN_BOLD + "1. Power\n" + "2. Art\n" + "3. Miracle\n" + "4. Scam" + RED_BOLD);
            System.out.print("Enter a number to make your choice :\n" + RESET);
            input2 = scanner.nextLine();
            check = 1;
            switch (input2) {
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
        while (check == 1) {
            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Okay... And how do you consider your own height?");
            Thread.sleep(2000);
            System.out.println(GREEN_BOLD + "1. Giant\n" + "2. Tall\n" + "3. Average\n" + "4. Little\n" + "5. Dwarf" + RED_BOLD);
            System.out.print("Enter a number to make your choice :\n" + RESET);
            input3 = scanner.nextLine();
            check = 2;
            switch (input3) {
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

        String input4;
        String input5;
        core = null;
        Thread.sleep(1000);
        while (core == null) { //The core
            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "I see...");
            Thread.sleep(3000);
            switch (pet) {
                case RAT, SNAKE -> {
                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "How do you imagine your future? ");
                    Thread.sleep(2000);
                    System.out.println(GREEN_BOLD + "1. Rich\n" + "2. Normal\n" + "3. Powerful\n" + "4. Famous\n" + "5. Sad\n" + "6. Cheerful\n" + "7. no idea" + RED_BOLD);
                    System.out.print("Enter a number to make your choice :\n" + RESET);
                    input4 = scanner.nextLine();
                    switch (input4) {
                        case "3", "6" -> {
                            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Really... And Do you prefer Odd or Even numbers ?");
                            Thread.sleep(2000);
                            System.out.println(GREEN_BOLD + "1. Odd\n" + "2. Even\n" + "3. It doesn't matter" + RED_BOLD);
                            System.out.print("Enter a number to make your choice :\n" + RESET);
                            input5 = scanner.nextLine();
                            switch (pet) {
                                case RAT:
                                    switch (input5) {
                                        case "2" -> core = Core.PHOENIX_FEATHER;
                                        case "1", "3" -> core = Core.UNICORN_HAIR;
                                        default -> System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Please focus... I will ask again from the question about the future:");
                                    }
                                case SNAKE:
                                    switch (input5) {
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
                case CAT, TOAD, OWL -> {
                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "I see that you have a " + pet + ", why did you choose it ?");
                    Thread.sleep(2000);
                    System.out.println(GREEN_BOLD + "1. It is cute\n" + "2. It is strong\n" + "3. It is beautiful\n" + "4. It is useful\n" + "5. It is smart\n" + "6. I don't know" + RED_BOLD);
                    System.out.print("Enter a number to make your choice :\n" + RESET);
                    input4 = scanner.nextLine();
                    switch (input4) {
                        case "1", "3", "6" -> {
                            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Really... And Do you prefer Odd or Even numbers ?");
                            Thread.sleep(2000);
                            System.out.println(GREEN_BOLD + "1. Odd\n" + "2. Even\n" + "3. It doesn't matter" + RED_BOLD);
                            System.out.print("Enter a number to make your choice :\n" + RESET);
                            input5 = scanner.nextLine();
                            switch (input5) {
                                case "1", "2", "3" -> {
                                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "That's what I thought...");
                                    Thread.sleep(2000);
                                    core = Core.UNICORN_HAIR;
                                }
                                default -> System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Please focus... I will ask again from the question about the pet:");
                            }
                        }
                        case "2", "5" -> {
                            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Really... And Do you prefer Odd or Even numbers ?");
                            Thread.sleep(2000);
                            System.out.println(GREEN_BOLD + "1. Odd\n" + "2. Even\n" + "3. It doesn't matter" + RED_BOLD);
                            System.out.print("Enter a number to make your choice :\n" + RESET);
                            input5 = scanner.nextLine();
                            switch (input5) {
                                case "1", "2", "3" -> {
                                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Well, this is not the answer I was expecting...");
                                    Thread.sleep(2000);
                                    core = Core.DRAGON_HEARTSTRING;
                                }
                                default -> System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Please focus... I will ask again from the question about the pet:");
                            }
                        }
                        case "4" -> {
                            System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Really... And Do you prefer Odd or Even numbers ?");
                            Thread.sleep(2000);
                            System.out.println(GREEN_BOLD + "1. Odd\n" + "2. Even\n" + "3. It doesn't matter" + RED_BOLD);
                            System.out.print("Enter a number to make your choice :\n" + RESET);
                            input5 = scanner.nextLine();
                            switch (input5) {
                                case "1" -> {
                                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "I also prefer Odd numbers.");
                                    Thread.sleep(2000);
                                    core = Core.PHOENIX_FEATHER;
                                }
                                case "2" -> {
                                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Even numbers are beautiful, I agree.");
                                    Thread.sleep(2000);
                                    core = Core.DRAGON_HEARTSTRING;
                                }
                                case "3" -> {
                                    System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "If you say so...");
                                    Thread.sleep(2000);
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
        Thread.sleep(1000);
        System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "I think I exactly know what is the best for you.");
        Thread.sleep(2000);
        System.out.println("** Ollivander gives you a magic wand **");
        Thread.sleep(4000);
        System.out.println("** You take it, and... You feel very comfortable with it! **");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Ollivander - " + RESET + "Awesome, I knew it!");
        Thread.sleep(2000);
        System.out.println(GREEN_BOLD + "You got a " + size + "cm Wand, with a " + core + " core.\n" + RESET);

        //End of the Introduction
        Thread.sleep(3000);
        System.out.println("** You are now ready to go to Hogwarts, so you go to the platform 9 3/4 at King's Cross Station. **");
        Thread.sleep(5000);
        System.out.println("** And you take the Hogwarts™ Express's train right to Hogwarts!**");
        Thread.sleep(6000);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        Thread.sleep(1000);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        Thread.sleep(1000);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        Thread.sleep(1000);
        System.out.println("               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||\n               || ____ ||");
        Thread.sleep(1000);
        System.out.println("** Finally, you arrive at Hogwarts Castle. **");
        Thread.sleep(3000);
        System.out.println("** You follow the other students to a Great Hall, with a Sorting Hat. **");
        Thread.sleep(3000);
        System.out.println("** Now it is your turn to pass the Sorting Hat test... Good Luck! **");
        Thread.sleep(3000);
    }

    // Method to get the wizard's name
    public String getName() {
        return this.name;
    }

    // Method to get the Pet chosen by the player
    public Pet getPet() {
        return pet;
    }

    // Method to get the Wand of the player
    public int getSize() {
        return size;
    }

    public Core getCore() {
        return core;
    }
}