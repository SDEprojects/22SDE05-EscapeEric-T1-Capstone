package com.ericsHouse;

public class Riddle {

    private static boolean question1Correct = false;
    private static boolean question2Correct = false;
    private static boolean question3Correct = false;

    public static void firstRiddle(String input) {
        String answer = "towel";
        if (input.equalsIgnoreCase(answer)) {
            question1Correct = true;
        }
    }

    public static void secondRiddle(String input) {
        String answer = "coffin";
        if (input.equalsIgnoreCase(answer)) {
            question2Correct = true;
        }
    }

    public static void thirdRiddle(String input) {
        String answer = "david";
        if (input.equalsIgnoreCase(answer)) {
            question3Correct = true;
        }
    }

    public static boolean isQuestion1Correct() {
        return question1Correct;
    }

    public static boolean isQuestion2Correct() {
        return question2Correct;
    }

    public static boolean isQuestion3Correct() {
        return question3Correct;
    }
}

