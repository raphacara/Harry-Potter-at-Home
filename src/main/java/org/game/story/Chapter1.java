package org.game.story;
import org.game.Color;
import org.game.GameContent;
import org.game.attributes.House;
import org.game.character.Wizard;

import java.util.Scanner;

public class Chapter1  implements StoryStep {
    private boolean check = false; //checking the loops
    private final String[] input = {"1","2","3","4","5","6","7","8"}; //the player inputs
    private final boolean[] classesTaken = new boolean[7]; //changing to true when the player take a lesson
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs
    private final Wizard wizard;
    private final GameContent game = new GameContent(); //to have access to the game content

    //Constructor
    public Chapter1(Wizard player) {
        wizard = player;
    }

    @Override
    public void runStory() {
        //-- Intro of Chapter 1 --
        System.out.println(Color.GREEN + "----------------- Chapter 1 -----------------");
        threadSleep(200);
        System.out.println("---------- The Philosopher’s Stone -----------\n" + Color.RESET);
        threadSleep(1000);
        System.out.println("** You are in your first year at Hogwarts. **");
        threadSleep(200);
        System.out.println("** Your school is a huge castle full of magic. **");
        threadSleep(200);
        System.out.println("** But you can not do what you want, you are a student and you have class today. **");
        threadSleep(200);
        System.out.println("** So you go to the Great Hall because it's the perfect place to eat, work, and meet. **");
        threadSleep(200);
        System.out.println("** Furthermore, there is the headmaster of hogwarts, Albus Dumbledore, who says: **");
        waiting();
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "Dear students, welcome to Hogwarts!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "Here, you can choose the classes you want to take.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "Let me present them to you:\n");
        threadSleep(200);
        System.out.println(Color.BLACK + "CHARMS: " + Color.RESET + "A course that teaches the casting and effects of charms, which are spells that alter the properties of an object or creature.");
        threadSleep(200);
        System.out.println(Color.BLACK + "DEFENSE AGAINST THE DARK ARTS: " + Color.RESET + "A course that teaches the defense against dark creatures, spells, and curses.");
        threadSleep(200);
        System.out.println(Color.BLACK + "HERBOLOGY: " + Color.RESET + "A course that teaches the study and cultivation of magical plants.");
        threadSleep(200);
        System.out.println(Color.BLACK + "HISTORY OF MAGIC: " + Color.RESET + "A course that teaches the history of magic and magical events.");
        threadSleep(200);
        System.out.println(Color.BLACK + "POTIONS: " + Color.RESET + "A course that teaches the brewing of magical potions, which can have various effects on the drinker.");
        waiting();
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "You will not be able to participate in all classes.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "So choose well...");
        threadSleep(200);

