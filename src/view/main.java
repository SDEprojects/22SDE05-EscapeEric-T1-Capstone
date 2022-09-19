package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static view.Time.gameTimer;

public class main {

    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(main.class.getResourceAsStream("/rooms/garage/garage_OBJ/frog.png"));

        // Game window is initialized and organized
        JFrame window = new JFrame();

        //Setting the frame to close when user clicks "x"
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Escape Eric - Office Garage");
        window.setIconImage(image);
        GamePanel gamePanel = new GamePanel();
//        SidePanel sidePanel = new SidePanel();
        //pack causes this window to be sized to fit the preferred size and layouts of its subcomponents(GamePanel)
        window.add(gamePanel);
//        window.setSize(984,576);
        window.pack();
//        window.add(sidePanel);
//        JLabel timerLabel = new JLabel();
//        timerLabel.setHorizontalAlignment(JLabel.CENTER);
//        timerLabel.setVerticalAlignment(JLabel.TOP);
//        timerLabel.setBounds(826, 0, 100, 50);
////        timerLabel.setFont(font1);
//        timerLabel.setText("03:00");
//        Time.setUpTimer(3, 0, timerLabel);
//        sidePanel.add(timerLabel);
        //TODO - use this set size to create a 200px wide JPanel inside the window to display the Game Control information

        //TODO - Pack can be used to build a new window with the game panel dimensions (we can build a side window to show a list of commands)
//        window.pack();
        //Sets display location to the center of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        //TODO - Put intro screen before game panel is started
        gamePanel.setUpGame();
        gamePanel.startGameThread();
//        gameTimer.start();
    }
}
