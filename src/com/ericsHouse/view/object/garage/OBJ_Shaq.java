package com.ericsHouse.view.object.garage;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Shaq extends SuperObject {

    public OBJ_Shaq() {
        name = "shaq";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/ask-shaq.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
