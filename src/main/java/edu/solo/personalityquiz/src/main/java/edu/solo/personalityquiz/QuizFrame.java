package edu.solo.personalityquiz;

/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 12-06-2025
 * Description: Minimal Swing GUI shell. Will render the current question and options.
 */

public class QuizFrame {

    // Title shown on the window.
    private String title;

    // Constructs a QuizFrame with a default title.
    public QuizFrame() {
        this.title = "Personality Quiz";
    }

    // Constructs a QuizFrame with a custom title.
    public QuizFrame(String title) {
        this.title = title;
    }

    // Returns the window title.
    public String getTitle() {
        return title;
    }

    // Sets the window title.
    public void setTitle(String title) {
        this.title = title;
    }
}
