package edu.solo.personalityquiz;

import java.util.ArrayList;
import java.util.List;

/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 12-06-2025
 * Description: Represents a single question and its list of answer options.
 */

public class Question {

    // The question prompt shown to the user.
    private String prompt;

    // The set of answer options for this question.
    private List<Option> options;

    // Constructs a blank question with no options.
    public Question() {
        this.prompt = "";
        this.options = new ArrayList<>();
    }

    // Constructs a question with a prompt and a starting list of options.
    public Question(String prompt, List<Option> options) {
        this.prompt = prompt;
        this.options = new ArrayList<>(options);
    }

    // Returns the question prompt.
    public String getPrompt() {
        return prompt;
    }

    // Sets the question prompt.
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

    // Adds a single option to the end of the options list.
    public void addOption(Option option) {
        this.options.add(option);
    }
}
