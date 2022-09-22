package com.ericsHouse.view.object.kitchen;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Fridge extends SuperObject {

    public OBJ_Fridge() {
        name = "fridge";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/kitchen_OBJ/fridge.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0, 0, 18 * 3, 31 * 3);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, 18 * 3, 31 * 3, null);

    }
}
