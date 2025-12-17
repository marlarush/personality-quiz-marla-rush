/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 12-16-2025
 * Description: Represents a quiz question and its list of answer options.
 */

package edu.solo.personalityquiz;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String prompt;
    private List<Option> options;

    // Creates a blank question with an empty option list.
    public Question() {
        this.prompt = "";
        this.options = new ArrayList<>();
    }

    // Creates a question with a prompt and an empty option list.
    public Question(String prompt) {
        this.prompt = prompt;
        this.options = new ArrayList<>();
    }

    // Creates a question with a prompt and initial options.
    public Question(String prompt, List<Option> options) {
        this.prompt = prompt;
        this.options = new ArrayList<>(options);
    }

    // Adds an option and returns this question for chaining.
    public Question addOption(String text, Trait traitAward) {
        this.options.add(new Option(text, traitAward));
        return this;
    }

    // Returns the prompt text.
    public String getPrompt() {
        return prompt;
    }

    // Sets the prompt text.
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    // Returns the list of options.
    public List<Option> getOptions() {
        return options;
    }

    // Replaces the list of options.
    public void setOptions(List<Option> options) {
        this.options = new ArrayList<>(options);
    }
}
