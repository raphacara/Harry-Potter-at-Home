package org.example;

public abstract class AbstractSpell {

    // Properties
    final private String name;
    final private int powerLevel;
    final private int accuracy;
    final private String description;

    // Constructor
    public AbstractSpell(String name, int powerLevel, int accuracy, String description) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.accuracy = accuracy;
        this.description = description;
    }

    // Methods
    public String getName() {
        return name;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getDescription() {
        return description;
    }

    public abstract void cast(Character target);
}


