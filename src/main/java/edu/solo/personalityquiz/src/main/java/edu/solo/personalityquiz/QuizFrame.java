/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 12-16-2025
 * Description: Swing GUI that displays questions, captures selections, and shows results.
 */

package edu.solo.personalityquiz;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;

public class QuizFrame extends JFrame {

    private final Quiz quiz;

    private final JLabel titleLabel;
    private final JLabel progressLabel;
    private final JTextArea promptArea;

    private final JPanel optionsPanel;
    private final ButtonGroup buttonGroup;

    private final JButton backButton;
    private final JButton nextButton;
    private final JButton submitButton;

    // Creates the quiz window and sets up the UI.
    public QuizFrame(Quiz quiz) {
        super("Personality Quiz — Introvert vs Extrovert");
        this.quiz = quiz;

        titleLabel = new JLabel("Personality Quiz", SwingConstants.CENTER);
        progressLabel = new JLabel("", SwingConstants.LEFT);
        promptArea = new JTextArea();

        optionsPanel = new JPanel(new GridLayout(0, 1, 8, 8));
        buttonGroup = new ButtonGroup();

        backButton = new JButton("Back");
        nextButton = new JButton("Next");
        submitButton = new JButton("Submit");

        buildWindow();

        wireButtons();

        refreshScreen();
    }

    // Builds the window layout and components.
    private void buildWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(12, 12));
        setResizable(false);

        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));
        add(titleLabel, BorderLayout.NORTH);

        JPanel center = new JPanel(new BorderLayout(10, 10));

        promptArea.setEditable(false);
        promptArea.setLineWrap(true);
        promptArea.setWrapStyleWord(true);
        promptArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(promptArea);
        center.add(scroll, BorderLayout.NORTH);
        center.add(optionsPanel, BorderLayout.CENTER);

        add(center, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(progressLabel, BorderLayout.WEST);

        JPanel nav = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        nav.add(backButton);
        nav.add(nextButton);
        nav.add(submitButton);

        bottom.add(nav, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);
    }

    // Connects button actions to quiz navigation and submission.
    private void wireButtons() {
        backButton.addActionListener(e -> {
            quiz.prev();
            refreshScreen();
        });

        nextButton.addActionListener(e -> {
            if (ensureAnswered()) {
                quiz.next();
                refreshScreen();
            }
        });

        submitButton.addActionListener(e -> {
            if (!quiz.allAnswered() && !ensureAnswered()) {
                return;
            }
            showResults();
        });
    }

    // Updates the screen with the current question and options.
    private void refreshScreen() {
        int index = quiz.getCurrentIndex();
        Question q = quiz.currentQuestion();

        progressLabel.setText("Question " + (index + 1) + " / " + quiz.size());

        promptArea.setText(q.getPrompt());

        rebuildOptions(q.getOptions(), index);

        backButton.setEnabled(quiz.canGoPrev());
        nextButton.setEnabled(quiz.canGoNext());
        submitButton.setEnabled(!quiz.canGoNext());
    }

    // Rebuilds the option radio buttons for the current question.
    private void rebuildOptions(List<Option> options, int questionIndex) {
        optionsPanel.removeAll();
        buttonGroup.clearSelection();

        int selected = quiz.getSelectionFor(questionIndex);

        for (int i = 0; i < options.size(); i++) {
            Option opt = options.get(i);
            JRadioButton rb = new JRadioButton(opt.getText());
            int optionIndex = i;

            rb.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));

            rb.addActionListener(e -> quiz.setSelectionForCurrent(optionIndex));

            if (selected == i) {
                rb.setSelected(true);
            }

            buttonGroup.add(rb);
            optionsPanel.add(rb);
        }

        optionsPanel.revalidate();
        optionsPanel.repaint();
    }

    // Ensures the current question has a selected answer.
    private boolean ensureAnswered() {
        int index = quiz.getCurrentIndex();
        if (quiz.getSelectionFor(index) < 0) {
            JOptionPane.showMessageDialog(this, "Please pick an answer before continuing.");
            return false;
        }
        return true;
    }

    // Displays the final results dialog and offers restart.
    private void showResults() {
        Map<Trait, Integer> scores = quiz.score();
        Trait winner = quiz.winner();

        String message =
                "Result: " + winner.getLabel() + "\n\n" +
                quiz.winnerDescription() + "\n\n" +
                "Scores:\n" +
                "Introvert: " + scores.get(Trait.INTROVERT) + "\n" +
                "Extrovert: " + scores.get(Trait.EXTROVERT);

        int choice = JOptionPane.showConfirmDialog(this, message + "\n\nPlay again?", "Your Result",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            Quiz fresh = new Quiz(Quiz.defaultBank());
            QuizFrame frame = new QuizFrame(fresh);
            frame.setVisible(true);
            dispose();
        }
    }
}
