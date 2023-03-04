package org.example;

public class Spell extends AbstractSpell {

    // Constructor
    public Spell(String name, int powerLevel, int accuracy, String description) {
        super(name, powerLevel, accuracy, description);
    }

    // Methods
    @Override
    public void cast(Character target) {
        // Implement the behavior for casting a spell
        // This could include damaging the target or causing some other effect
    }
}
