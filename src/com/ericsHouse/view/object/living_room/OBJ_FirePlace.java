package com.ericsHouse.view.object.living_room;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.WordOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;

public class OBJ_FirePlace extends SuperObject {
    public int width;
    public int height;
    public static WordOrder wo;
    public BufferedImage fire1, fire2, fire3, fire4, fire5;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public OBJ_FirePlace(String name, String file, int width, int height) {
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
        getFireImage();
    }

    public void getFireImage() {
        try {
            fire1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/fireplace_move1.png")));
            fire2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/fireplace_move2.png")));
            fire3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/fireplace_move3.png")));
            fire4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/fireplace_move4.png")));
            fire5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/fireplace_move5.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        //Change sprite num every 12 frames
        updateSprite();
        switch (spriteNum) {
            case 1:
                image = fire1;
                break;
            case 2:
                image = fire2;
                break;
            case 3:
                image = fire3;
                break;
            case 4:
                image = fire4;
                break;
            case 5:
                image = fire5;
                break;
        }
        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);

    }

    public void updateSprite() {
        spriteCounter++;
        if (spriteCounter > 12) {
            switch (spriteNum) {
                case 1:
                    spriteNum = 2;
                    break;
                case 2:
                    spriteNum = 3;
                    break;
                case 3:
                    spriteNum = 4;
                    break;
                case 4:
                    spriteNum = 5;
                    break;
                case 5:
                    spriteNum = 1;
                    break;
            }
            spriteCounter = 0;
        }
    }
}
