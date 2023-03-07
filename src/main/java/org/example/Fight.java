package org.example;
import java.util.Scanner;

public class Fight implements StoryStep {
    public static final String RESET = "\u001B[0m"; //fun
    public static final String RED_BOLD = "\033[1;31m"; //fun
    public static final String GREEN_BOLD = "\033[1;32m"; //fun
    public static final String YELLOW_BOLD = "\033[1;33m"; //fun
    private final Wizard wizard;
    private Enemy enemy;
    private final Scanner scanner = new Scanner(System.in);

    public Fight(Wizard wizard, Enemy enemy) {
        this.wizard = wizard;
        this.enemy = enemy;
    }

    @Override
    public void run() {
        boolean isFinished = false;
        while (!isFinished) {
            System.out.println(YELLOW_BOLD + "\n-----------------------");
            System.out.println(wizard.getName() + ": " + wizard.getHealth() + "/" + wizard.getMaxHealth() + " hp \n        - VS -");
            System.out.println(RED_BOLD + enemy.getName() + ": " + enemy.getHealth() + "/" + enemy.getMaxHealth() + " hp");
            System.out.println(YELLOW_BOLD + "-----------------------\n" + RESET);
            // Player's turn
            System.out.println("** Your turn! **");
            System.out.println(GREEN_BOLD + "1. Cast a spell\n2. Use a potion\n3. Quit the fight" + RESET);
            String choice = scanner.nextLine();
            scanner.nextLine();
            switch (choice) {
                case "1" -> castSpell();
                case "2" -> usePotion();
                case "3" -> {
                    System.out.println("You decide to flee the fight. But as you turn around to run away, the " + enemy.getName() + " catches you and hits you hard. You die instantly.");
                    wizard.setHealth(0);
                    System.out.println("You have died. Game over!");
                    System.exit(0);
                }
                default -> System.out.println("You missed");
            }

            // Troll's turn
            System.out.println("\n** " + enemy.getName() + " turn! **");
            enemy.attack(wizard); //This method is in AbstractEnemy

            // Check if the fight is over
            if (wizard.getHealth() <= 0) {
                System.out.println("You've been defeated by the " + enemy.getName() + ". Game over!");
                System.exit(0);
                isFinished = true;
            } else if (enemy.getHealth() <= 0) {
                System.out.println("You've defeated the " + enemy.getName() + "!");
                wizard.setHealth(wizard.getMaxHealth());
                upgrade(wizard);
                isFinished = true;
            }
        }
    }

    @Override
    public Wizard getWizard() {
        return null;
    }

    private void castSpell() {
        // display spells and get user input
        System.out.println("\n-- Spells --");
        for (Spell spell : wizard.getKnownSpells()) {
            System.out.println(spell.getName());
        }
        System.out.println("-------------");
        String input = scanner.nextLine();

        // find the selected spell
        Spell selectedSpell = null;
        for (Spell spell : wizard.getKnownSpells()) {
            if (input.equalsIgnoreCase(spell.getName())) {
                selectedSpell = spell;
                break;
            }
        }

        // handle invalid input
        if (selectedSpell == null) {
            System.out.println("Invalid spell. Please try again.");
            castSpell();
            return;
        }

        // display spell description and prompt for confirmation
        System.out.println("\n" + selectedSpell.getDescription());
        System.out.println("Do you want to cast " + selectedSpell.getName() + "? (Y/N)");
        String confirm = scanner.nextLine();

        // handle user confirmation
        if (confirm.equalsIgnoreCase("Y")) {
            int damage = selectedSpell.getPowerLevel();
            System.out.println("You cast " + selectedSpell.getName() + " for " + damage + " damage.");
            enemy.takeDamage(damage);
        } else {
            castSpell();
        }
    }

    private void usePotion() {
        // display potions and get user input
        System.out.println("\n-- Potions --");
        for (Potion potion : wizard.getPotions()) {
            System.out.println(potion.getName());
        }
        System.out.println("-------------");
        String input = scanner.nextLine();

        // find the selected potion
        Potion selectedPotion = null;
        for (Potion potion : wizard.getPotions()) {
            if (input.equalsIgnoreCase(potion.getName())) {
                selectedPotion = potion;
                break;
            }
        }

        // handle invalid input
        if (selectedPotion == null) {
            System.out.println("Invalid potion. Please try again.");
            usePotion();
            return;
        }

        // display potion description and prompt for confirmation
        System.out.println("\n" + selectedPotion.getDescription());
        System.out.println("Do you want to use " + selectedPotion.getName() + "? (Y/N)");
        String confirm = scanner.nextLine();

        // handle user confirmation
        if (confirm.equalsIgnoreCase("Y")) {
            int healing = selectedPotion.getHealthPoints();
            System.out.println("You use " + selectedPotion.getName() + " for " + healing + " healing.");
            wizard.setHealth(wizard.getHealth() + healing);
        } else {
            usePotion();
        }
    }

    public void upgrade(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to upgrade your maxHealth (type '1') or your power multiplier (type '2')?");
        int choice = scanner.nextInt();
        if (choice == 1) {
            int newMaxHealth = wizard.getMaxHealth() + 10;
            wizard.setMaxHealth(newMaxHealth);
            System.out.println("Your max health has been increased to " + newMaxHealth + "!");
        } else if (choice == 2) {
            int newPowerMultiplier = (int) (wizard.getPower() + 1);
            wizard.setPower(newPowerMultiplier);
            System.out.println("Your power multiplier has been increased to " + newPowerMultiplier + "!");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}