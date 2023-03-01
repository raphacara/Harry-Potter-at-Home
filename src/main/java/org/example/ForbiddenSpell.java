package org.example;

public class ForbiddenSpell extends AbstractSpell {

    // Constructor
    public ForbiddenSpell(String name, int powerLevel) {
        super(name, powerLevel);
    }

    // Methods
    @Override
    public void cast(Character target) {
        // Implement the behavior for casting a forbidden spell
        // This could include damaging the target or causing some other negative effect
    }
}

