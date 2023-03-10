package org.example;
import java.util.Random;
import java.util.Scanner;

public class Fight implements StoryStep {
    private static final String RESET = "\u001B[0m"; //fun
    private static final String RED_BOLD = "\033[1;31m"; //fun
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String YELLOW_BOLD = "\033[1;33m"; //fun
    private final Wizard wizard; //The wizard
    private final Enemy enemy; //The enemy
    private boolean isFinished = false; //Checking is the fight is finished
    private final Scanner scanner = new Scanner(System.in); //to scan the inputs

    public Fight(Wizard wizard, Enemy enemy) {
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
            System.out.println("~~ Your turn! ~~");
            System.out.println(GREEN_BOLD + "1. Cast a spell\n2. Use a potion\n3. Run away" + RESET);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> castSpell();
                case "2" -> usePotion();
                case "3" -> System.out.println("You decide to flee the fight. But as you turn around to run away, the " + enemy.getName() + " catches you...");
                default -> System.out.println("You missed your choice...");
            }
            threadSleep(2000);
            ifDead(wizard, enemy); // Check if the fight is over

            //-- TROLL's TURN
            if (!isFinished) {
                System.out.println(RED_BOLD + "\n~~ " + enemy.getName() + " turn! ~~" + RESET);
                threadSleep(2000);
                if (enemy.isAttacking()) { // If isAttacking = true -> if the enemy is able to attack
                    enemy.attack(wizard); // This method is in AbstractEnemy
                    threadSleep(1000);
                } else {
                    enemy.setIsAttacking(true);
                    System.out.println("You blocked the attack!");
                }
                ifDead(wizard, enemy); // Check if the fight is over
                threadSleep(1000);
            }
        }
    }

    @Override
    public Wizard getWizard() {
        return null;
    }

    private void ifDead(Wizard wizard, AbstractEnemy enemy) {
        if (wizard.getHealth() <= 0) {
            System.out.println("** You have been defeated by the " + enemy.getName() + ". Game over! **");
            System.exit(0);
            isFinished = true;
        } else if (enemy.getHealth() <= 0) {
            System.out.println("** You have defeated the " + enemy.getName() + "! **");
            upgrade(wizard);
            isFinished = true;
        }
    }

    private void castSpell() {
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
                selectedPotion.usePotion(wizard);
                wizard.setHealth(wizard.getHealth() + selectedPotion.getHealthPoints());
                break; //break after setting selectedPotion
            }
        }
        if (selectedPotion == null) { //Check if a potion was selected
            System.out.println("This potion does not exist.");
        }
    }

    public void upgrade(Wizard wizard) {
        wizard.setHealth(wizard.getMaxHealth()); //Putting the Heath of the player to the max
        System.out.println(RED_BOLD + "\nWhat do you want to upgrade?");
        System.out.println(GREEN_BOLD + "1. Hp\n2. Damage\n3. Accuracy\n4. Botanist");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                int newMaxHealth = wizard.getMaxHealth() + 10;
                wizard.setMaxHealth(newMaxHealth);
                System.out.println(GREEN_BOLD + "** You have gained +10hp! **" + RESET);
            }
            case 2 -> {
                int newPower = wizard.getPower() + 5;
                wizard.setPower(newPower);
                System.out.println(GREEN_BOLD + "** You have gained +5 of power! **" + RESET);
            }
            case 3 -> {
                int newAccuracy = wizard.getAccuracy() + 5;
                wizard.setAccuracy(newAccuracy);
                System.out.println(GREEN_BOLD + "** You have gained +5 of accuracy!" + RESET);
            }
            case 4 -> {
                int newBotanist = wizard.getBotanist() + 5;
                wizard.setBotanist(newBotanist);
                System.out.println(GREEN_BOLD + "** You have gained +5 of healing points!" + RESET);
            }
            default -> System.out.println("Don't miss an upgrade!");
        }
    }

    public void checkingSpell(Spell spell) { //Checking how to kill each enemy
        if (enemy.getName().equals("Troll") && spell.getName().equals("Wingardium Leviosa")) {
            System.out.println("\nYou are casting Wingardium Leviosa on the Troll");
            threadSleep(2000);
            System.out.println("You make his mass to levitate... Just above the Troll's head...");
            threadSleep(3000);
            System.out.println("And BOOM! The mass falls right on the his head!");
            threadSleep(2000);
            int damage = new Random().nextInt(51) + 50; //random number between 50 and 100
            System.out.println("It deals " + damage + " damage!");
            enemy.takeDamage(damage); //method in Character class.
        }
        else {
            spell.cast(wizard, enemy);
            threadSleep(2000);
        }
    }

    public void threadSleep(int time) { //To use it in the while loop otherwise it is "busy waiting"
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}