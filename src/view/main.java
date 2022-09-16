package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class main {

    public JFrame window;
    public static void main(String[] args) throws IOException {
        GamePanel gamePanel = new GamePanel();
       BuildWindow.buildWindow(gamePanel,"Escape Eric - Garage Office Beginning");
    }
}
