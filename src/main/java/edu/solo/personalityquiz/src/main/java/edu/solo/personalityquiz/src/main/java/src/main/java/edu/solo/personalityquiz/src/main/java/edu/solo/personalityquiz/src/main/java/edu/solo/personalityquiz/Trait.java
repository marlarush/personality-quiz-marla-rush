package edu.solo.personalityquiz;

/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 12-06-2025
 * Description: Enum of personality traits with a display label.
 */

public enum Trait {

    // Introvert trait.
    INTROVERT("Introvert"),

    // Extrovert trait.
    EXTROVERT("Extrovert");

    // Human-readable label for display.
    private final String label;

    // Constructs a trait with a label.
    Trait(String label) {
        this.label = label;
    }

    // Returns the display label for the trait.
    public String getLabel() {
        return label;
    }
}
