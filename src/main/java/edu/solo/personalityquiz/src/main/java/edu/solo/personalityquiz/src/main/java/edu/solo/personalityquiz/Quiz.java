package edu.solo.personalityquiz;

import java.util.ArrayList;
import java.util.List;

/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 12-06-2025
 * Description: Stores questions, tracks selected option indexes, and will compute results.
 */

public class Quiz {

    // Bank of questions used by the quiz.
    private List<Question> questions;

    // Selected option index per question (-1 means unanswered).
    private List<Integer> selections;

    // Constructs an empty quiz with no questions.
    public Quiz() {
        this.questions = new ArrayList<>();
        this.selections = new ArrayList<>();
    }

    // Constructs a quiz with a provided list of questions; selections are initialized to -1.
    public Quiz(List<Question> questions) {
        this.questions = new ArrayList<>(questions);
        this.selections = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            this.selections.add(-1);
        }
    }

    // Returns the list of questions.
    public List<Question> getQuestions() {
        return questions;
    }

    // Replaces the question bank and resets selections to -1 accordingly.
    public void setQuestions(List<Question> questions) {
        this.questions = new ArrayList<>(questions);
        this.selections = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            this.selections.add(-1);
        }
    }

    // Returns the selections list (option index per question).
    public List<Integer> getSelections() {
        return selections;
    }

    // Sets the selection for a specific question index.
    public void setSelection(int questionIndex, int optionIndex) {
        if (questionIndex >= 0 && questionIndex < selections.size()) {
            selections.set(questionIndex, optionIndex);
        }
    }
}
