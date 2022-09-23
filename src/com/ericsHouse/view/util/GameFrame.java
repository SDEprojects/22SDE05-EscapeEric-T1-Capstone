package com.ericsHouse.view.util;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.main;
import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.panels.SidePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameFrame extends JFrame implements ActionListener {
    public static JFrame window;
    public static SidePanel sidePanel;
    public static GamePanel gamePanel;

    public GameFrame() throws IOException {
        BufferedImage image = ImageIO.read(main.class.getResourceAsStream("/rooms/garage/garage_OBJ/frog.png"));
        BufferedImage backgroundImage = ImageIO.read(main.class.getResourceAsStream("/side-panel-background.png"));
        // Game window is initialized and organized
        window = new JFrame();

        //Setting the frame to close when user clicks "x"
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Escape Eric - Office Garage");
        window.setIconImage(image);
        //window.setSize(984,612);

        gamePanel = new GamePanel();
        sidePanel = new SidePanel(this, backgroundImage, gamePanel);
        //pack causes this window to be sized to fit the preferred size and layouts of its subcomponents(GamePanel)
        window.add(gamePanel, BorderLayout.LINE_START);

        window.add(sidePanel, BorderLayout.LINE_END);
        window.pack();
        sidePanel.timerSetUp();
        sidePanel.inventorySetUp(gamePanel);
        sidePanel.buttonSetUp();

        // TODO - use this set size to create a 200px wide JPanel inside the window to display the Game Control information

        // Pack can be used to build a new window with the game panel dimensions (we can build a side window to show a list of commands)
//        window.pack();
        //Sets display location to the center of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                gamePanel.requestFocus();
            }
        });
        sidePanel.setFocusable(false);
        //TODO - Put intro screen before game panel is started
        gamePanel.setUpGame();
        //sidePanel.inventoryDisplay();
        gamePanel.startGameThread();
        gamePanel.gameState = gamePanel.introState;
        //gameTimer.start();
       //gameTimer.stop();
    }
    public static void reset() throws IOException {
        Time.resetUpTimer(sidePanel.time());
        Time.gameTimer.start();
        sidePanel.inventorySetUp(new GamePanel());
        sidePanel.resetItems();
        GamePanel.setUpGame();
        Player.setDefaultValues();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sidePanel.askShaqButton) {
            gamePanel.setFocusable(true);
            gamePanel.ui.currentDialogue = JsonParser.getPrompt("askShaq", gamePanel);
            gamePanel.gameState = gamePanel.Shaq;
        }
        if (e.getSource() == sidePanel.helpButton) {
            gamePanel.ui.currentDialogue = JsonParser.getPrompt("help", gamePanel);
            gamePanel.setFocusable(true);
            gamePanel.gameState = gamePanel.dialogueState;
        }
    }
}