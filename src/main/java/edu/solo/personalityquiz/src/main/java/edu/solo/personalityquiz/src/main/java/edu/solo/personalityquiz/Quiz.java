/*
 * Project: Personality Quiz (Java Swing) — Introvert vs Extrovert
 * Author: Marla Rush
 * Date: 2025-12-16
 * Description: Stores questions, tracks selections, and calculates the final result.
 */

package edu.solo.personalityquiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Quiz {

    private final List<Question> questions;
    private final int[] selections;
    private int currentIndex;

    // Creates a quiz using a provided question bank.
    public Quiz(List<Question> questionBank) {
        this.questions = new ArrayList<>(questionBank);
        this.selections = new int[this.questions.size()];
        Arrays.fill(this.selections, -1);
        this.currentIndex = 0;
    }

    // Returns the number of questions in the quiz.
    public int size() {
        return questions.size();
    }

    // Returns the current question index.
    public int getCurrentIndex() {
        return currentIndex;
    }

    // Returns the current question.
    public Question currentQuestion() {
        return questions.get(currentIndex);
    }

    // Returns the selected option index for a specific question.
    public int getSelectionFor(int questionIndex) {
        return selections[questionIndex];
    }

    // Sets the selection for the current question.
    public void setSelectionForCurrent(int optionIndex) {
        selections[currentIndex] = optionIndex;
    }

    // Returns true if the quiz can move to the next question.
    public boolean canGoNext() {
        return currentIndex < questions.size() - 1;
    }

    // Returns true if the quiz can move to the previous question.
    public boolean canGoPrev() {
        return currentIndex > 0;
    }

    // Moves to the next question if possible.
    public void next() {
        if (canGoNext()) {
            currentIndex++;
        }
    }

    // Moves to the previous question if possible.
    public void prev() {
        if (canGoPrev()) {
            currentIndex--;
        }
    }

    // Returns true if every question has been answered.
    public boolean allAnswered() {
        for (int s : selections) {
            if (s < 0) {
                return false;
            }
        }
        return true;
    }

    // Calculates and returns the score map for each trait.
    public Map<Trait, Integer> score() {
        Map<Trait, Integer> scores = new EnumMap<>(Trait.class);
        scores.put(Trait.INTROVERT, 0);
        scores.put(Trait.EXTROVERT, 0);

        for (int i = 0; i < questions.size(); i++) {
            int sel = selections[i];
            if (sel >= 0) {
                Trait awarded = questions.get(i).getOptions().get(sel).getTraitAward();
                scores.put(awarded, scores.get(awarded) + 1);
            }
        }
        return scores;
    }

    // Returns the winning trait based on the current score.
    public Trait winner() {
        Map<Trait, Integer> scores = score();
        int iScore = scores.get(Trait.INTROVERT);
        int eScore = scores.get(Trait.EXTROVERT);

        if (eScore > iScore) {
            return Trait.EXTROVERT;
        }
        return Trait.INTROVERT;
    }

    // Returns a description for the winning trait.
    public String winnerDescription() {
        Trait w = winner();
        if (w == Trait.EXTROVERT) {
            return "You’re the type to talk it out, laugh it off, and recharge around people. You bring momentum and energy wherever you go.";
        }
        return "You recharge in peace, move with intention, and think things through. You don’t need to be loud to be powerful.";
    }

    // Builds and returns a fun, less-common set of quiz questions.
    public static List<Question> defaultBank() {
        List<Question> bank = new ArrayList<>();

        bank.add(new Question("You walk into a room where everyone suddenly stops talking. You:")
                .addOption("Mentally replay everything I did in the last 10 minutes", Trait.INTROVERT)
                .addOption("Crack a joke to reset the vibe", Trait.EXTROVERT));

        bank.add(new Question("Someone texts you: “Can we talk?” Your first reaction:")
                .addOption("Instant anxiety + I start analyzing every possibility", Trait.INTROVERT)
                .addOption("Curious… like okay, what’s going on?", Trait.EXTROVERT));

        bank.add(new Question("You get an unexpected free afternoon. You:")
                .addOption("Guard it like sacred alone time", Trait.INTROVERT)
                .addOption("Text people and make something happen", Trait.EXTROVERT));

        bank.add(new Question("At a group dinner, you’re most likely to:")
                .addOption("Listen quietly, then drop one strong comment", Trait.INTROVERT)
                .addOption("Bounce between conversations like it’s my job", Trait.EXTROVERT));

        bank.add(new Question("Your energy refills fastest when you:")
                .addOption("Disconnect from people completely", Trait.INTROVERT)
                .addOption("Are around people who make me laugh", Trait.EXTROVERT));

        bank.add(new Question("Someone interrupts your train of thought. You feel:")
                .addOption("I was in the zone… now I’m annoyed", Trait.INTROVERT)
                .addOption("It’s fine, I’ll circle back", Trait.EXTROVERT));

        bank.add(new Question("When you’re learning something new, you prefer to:")
                .addOption("Research quietly first, then try it", Trait.INTROVERT)
                .addOption("Talk through it while figuring it out", Trait.EXTROVERT));

        bank.add(new Question("At social events, you’re secretly counting:")
                .addOption("How long I’ve been here", Trait.INTROVERT)
                .addOption("How many new people I’ve met", Trait.EXTROVERT));

        bank.add(new Question("When you’re stressed, your instinct is to:")
                .addOption("Withdraw and process alone", Trait.INTROVERT)
                .addOption("Vent and get feedback right away", Trait.EXTROVERT));

        bank.add(new Question("You’re most productive when:")
                .addOption("It’s quiet and controlled", Trait.INTROVERT)
                .addOption("There’s movement, noise, or teamwork", Trait.EXTROVERT));

        return bank;
    }
}
