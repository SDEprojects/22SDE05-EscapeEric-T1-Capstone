package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(main.class.getResourceAsStream("/garage_OBJ/frog.png"));
        JFrame window = new JFrame();
        //Setting the frame to close when user clicks "x"
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Escape Eric - Office Garage");
        window.setIconImage(image);
        GamePanel gamePanel = new GamePanel();

        //pack causes this window to be sized to fit the preferred size and layouts of its subcomponents(GamePanel)
        window.add(gamePanel);
        window.pack();
        //Sets display location to the center of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();

    }
}