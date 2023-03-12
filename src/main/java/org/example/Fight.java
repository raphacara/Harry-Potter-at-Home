package org.example;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Fight implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String YELLOW_BOLD = "\033[1;33m"; //fun
    private final Wizard wizard; //The wizard
    private final Character enemy; //The enemy
    private boolean isFinished = false; //Checking is the fight is finished
    boolean firstAttack = true; //a check when it is the 1st round of a fight
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs

    public Fight(Wizard wizard, Character enemy) {
        this.wizard = wizard;
        this.enemy = enemy;
    }

    @Override
    public void run() throws InterruptedException {
        while (!isFinished) { //Fight loop
            //-- INFOS --
            System.out.println("\n-----------------------" + YELLOW_BOLD);
            System.out.println(wizard.getName() + ": " + wizard.getHealth() + "/" + wizard.getMaxHealth() + " hp" + RESET +"\n        - VS -");
            System.out.println(RED_BOLD + enemy.getName() + ": " + enemy.getHealth() + "/" + enemy.getMaxHealth() + " hp");
            System.out.println(RESET + "-----------------------\n");
            threadSleep(1000);

            //-- PLAYER's TURN --
            System.out.println("~~~~~~~~~~ Your turn! ~~~~~~~~~~");
            if (wizard.isAttacking()) {
                System.out.println(GREEN_BOLD + "1. Cast a spell\n2. Use a potion\n3. Run away" + RESET);
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> castSpell();
                    case "2" -> usePotion();
                    case "3" -> System.out.println("You decide to flee the fight. But as you turn around to run away, the " + enemy.getName() + " catches you...");
                    default -> System.out.println("You missed your choice...");
                }
            }
            threadSleep(1000);
            ifDead(wizard, enemy); // Check if the fight is over

            //-- ENEMY's TURN
            enemyTurn();
            checkingBoss(); //Do different things regarding which boss you are fighting.
            threadSleep(1000);
        }
        upgrade(wizard);
    }

    //The method when it is the enemy turn in a fight
    public void enemyTurn() throws InterruptedException {
        if (!isFinished) {
            System.out.println(RED_BOLD + "\n~~~~~~~~~~ " + enemy.getName() + " turn! ~~~~~~~~~~" + RESET);
            threadSleep(2000);
            if (enemy.isAttacking()) { // If isAttacking = true -> if the enemy is able to attack
                enemy.attack(wizard); // This method is in AbstractEnemy
                threadSleep(1000);
            } else {
                checkingCondition();
            }
            if (Objects.equals(enemy.getCondition(), "burned")) {
                int damage = 10 + wizard.getPower();
                enemy.takeDamage(damage);
                System.out.println("The enemy is burned and loose " + damage + "hp!");
                threadSleep(1000);
            }
            ifDead(wizard, enemy); // Check if the fight is over
        }
    }

    //To check if someone is dead
    private void ifDead(Wizard wizard, Character enemy) {
        if (wizard.getHealth() <= 0) {
            System.out.println("\n** You have been defeated by the " + enemy.getName() + ". Game over! **");
            System.exit(0);
            isFinished = true;
        } else if (enemy.getHealth() <= 0) {
            System.out.println("\n** You have defeated the " + enemy.getName() + "! **");
            isFinished = true;
        }
    }

    //Method to cast a spell
    private void castSpell() throws InterruptedException {
        // List of spells
        System.out.println("\n--- Spells ---");
        for (Spell spell : wizard.getKnownSpells()) {
            System.out.println(spell.getName());
        }
        System.out.println("---------------");

        // Choosing a spell
        System.out.println(RED_BOLD + "Write the spell you want to use :" + RESET);
        String input = scanner.nextLine();
        Spell selectedSpell = null;
        for (Spell spell : wizard.getKnownSpells()) {
            if (input.equalsIgnoreCase(spell.getName())) {
                selectedSpell = spell;
                checkingSpell(selectedSpell); //checking the way to kill the enemy
                break;
            }
        }
        if (selectedSpell == null) {
            System.out.println("You missed the spell.");
        }
    }

    //Method to use a potion
    private void usePotion() {
        //List of potions
        System.out.println("\n--- Potions ---");
        for (Potion potion : wizard.getPotions()) {
            System.out.println(potion.getName());
        }
        System.out.println("---------------");
        //Choosing a potion
        System.out.println(RED_BOLD + "\nWrite the potion you want to use :" + RESET);
        String input = scanner.nextLine();
        Potion selectedPotion = null; //Initialize selectedPotion to null
        for (Potion potion : wizard.getPotions()) {
            if (input.equalsIgnoreCase(potion.getName())) {
                selectedPotion = potion;
                int heal = selectedPotion.getHealthPoints();
                System.out.println("You recover " + heal + " hp!");
                wizard.healing(heal);
                break; //break after setting selectedPotion
            }
        }
        if (selectedPotion == null) { //Check if a potion was selected
            System.out.println("This potion does not exist.");
        }
    }

    //Method to check if a specific spell is used in a fight
    public void checkingSpell(Spell spell) throws InterruptedException { //Checking how to kill each enemy
        if (enemy.getName().equals("Troll") && spell.getName().equalsIgnoreCase("Wingardium Leviosa")) {
            System.out.println("\nYou are casting Wingardium Leviosa on the Troll");
            threadSleep(2000);
            System.out.println("You make his mass to levitate... Just above the Troll's head...");
            threadSleep(3000);
            System.out.println("And BOOM! The mass falls right on the his head!");
            threadSleep(2000);
            int damage = new Random().nextInt(51) + 50; //random number between 50 and 100
            System.out.println("It deals " + damage + " damage!");
            enemy.takeDamage(damage); //method in Character class.
        } else if (enemy.getName().equals("Basilisk") && spell.getName().equalsIgnoreCase("Accio")) {
            firstAttack = false;
            System.out.println("You attract a Basilisk tooth with Accio!");
            threadSleep(2000);
            System.out.println("Now you try to pierce the Basilisk skin with his own tooth.");
            threadSleep(2000);
            basiliskFight("sharp tooth");
        } else {
            System.out.println(spell.getDescription());
            threadSleep(2000);
            spell.cast(wizard, enemy);
            threadSleep(2000);
        }
    }

    //Method to check if character can fight or if a spell prevents it
    public void checkingCondition() throws InterruptedException {
        Random random = new Random();
        int luck = random.nextInt(100) + 1;
        int damage;
        if (Objects.equals(enemy.getCondition(), "Protego")) {
            System.out.println("Protego protected you!");
            threadSleep(1000);
            if (luck <= (33 + wizard.getAccuracy())) {
                damage = 10 + wizard.getPower();
                System.out.println("And it returns " + damage + " damage to the " + enemy.getName() + "!");
                enemy.takeDamage(damage);
                threadSleep(1000);
            }
            enemy.setAttacking(true);
        }
        if (Objects.equals(enemy.getCondition(), "Expelliarmus")) {
            if (luck <= (33 + wizard.getAccuracy())) {
                System.out.println("Expelliarmus prevents the " + enemy.getName() + " from attacking!");
                threadSleep(1000);
            } else {
                enemy.attack(wizard); // This method is in AbstractEnemy
                threadSleep(1000);
            }
            enemy.setAttacking(true);
        }
        if (Objects.equals(enemy.getCondition(), "Incendio")) {
            if (luck <= (50 + wizard.getAccuracy())) {
                enemy.setCondition("burned");
                System.out.println("The " + enemy.getName() + " is burned!");
                threadSleep(1000);
            }
            enemy.attack(wizard); // This method is in AbstractEnemy
            threadSleep(1000);
        }
    }

    //Method to check when there is a specific fight against a boss
    public void checkingBoss() throws InterruptedException {
        if (Objects.equals(enemy.getName(), "Basilisk")) {
            if (Objects.equals(wizard.getHouse(), "Gryffindor")) {
                System.out.println("You see a Phoenix flying over you and dropping the Sorting Hat next to you.");
                threadSleep(2000);
                System.out.println("And in the Sorting Hat, you discover a shiny and sharp sword.");
                threadSleep(2000);
                System.out.println("You quickly grab the sword, notice that -GRYFFINDOR- is written on it, and continue the fight...");
                threadSleep(3000);
                System.out.println("~~ Your turn! ~~"); //-- PLAYER's TURN --
                System.out.println(GREEN_BOLD + "1. Sword strike on the Basilisk\n2. Drop the sword and fight without it" + RESET);
                boolean check = false;
                while (!check) {
                    check = true;
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "1" -> basiliskFight("Gryffindor Sword");
                        case "2" -> {
                            enemyTurn();
                            run();
                        }
                        default -> {
                            System.out.println("You missed your choice...");
                            check = false;
                        }
                    }
                }
                threadSleep(1000);
            } else if (firstAttack) {
                System.out.println("During the attack, the Basilisk loose a huge tooth that gets stuck in a wall.");
                threadSleep(2000);
                System.out.println("If you could attract the tooth to you, it might help you to kill the snake...");
                threadSleep(2000);
                firstAttack = false;
            }
        }
        //if (another boss)
    }

    public void basiliskFight(String weapon) throws InterruptedException {
        System.out.println("So you are attacking the Basilisk with the " + weapon + "!");
        threadSleep(2000);
        System.out.println("You plant it in his skin!");
        threadSleep(1000);
        System.out.println("It deals 300 damage!");
        enemy.takeDamage(300);
        threadSleep(2000);
        // -- Enemy Turn --
        System.out.println("The Basilisk tries a last attack.");
        enemyTurn();
        if (wizard.getHealth() == 0) {
            wizard.setHealth(1);
            System.out.println("But you hold on with 1hp!");
        }
        // -- Infos --
        System.out.println("\n-----------------------" + YELLOW_BOLD);
        System.out.println(wizard.getName() + ": " + wizard.getHealth() + "/" + wizard.getMaxHealth() + " hp" + RESET +"\n        - VS -");
        System.out.println(RED_BOLD + enemy.getName() + ": " + enemy.getHealth() + "/" + enemy.getMaxHealth() + " hp");
        System.out.println(RESET + "-----------------------\n");
        threadSleep(1000);
        //-- PLAYER's TURN --
        System.out.println("~~~~~~~~~~ Your turn! ~~~~~~~~~~");
        threadSleep(1000);
        System.out.println("You put all your strength in your attack and the " + weapon + " pierce the Basilisk!");
        threadSleep(3000);
        System.out.println("It kills it instantly!");
        enemy.setHealth(0);
    }

    //Method get rewarded at the end of a fight
    public void upgrade(Wizard wizard) {
        wizard.setHealth(wizard.getMaxHealth()); //Putting the Heath of the player to the max
        System.out.println(RED_BOLD + "\nWhat do you want to upgrade?");
        System.out.println(GREEN_BOLD + "1. Hp\n2. Damage\n3. Accuracy\n4. Botanist");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                int newMaxHealth = wizard.getMaxHealth() + 5;
                wizard.setMaxHealth(newMaxHealth);
                System.out.println(GREEN_BOLD + "** You have gained +5hp! **" + RESET);
            }
            case 2 -> {
                int newPower = wizard.getPower() + 1;
                wizard.setPower(newPower);
                System.out.println(GREEN_BOLD + "** You have gained +1 of power! **" + RESET);
            }
            case 3 -> {
                int newAccuracy = wizard.getAccuracy() + 1;
                wizard.setAccuracy(newAccuracy);
                System.out.println(GREEN_BOLD + "** You have gained +1 of accuracy!" + RESET);
            }
            case 4 -> {
                int newBotanist = wizard.getBotanist() + 1;
                wizard.setBotanist(newBotanist);
                System.out.println(GREEN_BOLD + "** You have gained +1 of healing points!" + RESET);
            }
            default -> System.out.println("Don't miss an upgrade!");
        }
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }

    public void threadSleep(int time) { //To use it in the while loop otherwise it is "busy waiting"
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}