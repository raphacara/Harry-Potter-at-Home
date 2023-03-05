package org.example;
import java.util.Arrays;
import java.util.List;

public class House {

    // Properties
    private String name;
    // Define a list of the four house names
    public static List<String> houseNames = Arrays.asList("Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin");

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