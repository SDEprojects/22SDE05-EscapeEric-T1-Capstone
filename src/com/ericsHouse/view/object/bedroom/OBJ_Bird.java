package com.ericsHouse.view.object.bedroom;

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

public class OBJ_Bird extends SuperObject {
    public int width;
    public int height;
    public BufferedImage bird1, bird2, bird3, bird4, bird5, bird6, bird7, bird8, bird9, bird10;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public OBJ_Bird(String name, String file, int width, int height) {
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
        getBirdImage();
    }

    public void getBirdImage(){
        try{
            bird1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird1.png")));
            bird2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird2.png")));
            bird3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird3.png")));
            bird4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird4.png")));
            bird5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird5.png")));
            bird6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird6.png")));
            bird7 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird7.png")));
            bird8 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird8.png")));
            bird9 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird9.png")));
            bird10 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/bedroom/bedroom_OBJ/bird10.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        updateSprite();
        switch (spriteNum) {
            case 1:
                image = bird1;
                break;
            case 2:
                image = bird2;
                break;
            case 3:
                image = bird3;
                break;
            case 4:
                image = bird4;
                break;
            case 5:
                image = bird5;
                break;
            case 6:
                image = bird6;
                break;
            case 7:
                image = bird7;
                break;
            case 8:
                image = bird8;
                break;
            case 9:
                image = bird9;
                break;
            case 10:
                image = bird10;
                break;
        }
        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);
    }

    public void updateSprite() {
        spriteCounter++;
        if (spriteCounter > 15) {
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
                    spriteNum = 6;
                    break;
                case 6:
                    spriteNum = 7;
                    break;
                case 7:
                    spriteNum = 8;
                    break;
                case 8:
                    spriteNum = 9;
                    break;
                case 9:
                    spriteNum = 10;
                    break;
                case 10:
                    spriteNum = 1;
                    break;
            }
            spriteCounter = 0;
        }
    }
    @Override
    public void interact(String objIndex, GamePanel gp) {
        if (Objects.equals(currentRoom.mapObjects.get(objIndex).name, "door")) {
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = JsonParser.doorParser(gp);
        } else if (this.riddleItem && !this.solved) {
            gp.gameState = gp.riddleState;
            gp.ui.currentDialogue = JsonParser.riddleParser(currentRoom.mapObjects.get(objIndex).name, gp);
        } else if (this.riddleItem) {
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "correctOut", gp);
        } else {
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
        }
    }
}
