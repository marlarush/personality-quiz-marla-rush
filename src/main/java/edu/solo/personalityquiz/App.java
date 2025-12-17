/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 2025-12-16
 * Description: Entry point that launches the Swing GUI.
 */

package edu.solo.personalityquiz;

import java.awt.EventQueue;

public class App {

    // Launches the Personality Quiz application.
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Quiz quiz = new Quiz(Quiz.defaultBank());
            QuizFrame frame = new QuizFrame(quiz);
            frame.setVisible(true);
        });
    }
}
