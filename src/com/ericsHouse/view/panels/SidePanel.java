package com.ericsHouse.view.panels;

import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.util.Time;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SidePanel extends JPanel {

    public static Map<String, JButton> items = new HashMap<>();
    final int screenWidth = 216;
    final int screenHeight = GamePanel.screenHeight;
    GridBagConstraints c = new GridBagConstraints();


    public SidePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(new GridBagLayout());
    }

    public void timerSetUp() {
        // Game Timer
        JLabel timerLabel = new JLabel("HELLOOOOOO");
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setBounds(58, 0, 100, 50);
        timerLabel.setText("04:00");
        Time.setUpTimer(4, 0, timerLabel);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.ipady = 50;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        this.add(timerLabel, c);
    }

    public void inventorySetUp(GamePanel gp) {
//        Player.addItem(new OBJ_Bedroom("side-table-girl", "/rooms/bedroom/bedroom_OBJ/side-table-girl.png", 14, 21));
        for (SuperObject item : gp.player.getBackpack()) {
            ImageIcon image = new ImageIcon(item.image);
            items.put(item.name, new JButton());
            items.get(item.name).setIcon(image);
            items.get(item.name).setPreferredSize(new Dimension(72, 72));
        }
    }

    public void inventoryDisplay() {
        JPanel inventory = new JPanel();
        Collection<JButton> values = items.values();
        for (JButton button : values) {
            inventory.add(button);
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.ipady = 454;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        this.add(inventory, c);
    }

    public void buttonSetpUp() {
        JButton askShaqButton = new JButton("Ask Shaq");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(askShaqButton, c);

        JButton helpButton = new JButton("Help");
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(helpButton, c);
    }
}
