package org.example;

public abstract class AbstractSpell {

    // Properties
    final private String name;
    private int powerLevel;
    private int accuracy;
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

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getDescription() {
        return description;
    }

    public abstract void cast(Character target);
}