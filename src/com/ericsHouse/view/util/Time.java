package com.ericsHouse.view.util;

import javax.swing.*;
import java.text.DecimalFormat;

public class Time {

    public static Timer gameTimer;
    private static int minute;
    private static int second;
    static String dMinute;
    static String dSecond;
    static DecimalFormat dFormat = new DecimalFormat("00");


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
            if (minute == 0 && second == 0) {
                gameTimer.stop();
//                LosePanel.lose();
            }
        });

    }

}