        //-- 1st lesson --
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + wizard.getName() + ", what are you going to choose for your first class?");
        chooseClass();
        waiting();
        System.out.println("** The year goes on and it is almost Christmas. **");
        waiting();

        //-- Learning Wingardium Leviosa --
        System.out.println("** Meanwhile, You went to see Hagrid who lives in a small hut between the castle and the forest. **\n");
        threadSleep(200);
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Hey " + wizard.getName() + "! I hope you like your experience here :)");
        threadSleep(200);
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "I am happy you are a " + wizard.getHouse() + " by the way, it fits you well.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Oh, I'll give you a little help, by teaching you a new spell!");
        waiting();
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "It is a charm used to levitate objects: Wingardium Leviosa.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "But you have to pronounce it well, try it.");
        threadSleep(200);
        System.out.println(Color.RED + "Write the spell to learn it :" + Color.RESET);
        while (true) {
            input[0] = scanner.nextLine();
            if (input[0].equalsIgnoreCase("Wingardium Leviosaaa")) {
                break;
            } else {
                System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Haha! This one is tricky. Try: Wingardium Leviosaaa");
            }
        }
        wizard.learnSpell(game.spell("Wingardium Leviosa"));
        System.out.println(Color.BLUE + "\nHagrid - " + Color.RESET + "Well done " + wizard.getName() + "!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Next time you will be able to write it with one 'a' at the end.");
        waiting();
        System.out.println(Color.BLUE + "Hagrid - " + Color.RESET + "Go back to the castle for your next class.\n");
        threadSleep(200);

        //-- 2nd lesson --
        System.out.println("** You are going to attend your last lesson before the Christmas holidays. **\n");
        threadSleep(200);
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "Which class are you going to choose this time?");
        chooseClass();
        waiting();
        System.out.println("** Just after the lesson, you want to go to the toilet. **");
        waiting();

        //-- Troll battle --
        System.out.println("** You find yourself in a dark and damp toilet, next to the dungeon. **");
        threadSleep(200);
        System.out.println("** Suddenly, you hear loud footsteps approaching. **");
        threadSleep(200);
        System.out.println("** As you turn around, you see a huge troll blocking the exit. You have no choice but to fight for your life! **");
        waiting();
        System.out.println(Color.RED + "Troll - " + Color.RESET + "Raaargh!");
        threadSleep(200);
        wizard.attack(game.enemy("Troll")); //attacking the troll
        System.out.println("** The year goes on and it is now almost the end of the year **");
        waiting();

        //-- 3rd lesson
        System.out.println("** You have to do a last lesson before the end of the year. **\n");
        threadSleep(200);
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "This is going to be your last class, which one will you choose?");
        chooseClass();
        waiting();

        // End
        System.out.println("\n** This is the end of the year, so all the students meet in the Great Hall. **\n");
        threadSleep(200);
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "It is time to say which house was the best this year.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "Before that, I would like to thanks " + wizard.getName() + " for beating the troll this year.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "And I give 50 points to " + wizard.getHouse() + "!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "So the winning House of this year is...");
        waiting();
        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + wizard.getHouse() + "!");
        waiting();
        System.out.println("\n** Chapter 1 - THE END **\n");
        threadSleep(1000);
    }

    //Algorithm to let the player choose a class (I use it 3 times in the story)
    public void chooseClass() {
        boolean ok = check;
        while (check == ok) {
            System.out.print(Color.GREEN);
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
            System.out.println("6. Skip class");
            System.out.print(Color.RED + "Enter a number to make your choice :\n" + Color.RESET);
            input[1] = scanner.nextLine();
            check = !ok;
            switch (input[1]) {
                case "1" :
                    if (classesTaken[1]) {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "You have already taken the Charms class.");
                        check = ok;
                    } else {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "Charms class is always interesting.");
                        charmsClass();
                    }
                    break;
                case "2":
                    if (classesTaken[2]) {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "You have already taken the Defense Against the Dark Arts class.");
                        check = ok;
                    } else {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "I think that you have a warrior's soul.");
                        defenseClass();
                    }
                    break;
                case "3":
                    if (classesTaken[3]) {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "You have already taken the Herbology class.");
                        check = ok;
                    } else {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "You must love plants.");
                        herbologyClass();
                    }
                    break;
                case "4":
                    if (classesTaken[4]) {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "You have already taken the History of Magic class.");
                        check = ok;
                    } else {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "Who likes history class?");
                        historyClass();
                    }
                    break;
                case "5":
                    if (classesTaken[5]) {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "You have already taken the Potions class.");
                        check = ok;
                    } else {
                        System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "Nice, that is always useful.");
                        potionsClass();
                    }
                    break;
                case "6":
                    System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "As you want.");
                    break;
                default :
                    System.out.println(Color.BLUE + "Dumbledore - " + Color.RESET + "You have to choose a class. -10 points for " + wizard.getHouse()+ "!");
                    check = ok;
            }
        }
    }

    //The 5 lessons method
    public void charmsClass() {
        classesTaken[1] = true;
        threadSleep(200);
        System.out.println("\n** And so you are going to the Charms class **");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println(Color.BLACK + "            ~~~   CHARMS   ~~~\n" + Color.RESET);
        threadSleep(1000);
        System.out.println(Color.BLUE + "Charms Teacher - " + Color.RESET + "Welcome to the Charms class!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Charms Teacher - " + Color.RESET + "Today, we will learn how to make light with your wand.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Charms Teacher - " + Color.RESET + "There is a charm for that, it is called: Lumos.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Charms Teacher - " + Color.RESET + "Let's try to learn it.");
        threadSleep(200);
        System.out.println(Color.RED + "Write Lumos to learn the spell :" + Color.RESET);
        while (true) {
            input[3] = scanner.nextLine();
            if (input[3].equalsIgnoreCase("Lumos")) {
                break;
            } else {
                System.out.println(Color.BLUE + "Charms Teacher - " + Color.RESET + "It is not exactly that, write: Lumos");
            }
        }
        wizard.learnSpell(game.spell("Lumos"));
        threadSleep(200);
        System.out.println(Color.BLUE + "\nCharms Teacher - " + Color.RESET + "Wonderful!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Charms Teacher - " + Color.RESET + "It is the end of the lesson. Thank you.");
    }

    public void defenseClass() {
        classesTaken[2] = true;
        threadSleep(200);
        System.out.println("\n** Without wasting time, you are going to the Defense Against the Dark Arts class **");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println(Color.BLACK + "~~~   DEFENSE AGAINST THE DARK ARTS   ~~~\n" + Color.RESET);
        threadSleep(1000);
        System.out.println(Color.BLUE + "Defense Teacher - " + Color.RESET + "Welcome to the Defense Against the Dark Arts class!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Defense Teacher - " + Color.RESET + "Today we will learn one of the most important and useful spell.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Defense Teacher - " + Color.RESET + "A spell that protects you for a moment: Protego");
        threadSleep(200);
        System.out.println(Color.BLUE + "Defense Teacher - " + Color.RESET + "Practice it to learn it.");
        threadSleep(200);
        System.out.println(Color.RED + "Write Protego to learn the spell :" + Color.RESET);
        while (true) {
            input[4] = scanner.nextLine();
            if (input[4].equalsIgnoreCase("Protego")) {
                break;
            } else {
                System.out.println(Color.BLUE + "Defense Teacher - " + Color.RESET + "It is not so easy, i know.");
            }
        }
        wizard.learnSpell(game.spell("Protego"));
        threadSleep(200);
        System.out.println(Color.BLUE + "\nDefense Teacher - " + Color.RESET + "Fabulous");
        threadSleep(200);
        System.out.println(Color.BLUE + "Defense Teacher - " + Color.RESET + "We will stop for today. Thank you.");
    }

    public void herbologyClass() {
        classesTaken[3] = true;
        threadSleep(200);
        System.out.println("\n** Anyway, you are going to the Herbology class **");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println(Color.BLACK + "          ~~~   HERBOLOGY   ~~~\n" + Color.RESET);
        threadSleep(1000);
        System.out.println(Color.BLUE + "Herbology Teacher - " + Color.RESET + "Welcome to the Herbology class!");
        threadSleep(200);
        System.out.println(Color.BLUE + "Herbology Teacher - " + Color.RESET + "Today, We will see the benefits of plants.\n");
        threadSleep(200);
        System.out.println("** The Herbology Teacher is showing you how to take care of magical plants **");
        waiting();
        if (wizard.getHouse() == House.Hufflepuff) {
            System.out.println("** And it is really interesting! **");
            threadSleep(200);
            System.out.println("** you have gained a bonus of 20hp. **");
            threadSleep(200);
            wizard.setMaxHealth(wizard.getMaxHealth() + 20);
        } else {
            System.out.println("** But you don't really understand the lesson... **");
            threadSleep(200);
            System.out.println("** Still, that was resourceful **");
            threadSleep(200);
            System.out.println("** you have gained a bonus of 10hp. **");
            threadSleep(200);
            wizard.setMaxHealth(wizard.getMaxHealth() + 10);
        }
        System.out.println(Color.GREEN + "** Your health is now " + wizard.getHealth() + "hp! **" + Color.RESET);
        threadSleep(200);
        System.out.println(Color.BLUE + "\nHerbology Teacher - " + Color.RESET + "Perfect, that will be enough for today. See you next time!");

    }
    public void historyClass() {
        classesTaken[4] = true;
        threadSleep(200);
        System.out.println("\n** Whatever, you are going to the History of Magic class **");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println(Color.BLACK + "       ~~~   HISTORY OF MAGIC   ~~~\n" + Color.RESET);
        threadSleep(1000);
        System.out.println(Color.BLUE + "History Teacher - " + Color.RESET + "Welcome to the History of Magic class!");
        threadSleep(2000);
        System.out.println(Color.BLUE + "History Teacher - " + Color.RESET + "Today, we will be studying the story of the four founders of Hogwarts School of Witchcraft and Wizardry.");
        threadSleep(3000);
        System.out.println(Color.BLUE + "History Teacher - " + Color.RESET + "In the 10th century, four powerful wizards : Godric Gryffindor, Helga Hufflepuff, Rowena Ravenclaw, and Salazar Slytherin.");
        threadSleep(3000);
        System.out.println(Color.BLUE + "History Teacher - " + Color.RESET + "They came together to create a school where young witches and wizards could learn and hone their magical skills.");
        threadSleep(3000);
        System.out.println(Color.BLUE + "History Teacher - " + Color.RESET + "Each of the founders valued different qualities in their students, and they created separate houses within the school to reflect these values.");
        threadSleep(4000);
        System.out.println(Color.BLUE + "History Teacher - " + Color.RESET + "Gryffindor valued bravery and chivalry, Hufflepuff valued hard work and loyalty, Ravenclaw valued intelligence and wit, and Slytherin valued ambition and cunning.");
        threadSleep(4000);
        System.out.println(Color.BLUE + "History Teacher - " + Color.RESET + "Over the centuries, Hogwarts has grown and evolved, but the four houses founded by the school's founders have remained at the heart of its culture and tradition.");
        threadSleep(4000);
        System.out.println(Color.BLUE + "History Teacher - " + Color.RESET + "In this class, we will explore the story of the four founders and the legacy they left behind, as well as the role that Hogwarts has played in shaping the course of magical history.\n");
        threadSleep(4000);
        System.out.println("**    Zzz... **");
        waiting();
        System.out.println("** You wake up, the class has just ended. **");
        threadSleep(200);
        System.out.println(Color.BLUE + "\nHistory Teacher - " + Color.RESET + "Thank you all for your attention.\n");
    }

    public void potionsClass() {
        classesTaken[5] = true;
        threadSleep(200);
        System.out.println("\n** On these beautiful words, you are going to the Potions class **");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println("                   | |\n                   | |\n                   | |\n                   | |\n                   | |");
        threadSleep(200);
        System.out.println(Color.BLACK + "           ~~~   POTIONS   ~~~\n" + Color.RESET);
        threadSleep(1000);
        System.out.println(Color.BLUE + "Potions Teacher - " + Color.RESET + "Welcome to the Potions class! My name is Severus Snape.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Professor Snape - " + Color.RESET + "This will probably be your most important class of the year.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Professor Snape - " + Color.RESET + "Well, today we will learn a potion that can heal you.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Professor Snape - " + Color.RESET + "This potion is called: Wiggenweld");
        threadSleep(200);
        System.out.println(Color.BLUE + "Professor Snape - " + Color.RESET + wizard.getName()+"! What do you need to make such a potion?");
        threadSleep(200);
        boolean loop = true;
        while (loop) {
            System.out.println(Color.GREEN + "1. A cauldron\n" + "2. Ingredients\n" + "3. Heat source" + Color.RED);
            System.out.println("Enter a number to make your choice :" + Color.RESET);
            input[7] = scanner.nextLine();
            switch (input[7]) {
                case "1", "2", "3" -> {
                    System.out.println(Color.BLUE + "Professor Snape - " + Color.RESET + "Well, that's not wrong, " + wizard.getName() + ".");
                    loop = false;
                }
                default ->
                        System.out.println(Color.BLUE + "Professor Snape - " + Color.RESET + "That is not correct, try again.");
            }
        }
        wizard.learnPotion(game.potion("Wiggenweld"));
        threadSleep(200);
        System.out.println(Color.BLUE + "\nProfessor Snape - " + Color.RESET + "Not bad.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Professor Snape - " + Color.RESET + "This potion will be useful later, believe me.");
        threadSleep(200);
        System.out.println(Color.BLUE + "Professor Snape - " + Color.RESET + "But that's it for today, thank you.");
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }  //To get the wizard's infos back
}