package com.ericsHouse.view.util;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BuildWindow {

    public static JFrame window;

    public static void buildWindow(GamePanel gamePanel, String title) throws IOException {
        BufferedImage image = ImageIO.read(main.class.getResourceAsStream("/rooms/garage/garage_OBJ/frog.png"));
        window = new JFrame();
        //Setting the frame to close when user clicks "x"
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle(title);
        window.setIconImage(image);

        //pack causes this window to be sized to fit the preferred size and layouts of its subcomponents(GamePanel)
        window.add(gamePanel);
        //TODO - use this set size to create a 200px wide JPanel inside the window to display the Game Control information
        //window.setSize(984,615);
        //TODO - Pack can be used to build a new window with the game panel dimensions (we can build a side window to show a list of commands)
        window.pack();
        //Sets display location to the center of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        //TODO - Put intro screen before game panel is started
        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}