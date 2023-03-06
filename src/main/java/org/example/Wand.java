package org.example;

public class Wand {

    // Properties
    private final Core core;
    private final int size;

    // Constructor
    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }

    // Getters and setters
    public Core getCore() {
        return core;
    }

    public int getSize() {
        return size;
    }
}