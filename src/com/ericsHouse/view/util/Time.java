package com.ericsHouse.view.util;

import com.ericsHouse.view.panels.GamePanel;

import javax.swing.*;
import java.text.DecimalFormat;

public class Time {

    public static Timer gameTimer;
    public static int minute;
    public static int second;
    static String dMinute;
    static String dSecond;
    static DecimalFormat dFormat = new DecimalFormat("00");

    /**
     * This method sets up the Game timer and updates the timer inside the label provided
     * @param minutes int minutes of the game
     * @param seconds int seconds of the game, consistent with clock with 60 seconds = 1 minute
     * @param label the Jlabel inside the panel of the GUI that holds the game clock
     */
    public static void setUpTimer(int minutes, int seconds, JLabel label) {
        minute = minutes;
        second = seconds;

        gameTimer = new Timer(1000, e -> {
            second--;
            dSecond = dFormat.format(second);
            dMinute = dFormat.format(minute);
            label.setText(dMinute + ":" + dSecond);

            if (second < 0) {
                second = 59;
                minute--;
                dSecond = dFormat.format(second);
                dMinute = dFormat.format(minute);
                label.setText(dMinute + ":" + dSecond);
            }
            if (minute <= 0 && second <= 0) {
                GamePanel.gameState = GamePanel.deathState;
                gameTimer.stop();
            }
        });

    }

    /**
     * Method to restart Game clock, part of the restart game mechanic
     * @param label JLabel for the game clock inside the Panel
     */
    public static void resetUpTimer( JLabel label) {
        minute = 8;
        second = 0;
        gameTimer.stop();
        gameTimer = new Timer(1000, e -> {
            second--;
            dSecond = dFormat.format(second);
            dMinute = dFormat.format(minute);
            label.setText(dMinute + ":" + dSecond);

            if (second < 0) {
                second = 59;
                minute--;
                dSecond = dFormat.format(second);
                dMinute = dFormat.format(minute);
                label.setText(dMinute + ":" + dSecond);
            }
            if (minute <= 0 && second <= 0) {
                GamePanel.gameState = GamePanel.deathState;
                gameTimer.stop();
            }
        });

    }
}