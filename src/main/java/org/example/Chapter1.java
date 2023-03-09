package org.example;
import java.util.Objects;
import java.util.Scanner;

public class Chapter1  implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String BLUE_BOLD = "\033[1;34m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String BLACK_BOLD = "\033[1;30m"; //fun
    private static Wizard wizard;
    private static final String[] input = {"1","2","3","4","5","6","7","8"}; //the player inputs
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private boolean check = false; //checking the loops
    private final boolean[] classesTaken = new boolean[6]; //changing to true when the player take a lesson

    // Create a new instance of Sells and Potions
    Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 0, 80, "It makes objects to levitate, but it does not work on the enemy.");
    Spell lumos = new Spell("Lumos", 0, 100, "It makes light!");
    Spell protego = new Spell("Protego", 0, 75, "It will protect you.");
    Potion wiggenweld = new Potion("Wiggenweld", 40, "A potion that instantly heals by restoring some health.");

    //Constructor
    public Chapter1(Wizard player) {
        wizard = player;
    }

    @Override
    public void run() throws InterruptedException {
        //-- Intro of Chapter 1 --
        System.out.println(GREEN_BOLD + "\n----------------- Chapter 1 -----------------");
        Thread.sleep(1000);
        System.out.println("---------- The Philosopher’s Stone -----------\n" + RESET);
        Thread.sleep(2000);
        System.out.println("** You are in your first year at Hogwarts. **");
        Thread.sleep(2000);
        System.out.println("** Your school is a huge castle full of magic. **");
        Thread.sleep(2000);
        System.out.println("** But you can not do what you want, you are a student and you have class today. **");
        Thread.sleep(3000);
        System.out.println("** So you go to the Great Hall because it's the perfect place to eat, work, and meet. **");
        Thread.sleep(4000);
        System.out.println("** Furthermore, there is the headmaster of hogwarts, Albus Dumbledore, who says: **\n");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Dear students, welcome to Hogwarts!");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Here, you can choose the classes you want to take.");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Let me present them to you:\n");
        Thread.sleep(3000);
        System.out.println(BLACK_BOLD + "CHARMS: " + RESET + "A course that teaches the casting and effects of charms, which are spells that alter the properties of an object or creature.");
        Thread.sleep(500);
        System.out.println(BLACK_BOLD + "DEFENSE AGAINST THE DARK ARTS: " + RESET + "A course that teaches the defense against dark creatures, spells, and curses.");
        Thread.sleep(500);
        System.out.println(BLACK_BOLD + "HERBOLOGY: " + RESET + "A course that teaches the study and cultivation of magical plants.");
        Thread.sleep(500);
        System.out.println(BLACK_BOLD + "HISTORY OF MAGIC: " + RESET + "A course that teaches the history of magic and magical events.");
        Thread.sleep(500);
        System.out.println(BLACK_BOLD + "POTIONS: " + RESET + "A course that teaches the brewing of magical potions, which can have various effects on the drinker.\n");
        Thread.sleep(5000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You will not be able to participate in all classes.");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "So choose well...");
        Thread.sleep(2000);

        //-- 1st lesson --
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + wizard.getName() + ", what are you going to choose for your first class?");
        chooseClass();
        Thread.sleep(2000);
        System.out.println("\n** The year goes on and it is almost Christmas. **");
        Thread.sleep(3000);

        //-- Learning Wingardium Leviosa --
        System.out.println("** Meanwhile, You went to see Hagrid who lives in a small hut between the castle and the forest. **\n");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Hey " + wizard.getName() + "! I hope you like your experience here :)");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "I am happy you are a " + wizard.getHouse() + " by the way, it fits you well.");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Oh, I'll give you a little help, by teaching you a new spell!");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "It is a charm used to levitate objects: Wingardium Leviosa.");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "But you have to pronounce it well, try it.");
        Thread.sleep(1000);
        System.out.println(RED_BOLD + "Write the spell to learn it :" + RESET);
        while (true) {
            input[0] = scanner.nextLine();
            if (input[0].equals("Wingardium Leviosaaa")) {
                break;
            } else {
                System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Haha! This one is tricky. Try: Wingardium Leviosaaa");
            }
        }
        wizard.learnSpell(wingardiumLeviosa);
        System.out.println(BLUE_BOLD + "\nHagrid - " + RESET + "Well done " + wizard.getName() + "!");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "\nHagrid - " + RESET + "Next time you will be able to write it with one 'a'.");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Hagrid - " + RESET + "Go back to the castle for your next class.\n");
        Thread.sleep(2000);

        //-- 2nd lesson --
        System.out.println("** You are going to attend your last lesson before the Christmas holidays. **\n");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Which class are you going to choose this time?");
        chooseClass();
        Thread.sleep(2000);
        System.out.println("\n** Just after the lesson, you want to go to the toilet. **");
        Thread.sleep(2000);

        //-- Troll battle --
        System.out.println("** You find yourself in a dark and damp toilet, next to the dungeon. **");
        Thread.sleep(3000);
        System.out.println("** Suddenly, you hear loud footsteps approaching. **");
        Thread.sleep(3000);
        System.out.println("** As you turn around, you see a huge troll blocking the exit. You have no choice but to fight for your life! **");
        Thread.sleep(4000);
        System.out.println(RED_BOLD + "\nTroll - " + RESET + "Raaargh!");
        Thread.sleep(2000);
        Enemy troll = new Enemy("Troll", 150, 30); //Creating a Troll
        wizard.attack(troll); //attacking the troll
        System.out.println("\n** The year goes on and it is now almost the end of the year **");
        Thread.sleep(3000);

        //-- 3rd lesson
        System.out.println("** You have to do a last lesson before the end of the year. **\n");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "This is going to be your last class, which one will you choose?");
        chooseClass();
        Thread.sleep(2000);

        // End
        System.out.println("\n** This is the end of the year, so all the students meet in the Great Hall. **\n");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "It is time to say which house was the best this year.");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Before that, I would like to thanks " + wizard.getName() + " for beating the troll this year.");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "And I give 50 points to " + wizard.getHouse() + "!");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "So the winning House of this year is...");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + wizard.getHouse() + "!");
        Thread.sleep(2000);
        System.out.println("\n** Chapter 1 - THE END **\n");
        Thread.sleep(2000);
    }

    //To get the wizard's infos back
    @Override
    public Wizard getWizard() {
        return wizard;
    }

    //Algorithm to let the player choose a class (I use it 3 times in the story)
    public void chooseClass() throws InterruptedException {
        boolean ok = check;
        while (check == ok) {
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
            check = !ok;
            switch (input[1]) {
                case "1" :
                    if (classesTaken[1]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the Charms class.");
                        check = ok;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Charms class is always interesting.");
                        charmsClass();
                    }
                    break;
                case "2":
                    if (classesTaken[2]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the Defense Against the Dark Arts class.");
                        check = ok;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "I think that you have a warrior's soul.");
                        defenseClass();
                    }
                    break;
                case "3":
                    if (classesTaken[3]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the Herbology class.");
                        check = ok;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You must love plants.");
                        herbologyClass();
                    }
                    break;
                case "4":
                    if (classesTaken[4]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the History of Magic class.");
                        check = ok;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Who likes history class?");
                        historyClass();
                    }
                    break;
                case "5":
                    if (classesTaken[5]) {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have already taken the Potions class.");
                        check = ok;
                    } else {
                        System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "Nice, that is always useful.");
                        potionsClass();
                    }
                    break;
                default :
                    System.out.println(BLUE_BOLD + "Dumbledore - " + RESET + "You have to choose a class. -10 points for " + wizard.getHouse()+ "!");
                    check = ok;
            }
        }
    }

    //The 5 lessons method
    public void charmsClass() throws InterruptedException {
        classesTaken[1] = true;
        Thread.sleep(2000);
        System.out.println("\n** And so you are going to the Charms class **");
        Thread.sleep(3000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println(BLACK_BOLD + "            ~~~   CHARMS   ~~~\n" + RESET);
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "Welcome to the Charms class!");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "Today, we will learn how to make light with your wand.");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "There is a charm for that, it is called: Lumos.");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "Let's try to learn it.");
        Thread.sleep(2000);
        System.out.println(RED_BOLD + "Write Lumos to learn the spell :" + RESET);
        while (true) {
            input[3] = scanner.nextLine();
            if (input[3].equals("Lumos")) {
                break;
            } else {
                System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "It is not exactly that, write: Lumos");
            }
        }
        wizard.learnSpell(lumos);
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "\nCharms Teacher - " + RESET + "Wonderful!");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Charms Teacher - " + RESET + "It is the end of the lesson. Thank you.");
    }

    public void defenseClass() throws InterruptedException {
        classesTaken[2] = true;
        Thread.sleep(2000);
        System.out.println("\n** Without wasting time, you are going to the Defense Against the Dark Arts class **");
        Thread.sleep(3000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println(BLACK_BOLD + "~~~   DEFENSE AGAINST THE DARK ARTS   ~~~\n" + RESET);
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Defense Teacher - " + RESET + "Welcome to the Defense Against the Dark Arts class!");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Defense Teacher - " + RESET + "Today we will learn one of the most important and useful spell.");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Defense Teacher - " + RESET + "A spell that protects you for a moment: Protego");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Defense Teacher - " + RESET + "Practice it to learn it.");
        Thread.sleep(2000);
        System.out.println(RED_BOLD + "Write Protego to learn the spell :" + RESET);
        while (true) {
            input[4] = scanner.nextLine();
            if (input[4].equals("Protego")) {
                break;
            } else {
                System.out.println(BLUE_BOLD + "Defense Teacher - " + RESET + "It is not so easy, i know.");
            }
        }
        wizard.learnSpell(protego);
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "\nDefense Teacher - " + RESET + "Fabulous");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Defense Teacher - " + RESET + "We will stop for today. Thank you.");
    }

    public void herbologyClass() throws InterruptedException {
        classesTaken[3] = true;
        Thread.sleep(2000);
        System.out.println("\n** Anyway, you are going to the Herbology class **");
        Thread.sleep(3000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println(BLACK_BOLD + "          ~~~   HERBOLOGY   ~~~\n" + RESET);
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Herbology Teacher - " + RESET + "Welcome to the Herbology class!");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Herbology Teacher - " + RESET + "Today, We will see the benefits of plants.\n");
        Thread.sleep(3000);
        System.out.println("** The Herbology Teacher is showing you how to take care of magical plants **");
        Thread.sleep(4000);
        if (Objects.equals(wizard.getHouse(), "Hufflepuff")) {
            System.out.println("** And it is really interesting! **");
            Thread.sleep(2000);
            System.out.println("** you have gained a bonus of 20hp. **");
            Thread.sleep(1000);
            wizard.setMaxHealth(wizard.getMaxHealth() + 20);
        } else {
            System.out.println("** But you don't really understand the lesson... **");
            Thread.sleep(2000);
            System.out.println("** Still, that was resourceful **");
            Thread.sleep(2000);
            System.out.println("** you have gained a bonus of 10hp. **");
            Thread.sleep(1000);
            wizard.setMaxHealth(wizard.getMaxHealth() + 10);
        }
        System.out.println(GREEN_BOLD + "** Your health is now " + wizard.getHealth() + "hp! **" + RESET);
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "\nHerbology Teacher - " + RESET + "Perfect, that will be enough for today. See you next time!");

    }
    public void historyClass() throws InterruptedException {
        classesTaken[4] = true;
        Thread.sleep(2000);
        System.out.println("\n** Whatever, you are going to the History of Magic class **");
        Thread.sleep(3000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println(BLACK_BOLD + "       ~~~   HISTORY OF MAGIC   ~~~\n" + RESET);
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Welcome to the History of Magic class!");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Today, we will be studying the story of the four founders of Hogwarts School of Witchcraft and Wizardry.");
        Thread.sleep(4000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "In the 10th century, four powerful wizards : Godric Gryffindor, Helga Hufflepuff, Rowena Ravenclaw, and Salazar Slytherin.");
        Thread.sleep(5000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "They came together to create a school where young witches and wizards could learn and hone their magical skills.");
        Thread.sleep(5000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Each of the founders valued different qualities in their students, and they created separate houses within the school to reflect these values.");
        Thread.sleep(5000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Gryffindor valued bravery and chivalry, Hufflepuff valued hard work and loyalty, Ravenclaw valued intelligence and wit, and Slytherin valued ambition and cunning.");
        Thread.sleep(5000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "Over the centuries, Hogwarts has grown and evolved, but the four houses founded by the school's founders have remained at the heart of its culture and tradition.");
        Thread.sleep(5000);
        System.out.println(BLUE_BOLD + "History Teacher - " + RESET + "In this class, we will explore the story of the four founders and the legacy they left behind, as well as the role that Hogwarts has played in shaping the course of magical history.\n");
        Thread.sleep(5000);
        System.out.println("**    Zzz... **");
        Thread.sleep(5000);
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
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "\nHistory Teacher - " + RESET + "Thank you all for your attention.\n");
    }

    public void potionsClass() throws InterruptedException {
        classesTaken[5] = true;
        Thread.sleep(2000);
        System.out.println("\n** On these beautiful words, you are going to the Potions class **");
        Thread.sleep(3000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        Thread.sleep(1000);
        System.out.println(BLACK_BOLD + "           ~~~   POTIONS   ~~~\n" + RESET);
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Potions Teacher - " + RESET + "Welcome to the Potions class! My name is Severus Snape.");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Professor Snape - " + RESET + "This will probably be your most important class of the year.");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Professor Snape - " + RESET + "Well, today we will learn a potion that can heal you.");
        Thread.sleep(3000);
        System.out.println(BLUE_BOLD + "Professor Snape - " + RESET + "This potion is called: Wiggenweld");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Professor Snape - " + RESET + wizard.getName()+"! What do you need to make such a potion?");
        Thread.sleep(2000);
        boolean loop = true;
        while (loop) {
            System.out.println(GREEN_BOLD + "1. A cauldron\n" + "2. Ingredients\n" + "3. Heat source" + RED_BOLD);
            System.out.println("Enter a number to make your choice :" + RESET);
            input[7] = scanner.nextLine();
            switch (input[7]) {
                case "1", "2", "3" -> {
                    System.out.println(BLUE_BOLD + "Professor Snape - " + RESET + "Well, that's not wrong, " + wizard.getName() + ".");
                    loop = false;
                }
                default ->
                        System.out.println(BLUE_BOLD + "Professor Snape - " + RESET + "That is not correct, try again.");
            }
        }
        wizard.learnPotion(wiggenweld);
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "\nProfessor Snape - " + RESET + "Not bad.");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Professor Snape - " + RESET + "This potion will be useful later, believe me.");
        Thread.sleep(2000);
        System.out.println(BLUE_BOLD + "Professor Snape - " + RESET + "But that's it for today, thank you.");
    }
}