package org.example;
import java.util.Arrays;
import java.util.List;

public class House {

    // Properties
    private String name; // Name of the House
    protected static List<String> houseNames = Arrays.asList("Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"); // Define a list of the four house names

    // Constructor
    public House(String name) {
        this.name = name;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}