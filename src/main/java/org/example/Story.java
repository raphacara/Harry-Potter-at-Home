package org.example;
import java.util.ArrayList;
import java.util.List;

public class Story {

    // Properties
    private List<StoryStep> steps;

    // Constructor
    public Story() {
        this.steps = new ArrayList<>();
    }

    // Method to add a step to the story
    public void addStep(StoryStep step) {
        steps.add(step);
    }
    // Method to remobe a step from the story
    public void removeStepp(StoryStep step) {
        steps.remove(step);
    }

    // Method to run the story
    public void run() throws InterruptedException {
        for (StoryStep step : steps) {
            step.run();
        }
    }
}

