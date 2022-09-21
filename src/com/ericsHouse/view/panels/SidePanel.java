package com.ericsHouse.view.panels;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.util.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class SidePanel extends JPanel {

    private final JFrame jframe;
    public JPanel inventory = new JPanel();
    public JButton askShaqButton;
    public JButton helpButton;

    public static Map<String, JButton> items = new HashMap<>();
    final int screenWidth = 216;
    final int screenHeight = GamePanel.screenHeight;
    GridBagConstraints c = new GridBagConstraints();


    public SidePanel(JFrame jframe) {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(new GridBagLayout());
        this.jframe = jframe;
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
            items.get(item.name).setPreferredSize(new Dimension(16*4, 16*4));
        }

        inventory.revalidate();
        inventory.repaint();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.ipady = 454;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        this.add(inventory, c);
    }

    public void inventorySetUp(SuperObject sp){
        ImageIcon image = new ImageIcon(sp.image);
        Image newImg = image.getImage();
        Image img = newImg.getScaledInstance(48,48, Image.SCALE_SMOOTH);
        ImageIcon imgI = new ImageIcon(img);
        JButton button = new JButton(imgI);
        JLabel label = new JLabel(sp.name);
        button.setPreferredSize(new Dimension(16*4, 16*4));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.add(label);
        label.setVisible(false);
        button.setContentAreaFilled(false);
        button.addActionListener(e->{
            System.out.println("Button Pressed");
        });

        inventory.revalidate();
        inventory.repaint();
        inventory.add(button);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.ipady = 454;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        this.add(inventory, c);
    }


    public void buttonSetUp() {
       askShaqButton = new JButton("Ask Shaq");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(askShaqButton, c);
        askShaqButton.addActionListener((ActionListener) jframe);


        helpButton = new JButton("Help");
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(helpButton, c);
        helpButton.addActionListener((ActionListener) jframe);
    }

}
