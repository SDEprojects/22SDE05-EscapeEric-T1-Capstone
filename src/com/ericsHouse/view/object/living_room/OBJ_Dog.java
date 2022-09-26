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

public class OBJ_Dog extends SuperObject {
    public int width;
    public int height;
    public static WordOrder wo;
    public BufferedImage dog1, dog2, dog3, dog4;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public OBJ_Dog(String name, String file, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0, 0, width * 5, height * 5);
        getDogImage();
    }

    public void getDogImage(){
        try{
            dog1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/sleeping-dog1.png")));
            dog2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/sleeping-dog2.png")));
            dog3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/sleeping-dog3.png")));
            dog4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/rooms/living_room/living_room_OBJ/sleeping-dog4.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        updateSprite();
        switch (spriteNum) {
            case 1:
                image = dog1;
                break;
            case 2:
                image = dog2;
                break;
            case 3:
                image = dog3;
                break;
            case 4:
                image = dog4;
                break;
        }
        g2.drawImage(image, screenX, screenY, width * 5, height * 5, null);

    }

    @Override
    public void interact(String objIndex, GamePanel gp) throws JsonProcessingException {
        int itemCount = 0;
        for(SuperObject obj:gp.player.getBackpack()){
            if(obj.name.equals("pears") || obj.name.equals( "oranges") || obj.name.equals("note") || obj.name.equals("emerald-earrings")){
                itemCount++;
            }
        }
        if(itemCount == 4){
            gp.gameState = gp.wordOrder;
            gp.ui.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
            wo = new WordOrder(gp);
        }else{
            gp.ui.currentDialogue = "The dog gives you a look that makes you feel like\nyou may not have all the items you need.\nTry looking in the living-room and kitchen for the items.";
            gp.gameState = gp.dialogueState;
        }
    }
    public void updateSprite() {
        spriteCounter++;
        if (spriteCounter > 30) {
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
                    spriteNum = 1;
                    break;
            }
            spriteCounter = 0;
        }
    }
}
