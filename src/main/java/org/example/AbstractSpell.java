package org.example;

public abstract class AbstractSpell {

    // Properties
    final private String name;
    final private int powerLevel;

    // Constructor
    public AbstractSpell(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    // Methods
    public String getName() {
        return name;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public abstract void cast(Character target);

}


