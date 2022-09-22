package com.ericsHouse.view.object;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.panels.GamePanel;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.ericsHouse.view.util.GameFrame.sidePanel;
import static com.ericsHouse.view.panels.GamePanel.currentRoom;


public abstract class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int screenX, screenY;
    //You may need to change this for the different objects, this is only one tile worth of area
    public Rectangle solidArea = new Rectangle(0, 0, 48 * 2, 48 * 2);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public boolean gettable = false;
    public boolean riddleItem = false;
    public boolean solved = false;

    public static boolean win = false;

    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2, null);

    }

    public void interact(String objIndex, GamePanel gp) throws JsonProcessingException {
        if (gettable) {
            //If object is gettable, display dialogue box
            //If user selects get item then the object is put in their inventory
            JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
            gp.player.addItem(currentRoom.mapObjects.get(objIndex));
            sidePanel.inventorySetUp(currentRoom.mapObjects.get(objIndex));
            currentRoom.mapObjects.remove(objIndex);
        }
        //If item isn't gettable display dialogue box with description
        else {
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
        }
    }
}
