package com.ericsHouse.view.panels;

import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.util.Time;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SidePanel extends JPanel {

    public static ArrayList<String> items;
    final int screenWidth = 216;
    final int screenHeight = GamePanel.screenHeight;

    public SidePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    }

    public void timerSetUp() {
        // Game Timer
        JLabel timerLabel = new JLabel("HELLOOOOOO");
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setVerticalAlignment(JLabel.TOP);
        timerLabel.setBounds(58, 0, 100, 50);
        timerLabel.setText("04:00");
        Time.setUpTimer(4, 0, timerLabel);
        this.add(timerLabel, BorderLayout.PAGE_START);
    }

    public void inventorySetUp() {
        for (SuperObject item : Player.backpack) {
            items.add(item.toString());
        }
//        DefaultListModel<String> model = new DefaultListModel<>();
//        model.addAll(items);
//        JList<String> inventory = new JList<>(model);
//        this.add(inventory);
    }

    public void buttonSetpUp() {
        JButton askShaqButton = new JButton("Ask Shaq");
        JButton helpButton = new JButton("Help");
        this.add(askShaqButton, BorderLayout.PAGE_END);
        this.add(helpButton, BorderLayout.PAGE_END);
    }
}
