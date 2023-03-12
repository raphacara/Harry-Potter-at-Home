package org.example;
import lombok.Getter;

@Getter
public abstract class AbstractSpell {

    // Properties
    private final String name;
    private final int powerLevel;
    private final int accuracy;
    private final String description;

    // Constructor
    public AbstractSpell(String name, int powerLevel, int accuracy, String description) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.accuracy = accuracy;
        this.description = description;
    }

    // Methods
    public abstract void cast(Wizard wizard, Character target);
}