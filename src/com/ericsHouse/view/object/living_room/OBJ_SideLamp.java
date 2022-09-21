package com.ericsHouse.view.object.living_room;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class OBJ_SideLamp extends SuperObject {
    public int width;
    public int height;
    public boolean lampOn;

    public OBJ_SideLamp(String name, String file, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0, 0, width * 3, height * 3);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);

    }

    @Override
    public void interact(int objIndex, GamePanel gp) {
        try {
            gp.obj[objIndex].image = ImageIO.read(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/side-lamp-on.png"));
            lampOn = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
