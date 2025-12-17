/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 12-16-2026
 * Description: Enum of personality traits with a display label.
 */

package edu.solo.personalityquiz;

public enum Trait {

    // Introvert trait.
    INTROVERT("Introvert"),

    // Extrovert trait.
    EXTROVERT("Extrovert");

    private final String label;

    // Creates a Trait with a display label.
    Trait(String label) {
        this.label = label;
    }

    // Returns the display label for the trait.
    public String getLabel() {
        return label;
    }
}

