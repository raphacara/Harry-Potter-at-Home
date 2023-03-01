package org.example;

public class Wand {

    // Properties
    private Core core;
    private int size;

    // Constructor
    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }

    // Getters and setters
    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
