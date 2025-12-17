/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 12-16-2025
 * Description: Represents one answer choice and the trait it supports.
 */

package edu.solo.personalityquiz;

public class Option {

    private String text;
    private Trait traitAward;

    // Creates a blank option (defaults to Introvert).
    public Option() {
        this.text = "";
        this.traitAward = Trait.INTROVERT;
    }

    // Creates an option with text and the trait it awards.
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

    // Returns the trait awarded by this option.
    public Trait getTraitAward() {
        return traitAward;
    }

    // Sets the trait awarded by this option.
    public void setTraitAward(Trait traitAward) {
        this.traitAward = traitAward;
    }
}
