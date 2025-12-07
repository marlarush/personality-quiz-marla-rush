package edu.solo.personalityquiz;

/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 12-06-2025
 * Description: Represents one answer choice and the trait it supports.
 */

public class Option {

    // The visible text of the answer choice.
    private String text;

    // The trait awarded when this option is selected.
    private Trait traitAward;

    // Constructs a blank option (no text, defaults to INTROVERT).
    public Option() {
        this.text = "";
        this.traitAward = Trait.INTROVERT;
    }

    // Constructs an option with text and the trait it awards.
    public Option(String text, Trait traitAward) {
        this.text = text;
        this.traitAward = traitAward;
    }

    // Returns the option text.
    public String getText() {
        return text;
    }

    // Sets the option text.
    public void setText(String text) {
        this.text = text;
    }

    // Returns the awarded trait.
    public Trait getTraitAward() {
        return traitAward;
    }

    // Sets the awarded trait.
    public void setTraitAward(Trait traitAward) {
        this.traitAward = traitAward;
    }
}
