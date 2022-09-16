package view;

import javax.swing.*;

public class LosePanel extends JPanel {

    //SCREEN SETTINGS
    final int originalTileSize = 16; // 16 x 16 tile
    final int scale = 3;
    final int FPS = 60;

    public final int tileSize = originalTileSize * scale; //48 x 48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    public static void lose() {
        GamePanel.setDead(true);
    }
}
