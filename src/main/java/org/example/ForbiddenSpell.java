package org.example;

public class ForbiddenSpell extends AbstractSpell {

    // Constructor
    public ForbiddenSpell(String name, int powerLevel, int accuracy, String description) {
        super(name, powerLevel, accuracy, description);
    }

    // Methods
    @Override
    public void cast(Wizard wizard, AbstractEnemy target) {
        // Implement the behavior for casting a forbidden spell
        // This could include damaging the target or causing some other negative effect
    }
}