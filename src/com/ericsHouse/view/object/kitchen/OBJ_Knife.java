package com.ericsHouse.view.object.kitchen;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;
import static com.ericsHouse.view.util.GameFrame.sidePanel;


public class OBJ_Knife extends SuperObject {
    public OBJ_Knife() {
        name = "knife";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/kitchen_OBJ/knife.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        solidArea = new Rectangle(0, 0, 18 * 3, 21 * 3);
        gettable = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, 47*3, 61*3, gp.tileSize, gp.tileSize, null);
    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        if (gettable) {

            gp.ui.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
            gp.player.addItem(currentRoom.mapObjects.get(objIndex));
            sidePanel.inventorySetUp(currentRoom.mapObjects.get(objIndex));
            currentRoom.mapObjects.remove(objIndex);
            gp.gameState = gp.dialogueState;
        }
    }
}
