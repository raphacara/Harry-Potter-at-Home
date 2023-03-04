package org.example;
import java.util.Scanner;

public class Chapter1  implements StoryStep {
    public static final String RESET = "\u001B[0m"; //fun
    public static final String RED_BOLD = "\033[1;31m"; //fun
    public static final String BLUE_BOLD = "\033[1;34m"; //fun
    public static final String GREEN_BOLD = "\033[1;32m"; //fun
    public static final String BLACK_BOLD = "\033[1;30m"; //fun
    private static Wizard wizard;
    private static final String[] input = {"1","2","3","4","5","6","7","8"}; //the player inputs
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private int check = 0; //checking the loops
    private final boolean[] classesTaken = new boolean[6]; //changing to true when the player take a lesson

    // Create a new instance of spells
    Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 0, 80,
            "This spell causes objects to levitate, but deals no damage by itself.");

    //Constructor
    public Chapter1(Wizard player) {
        wizard = player;
    }

    @Override
    public void run() throws InterruptedException {
        //Chapter 1
        Thread.sleep(2000);
        System.out.println(GREEN_BOLD + "\n----------------- Chapter 1 -----------------");
        Thread.sleep(1000);
        System.out.println("---------- The Philosopher’s Stone -----------\n" + RESET);
        Thread.sleep(3000);
        System.out.println("** You are in your first year at Hogwarts. **");
        Thread.sleep(2000);
        System.out.println("** Your school is a huge castle full of magic. **");
        Thread.sleep(3000);
        System.out.println("** There are ghosts and secret passages hidden everywhere. **");
        Thread.sleep(3000);
        System.out.println("** But you can't do what you want, you are a student and you have class today. **");
        Thread.sleep(4000);
        System.out.println("** So you go to the Great Hall because it's the perfect place to eat, work, and meet. **");
        Thread.sleep(5000);
        System.out.println("** Furthermore, there is the headmaster of hogwarts, Albus Dumbledore, who says: **\n");
        Thread.sleep(5000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Dear students, welcome to Hogwarts!");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Here, you can choose the classes you want to take.");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Let me present them to you:\n");
        Thread.sleep(4000);
        System.out.println(BLACK_BOLD + "CHARMS: " + RESET + "A course that teaches the casting and effects of charms, which are spells that alter the properties of an object or creature.");
        Thread.sleep(5000);
        System.out.println(BLACK_BOLD + "DEFENSE AGAINST THE DARK ARTS: " + RESET + "A course that teaches the defense against dark creatures, spells, and curses.");
        Thread.sleep(4000);
        System.out.println(BLACK_BOLD + "HERBOLOGY: " + RESET + "A course that teaches the study and cultivation of magical plants.");
        Thread.sleep(4000);
        System.out.println(BLACK_BOLD + "HISTORY OF MAGIC: " + RESET + "A course that teaches the history of magic and magical events.");
        Thread.sleep(4000);
        System.out.println(BLACK_BOLD + "POTIONS: " + RESET + "A course that teaches the brewing of magical potions, which can have various effects on the drinker.\n");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You will not be able to participate in all classes.");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "So choose well. I recommend Charms class...");
        Thread.sleep(3000);
        // 1st lesson
        while (check == 0) {
            System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + wizard.getName() + ", what are you going to choose for your first class?");
            System.out.println(GREEN_BOLD + "1. CHARMS \n" + "2. DEFENSE AGAINST THE DARK ARTS\n" + "3. HERBOLOGY\n" + "4. HISTORY OF MAGIC\n" + "5. POTIONS" + RED_BOLD);
            System.out.print("Enter a number to make your choice :\n" + RESET);
            input[0] = scanner.nextLine();
            check = 1;
            switch (input[0]) {
                case "1" :
                    System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Charms class is the best one!");
                    charmsClass(); //calling the method of this lesson
                    break;
                case "2":
                    System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "I think that you have a warrior's soul.");
                    defenseClass(); //calling the method of this lesson
                    break;
                case "3":
                    System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You must love nature.");
                    herbologyClass(); //calling the method of this lesson
                    break;
                case "4":
                    System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Who likes history class?");
                    historyClass(); //calling the method of this lesson
                    break;
                case "5":
                    System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Nice, that is always useful.");
                    potionsClass(); //calling the method of this lesson
                    break;
                default :
                    System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have to choose a class. -10 points for " + wizard.getHouse()+ "!");
                    check = 0;
            }
        }
        Thread.sleep(3000);
        System.out.println("\n** The year goes on and it is almost Christmas. **");
        Thread.sleep(4000);
        System.out.println("** You are going to attend your last lesson before the Christmas holidays. **\n");
        Thread.sleep(4000);
        // 2nd lesson
        while (check == 1) {
            System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Which class are you going to choose this time?");
            System.out.print(GREEN_BOLD);
            if (!classesTaken[1]) { // hiding if the lesson was taken before
                System.out.println("1. CHARMS");
            }
            if (!classesTaken[2]) {
                System.out.println("2. DEFENSE AGAINST THE DARK ARTS");
            }
            if (!classesTaken[3]) {
                System.out.println("3. HERBOLOGY");
            }
            if (!classesTaken[4]) {
                System.out.println("4. HISTORY OF MAGIC");
            }
            if (!classesTaken[5]) {
                System.out.println("5. POTIONS");
            }
            System.out.print(RED_BOLD + "Enter a number to make your choice :\n" + RESET);
            input[1] = scanner.nextLine();
            check = 0;
            switch (input[1]) {
                case "1" :
                    if (classesTaken[1]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the Charms class.");
                        check = 1;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Charms class is the best one!");
                        charmsClass();
                        break;
                    }
                case "2":
                    if (classesTaken[2]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the History of Magic class.");
                        check = 1;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "I think that you have a warrior's soul.");
                        defenseClass();
                        break;
                    }
                case "3":
                    if (classesTaken[3]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the History of Magic class.");
                        check = 1;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You must love nature.");
                        herbologyClass();
                        break;
                    }
                case "4":
                    if (classesTaken[4]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the History of Magic class.");
                        check = 1;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Who likes history class?");
                        historyClass();
                        break;
                    }
                case "5":
                    if (classesTaken[5]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the History of Magic class.");
                        check = 1;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Nice, that is always useful.");
                        potionsClass();
                        break;
                    }
                default :
                    System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have to choose a class. -20 points for " + wizard.getHouse()+ "!");
                    check = 1;
            }
        }
        Thread.sleep(3000);
        System.out.println("\n** The year goes on and it is now almost the end of the year **");
        Thread.sleep(4000);
        System.out.println("** You have to do a last lesson **\n");
        Thread.sleep(4000);
        // 3rd lesson
        while (check == 0) {
            System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "This is going to be your last class, which one will you choose?");
            System.out.print(GREEN_BOLD);
            if (!classesTaken[1]) { // hiding if the lesson was taken before
                System.out.println("1. CHARMS");
            }
            if (!classesTaken[2]) {
                System.out.println("2. DEFENSE AGAINST THE DARK ARTS");
            }
            if (!classesTaken[3]) {
                System.out.println("3. HERBOLOGY");
            }
            if (!classesTaken[4]) {
                System.out.println("4. HISTORY OF MAGIC");
            }
            if (!classesTaken[5]) {
                System.out.println("5. POTIONS");
            }
            System.out.print(RED_BOLD + "Enter a number to make your choice :\n" + RESET);
            input[1] = scanner.nextLine();
            check = 1;
            switch (input[1]) {
                case "1" :
                    if (classesTaken[1]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the Charms class.");
                        check = 0;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Charms class is the best one!");
                        charmsClass();
                        break;
                    }
                case "2":
                    if (classesTaken[2]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the History of Magic class.");
                        check = 0;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "I think that you have a warrior's soul.");
                        defenseClass();
                        break;
                    }
                case "3":
                    if (classesTaken[3]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the History of Magic class.");
                        check = 0;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You must love nature.");
                        herbologyClass();
                        break;
                    }
                case "4":
                    if (classesTaken[4]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the History of Magic class.");
                        check = 0;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Who likes history class?");
                        historyClass();
                        break;
                    }
                case "5":
                    if (classesTaken[5]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the History of Magic class.");
                        check = 0;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Nice, that is always useful.");
                        potionsClass();
                        break;
                    }
                default :
                    System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have to choose a class. -20 points for " + wizard.getHouse()+ "!");
                    check = 0;
            }
        }
        Thread.sleep(3000);
        System.out.println("\n** This is the end of the year, well done ! **");
        Thread.sleep(4000);

    }

    public static Wizard getWizard() {
        return wizard;
    }

    public void charmsClass() throws InterruptedException {
        classesTaken[1] = true;
        Thread.sleep(2000);
        System.out.println("** Anyway, you are going to the Charms class **");
        Thread.sleep(4000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
        // Call the learnSpell() method of the wizard object to add the new spell to the list of known spells
        wizard.learnSpell(wingardiumLeviosa);
    }

    public void defenseClass() throws InterruptedException {
        classesTaken[2] = true;
        Thread.sleep(2000);
        System.out.println("** Anyway, you are going to the Defense Against the Dark Arts class **");
        Thread.sleep(4000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
    }

    public void herbologyClass() throws InterruptedException {
        classesTaken[3] = true;
        Thread.sleep(2000);
        System.out.println("** Anyway, you are going to the Herbology class **");
        Thread.sleep(4000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
    }
    public void historyClass() throws InterruptedException {
        classesTaken[4] = true;
        Thread.sleep(2000);
        System.out.println("** Anyway, you are going to the History of Magic class **");
        Thread.sleep(4000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Welcome to the History of Magic class!");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Today, we will be studying the story of the four founders of Hogwarts School of Witchcraft and Wizardry.");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "In the 10th century, four powerful wizards : Godric Gryffindor, Helga Hufflepuff, Rowena Ravenclaw, and Salazar Slytherin.");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "They came together to create a school where young witches and wizards could learn and hone their magical skills.");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Each of the founders valued different qualities in their students, and they created separate houses within the school to reflect these values.");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Gryffindor valued bravery and chivalry, Hufflepuff valued hard work and loyalty, Ravenclaw valued intelligence and wit, and Slytherin valued ambition and cunning.");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Over the centuries, Hogwarts has grown and evolved, but the four houses founded by the school's founders have remained at the heart of its culture and tradition.");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "In this class, we will explore the story of the four founders and the legacy they left behind, as well as the role that Hogwarts has played in shaping the course of magical history.");
        Thread.sleep(4000);
        System.out.println("**    Zzz... **");
        Thread.sleep(4000);
        System.out.print(RED_BOLD + "Press 1 to wake up :\n" + RESET);
        while (true) {
            input[6] = scanner.nextLine();
            if (input[6].equals("1")) {
                break;
            } else {
                System.out.println("**    Zzz... **");
            }
        }
        System.out.println("** You wake up, the class has just ended. **");
    }

    public void potionsClass() throws InterruptedException {
        classesTaken[5] = true;
        Thread.sleep(2000);
        System.out.println("** Anyway, you are going to the Potions class **");
        Thread.sleep(4000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
        System.out.println("          | |\n          | |\n          | |\n          | |\n          | |\n          | |\n          | |");
        Thread.sleep(2000);
    }

}
