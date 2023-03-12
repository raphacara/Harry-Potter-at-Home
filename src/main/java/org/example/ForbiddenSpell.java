package org.example;

public class ForbiddenSpell extends AbstractSpell {
    // Create Sells (protected because there are instance, more than attributes, that I might need everywhere without creating a new Spell).
    protected static final ForbiddenSpell avadaKedavra = new ForbiddenSpell("Avada Kedavra", 999999, 50, "killing curse.");
    protected static final ForbiddenSpell crucio = new ForbiddenSpell("Crucio", 0, 50, "Cruciatus curse.");
    protected static final ForbiddenSpell imperio = new ForbiddenSpell("Imperio", 0, 50, "Imperius curse.");

    // Constructor
    public ForbiddenSpell(String name, int powerLevel, int accuracy, String description) {
        super(name, powerLevel, accuracy, description);
    }

    // Methods
    @Override
    public void cast(Wizard wizard, Character target) {
        // Implement the behavior for casting a forbidden spell
        // This could include damaging the target or causing some other negative effect
    }
}