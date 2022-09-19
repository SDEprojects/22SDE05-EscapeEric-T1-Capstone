package view;

import javax.swing.*;
import java.awt.*;
import static view.Time.gameTimer;

public class SidePanel extends JPanel {

    final int screenWidth = 196;
    final int screenHeight = 576;

    public SidePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    }
}
