package org.example;

public class Spell extends AbstractSpell {

    // Constructor
    public Spell(String name, int powerLevel) {
        super(name, powerLevel);
    }

    // Methods
    @Override
    public void cast(Character target) {
        // Implement the behavior for casting a spell
        // This could include damaging the target or causing some other effect
    }
}
