package org.game.spells;
import lombok.Getter;
import org.game.character.Character;
import org.game.character.Wizard;

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