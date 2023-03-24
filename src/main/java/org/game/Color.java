package org.game;

public enum Color {
    RESET("\u001B[0m"), //fun
    BLACK("\033[1;30m"), //fun
    RED("\033[1;31m"), //fun
    GREEN("\033[1;32m"), //fun
    YELLOW("\033[1;33m"), //fun
    BLUE("\033[1;34m"); //fun

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String toString() {
        return color;
    }
}
