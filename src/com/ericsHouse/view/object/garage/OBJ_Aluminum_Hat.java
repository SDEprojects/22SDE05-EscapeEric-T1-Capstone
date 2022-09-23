package com.ericsHouse.view.object.garage;

import com.ericsHouse.view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Aluminum_Hat extends SuperObject {

    public OBJ_Aluminum_Hat() {
        name = "aluminum hat";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/aluminum-hat.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        solidArea = new Rectangle(0, 0, 16 * 2, 16 * 2);
    }
}
