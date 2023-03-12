package org.example;
import lombok.Getter;

@Getter
public class Wand {
    private final Core core;
    private final int size;

    // Constructor
    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }
}